/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.*;
/**
 *
 * @author Kiet
 */
public class JDBCconnect {

    /**
     * @param args the command line arguments
     */
    public static Connection getJDBCConnection() throws SQLException {
        final String url = "jdbc:sqlserver://DESKTOP-B4NOMFA:1433;databaseName = CRUDuser";
        final String login = "sa";
        final String password = "cabber123";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
