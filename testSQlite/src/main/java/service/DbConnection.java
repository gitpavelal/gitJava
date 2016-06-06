package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;


public class DbConnection {
    private final static Logger logger = LoggerFactory.getLogger(DbConnection.class);
//  private static final String URL ="jdbc:sqlite:lesson2.db";
    private final static String URL ="jdbc:sqlite:E:\\_PAVEL\\GIT\\gitJava\\testSQlite\\src\\main\\resources\\lesson2.db";
    private Connection connection;

    public DbConnection() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            logger.error("Error service.DbConnection. ", e);
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
