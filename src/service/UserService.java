/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.UserDao;
import java.sql.*;
import java.util.*;
import Model.User;
/**
 *
 * @author Kiet
 */
public class UserService {
    private UserDao userDao;
    
    public UserService() {
        userDao = new UserDao();
    }
    
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    
    
}
