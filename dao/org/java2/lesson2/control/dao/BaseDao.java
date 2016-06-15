package org.java2.lesson2.control.dao;

import org.java2.lesson2.control.common.DbConnector;
import org.java2.lesson2.model.common.Identity;
import org.java2.lesson2.model.common.Row;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Базовый DAO
 *
 * @param <T> идентифицируемая сущность
 */
public abstract class BaseDao<T extends Identity> implements Dao<T> {
    /**
     * Интерфейс для формирование информации о колонке таблицы
     */
    private static interface ColumnBuilder {
        public String column(Row.Entity entity);
    }

    /**
     * Удаления идентификатора из строки БД
     *
     * @param row строка БД
     * @return удаленное поле
     */
    private Row.Entity clearId(final Row row) {
        for (Iterator<Row.Entity> iterator = row.getEntities().iterator(); iterator.hasNext(); ) {
            Row.Entity entity = iterator.next();
            if (Identity.COLUMN_NAME.equals(entity.getName())) {
                iterator.remove();
                return entity;
            }
        }
        return null;
    }

    /**
     * Очистка всех полей строки БД, кроме идентификатора
     *
     * @param row строка БД
     */
    private void clearNotId(final Row row) {
        for (Iterator<Row.Entity> iterator = row.getEntities().iterator(); iterator.hasNext(); ) {
            Row.Entity entity = iterator.next();
            if (!Identity.COLUMN_NAME.equals(entity.getName()))
                iterator.remove();
        }
    }

    /**
     * Формирование строки информации о колонках таблицы
     *
     * @param row           строка БД
     * @param columnBuilder инструмент формировки инфрмации о колонке БД
     * @ы сформированная строка
     */
    private String stringColumns(final Row row, final ColumnBuilder columnBuilder) {
        StringBuilder builder = new StringBuilder();
        for (Row.Entity entity : row.getEntities()) {
            builder.append(columnBuilder.column(entity));
        }
        if (builder.length() != 0) {
            builder.deleteCharAt(builder.lastIndexOf(","));
        }
        return builder.toString();
    }

    /**
     * Перечесление нужных нам колонок в запросе <br>
     * Пример: column_1, column_2, column_3 <br>
     *
     * @param row срока БД
     * @return перчесление колонок БД
     */
    private String columns(final Row row) {
        return stringColumns(row, new ColumnBuilder() {
            @Override
            public String column(final Row.Entity entity) {
                return String.format("%s, ", entity.getName());
            }
        });
    }

    /**
     * Перечесление параметров для колонок в запросе <br>
     * Например колонки name и surname, тогда будет на выходе: ?, ? <br>
     *
     * @param row срока БД
     * @return пересечение параметров для колонок
     */
    private String values(final Row row) {
        return stringColumns(row, new ColumnBuilder() {
            @Override
            public String column(final Row.Entity entity) {
                return "?, ";
            }
        });
    }

    /**
     * Запрос на удаление записи из таблицы
     *
     * @return SQL DELETE
     */
    private String deleteSql() {
        return String.format("DELETE FROM %1$s WHERE id=?;", tableName());
    }

    /**
     * Запрос на добавление записи в таблицу
     *
     * @param row строка БД
     * @return SQL INSERT
     */
    private String insertSql(final Row row) {
        return String.format("INSERT INTO %1$s(%2$s) values(%3$s);", tableName(), columns(row), values(row));
    }

    /**
     * Запрос на обновление записи в таблицу
     *
     * @param row строка БД
     * @return SQL UPDATE
     */
    private String updateSql(final Row row) {
        return String.format("UPDATE %1$s SET %2$s WHERE id=?;", tableName(), stringColumns(row, new ColumnBuilder() {
            @Override
            public String column(final Row.Entity entity) {
                return String.format("%s=?, ", entity.getName());
            }
        }));
    }

    /**
     * Формирование запроса на получение всех записей из таблицы БД <br>
     * Например: SELECT * from Author;
     *
     * @return SELECT SQL
     */
    public String selectAllSql() {
        return String.format("SELECT * FROM %1$s;", tableName());
    }

    /**
     * Проверка на отсутствие объекта
     *
     * @param t проверяемый объекат
     */
    private void checkT(T t) {
        if (t == null)
            throw new IllegalArgumentException("empty object");
    }

    /**
     * Проверка на отсутсвие индентификатора
     *
     * @param t проверяемый объекат
     */
    private void checkIdentity(T t) {
        checkT(t);
        if (t.getIdentity() == null)
            throw new IllegalArgumentException("missing identity");
    }

    @Override
    public Collection<T> select() {
        Collection<Row> rows = DbConnector.getInstance().executeSelectNew(selectAllSql());
        Collection<T> res = new ArrayList<T>();
        for (Row row : rows) {
            res.add(convert(row));
        }
        return res;
    }

    @Override
    public boolean insert(final T t) {
        checkT(t);
        Row row = convert(t);
        clearId(row);
        Integer id = DbConnector.getInstance().executeUpdate(insertSql(row), row);
        if (id > 0) {
            t.setIdentity(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(final T t) {
        checkIdentity(t);
        Row row = convert(t);
        Row.Entity id = clearId(row);
        String sql = updateSql(row);
        row.getEntities().add(id);
        return DbConnector.getInstance().executeUpdate(sql, row) == -1;
    }

    @Override
    public boolean delete(final T t) {
        checkIdentity(t);
        Row row = convert(t);
        clearNotId(row);
        return DbConnector.getInstance().executeUpdate(deleteSql(), row) == -1;
    }

    /**
     * Получение название таблицы
     *
     * @return название таблицы
     */
    public abstract String tableName();

    /**
     * Метод для превращения строку БД в объект
     *
     * @param row строка из БД
     * @return объект
     */
    public abstract T convert(final Row row);

    /**
     * Метод для превращения объект в строку БД
     *
     * @param t объект
     * @return строка бд
     */
    public abstract Row convert(final T t);
}
