package org.java2.lesson2.model;

import org.java2.lesson2.model.common.Identity;

/**
 * Клас отвечающий за сущность в БД - Author
 */
public class Author implements Identity {
    /**
     * Идентификатор автора
     */
    private Integer id;
    /**
     * Фамилия
     */
    private String firstName;
    /**
     * Имя
     */
    private String secondName;
    /**
     * Отчество
     */
    private String middleName;

    public Author() {
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
        return  id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return !(id != null ? !id.equals(author.id) : author.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
