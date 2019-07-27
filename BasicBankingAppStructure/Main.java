package com.ExampleProject;

import java.util.Scanner;

public class Main {

    private static Scanner myScanner = new Scanner(System.in);
    private static Bank myBank = new Bank();


    public static void main(String[] args) {
        System.out.println("Welcome to Bank World");
        boolean runProgram = true;
        while(runProgram){
            printOutOptions();
            int response = myScanner.nextInt();
            myScanner.nextLine();
            switch(response){
                case 0:
                    System.out.println("\nShutting down...");
                    runProgram = false;
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    System.out.println("What branch does the new customer want to go to?");
                    String newCustomerBranch = myScanner.nextLine();
                    addNewCustomer(newCustomerBranch);
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    System.out.println("Would you like to see transactions as well? (Y/N)");
                    String answer = myScanner.nextLine();
                    boolean showTrans = false;
                    if(answer.toLowerCase().equals("y")){
                        showTrans = true;
                    }
                    System.out.println("What branch would you like to see the list for?");
                    String branchName = myScanner.nextLine();
                    showAllCustomers(showTrans,branchName);
                    break;
            }
        }

        System.out.println("Good Bye");
    }


    private static void printOutOptions(){
        System.out.println("\nPlease select from the following options \npress");
        System.out.println("0 - shutdown\n" +
                "1 - Add a new bank branch\n" +
                "2 - Add a new customer \n" +
                "3 - Add a transaction for existing customer\n" +
                "4 - Show all customers");
        System.out.println("Choose your action");
    }

    private static void addBranch(){
        System.out.println("What is the name of the new branch?");
        String branchName = myScanner.nextLine();
        boolean branchAddSuccessful = myBank.addNewBranch(branchName);
        if(!branchAddSuccessful){
            return;
        }
        System.out.println("Would you like to add a new customer as well? enter (Y/N)");
        String customerResponse = myScanner.nextLine();
        if(customerResponse.toLowerCase().equals("y")){
            addNewCustomer(branchName);
        }

    }

    private static void addNewCustomer(String branchName){
        System.out.println("Please enter the customers name");
        String newCustomer = myScanner.nextLine();
        System.out.println("What was their first transaction?");
        double customerTransaction = myScanner.nextDouble();
        myScanner.nextLine();
        myBank.addNewCustomer(branchName,newCustomer,customerTransaction);
    }

    private static void addTransaction(){
        System.out.println("What is the customer name making the transaction?");
        String customerName = myScanner.nextLine();
        System.out.println("What is the branch the customer goes to?");
        String customerBranch = myScanner.nextLine();
        System.out.println("Enter the customer's transaction");
        double customerTransaction = myScanner.nextDouble();
        myBank.addExistingCustomerTransaction(customerName,customerTransaction,customerBranch);

    }

    private static void showAllCustomers(boolean showTrans, String branchName){
        myBank.printAllCustomers(showTrans,branchName);
    }

}
