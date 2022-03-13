/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.User;
import java.sql.*;
import java.util.*;
import Dao.JDBCconnect;
/**
 *
 * @author Kiet
 */
public class UserDao {
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<User>();
        
        Connection connection = JDBCconnect.getJDBCConnection();

        String sql = "SELECT * FROM account";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                User user = new User();
                
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNum(rs.getString("phone"));
                
                users.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();;
        }
        return users;
    }
}
