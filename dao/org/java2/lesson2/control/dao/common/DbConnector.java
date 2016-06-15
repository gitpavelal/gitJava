package org.java2.lesson2.control.common;

import org.java2.lesson2.model.common.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Класс для работы с БД
 * Реализован как класс Singleton
 * Не рассчитан на многопоточность
 */
public class DbConnector {
    /**
     * Экземпляр коннектора к базе данных
     */
    private static DbConnector instance;
    /**
     * Экземпляр соединения с БД
     */
    private Connection connection;

    /**
     * Ссылка для соединения с БД
     */
    private static final String URL_CONNECTION = "jdbc:sqlite:C:\\Users\\Кирилл\\lesson2.db";
    //private static final String URL_CONNECTION = "jdbc:sqlite:test.db";

    /**
     * Объект для логирования
     */
    private static Logger LOG = LoggerFactory.getLogger(DbConnector.class);

    /**
     * Закрытый конструктор, т.к. класс является Singleton
     */
    private DbConnector() {
        try {
            /**
             * Регистрация драйвера JDBC для СУБД SQLite
             */
            DriverManager.registerDriver(new org.sqlite.JDBC());
            /**
             * Создание соединения с СУБД
             */
            this.connection = DriverManager.getConnection(URL_CONNECTION);
            LOG.info("CREATE DbConnector - SUCCESS");
        } catch (SQLException e) {
            LOG.error("CREATE DbConnector - ERROR");
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод для получения экземпляра DbConnector
     *
     * @return настроенное соединение к СУБД
     */
    public static DbConnector getInstance() {
        if (instance == null)
            instance = new DbConnector();
        return instance;
    }

    /**
     * Выполнение операции SELECT к баже
     *
     * @param sql валидный SQL SELECT
     * @return коллекция записей из бд
     */
    public Collection<Row> executeSelectNew(final String sql) {
        PreparedStatement statement = null;
        try {
            LOG.debug("TRY EXECUTE SELECT={0}", sql);
            statement = this.connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            String[] columns = getColumns(rs.getMetaData());
            Collection<Row> res = new ArrayList<Row>();
            while (rs.next()) {
                Row row = new Row();
                for (String column : columns) {
                    Row.Entity entity = new Row.Entity();
                    entity.setName(column);
                    entity.setValue(rs.getObject(column));
                    row.getEntities().add(entity);
                }
                res.add(row);
            }
            LOG.debug("SELECT RESULT={0}", res.size());
            return res;
        } catch (Throwable t) {
            LOG.error("EXECUTE SELECT - ERROR");
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (Throwable tt) {
                    LOG.error("TRY CLOSE PREPARED_STATMENT - ERROR");
                }
        }
        return Collections.emptyList();
    }

    /**
     * Выполнение запросов: <br>
     * 1)CREATE TABLE <br>
     * 2)INSERT <br>
     * 3)UPDATE <br>
     * 4)DELETE <br>
     *
     * @param sql запрос
     * @param row строка БД
     * @return 0 - не получилось, -1- все прошло хорошо, >0 идентификатор записи если это был INSERT
     */
    public Integer executeUpdate(final String sql, final Row row) {
        PreparedStatement statement = null;
        try {
            LOG.debug("TRY EXECUTE SQL={0}", sql);
            statement = this.connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            int i = 1;
            for (Row.Entity entity : row.getEntities()) {
                statement.setObject(i++, entity.getValue());
            }
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    return (Integer) rs.getObject(1);
                }
            }
            return -1;
        } catch (SQLException e) {
            LOG.error("EXECUTE SQL - ERROR");
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    LOG.error("TRY CLOSE PREPARED_STATMENT - ERROR");
                }
        }
        return 0;
    }

    /**
     * Получение название колонок из результата поиска
     *
     * @param metaData мета информации из результата поиска
     * @return массив колонок
     * @throws SQLException если произошли ошибки
     */
    private String[] getColumns(final ResultSetMetaData metaData) throws SQLException {
        String[] res = new String[metaData.getColumnCount()];
        for (int i = 0; i < res.length; i++) {
            res[i] = metaData.getColumnName(i + 1);
        }
        return res;
    }
}
