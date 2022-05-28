package com.example.midterm.dbcontext;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ly Quynh Tran
 */
public class DBUtil implements DatabaseInfor {

    private static DBUtil instance;

    public DBUtil() {
    }

    public Connection getConnection() throws ClassNotFoundException {
        try {
//            Class.forName(driverName);
            DriverManager.registerDriver(new SQLServerDriver());
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;



        } catch (SQLException ex) {
           System.out.print(ex);
        }
        return null;
    }

    //Get instance of dbms only one time
    public static DBUtil getInstance() {
        if (instance == null) {
            instance = new DBUtil();
        }
        return instance;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
