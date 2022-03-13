/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import Dao.JDBCconnect;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kiet
 */
public class addProduct extends JFrame {
    private JTextField ProductName,Quantity,CateID;
    
    private JPanel contentPane;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    addProduct frame = new addProduct();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public addProduct() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Create new Product");
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
         btnBackButton.setBounds(270, 410, 230, 63);
         btnBackButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                  try {
                            dispose();
                            new ProductPage().setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
                        }
             }
         });
         
        JButton btnNewProductButton = new JButton("Add");
        contentPane.add(btnNewProductButton);
         btnNewProductButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
        btnNewProductButton.setBounds(530, 410, 230, 63);
        btnNewProductButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String productname = ProductName.getText();
                int quantity = Integer.valueOf(Quantity.getText());
                int cateId= Integer.valueOf(CateID.getText());
                try {
                    Connection connection = JDBCconnect.getJDBCConnection();
                    String query = "insert into product values('" + productname + "',"+ cateId + "," + quantity +")";
                    System.out.println(query);
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                            JOptionPane.showMessageDialog(btnNewProductButton, "Create new product failed ");
                    } else {
                        JOptionPane.showMessageDialog(btnNewProductButton,
                                "Succesfully add "+ productname +" into product list");
                    }
                    dispose();
                    new ProductPage().setVisible(true);
                    
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                        }
                    }
                });  
    }
}
