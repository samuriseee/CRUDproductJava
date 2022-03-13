/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import Dao.JDBCconnect;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author Kiet
 */
public class Res extends JFrame {
    
    private JPanel contentPane;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField email;
    private JTextField username;
    private JTextField phone;
    private JPasswordField password;
    private JButton btnNewButton;
    private JButton btnLogButton;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Res frame = new Res();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Res() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewUserRegister = new JLabel("Dang ky tai khoan");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);
        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);
        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);
        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);
        
        firstName = new JTextField();
        firstName.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstName.setBounds(214, 151, 228, 50);
        contentPane.add(firstName);
        firstName.setColumns(10);
        
        lastName = new JTextField();
        lastName.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastName.setBounds(214, 235, 228, 50);
        contentPane.add(lastName);
        lastName.setColumns(10);
        
        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);
        
        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);
        
        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);
        
        phone = new JTextField();
        phone.setFont(new Font("Tahoma", Font.PLAIN, 32));
        phone.setBounds(707, 320, 228, 50);
        contentPane.add(phone);
        phone.setColumns(10);
        
        password = new JPasswordField();
        password.setFont(new Font("Tahoma", Font.PLAIN, 32));
        password.setBounds(707, 235, 228, 50);
        contentPane.add(password);
        
        btnLogButton = new JButton("Login");
        btnLogButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnLogButton.setBounds(326, 447, 162, 73);
        btnLogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                dispose();
                new Log().setVisible(true);
            }
        });
        contentPane.add(btnLogButton);
        
        btnNewButton = new JButton("Dang ky");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstname = firstName.getText();
                String lastname = lastName.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = phone.getText();
                String pass = password.getText(); 
                String msg = "" + firstname;
                msg += " \n";
                try {
                    Connection connection = JDBCconnect.getJDBCConnection();
                    String query = "INSERT INTO account values('" + firstname + "','" + lastname + "','" + userName + "','" +
                            pass + "','" + emailId + "','" + mobileNumber + "')";
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                            JOptionPane.showMessageDialog(btnNewButton, "Tai khoan da ton tai");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Chao mung, " + msg + "Ban da tao tai khoan thanh cong");
                    }
                    dispose();
                    new Log().setVisible(true);
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                        }
                    }
                });
            btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
            btnNewButton.setBounds(526, 447, 162, 73);
            contentPane.add(btnNewButton);
            }    
}
