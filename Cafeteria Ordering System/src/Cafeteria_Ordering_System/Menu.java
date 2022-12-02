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
public class Menu {
    private String name;
    private String price;
    private String itemtype;
    private String picture;

    public Menu(String name, String price, String itemtype, String picture) {
        this.name = name;
        this.price = price;
        this.itemtype = itemtype;
        this.picture = picture;
    }

    public Menu() {
    }
    
    public String addMenu(){
        return name + "," + price + "," + itemtype + "," + picture + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
