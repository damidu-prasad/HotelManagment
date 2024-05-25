package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author SLuda
 */
public class MYSQL {
    
    
      private static Connection c;
    private static final String username = "root";
    private static final String password = "lahiru2001@";
    private static final String database = "hotel";

    public static Statement createConnection() throws Exception {

        if (c == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, username, password);
        }

        Statement s = c.createStatement();
        return s;
    }

    public static void iud(String query) {
        try {

            createConnection().executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ResultSet search(String query) throws Exception {

        ResultSet r = (ResultSet) createConnection().executeQuery(query);

        return r;

    }

    
}
