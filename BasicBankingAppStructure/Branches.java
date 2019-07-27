package com.ExampleProject;

import java.util.ArrayList;

public class Branches {

    /*Functionality needed, add a new customer to branch and initial transaction amount
     */

    private String branchName;
    private ArrayList<Customers> customerList;

    public Branches(String branchName){
        this.branchName = branchName;
        this.customerList = new ArrayList<Customers>();
    }


    public String getBranchName(){
        return this.branchName;
    }


    public ArrayList<Customers> getCustomerList(){
        return this.customerList;
    }

    public boolean addCustomer(String customerName, double firstTransaction){
        int customerIndex = existingCustomerIndex(customerName);
        if(customerIndex>=0){
            System.out.println("Customer already exists");
            return false;
        }
        Customers newCustomer = new Customers(customerName,firstTransaction);
        customerList.add(newCustomer);
        return true;
    }

    public boolean addTransaction(String customerName, double transactionVal){
        int customerIndex = existingCustomerIndex(customerName);
        if(customerIndex<0){
            System.out.println("Customer does not exist");
            return false;
        }
        Customers currentCustomer = customerList.get(customerIndex);
        currentCustomer.addTransaction(transactionVal);
        return true;
    }

    private int existingCustomerIndex(String customerName){
        for(int i = 0; i < customerList.size();i++){
            if(customerList.get(i).getCustomerName().equals(customerName)){
                return i;
            }
        }
        return -1;
    }
}
