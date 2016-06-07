package model;

public class Book {
    private int bookId;
    private String bookName;
    private int bookAuthorId;



    public Book() {
    }

    public Book(String bookName, int bookAuthorId) {
        this.bookName = bookName;
        this.bookAuthorId = bookAuthorId;
    }

    public Book(int bookPrimaryKeyId, String authorName, int bookAuthorId) {
        this.bookId = bookPrimaryKeyId;
        this.bookName = authorName;
        this.bookAuthorId = bookAuthorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookAuthorId() {
        return bookAuthorId;
    }

    public void setBookAuthorId(int bookAuthorId) {
        this.bookAuthorId = bookAuthorId;
    }

    @Override
    public String toString() {
        return "{" +
                "id книги= '" + bookId +
                "' название книги = '" + bookName + "'}";
    }

}
