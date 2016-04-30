/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessClass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abush
 */
public class CustomerList {
    
    private PreparedStatement pst;
    private CallableStatement stmt;
    private ResultSet rst;
    private Connection conn;
    private String db_url = "jdbc:oracle:thin:@localhost:1521:oradb";
    private String db_user = "hoteladmin";
    private String db_pass = "admin";
    
     private final HashMap<String, Customer> customerList = new HashMap<>();
    
    public CustomerList(){
         
    }
    
    
    //makes a database connection
    public void getConnection(){
        try{
            conn = DriverManager.getConnection(db_url,db_user,db_pass);
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    
    // add a customer to a collection
    public boolean add(String key,Customer cust){
        if(!customerList.containsKey(key)){            
            customerList.put(key, cust);
            return true;
        }
        return false;
    } // end of Add
    
    
    //load customer
    public void loadCustomer(){
        this.getConnection();
        
    }// end of load customer
    
    
    //save customer
    public void saveCustomer() {
      
          String sql = "{ call addcustomer(?,?,?,?,?,?,?,?,?,?)}";
          getConnection();
           try {
             for(Customer cust: customerList.values()) {
           
                
                Date DOB;      
                 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                  DOB = df.parse(cust.getDateOfBirth());
                  java.sql.Date dateof_Birth = new java.sql.Date(DOB.getTime());
                
                
                  stmt = conn.prepareCall(sql);
                  stmt.setString(1, cust.getIdNumber());
                  stmt.setString(2, cust.getFirstName());
                  stmt.setString(3, cust.getLastName());
                  stmt.setDate(4, dateof_Birth);
                  stmt.setString(5, cust.getAddress());
                  stmt.setString(6, cust.getPhone());
                  stmt.setString(7, cust.getEmail());
                  stmt.setString(8, cust.getCity());
                  stmt.setString(9, cust.getState());
                  stmt.setString(10, cust.getipCode());

                  stmt.execute();
                 // return true;
              } 
           }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error while saving customer"+ex.toString());
            } catch (ParseException ex2) {
                  JOptionPane.showMessageDialog(null, "Invalid Data"+ex2.toString());
                }
                
          //return false;
          
  } // end of save customer
    
}
