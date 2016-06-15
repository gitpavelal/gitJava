package org.java2.lesson2.model.common;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Класс отвечающий за строчку пришедшую из БД
 */
public class Row {
    /**
     * Элементы строки
     */
    private Collection<Entity> entities = new ArrayList<Entity>();

    public Row() {
        //no-op
    }

    public static class Entity {
        /**
         * Название поля
         */
        private String name;
        /**
         * Содержимое поля
         */
        private Object value;

        public Entity() {
            //no-op
        }

        public Entity(final String name, final Object value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(final Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * Получение значение в строке по ее название
     *
     * @param name название элемента строки, не завист от регистра
     * @return значение элементы строки, если не нашлось вернет null
     */
    public Object getValue(final String name) {
        if (name == null)
            return null;
        for (Entity entity : this.entities) {
            if (entity == null)
                continue;
            if (name.equalsIgnoreCase(entity.name)) {
                return entity.value;
            }
        }
        return null;
    }

    public Collection<Entity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "Row{" +
                "entities=" + entities.toString() +
                '}';
    }
}
