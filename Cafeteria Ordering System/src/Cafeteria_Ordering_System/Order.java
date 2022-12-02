/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cafeteria_Ordering_System;

/**
 *
 * @author Pang
 */
public class Order{
    public String order_name;
    public String valueselected;
    public String price;
    public String totalprice;
    
    public Order(){ }
    
    public Order(String Order_Name, String Price, String Value_Selected, String Total_Price)
    {
        order_name = Order_Name;
        price = Price;
        valueselected = Value_Selected;
        totalprice = Total_Price;
    }
    
    public String Order()
    {
        return order_name + "," + price + "," + valueselected + "," + totalprice + "\n";
    }
        
    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }
    
}
