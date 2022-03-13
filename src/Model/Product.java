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
public class Product {
    private int id;
    private String  productName;
    private int  quantityLeft;
    private int CateID;
    
    public int getID() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public int getQuantityLeft() {
        return quantityLeft;
    }
    
    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }
    
    public int getCateID() {
        return CateID;
    }
    
    public void setCateID(int cateId) {
        this.CateID = cateId;
    }

    
}
