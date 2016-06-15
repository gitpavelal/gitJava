package org.java2.lesson2.model.common;

/**
 * Интерфейс для идентификации записей
 */
public interface Identity {
    /**
     * Получение идентификатора
     *
     * @return идентификатор
     */
    Integer getIdentity();

    /**
     * Установка идентификатора
     *
     * @param id идентификатор
     */
    void setIdentity(Integer id);

    /**
     * Название колонки для идентификатора
     */
    public static final String COLUMN_NAME = "id";
}
