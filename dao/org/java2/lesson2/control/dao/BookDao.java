package org.java2.lesson2.control.dao;

import org.java2.lesson2.model.Book;
import org.java2.lesson2.model.common.Row;

/**
 * DAO для Книги
 */
public class BookDao extends BaseDao<Book> {
    @Override
    public String tableName() {
        return "Book";
    }

    @Override
    public Book convert(final Row row) {
        Book book = new Book();
        book.setId((Integer) row.getValue("id"));
        book.setName((String) row.getValue("name"));
        book.setAuthor((Integer) row.getValue("author"));
        return book;
    }

    @Override
    public Row convert(final Book book) {
        Row row = new Row();
        row.getEntities().add(new Row.Entity("id", book.getId()));
        row.getEntities().add(new Row.Entity("name", book.getName()));
        row.getEntities().add(new Row.Entity("author", book.getAuthor()));
        return row;
    }
}
