/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.ProductDao;
import java.sql.*;
import java.util.*;
import Model.Product;
/**
 *
 * @author Kiet
 */
public class ProductService {
    private ProductDao productDao;
    
    public ProductService() {
        productDao = new ProductDao();
    }
    
    public List<Product> getAllProduct() throws SQLException {
        return productDao.getAllProduct();
    }
    
    public void DeleteProduct(int id) throws SQLException {
        productDao.DeleteProduct(id);
    }
    
    
    public void updateProduct (Product product) throws SQLException {
        productDao.updateProduct(product);
    }

    public Product getProductById(int id) throws SQLException {
        return productDao.getProductById(id);
    }
}
