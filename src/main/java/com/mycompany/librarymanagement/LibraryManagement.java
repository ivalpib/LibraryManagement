/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagement;

import java.util.Scanner;

/**
 *
 * Author : Biplav karki
 * Date : 17/ 02/2023
 * filename : LibraryManagement.java
 * purpose: main class to run the program
 */
public class LibraryManagement {
    
    //creating required constant, int and String variables
    final int ADD_BOOK = 1;
    final int SEARCH_BOOK = 2;
    final int AVAILABLE_BOOK = 3;
    final int TAKE_BOOK = 4;
    final int RETURN_BOOK = 5;
    final int DONATE_BOOK = 6; 
    final int BOOK_RECORD = 7;
    final int DONATE_FUND = 8;
    final int HONOUR_BADGE = 9;
    final int DONOR_STATISTIC = 10;
    final int EXIT = 11;
    final int N = 8; // declaring N = 8 as largest number of student id is 8.
    int count = 0;
    int searchCount = 0;
    
    private String bookName;
    private String checkISBN;
    private int ISBN;
    private String bookAuthor;
    private String bookPublication;
    private String checkBookQuantity;
    private int bookQuantity;
    Book book[] = new Book[N]; // creating book object to store multiple book details
    
    private String username;
    private String userBookName;
    int bookCount = 0;
    Bookings newBooking[] = new Bookings[N]; // creating newBooking object to store multiple users details who take the books 
    
    private String fundDonorName;
    private String checkFundAmount;
    private int fundAmount;
    Fund newFund[] = new Fund[N]; // creating newFund object to store details of the users who donate fund
    int fundCount = 0;
    private int chance = 1 ;
    
    //creating a method to take user choice for the menu
    private void takeChoice()
	{
            Scanner inputMenuChoice = new Scanner(System.in);

            int choice = getMenuChoice();

            while (choice != EXIT)
            {
                switch (choice)
                {
                        case ADD_BOOK:
                                addBook();
                                break;
                        case SEARCH_BOOK:
                                checkAvailability();
                                break;
                        case AVAILABLE_BOOK:
                                availableBook();
                                break;
                        case TAKE_BOOK:
                                takeBook();
                                break;
                        case RETURN_BOOK:
                                returnBook();
                                break;
                        case DONATE_BOOK:
                                donateBook();
                                break;
                        case BOOK_RECORD:
                                bookRecord();
                                break;
                        case DONATE_FUND:
                                donateFund();
                                break;
                        case HONOUR_BADGE:
                                honourBadge();
                                break;
                        case DONOR_STATISTIC:
                                donorStatistic();
                                break;
                        default:
                                System.out.println("ERROR choice not recognised.");
                }
                choice = getMenuChoice();
            }
            
            System.out.println("\nThank you for using our Non-Profit Library Management System \nProgram written by 12205788 ");
	}
    
    //creating a method to add book in the Library system
    private void addBook(){
        
        // creating required variables for the method
        
        int i = count;
        String quantityChoice;
        int newQuantity;
        
        Scanner newScan = new Scanner(System.in); // creating a scanner to take user input
        
        System.out.print("Enter the book name: ");
        bookName = newScan.nextLine();
        
        //using while loop to validate bookName data
        while (bookName.equals("") || isStringNumeric(bookName))
            {
                System.out.println("Error - Book Name cannot be blank and must not be numeric.");
                System.out.print("Please enter the book name correctly: ");
                bookName = newScan.nextLine();
            }
        
        System.out.print("Please enter the name of the author: ");
        bookAuthor = newScan.nextLine();
        
        // using while loop to validate bookAuthor data
        while (bookAuthor.equals("") || isStringNumeric(bookAuthor))
            {
                System.out.println("Error - Author name cannot be blank and must not be numeric.");
                System.out.print("Please enter the author name correctly: ");
                bookAuthor = newScan.nextLine();
            }
        //creating a for loop read all the data from book object
        for (int j = 0;j < count; j++){
                
                //using while loop to stop user from adding same book with same author 
                while (book[j].getBookName().equalsIgnoreCase(bookName) && book[j].getBookAuthor().equalsIgnoreCase(bookAuthor))
                {
                    
                    System.out.println("ERROR - book with same book name and same author cannot be added. ");
                    System.out.println("But you can increase the quantity. ");
                    System.out.print("Are you sure you want to add more of same book. (Y/N): ");
                    quantityChoice = newScan.nextLine();
                    
                    //creating while loop to ensure quantityChoice gets a data
                    while (quantityChoice.equals("")){
                        System.out.println("ERROR - Book quantity cannot be blank or string value");
                        System.out.print("PLease enter 'Y'/'N' or 'Yes'/ 'No'");
                    }
                    
                    //using if, else if and else condtition to ensure the user choice 
                    
                    if (quantityChoice.equalsIgnoreCase("Y")||quantityChoice.equalsIgnoreCase("YES"))
                    {
                        System.out.print("How many book you want to add?: ");
                        newQuantity = newScan.nextInt();
                        
                        book[j].setQuantity(book[j].getQuantity()+newQuantity);
                        return;
                        
                    }
                    else if(quantityChoice.equalsIgnoreCase("N")||quantityChoice.equalsIgnoreCase("NO"))
                    {
                        System.out.print("Please enter the different book name : ");
                        bookName = newScan.nextLine();
                        
                        //creating while loop to ensure bookName is not empty or numeric
                        while (bookName.equals("") || isStringNumeric(bookName))
                        {
                            System.out.println("Error - Book Name cannot be blank and must not be numeric.");
                            System.out.print("Please enter the book name correctly: ");
                            bookName = newScan.nextLine();
                        }

                        System.out.print("Please enter the name of the author: ");
                        bookAuthor = newScan.nextLine();
                        
                        //creating while loop to ensure bookAuthor is not empty or numeric
                        while (bookAuthor.equals("") || isStringNumeric(bookAuthor))
                        {
                            System.out.println("Error - Author name cannot be blank and must not be numeric.");
                            System.out.print("Please enter the name of the author correctly: ");
                            bookAuthor = newScan.nextLine();
                        }
                        
                        if(book[j].getBookName().equalsIgnoreCase(bookName) && book[j].getBookAuthor().equalsIgnoreCase(bookAuthor)){
                            chance = chance +1;
                            System.out.println("\nYou entered same book");
                            if(chance == 2){
                                break;
                            }
                            addBook();
                        }
                    }
                    else{
                        System.out.println("ERROR - Quantity cannot be read. Please re - enter the details. ");
                        System.out.print("Please enter the different book name : ");
                        bookName = newScan.nextLine();
                        //creating while loop to ensure bookName is not empty or numeric
                        while (bookName.equals("") || isStringNumeric(bookName))
                        {
                            System.out.println("Error - Book Name cannot be blank and must not be numeric.");
                            System.out.print("Please enter the book name correctly: ");
                            bookName = newScan.nextLine(); // storing user input into variable
                        }

                        System.out.print("Please enter the name of the author: ");
                        bookAuthor = newScan.nextLine(); //storing user input into variable
                        
                        //creating while loop to ensure bookAuthor is not empty or numeric
                        while (bookAuthor.equals("") || isStringNumeric(bookAuthor))
                        {
                            System.out.println("Error - Author name cannot be blank and must not be numeric.");
                            System.out.print("Please enter the name of the author correctly: ");
                            bookAuthor = newScan.nextLine();
                        }
                        
                    }
                    
                }
                
            }
        Scanner newScan1 = new Scanner(System.in); //creating scanner to read user and store user input
        
        System.out.print("Please enter the name of the publication: ");
        bookPublication = newScan1.nextLine();
        
        //creating while loop to ensure bookPublication is not empty or numeric
        while (bookPublication.equals("") || isStringNumeric(bookPublication))
            {
                System.out.println("Error - Publication for the book cannot be blank and must not be numeric.");
                System.out.print("Please enter the name of the publication correctly: ");
                bookPublication = newScan1.nextLine();
            }
        
        System.out.print("Please enter the ISBN number: ");
        checkISBN = newScan1.nextLine();
        
        //creating while loop to ensure ISBN is not empty or string
        while(checkISBN.equals("") ||!isStringNumeric(checkISBN)){
            System.out.println("ERROR - ISBN number cannot be blank or string value.");
            System.out.print("Please enter numbers for ISBN: ");
            checkISBN = newScan1.nextLine();
        }
        ISBN = Integer.parseInt(checkISBN); 
        
        System.out.print("Please enter the quantity of the book: ");
        checkBookQuantity = newScan1.nextLine();
        
        //using while loop to ensure the quantity is number and not empty
        while(checkBookQuantity.equals("") ||!isStringNumeric(checkBookQuantity)){
            System.out.println("ERROR - Book quantity cannot be blank or string value.");
            System.out.print("Please enter numbers for quantity: ");
            checkBookQuantity = newScan1.nextLine();
        }
        bookQuantity = Integer.parseInt(checkBookQuantity);
        
        book[i] = new Book(bookName, ISBN, bookAuthor, bookPublication, bookQuantity);
        count++;
        System.out.println("\n*** Book: '"+book[i].getBookName()+ "' has been successfully added ***");
        
    }
    private void checkAvailability()
    {   
        //using if condition to terminate if there is not a single book to search
        if (count < 1)
        {
            System.out.println("\nERROR - Please enter at least one book to search availability.");
            return;
        }
        
        //creating required variables for the method
        String searchBook;
        boolean flag = false;
        Scanner search = new Scanner(System.in);
        System.out.println("\n*** You can check the book availability here. ***\n");
        System.out.print("Please enter the name of book you want to search: ");
        searchBook = search.nextLine(); //taking user input for searching 
        
        //using for loop to read all the books from book object
        for (int i = 0; i < count ; i++)
        {
            
            // using if condition to check the user input match the data in object or not
            if(book[i].getBookName().equalsIgnoreCase(searchBook)){
                System.out.println("\n*** The book you are searching is available. ***\n");
                System.out.printf("%-25s%-15s%-25s%-25s%-15s\n","Book name","ISBN","Author","Publication","Quantity");
                
                printAllBooks(book[i]);
                return;
            }
            else 
            {
                flag = false;
            }
        }
        
        //using if condition to print unavailability of book if there is no book found
        if (flag == false){
            System.out.println("'"+searchBook+"' is not available.");
            System.out.println("*** Please try searching with different name. ***"); 
            searchCount = searchCount + 1;
            System.out.print(searchCount);
        }
        
        //using if condition to give user atleast 2 more times to search with correct book name
        if (searchCount <= 2){
            checkAvailability();
        }
        //returns to main menu if users could not find the book they search for 3 times
        else{
            return;
        }
        
    }
    
    //creating a method to show all available books in the library
    private void availableBook(){   
        
        //using if condtion to terminate error if there is no books in library
        if (count < 1){
            System.out.println("ERROR - There are no available books now.");
            System.out.println("Please add books to view.");
            return;
        }
        
        //declaring required variables for the method
        double totalQuantity = 0;
        int maxIndex = 0;
        double averageQuantity;
        int maximum = book[0].getQuantity();
        int minIndex = 0;
        int minimum = book[0].getQuantity();
       
        // printing the data with formatting the data to make better interface
        System.out.printf("%-25s%-15s%-25s%-25s%-15s\n","Book name","ISBN","Author","Publication","Quantity");
        
        
        //using for loop to read all data from book object to get total quantity
        for (int i = 0; i < count; i++){
            printAllBooks(book[i]);
            totalQuantity = totalQuantity + book[i].getQuantity();
        }
        
        //using for loop to read all data from book object to get index of maximum quantity
        for (int i = 1; i < count; i++){
            if(book[i].getQuantity() > maximum)
            {
                maximum = book[i].getQuantity();
                maxIndex = i;
            }
        }
        
        //using for loop to read all data from book object to get index of minimum quantity
        for (int i = 1; i < count; i++){
            if (book[i].getQuantity() < minimum)
            {
                minimum = book[i].getQuantity();
                minIndex = i;
            }
        }
        
        averageQuantity = totalQuantity / count; // calculating average
        
        //printing maximum, minimum, total and average of the books quantity in the library
        System.out.print("\n");
        System.out.print(book[minIndex].getBookName()+" has the minimum number with "+book[minIndex].getQuantity()+ " books.\n");
        System.out.print(book[maxIndex].getBookName()+" has the maximium number with "+book[maxIndex].getQuantity()+" books. \n");
        System.out.print("The total number of books in the Library is "+totalQuantity);
        System.out.println("\nThere are total "+count+" types of book stored in Library.");
        System.out.printf("The average quantity per book is %.2f", averageQuantity);
        System.out.print("\n");
        
    }
    
    //creating a method to print the book according to the parameter
    private void printAllBooks(Book b){
        System.out.printf("%-25s%-15s%-25s%-25s%-15s\n", b.getBookName(),b.getISBN(),b.getBookAuthor(),b.getBookPublication(),b.getQuantity());
    }
    
    //creating a method showing available books as a menu
    private void bookMenu(Book m){
        
        System.out.print(m.getBookName());
           
    }
    
    //creating a method to take book 
    private void takeBook(){
        
        //using if condtion if there is no book to take
        if (count < 1){
            System.out.println("ERROR - There are no available books now.");
            System.out.println("Please add books to take the book.");
            return;
        }
        
        //creating required variables
        int choiceIndex;
        String checkChoiceIndex;
        System.out.println("\n*** List of available books in the Library. ***");
        
        System.out.printf("%-11s%-10s","S.No.", "Book Name"); //printing the data with formatting them
        
        //using for loop to read all the books to create menu for the user to take
        for (int i = 0;i < count; i++){
                
                System.out.printf("\n %-9s ",i+1);
                bookMenu(book[i]); //calling a method with passing the value to the method parameter
            }
        
        Scanner choice = new Scanner(System.in); // creating scanner to take user input and read data
        System.out.print("\n\nPlease select the book with serial number (S.NO.): ");
        checkChoiceIndex = choice.nextLine();
        
       // using while loop to ensure the variable is not empty or string value
        while(checkChoiceIndex.equals("")||!isStringNumeric(checkChoiceIndex)){
            System.out.println("Error - ISBN number cannot be blank or string value.");
            System.out.print("Please enter numbers for ISBN: ");
            checkChoiceIndex = choice.nextLine();
        }
        
        choiceIndex = Integer.parseInt(checkChoiceIndex) - 1; // changing string data to integer to store in integer data type

        System.out.println("You have selected '"+book[choiceIndex].getBookName()+"'");
        userBookName = book[choiceIndex].getBookName();
        
        Scanner userInfo = new Scanner(System.in); //creating a scanner to read user input
        System.out.print("Enter your name: ");
        username = userInfo.nextLine();
        
        //using while loop to ensure the variable wont be empty or numbers
        while (username.equals("") || isStringNumeric(username))
        {
            System.out.println("Error - Username cannot be blank and cannot be numbers.");
            System.out.print("Please enter your name carefully: ");
            username = userInfo.nextLine();
        }
        
        newBooking[bookCount] = new Bookings(username, userBookName); //storing values on object 
        bookCount = bookCount + 1; // increasing book count to count the total books taken
        
        book[choiceIndex].setQuantity(book[choiceIndex].getQuantity() - 1); // decreasing the quantity of book from library when user take the book 
        
        System.out.println("*** '"+newBooking[bookCount-1].getBookingName()+"' took the book '"+book[choiceIndex].getBookName()+"' ***");
        
    }
    
    //creating a method to return the taken books
    private void returnBook(){
        
        //using if condition to terminate if there is no taken books
        if (bookCount < 1){
            System.out.println("ERROR - There are no taken books now.");
            System.out.println("Please take books to return.");
            return;
        }
        
        //creating required variables
        String checkReturnChoiceIndex;
        int returnChoiceIndex;
        int k;
        String indexBookName;
     
        System.out.println("\n   ***** Booking list *****\n");
        System.out.printf("%-11s%-15s%-10s","S.No","Book Taken By","Book Name"); //formatting the data
        
        //using for loop to read all the taken books
        for(int i = 0; i < bookCount; i++){  
            System.out.printf("\n %-9s ",i+1);
            allTakenBook(newBooking[i]);   // calling a method to print the data according to the value passed to the certain method  
        }
        
        Scanner returnChoice = new Scanner(System.in); // creating a scanner to read user input 
        System.out.print("\n\nPlease select the book with serial number (S. No.) to return: ");
        checkReturnChoiceIndex = returnChoice.nextLine();
        
        //using while loop to validate
        while(checkReturnChoiceIndex.equals("") ||!isStringNumeric(checkReturnChoiceIndex))
        {
            System.out.print("ERROR - Book selection cannot be blank or string value.");
            System.out.print("Please enter serial numbers (S.No.) to select the book:  ");
            checkReturnChoiceIndex = returnChoice.nextLine();
        }
        
        returnChoiceIndex = Integer.parseInt(checkReturnChoiceIndex) - 1 ;
        System.out.println("*** You have selected '"+newBooking[returnChoiceIndex].getUserBookName()+"' book to return which was taken by '"+newBooking[returnChoiceIndex].getBookingName()+"'.***");
        
        indexBookName = newBooking[returnChoiceIndex].getUserBookName();
        
        //using for loop to read all the books from the library
        for (int a = 0; a < count; a++)
        {
            if(indexBookName.equalsIgnoreCase(book[a].getBookName()))
            {
                book[a].setQuantity(book[a].getQuantity()+1); // updating the library when user return the book
            }
        }
        
        k = returnChoiceIndex;
        
        //using for loop to update the newBooking object when user returned the book
        for (int j = 0; j < bookCount - returnChoiceIndex; j++)
        {
            newBooking[k] = newBooking[k+1];
            k++;
            
        }
        
        bookCount = bookCount - 1; // decreasing the book count to update the taken book history when user return the book 
        
    }
    
    //creating parametised method to print all taken books
    private void allTakenBook(Bookings t)
    {
        
        System.out.printf("%-15s%-1s",t.getBookingName(),t.getUserBookName());
        
    }
   
    //creating a method to show the record of the book taken
    private void bookRecord()
    {
        //using if condition to terminate if there is no books taken
        if (bookCount < 1){
            System.out.println("ERROR - There is not a single book taken until now to show history.");
            System.out.println("Please take books to create history.");
            return;
        }
        
        System.out.println(" ***** Booking list *****");
        System.out.printf("%-11s%-15s%-10s","S.No","Book Taken By","Book Name"); //formatting and printing ther data
        for(int i = 0; i < bookCount; i++){
            
            System.out.printf("\n %-9s ",i+1);
            allTakenBook(newBooking[i]); // calling a method to print data according to passing object value
            
        }
        System.out.print("\n");
        
    }
    
    //creating a method to donate the book 
    private void donateBook()
    {   System.out.println("\n*** Donate Book Here ***");
        System.out.println(">>>Please enter the book details to add on Library System<<<");
        addBook(); // calling a addBook method to add the book details
        System.out.println("*** Thank you for donating books to the Library System. ***");
        System.out.println("***** Looking forward to have amazing people like you. *****");
    }
    
    //creating a method to donate the fund for library
    private void donateFund()
    {
        Scanner fund = new Scanner(System.in); //creating a scanner to take user input
        System.out.println("\n*** You can donate fund for support Library here. *** ");
        System.out.print("Please enter your name: ");
        fundDonorName = fund.nextLine();
        
        //using while loop to validate data with empty or numbers
        while(fundDonorName.equals("")||isStringNumeric(fundDonorName)){
            System.out.println("Error -  Donor Name cannot be blank or cannot be numbers.");
            System.out.print("Please  enter your name: ");
            fundDonorName = fund.nextLine();
        }
        
        for (int i = 0; i < fundCount;i++){
            if (newFund[i].getDonorName().strip().equalsIgnoreCase(fundDonorName.strip())){
                System.out.println(newFund[i].getDonorName()+" is already existed in the system who have donated $" +newFund[i].getAmount() );
                System.out.println("Do want to donate more ?"); 
                Scanner scan = new Scanner(System.in);
                String userChoice = "";
                while(userChoice == "" ){
                    while (!userChoice.equalsIgnoreCase("N") && !userChoice.equalsIgnoreCase("Y")){
                        System.out.print(" Press \"Y\" to proceed and \"N\" to cancel. ");
                        userChoice = scan.nextLine().toUpperCase();
                         System.out.println(userChoice);   
                    }
                
                }
                
            }
        }
        
        
        System.out.print("Please enter the amount you want to donate: $");
        checkFundAmount = fund.nextLine();
        
         //using while loop to validate data with empty or string
        while(checkFundAmount.equals("")||!isStringNumeric(checkFundAmount)){
            System.out.println("Error -  Donating amount cannot be blank or string value.");
            System.out.print("Please enter the amount you want to donate: $");
            checkFundAmount = fund.nextLine();
        }
        fundAmount = Integer.parseInt(checkFundAmount); // parsing the string value into integer to store in integer variable
        
        //creating required variable within the method
        
        newFund[fundCount] = new Fund(fundDonorName, fundAmount); // storing data into the object
        honour(newFund[fundCount]); // passing data to honour method
        fundCount = fundCount + 1; //increasing the fundCount to trace total number of donation made by the users
        
    }
    
    //creating a parametised method to print the value according to the parameter
    private void honour(Fund f){
        //using if and else condition to print the donated amount with their repsective badge
        if (f.generateBadge().equalsIgnoreCase("normal")){
            System.out.println("You have donated $"+f.getAmount());
            System.out.println(" *** Thank you for your huge support for us. ***");
            System.out.println("If you donate more, you can earn a badge");
            System.out.println("1. Gold badge (above $1000)");
            System.out.println("2. Silver badge (above $500)");
            System.out.println("3. Bronze badge (above $200)");
        }
        else{
            System.out.println("You have donated $"+f.getAmount());
            System.out.println(" *** You have unlocked "+f.generateBadge()+" badge. ***");
            System.out.println(" *** Thank you for your huge support for us. ***");
        }
        
    }
    
    //creating a method to print data according to parameter
    private void printHonour(Fund d){
              
        System.out.println(d.getDonorName() + " has donated $"+d.getAmount()+" and achieved "+d.generateBadge()+" badge");
    
    }
    
    //creating a method to show statistical data 
    private void honourBadge()
    {   
        //using if condition to terminate the method if there is no single donation made for the library
        if (fundCount < 1){
            System.out.println("ERROR - Not a single person has donated fund.");
            System.out.println("Library need at least one donor to show their honour.");
            return;
        }
        
        // initialising the required variables for the method
        int goldCount = 0;
        int silverCount = 0;
        int bronzeCount = 0;
        System.out.println("\nGold Badge"); 
        
        //using for loop to read all data of newFund object
        for(int i = 0; i < fundCount; i++){ 
            
            //using if condition to print gold badge user
            if(newFund[i].generateBadge().equalsIgnoreCase("Gold")){
                printHonour(newFund[i]);
                goldCount = goldCount + 1; // to count total gold badge user
            }   
        }
        System.out.println("There are total "+goldCount+ " Gold Badge owner.");
        System.out.println("\nSilver Badge"); 
        
        //using for loop to read all data of newFund object
        for(int i = 0; i < fundCount; i++){   
            
            //using if condition to print silver badge user
            if(newFund[i].generateBadge().equalsIgnoreCase("Silver")){
                printHonour(newFund[i]);
                silverCount = silverCount + 1; // to count total silver badge user
            }   
        }
        System.out.println("There are total "+silverCount+ " Silver Badge owner.");
        System.out.println("\nBronze Badge");
        
        //using for loop to read all data of newFund object
        for(int i = 0; i < fundCount; i++){   
            
            //using if condition to print bronze badge user
           if(newFund[i].generateBadge().equalsIgnoreCase("Bronze")){
                printHonour(newFund[i]);
                bronzeCount = bronzeCount + 1; // to count total bronze badge user
            } 
        } 
       System.out.println("There are total "+bronzeCount+ " Bronze Badge owner.");
       
    }
    
    //creating a method print all the donors until now
    private void printAllDonor(Fund all){
        System.out.printf("%-15s%-15s%-3s",all.getDonorName(),all.getAmount(),all.generateBadge());
    }
    
    //creating a method to sort all the data of newFund object according to the quantity
    private void sortFundByAmount(){
        
        //using for loop to sort the data
        for(int i = 0;i < fundCount - 1 ;i++){
                int index = i;
                for(int j = i + 1; j < fundCount; j++){
                    if(newFund[j].getAmount()>(newFund[index].getAmount()) ){
                        index = j;
                    }
                }
                Fund small = newFund[index];
                newFund[index] = newFund[i];
                newFund[i] = small;
                
            }
    }
    
    //creating a method to show the donor statistical data
    private void donorStatistic()
    {
        //using if conditions to terminate the method if no person has donate fund to the library
        if (fundCount < 1){
            System.out.println("ERROR - Not a single person has donated fund.");
            System.out.println("To show donor statistics, there should be at least one donor");
            return;
        }
        
        //initialiasing required variables within the method
        double average = 0;
        double total = 0;
        sortFundByAmount(); // calling the sort method to sort the data
        System.out.print("\n*** List of Donor to help our Library ***\n");
        System.out.printf("%-12s%-15s%-15s%-3s","S. No.","Donor Name","Amount","Badge");//printing and formatting data
        
        //using for loop to read all the data on newFund object
        for (int i = 0; i < fundCount; i++){
            System.out.print("\n");
            System.out.printf("  %-10s",i+1);
            printAllDonor(newFund[i]);
            total = total + newFund[i].getAmount(); // to calculate total amount received
        }
        average = total / fundCount; // to calculate the average of the amount received per user
        
        //printing the statistical data
        System.out.printf("\n\nLibrary has received total of $%.2f",total);
        System.out.print(" from the donation fund.");
        System.out.print("\nLibrary has received contribution from "+fundCount+" users till now.");
        System.out.printf("\nLibraray has received average of $%.2f",average); // formating the average value in 2 decimal 
        System.out.println(" per user.");
    }
    
    
    //creating a method to show the menu of the interface and take the choice
    private int getMenuChoice()
    {
        String menuChoice;
        int selectChoice;
        System.out.println("\nPlease Select from the following");
        System.out.println("1. Add Book");
        System.out.println("2. Search book availability");
        System.out.println("3. Available Book");
        System.out.println("4. Take Books");
        System.out.println("5. Return Books");
        System.out.println("6. Donate Books");
        System.out.println("7. Taken Book Record");
        System.out.println("8. Donate Fund ");
        System.out.println("9. Display Honour Badge");
        System.out.println("10. Display Donor Statistic");
        System.out.println("11. Exit");
        System.out.print("Enter your choice: ");
        
        Scanner getChoice = new Scanner(System.in); // creating a scanner to take user input
        String choice = getChoice.nextLine();
        
        //using while loop to validate empty data or string data
        while(choice.equals("") ||!isStringNumeric(choice))
        {
            System.out.println("ERROR - Book selection cannot be blank or string value");
            System.out.print("Please enter serial numbers (S.No.) to select menu option:  ");
            choice = getChoice.nextLine();
            
        }
        selectChoice = Integer.parseInt(choice); // parsing the string data into integer to store in a variable
        
        //using while loop to ensure the choice entered is between 1-11
            while(selectChoice < 1 || selectChoice > 11){
                System.out.println("Error -  Please select between 1 to 11 ");
                System.out.print("Enter choice==> ");
                menuChoice = getChoice.nextLine();
                
                //using while loop to validate empty data or string data
                while(menuChoice.equals("") ||!isStringNumeric(menuChoice)){
                    System.out.println("ERROR - Book selection cannot be blank or string value");
                    System.out.print("Please enter serial numbers (S.No.) to select menu option:  ");
                    menuChoice = getChoice.nextLine();
                }
                selectChoice = Integer.parseInt(menuChoice); //parsing the string data into integer to store in a variable
            }

         return selectChoice; //returning value to the method which calls this method
        
    }
    //creating a method to validate the data 
    private boolean isStringNumeric(String str)
	{
            //using for loop to read the character according to the length of the data
            for (int i = 0; i < str.length(); i++)
            {
                //using if condition to check data is digit
                if (!Character.isDigit(str.charAt(i)))
                        return false; // returns the value (false) to the method which call this method
            }

            return true; // returns the value (true) to the method which call this method
	}
    
    //creating a main method 
    public static void main(String[] args) {
        System.out.println("*** Welcome to Our non-profit Library ***");
        
        
        LibraryManagement app = new LibraryManagement(); // creating an app object
        app.takeChoice(); // calling the method
        
    }
}
