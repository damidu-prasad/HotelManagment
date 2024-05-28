package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class MYSQL {

    private static Connection connection;
// private static final String username = "root";
//    private static final String password = "lahiru2001@";
//    private static final String database = "hotel_new";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://mysql-2d637d85-ak20010922-0dea.h.aivencloud.com:27927/hotel", "avnadmin", "AVNS_cCIfsbgeGrhrYOJoFnX");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet execute(String query) {
        try {
            Statement statement = connection.createStatement();

            if (query.startsWith("SELECT")) {
                ResultSet resultset = statement.executeQuery(query);
                return resultset;
            } else {
                int result = statement.executeUpdate(query);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
