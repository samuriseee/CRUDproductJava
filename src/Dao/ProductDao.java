/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.Product;
import java.sql.*;
import java.util.*;
import Dao.JDBCconnect;
/**
 *
 * @author Kiet
 */
public class ProductDao {
    public List<Product> getAllProduct() throws SQLException {
        List<Product> products = new ArrayList<Product>();
        
        Connection connection = JDBCconnect.getJDBCConnection();

        String sql = "SELECT * FROM product";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Product product = new Product();
                
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("productName"));
                product.setQuantityLeft(rs.getInt("quantityLeft"));
                product.setCateID(rs.getInt("CateId"));
                
                products.add(product);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public Product getProductById(int id) throws SQLException {
        
        Connection connection = JDBCconnect.getJDBCConnection();

        String sql = "SELECT * FROM product WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("productName"));
                product.setQuantityLeft(rs.getInt("quantityLeft"));
                product.setCateID(rs.getInt("CateId"));
                

                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void DeleteProduct(int id) throws SQLException {

        Connection connection = JDBCconnect.getJDBCConnection();

        String sql = "delete from product where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void updateProduct(Product product) throws SQLException {

        Connection connection = JDBCconnect.getJDBCConnection();

        String sql = "UPDATE product SET productName = ?,quantityLeft = ?, CateId=? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getQuantityLeft());
            preparedStatement.setInt(3, product.getCateID());
            preparedStatement.setInt(4, product.getID());
           
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
