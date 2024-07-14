/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author aqdha
 */
public class Billing {
    
    //Initialize attributes
    private int invoiceNo;
    private String paymentStatus;
    private double totalAmount;
    private double outstanding;
    private Patient patient;
    
    
    //Initialize constructor
    public Billing(int invoiceNo,Patient patient, double totalAmount,double outstanding, String paymentStatus){
        this.invoiceNo = invoiceNo;
        this.patient = patient;
        this.totalAmount  = totalAmount;
        this.outstanding = outstanding;
        this.paymentStatus = paymentStatus;
    }
    
    //Initialize default constructor
    public Billing(){}
    
    //Getter method for the patient
    public Patient getPatient(){
        return this.patient;
    }
    
    //Setter emthod for the patient
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    
    //getter method for the invoice No
    public int getInvoiceNo(){
        return this.invoiceNo;
    }
    
    //Setter method for the invoice No
    public void setInvoiceNo(int invoiceNo){
        this.invoiceNo = invoiceNo;
    }
    
    //Getter method for the total
    public double getTotal(){
        return this.totalAmount;
    }
    
    //setter method for the total
    public void setTotal(double total){
        this.totalAmount = total;
    }
  
    //getter method for the outstanding balance
    public double getOutstandingBal(){
        return this.outstanding;
    }
    
    //setter method for the outstanding balance
    public void setOutstandingBal(double balance){
        this.outstanding = balance;
    }
    
    //getter method for the payment status
    public String getPaymentStatus(){
        return this.paymentStatus;
    }
    
    //setter method for payment status
    public void setPaymentStatus(String status){
        this.paymentStatus = status;
    }
    
}
