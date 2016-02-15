

import java.sql.*;

/**
 * Created by TheFallen on 2/10/16.
 */
public class DatabaseCopyConsoleTool {

    private static final String HOST = "jdbc:mysql://localhost:3306/mentee?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";
    private static final String SCHEMA = "mentee";

    private static Statement statement = null;
    private static Connection connection = null;

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver").getInterfaces();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            System.out.println(connection.toString());
            statement = connection.createStatement();

            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
