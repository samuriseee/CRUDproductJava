/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kiet
 */
public class User {
    private String firstName;
    private String lastName;
    private String username;
    
    private String phone;
    private String password;
    private String email;
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPhoneNum(){
        return phone;
    }
    
    public void setPhoneNum(String phone) {
        this.phone = phone;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
