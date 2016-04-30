/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessClass;

import BussinessClass.Person;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;


/**
 *
 * @author Asefaw Mekuria
 */
public class Customer extends Person{
    
     private String idNumber;
    
    
    public String getIdNumber(){
        return idNumber;
    }
    public void setIdNumber(String id){
        this.idNumber =  id;
    }
    
    public Customer(){ //defualt constractor
        super();
        this.idNumber = "";
        Person.setCount(Person.getCount()+1);
    }
    public Customer(String id,String fName, String lName, String dob,String addr,String city,String state,String zip,String phone,String email){        
        //super(id,fName, lName,dob, addr,city,state,zip,phone,email);
        
            super.setFirstName(fName);
            super.setLastName(lName);
            super.setDateOfBirth(dob);
            super.setAddress(addr);
            super.setPhone(phone);
            super.setEmail(email);
            this.setIdNumber(id);
        Person.setCount(Person.getCount()+1);
         
    }
    
    
    
    public void Print() throws Exception {
        try {
            
            try (PrintWriter outStream = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("Network_Printer.txt",true)))) {
                outStream.println("*******************************");
                outStream.println("ID Number = "+idNumber);
                outStream.println("First Name = "+super.getFirstName());
                outStream.println("Last Name = "+super.getLastName());
                outStream.println("Date of Birth = "+super.getDateOfBirth());
                outStream.println("Address = "+super.getAddress());
                outStream.println("Age = "+super.getAge());
                outStream.println("Email = "+super.getEmail());
                outStream.println("*******************************");
                outStream.println();
                outStream.println();
            }
            
        }catch(Exception e) {
            throw new Exception("Error in Load()"+e.toString());
        }
    }
    public void load(String id) throws Exception {
        
            Database_Load(id);
       
    }
    public void insert() throws Exception {
        Database_Insert();
    }
    public void update() throws Exception{
        Database_Update();
    }
    public void delete(String id) throws Exception{
        
            Database_Delete(id);
        
    }  
    protected void Database_Load(String id) throws Exception {
        
        throw new UnsupportedOperationException("\n trying to search customer with ID:"+id+"\n "
                + "ERROR!!! LOAD FEATURE UNDER CONSTRUCTION");
        
    }
    protected void Database_Insert() throws Exception {

        throw new UnsupportedOperationException("\nTrying To Insert The Following Information\n"+
            "'ERROR!! INSERT FEATURE UNDER CONSTRUCTION'");
        
    }
    protected void Database_Update() throws Exception {
        
        throw new UnsupportedOperationException("\nTrying To Insert The Following Information\n" +
            "'ERROR!!! UPDATE FEATURE UNDER CONSTRUCTION'");

    }
    protected void Database_Delete(String id) throws Exception {
        
        throw new UnsupportedOperationException("Trying to Delete a Record With ID Number "+id +"\n"
          + "ERROR!!! DELETE FEATURE UNDER CONSTRUCTION");       
        
    }

    @Override
    public void print() {
    }
}
