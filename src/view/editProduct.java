/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.Product;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.ProductService;
/**
 *
 * @author Kiet
 */
public class editProduct extends JFrame {
    private JTextField ProductName,Quantity,CateID;
    private Product product;
    ProductService productService; 
    private JPanel contentPane;
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                     new editProduct(5).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public editProduct(int productId) throws SQLException {
        productService = new ProductService();
        product = productService.getProductById(productId);
        
        ProductName.setText(product.getProductName());
        Quantity.setText(String.valueOf(product.getQuantityLeft()));
        CateID.setText(String.valueOf(product.getCateID()));
        
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Edit Product info");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        lblNewLabel.setBounds(400, 13, 300, 93);
        contentPane.add(lblNewLabel);
        
        JLabel lbProductName = new JLabel("Product Name");
        lbProductName.setBackground(Color.BLACK);
        lbProductName.setForeground(Color.BLACK);
        lbProductName.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lbProductName.setBounds(250, 166, 193, 42);
        contentPane.add(lbProductName);
        
        ProductName = new JTextField();
        ProductName.setFont(new Font("Tahoma", Font.PLAIN, 28));
        ProductName.setBounds(481, 170, 301, 43);
        contentPane.add(ProductName);
        ProductName.setColumns(10);
        
        JLabel lbQuantity = new JLabel("Quantity");
        lbQuantity.setBackground(Color.BLACK);
        lbQuantity.setForeground(Color.BLACK); 
        lbQuantity.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lbQuantity.setBounds(250, 246, 193, 42);
        contentPane.add(lbQuantity);
        
        Quantity = new JTextField();
        Quantity.setFont(new Font("Tahoma", Font.PLAIN, 28));
        Quantity.setBounds(481, 326, 301, 43);
        contentPane.add(Quantity);
        Quantity.setColumns(10);
        
        JLabel lbCateId = new JLabel("CateID");
        lbCateId.setBackground(Color.BLACK);
        lbCateId.setForeground(Color.BLACK); 
        lbCateId.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lbCateId.setBounds(250, 330, 193, 42);
        contentPane.add(lbCateId);
        
        CateID = new JTextField();
        CateID.setFont(new Font("Tahoma", Font.PLAIN, 28));
        CateID.setBounds(481, 250, 301, 43);
        contentPane.add(CateID);
        CateID.setColumns(10);
        
        JButton btnBackButton = new JButton("Back");
         contentPane.add(btnBackButton);
         btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
         btnBackButton.setBounds(400, 410, 230, 63);
         btnBackButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                  try {
                            new ProductPage().setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
                        }
             }
         });
         
         JButton btnEditProductButton = new JButton("confirm edit");
         contentPane.add(btnEditProductButton);
         btnEditProductButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
         btnEditProductButton.setBounds(400, 410, 230, 63);
         btnEditProductButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                        ProductName.setText(product.getProductName());
                        Quantity.setText(String.valueOf(product.getQuantityLeft()));
                        CateID.setText(String.valueOf(product.getCateID()));
                        
                        product.setProductName(ProductName.getText());
                        product.setQuantityLeft(Integer.valueOf(Quantity.getText()));
                        product.setCateID(Integer.valueOf(CateID.getText()));
                        
                        try {
                                productService.updateProduct(product);
                        } catch (SQLException ex){
                            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        try {
                            new ProductPage().setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
         });           
         }
}
