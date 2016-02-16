

import java.sql.*;

/**
 * Created by TheFallen on 2/10/16.
 */
public class DatabaseCopyConsoleTool {

    private static final String SOURCE_HOST = "jdbc:mysql://localhost:3306/mentee?autoReconnect=true&useSSL=false";
    private static final String TARGET_HOST = "jdbc:mysql://localhost:3306/target?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";
    private static final String SOURCE_SCHEMA = "mentee";
    private static final String TARGET_SCHEMA = "target";

    private static Statement sourceStatement = null;
    private static Statement targetStatement = null;
    private static Connection sourceConnection = null;
    private static Connection targetConnection = null;

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver").getInterfaces();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            sourceConnection = DriverManager.getConnection(SOURCE_HOST, USERNAME, PASSWORD);
            sourceStatement = sourceConnection.createStatement();
            targetConnection = DriverManager.getConnection(TARGET_HOST, USERNAME, PASSWORD);
            targetStatement = targetConnection.createStatement();

            DatabaseMetaData md = sourceConnection.getMetaData();
            ResultSet tablesRs = md.getTables(null, null, "%", null);
            while (tablesRs.next()) {
                final String tableName = tablesRs.getString(3);
                // get column names from curent table
                StringBuilder columnsSb = new StringBuilder();
                columnsSb.append("SHOW COLUMNS FROM ");
                columnsSb.append(tableName);
                columnsSb.append(" FROM ");
                columnsSb.append(SOURCE_SCHEMA);
                ResultSet columnRs = sourceStatement.executeQuery(columnsSb.toString());

                StringBuilder newTableSb = new StringBuilder();
                newTableSb.append("CREATE TABLE ");
                newTableSb.append(tableName);
                newTableSb.append(" ( ");
                while (columnRs.next()) {
                    final String columName = columnRs.getString("Field");
                        newTableSb.append(columName);
                        newTableSb.append(" varchar(255)");
                        if (!columnRs.isLast()) {
                            newTableSb.append(", ");
                        }
                }
                newTableSb.append(" ); ");
                targetStatement.execute(newTableSb.toString());



            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
