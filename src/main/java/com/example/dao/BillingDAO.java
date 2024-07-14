/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

//importing relevant packages
import com.example.model.Billing;
import com.example.model.Patient;
import com.example.model.Prescription;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aqdha
 */

public class BillingDAO {
    //initialize a list to store the bills
    private static List<Billing> billings = new ArrayList<>();
    
    static{
        
        //creating dummy values 
        PatientDAO patientDAO = new PatientDAO();
        Patient patientOne   = patientDAO.getPatientById(1);
        billings.add(new Billing(1,patientOne,6500.00,2000.00,"Settled"));
        
    }
    
    //method to get all the avaialable bills
    public List<Billing> getAllBills(){
        return billings;
    }
    
    //method to get the bill by bill no
    public Billing getBillByInvoice(int billNo){
        //travesing through the avaialble list
        for(Billing bill : billings){
        //checking if the id's are matching. If so returning the bill.
            if(bill.getInvoiceNo() == billNo){
                return bill;
            }
        }
        return null;
    }
    
    
    //method for updating an existing bil;
    public void updateBill(Billing updatedBill ){
        //traversing throiught the bill list 
        for (int i = 0; i < billings.size(); i++) {
            Billing bill = billings.get(i);
            //checking if the ivoice no's are matching 
            if (bill.getInvoiceNo() == updatedBill.getInvoiceNo()) {
                //if so im applying the changes that were made
                billings.set(i, updatedBill);
                System.out.println("Bill updated: " + updatedBill);
                return;
            }
        }
    }
    
    //method for deleting a bill 
    public void deleteBill(int billNo){
        //traversing throught the available bills
        for(Billing bill : billings ){
            //if the id's are matching delete the bill no
            if(bill.getInvoiceNo() == billNo){
                billings.remove(bill);
                break;
            }
        }
    }
    
    //method add a new bill
    public void addBill(Billing bill){
        //getting a new invoice no
        int newInvoiceNo = getNextBillNo();
        //setting that invoice number as the invoice no for the new bill
        bill.setInvoiceNo(newInvoiceNo);
        //adding that bill to the list    
        billings.add(bill);
    }
    
    
    public int getNextBillNo() {
        // Initialize the maxInvoiceNo with a value lower than any possible invoice no
        int maxInvoiceNo = Integer.MIN_VALUE;

        // Iterate through the list to find the maxInvoiceNo
        for (Billing bill: billings) {
            int invoiceNo = bill.getInvoiceNo();
            if (invoiceNo > maxInvoiceNo) {
                maxInvoiceNo = invoiceNo;
            }
        }

        // Increment the maxInvoiceNo to get the next available invoice No
        return maxInvoiceNo + 1;
    }
    
    
}
