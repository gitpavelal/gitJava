package dao;

import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDao.class);

    public void addInStore(Book book) {

        String SQL = "INSERT INTO Book(name, author_id) values('" + book.getBookName() + "','"
                + book.getBookAuthorId() + "');";
        CRUDbook(SQL);

    }

    public void updateInStore(Book book) {

        String SQL = " UPDATE Book SET name='" + book.getBookName() + "', author_id="
                + book.getBookAuthorId() + " WHERE id=" + book.getBookId() + ";";
        CRUDbook(SQL);
    }


    public void removeInStore(Book book) {

        String SQL = " DELETE FROM Book WHERE id="+book.getBookId()+" ";
        CRUDbook(SQL);
    }

    public List<Object> getListBooksStore() {

        List<Object> bookCase = new ArrayList<>();
        String SQL = "SELECT * FROM Book";
        try {
            Statement statement = new DbConnection().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookName(resultSet.getString("name"));
                book.setBookId(resultSet.getInt("id"));
                book.setBookAuthorId(resultSet.getInt("author_id"));
                bookCase.add(book);
            }
        } catch (SQLException e) {
            logger.error("Error statement", e);

        }
        return bookCase;
    }

    private void CRUDbook(String SQL) {
        try {
            Statement statement = new DbConnection().getConnection().createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            logger.error("Error statement, executeUpdate", e);

        }
    }

}
