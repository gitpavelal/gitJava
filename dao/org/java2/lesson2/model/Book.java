package org.java2.lesson2.model;

import org.java2.lesson2.model.common.Identity;

/**
 * Клас отвечающий за сущность в БД - Book
 */
public class Book implements Identity {
    /**
     * Идентификатор книги
     */
    private Integer id;
    /**
     * Название
     */
    private String name;
    /**
     * Идентификатор автора
     */
    private Integer author;

    public Book() {
        //no-op
    }

    @Override
    public Integer getIdentity() {
        return this.id;
    }

    @Override
    public void setIdentity(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(final Integer author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return !(id != null ? !id.equals(book.id) : book.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
