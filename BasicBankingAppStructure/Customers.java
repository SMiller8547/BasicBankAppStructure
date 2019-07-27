package com.ExampleProject;

import java.util.ArrayList;

public class Customers {
    private String customerName;
    private ArrayList<Double> customerTransactions;

    public Customers(String customerName,double firstTransaction){
        this.customerTransactions = new ArrayList<Double>();
        customerTransactions.add(firstTransaction);
        this.customerName = customerName;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public ArrayList<Double> getCustomerTransactions(){
        return this.customerTransactions;
    }

    public void addTransaction(double transactionVal){
        customerTransactions.add(transactionVal);
        System.out.println("Transaction Added");
    }

}
