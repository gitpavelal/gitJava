package org.java2.lesson2.control.dao;

import org.java2.lesson2.model.common.Identity;

import java.util.Collection;

/**
 * Стандартный интерфейс DAO
 */
public interface Dao<T extends Identity> {
    /**
     * Получение всех записей
     *
     * @return Коллекция сущностей из БД
     */
    public Collection<T> select();

    /**
     * Добавление новой записи в БД
     *
     * @param t новая сущность БД
     * @return получилось/не получилось
     */
    public boolean insert(T t);

    /**
     * Обновление сущности в БД
     *
     * @param t существующая сущность БД
     * @return получилось/не получилось
     */
    public boolean update(T t);

    /**
     * Удаление сущности из БД
     *
     * @param t существующая сущность БД
     * @return получилось/не получилось
     */
    public boolean delete(T t);
}
