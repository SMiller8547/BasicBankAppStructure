package com.ExampleProject;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Branches> bankBranches;

    /*Functionality:
    1. Add new branch,
    2. add customer to that branch with initial transaction.
    3. Add a transaction for an existing customer.
    4. show a list of customers for a particular branch and optionally a list of their transactions.
    5. Also add additional transactions for a customer who has come back.
    6. Data validation - check if new customer name already in use, and if customer exists if adding an additional transaction
     */

    public Bank(){
        this.bankBranches = new ArrayList<Branches>();
    }

    public ArrayList<Branches> getBankBranches(){
        return this.bankBranches;
    }

    public boolean addNewBranch(String branchName){
        if(getBranchIndex(branchName)<0){
            bankBranches.add(new Branches(branchName));
            return true;
        }
        System.out.println("That branch name already exists");
        return false;
    }

    public boolean addNewCustomer(String bankBranch,String customerName, double firstTransaction){
        int branchIndex = getBranchIndex(bankBranch);
        if(branchIndex<0){
            System.out.println("Branch name not found");
            return false;
        }
        Branches customerBranch = bankBranches.get(branchIndex);
        customerBranch.addCustomer(customerName,firstTransaction);
        return true;

    }

    public boolean addExistingCustomerTransaction(String customerName, double transactionVal,String customerBranch){
        int branchIndex = getBranchIndex(customerBranch);
        if(branchIndex<0){
            System.out.println("Branch name not found");
            return false;
        }
        Branches currentBranch = bankBranches.get(branchIndex);
        currentBranch.addTransaction(customerName,transactionVal);
        return true;
    }

    public void printAllCustomers(boolean showTransactions, String branchName){
        int branchIndex = getBranchIndex(branchName);
        if(branchIndex<0){
            System.out.println("No branch found");
            return;
        }
        Branches currentBranch = bankBranches.get(branchIndex) ;
        ArrayList<Customers> customerList = currentBranch.getCustomerList();
        if(showTransactions){
            for(int j = 0; j < customerList.size();j++){
                System.out.println("Customer " + (j+1)+ ": "+ customerList.get(j).getCustomerName() +"\n");
                ArrayList<Double> customerTransactions = customerList.get(j).getCustomerTransactions();
                for(int k = 0; k <customerTransactions.size();k++){
                    System.out.println("Transaction " +(k+1)+ ": "+customerTransactions.get(k) +"\n");
                }
            }
        } else{
            for(int j = 0; j < customerList.size();j++){
                System.out.println("Customer " + (j+1)+ ": "+ customerList.get(j).getCustomerName() +"\n");
            }
        }
    }

    private int getBranchIndex(String branchName){
        for(int i = 0; i < bankBranches.size();i++){
            if(bankBranches.get(i).getBranchName().equals(branchName)){
                return i;
            }
        }
        return -1;
    }



}
