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
public class Customer {
    private String username;
    private String password;
    private String fullname;
    private String NRIC;
    private String gender;
    
    public Customer(){}
    
    public Customer (String Username, String Password, String Fullname, String nric, String Gender)
    {
        username = Username;
        password = Password;
        fullname = Fullname;
        NRIC = nric;
        gender = Gender;
    }
    
    public String Register()
    {
        return username + "," + password + "," + fullname + "," + NRIC + "," + gender + "\n";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
}
