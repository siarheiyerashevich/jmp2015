
import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by TheFallen on 2/10/16.
 */
public class HighloadWritingConsoleTool extends Thread {

    private static final String HOST = "jdbc:mysql://localhost:3306/mentee?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";

    private Statement statement = null;
    private Connection connection = null;
    private static int tableCount = 10;
    private static int columnCount = 100;
    private static int rowCount = 10000;
    private static int threadCount = 5;
    private static int tableCounter;

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver").getInterfaces();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        for (int thr = 0; thr <= threadCount; thr++) {
            HighloadWritingConsoleTool thread = new HighloadWritingConsoleTool();
            tableCounter = thr*50;
            thread.start();

        }
    }

    public void run() {

        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            System.out.println(connection.toString());
            statement = connection.createStatement();

            for( int table = 0; table<=tableCount; table++) {
                StringBuilder sb = new StringBuilder();
                final String tableName = "Table" + tableCounter++;
                sb.append("CREATE TABLE ");
                sb.append(tableName);
                sb.append(" ( ");
                for (int column = 0; column<=columnCount; column++) {
                    sb.append("Column");
                    sb.append(column);
                    sb.append(" varchar(255)");
                    if(column<columnCount) {
                        sb.append(", ");
                    }
                }
                sb.append( " ); ");
                statement.execute(sb.toString());

                for (int row=0; row<=rowCount; row++) {
                    StringBuilder sbAddRows = new StringBuilder();
                    sbAddRows.append("INSERT INTO ");
                    sbAddRows.append(tableName);
                    sbAddRows.append(" VALUES ( ");

                    for(int value = 0; value<=columnCount; value++) {
                        sbAddRows.append("'value'");
                       if (value < columnCount) {
                            sbAddRows.append(", ");
                        }
                    }
                    sbAddRows.append( " ); ");
                    statement.execute(sbAddRows.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    connection.close();
            } catch (SQLException se) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
