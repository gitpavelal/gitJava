package org.java2.lesson2.control.dao;

import org.java2.lesson2.model.Author;
import org.java2.lesson2.model.common.Row;

/**
 * DAO для Автора
 */
public class AuthorDao extends BaseDao<Author> {

    @Override
    public String tableName() {
        return "Author";
    }

    @Override
    public Row convert(final Author author) {
        Row row = new Row();
        row.getEntities().add(new Row.Entity("id", author.getId()));
        row.getEntities().add(new Row.Entity("firstName", author.getFirstName()));
        row.getEntities().add(new Row.Entity("secondName", author.getSecondName()));
        row.getEntities().add(new Row.Entity("middleName", author.getMiddleName()));
        return row;
    }

    @Override
    public Author convert(final Row row) {
        Author author = new Author();
        author.setId((Integer) row.getValue("id"));
        author.setFirstName((String) row.getValue("firstName"));
        author.setSecondName((String) row.getValue("secondName"));
        author.setMiddleName((String) row.getValue("middleName"));
        return author;
    }
}
