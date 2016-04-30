/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessClass;

import BussinessClass.RoomList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Transaction {
    
    
    private String empID;
    private String roomNumb;
    private String custID;  
    private String cardNumber;
    private int expMonth, expYear;
    private double totalCharge;
    private java.sql.Date checkoutDate;
    private java.util.Date today = new Date();
    
    
    public Transaction(){
        
    }
    
    public Transaction(String empID,String rNumb,String custID,String checkoutD){
      this.setEmpID(empID);
      this.setroomnumb(rNumb);
      this.setCustomerID(custID); 
      this.setCheckoutDate(checkoutD);
    }
    
    
    
    public void setEmpID(String id){
      empID = id;
  }
  
  public void setroomnumb(String rNumb) {
      this.roomNumb = rNumb;
  }
  
  public void setCustomerID(String custid){
      this.custID = custid;
  }
  
  public void setCardNumber(String cardN){
      this.cardNumber = cardN;
  }
  
  public void setExpMonth(int expMon){
       this.expMonth = expMon;
  }
  
  
  public void setExpYear(int expYr){
       this.expYear = expYr;
  }
  
  public void setTotalCharge(double amount){
      this.totalCharge = amount;
  }
   

  public void setCheckoutDate(String date){
      Date DOB;
      
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            DOB = df.parse(date);
            this.checkoutDate = new java.sql.Date(DOB.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(RoomList.class.getName()).log(Level.SEVERE, null, ex);
        }       
  }
//end of setters
  
  
  //Getters
  public String getEmpID(){
      return empID;
  }
  
  public String getroomnumb() {
      return roomNumb;
  }
  
  public String getCustomerID(){
      return custID;
  }
  
 
  public java.sql.Date getCheckOutDate(){
      return checkoutDate;
  }
    
  
  public String getCreditCard(){
      return this.cardNumber;
  }
  
  public int getExpMonth(){
      return this.expMonth;
  }
   
  public int getExpYear(){
      return this.expYear;
  }
  
  
  public double getTotalCharge(){
      return this.totalCharge;
  }
    
}
