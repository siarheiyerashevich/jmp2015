

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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
                final List<String> columnList = new LinkedList();

                StringBuilder newTableSb = new StringBuilder();
                newTableSb.append("CREATE TABLE ");
                newTableSb.append(tableName);
                newTableSb.append(" ( ");
                while (columnRs.next()) {
                    final String columnName = columnRs.getString("Field");
                    columnList.add(columnName);
                    newTableSb.append(columnName);
                    newTableSb.append(" ");
                    final String columnType = columnRs.getString("Type");
                    newTableSb.append(columnType);
                    if (!columnRs.isLast()) {
                        newTableSb.append(", ");
                    }
                }
                newTableSb.append(" ); ");
                targetStatement.execute(newTableSb.toString());

                StringBuilder rowsSb = new StringBuilder();
                rowsSb.append("SELECT * FROM ");
                rowsSb.append(tableName);
                ResultSet rowsRs = sourceStatement.executeQuery(rowsSb.toString());


                while (rowsRs.next()) {
                    StringBuilder sbAddRows = new StringBuilder();
                    sbAddRows.append("INSERT INTO ");
                    sbAddRows.append(tableName);
                    sbAddRows.append(" VALUES ( ");
                    for (int columnIndex = 0; columnIndex < columnList.size(); columnIndex++) {
                        final String value = rowsRs.getString(columnList.get(columnIndex));
                        sbAddRows.append("'");
                        sbAddRows.append(value);
                        sbAddRows.append("'");
                        if (columnIndex < columnList.size() - 1) {
                            sbAddRows.append(", ");
                        }
                    }
                    sbAddRows.append(" ); ");
                    targetStatement.executeUpdate(sbAddRows.toString());
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
