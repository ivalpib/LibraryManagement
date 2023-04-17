/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement;

/**
 *
 * Author : Biplav karki
 * Date : 17/ 02/2023
 * filename : Fund.java
 * purpose: to store and retrieve fund details
 */
public class Fund {
    //declaring variables to store fund amount and donor name
    private String donorName;
    private int amount;
    
    //creating deafault constructor to add default data
    public Fund(){
        donorName = "";
        amount = 0;
    }
    //creating parameterised constructor to pass the data into variables
    public Fund(String name, int money){
        this.donorName = name;
        this.amount = money;
    }
    
    //creating set and get method of required variables to protect data 
    public void setDonorName(String name){
        this.donorName = name;
    }
    
    public String getDonorName(){
        return donorName;
    }
    
    public void setAmount(int money){
        this.amount = money;
    }
    
    public int getAmount(){
        return amount;
    }
    
    //creating method to generate badge according to the amount donated by the user
    public String generateBadge(){
        
        String badge = "";
        if(amount > 1000)
        {
            badge = "Gold";
            return badge;
        }
        else if (amount > 500)
        {
            badge = "Silver";
            return badge;
        }
        else if (amount > 200)
        {   
            badge =  "Bronze";
            return badge;
        }
        else{
            badge = "Normal";
            return badge;
        }    
    }
    
}
