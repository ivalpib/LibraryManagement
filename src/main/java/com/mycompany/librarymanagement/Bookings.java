/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement;

/**
 *
 * Student Name : Biplav karki
 * Student Id : 12205788
 * Date : 17/ 02/2023
 * filename : Bookings.java
 * purpose: to store and retrieve information of book and book taken by the user
 */
public class Bookings {
    
    private String username; // variable for name of the user 
    private String userBookName; // variable for book taken by user
    
    
    public Bookings(){
        username = "";
        userBookName = "";
    }
    //creating parameterised constructor to pass the data into variables
    public Bookings(String name, String bookName ){
        this.username = name;
        this.userBookName = bookName;
    }
    
    //creating set and get method of required variables to protect data 
    public void setBookingName(String name){
        this.username = name;
    }
    public String getBookingName(){
        return username;
    }
    
    public void getUserBookName(String bookName){
        this.userBookName = bookName;
    }
    public String getUserBookName(){
        return userBookName;
    }
}
