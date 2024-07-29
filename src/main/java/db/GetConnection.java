package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    public static Connection getDatabaseConnection() throws SQLException {
        String databaseConnectionString = "jdbc:mysql://localhost:3306/librarymanagementdb";
        String databaseUserName = "thesk";
        String databasePassword = "sanu";

        Connection connection = DriverManager.getConnection(databaseConnectionString, databaseUserName,
                databasePassword);
        if (connection != null)
            System.out.println("connection successfully established.");

        return connection;
    }
}
