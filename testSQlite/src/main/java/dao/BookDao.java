package dao;

import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDao implements BookStoreDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDao.class);
    private DbConnection dbConnection;

    public void addInStore(Object object) {

    }

    public void updateInStore(Object object) {

    }

    public void removeInStore(Object object) {

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
            e.printStackTrace();
        }
        return bookCase;
    }

}
