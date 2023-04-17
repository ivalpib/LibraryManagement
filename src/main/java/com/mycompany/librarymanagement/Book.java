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
 * filename : Book.java
 * purpose: to store and retrieve details of the book in the library
 */
public class Book {
    
    //declaring variables to store book details
    private String bookName; 
    private int ISBN;
    private String bookAuthor;
    private String bookPublication;
    private int bookQuantity;
    
    //creating deafault constructor to add default data
    public Book(){
        bookName = "";
        ISBN = 0;
        bookAuthor = "";
        bookPublication = "";
        bookQuantity = 1;
    }
    
    //creating parameterised constructor to pass the data into variables
    public Book(String name, int isbn, String author, String publication, int quantity){
        this.bookName = name;
        this.ISBN = isbn;
        this.bookAuthor = author;
        this.bookPublication = publication;
        this.bookQuantity = quantity;
    }
    
    //creating set and get method of required variables to protect data 
 
    public void setBookName(String name){
        this.bookName = name;
    }
    public String getBookName(){
        return bookName;
    }
    
    public void setISBN(int isbn){
        this.ISBN = isbn;
    }
    public int getISBN(){
        return ISBN;
    }
    
    public void setBookAuthor(String author){
        this.bookAuthor = author;     
    }
    public String getBookAuthor(){
        return bookAuthor;
    }
    
    public void getBookPublication(String publication){
        this.bookPublication = publication;
    }
    public String getBookPublication(){
        return bookPublication;
    }
    
    public void setQuantity(int quantity){
        this.bookQuantity = quantity;
    }
    public int getQuantity(){
        return bookQuantity;
    }
    
}
