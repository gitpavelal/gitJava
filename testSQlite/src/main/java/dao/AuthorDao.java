package dao;


import model.Author;
import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
    private static final Logger logger = LoggerFactory.getLogger(AuthorDao.class);

    public void addInStore(Author author) {

        String SQL = "INSERT INTO Author(firstName, secondName, middleName) values('"
                + author.getAuthorFirstName() + "','"
                + author.getAuthorSecondName() + "','"
                + author.getAuthorMiddleName() + "');";
        CRUDauthor(SQL);
    }

    public void updateInStore(Author author) {

        String SQL = "UPDATE  Author SET firstName='"
                + author.getAuthorFirstName() + "', secondName='"
                + author.getAuthorSecondName() + "', middleName='"
                + author.getAuthorMiddleName() + "' WHERE id="
                +author.getAutorId()+";";
        CRUDauthor(SQL);

    }

    public void removeInStore(Author author) {
        String SQL = " DELETE FROM Author WHERE id="+author.getAutorId();
        CRUDauthor(SQL);
    }

    public List<Object> getListBooksStore() {
        List<Object> authorCase = new ArrayList<>();
        String SQL = "SELECT * FROM Author";
        try {
            Statement statement = new DbConnection().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
               Author author = new Author();
                author.setAutorId(resultSet.getInt("id"));
                author.setAuthorFirstName(resultSet.getString("firstName"));
                author.setAuthorSecondName(resultSet.getString("secondName"));
               author.setAuthorMiddleName(resultSet.getString("middleName"));

                authorCase.add(author);
            }
        } catch (SQLException e) {
            logger.error("Error statement", e);

        }
        return authorCase;
    }


    private void CRUDauthor(String SQL) {
        try {
            Statement statement = new DbConnection().getConnection().createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            logger.error("Error statement, executeUpdate", e);

        }
    }
}
