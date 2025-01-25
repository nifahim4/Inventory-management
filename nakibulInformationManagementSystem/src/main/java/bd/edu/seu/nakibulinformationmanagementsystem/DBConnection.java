package bd.edu.seu.nakibulinformationmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/nakibulInventory";
    private static String username = "root";
    private static String password = "seucse613";

    private static Connection connection;
    private static Statement statement;

    public static Statement getStatement() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }

        if(statement == null) {
            statement = connection.createStatement();
        }

        return statement;
    }

    public static void closeAll() throws SQLException {
        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
    }
}