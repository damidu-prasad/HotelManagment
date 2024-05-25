/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySql {
        private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adyapana_lms", "root", "1234");
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
