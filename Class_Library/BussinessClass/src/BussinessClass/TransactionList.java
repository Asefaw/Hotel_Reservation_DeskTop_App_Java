
package BussinessClass;
 
import java.sql.CallableStatement;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
 
import java.util.Date;
 import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
 
 public class TransactionList {
    private String empID;
    private String roomNumb;
    private String custID;
    private java.sql.Date checkoutDate;
    private final java.util.Date today = new Date();
    private Connection conn;
    private PreparedStatement pst;
    private CallableStatement cstmt;
    private ResultSet rst;
    private Statement stmt;
    private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String db_user = "hoteladmin";
    private String db_pass = "admin"; 
    private double roomPrice;
    private double taxRate;      
    private double subTotal;
    private double grandTotal;
    
   private final HashMap<String, Transaction>  transactionList = new HashMap<>();
   
  public TransactionList(){
    
   }
  
   
  
  
   //makes a database connection
    public void getConnection(){
        try{
            conn = DriverManager.getConnection(db_url,db_user,db_pass);
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    
  
 
  
  
  //Add 
  public boolean add(String key, Transaction tr){
      if(!transactionList.containsKey(key)){
          transactionList.put(key, tr);
          return true;
      }
      return false;
  } //end of add
   
  

 

  public void saveTransaction(){
      this.getConnection();
      //Transaction trans = new Transaction();
     String sql = ("{call addtransacton(?,?,?,?,?,?,?,?,?)}");
     for(Transaction trans: transactionList.values()){
        int room_num = Integer.parseInt(trans.getroomnumb());
         try{
             cstmt = conn.prepareCall(sql);
             cstmt.setInt(1, room_num);
             cstmt.setDate(2, new java.sql.Date(today.getTime()));
             cstmt.setString(3, trans.getCustomerID());
             cstmt.setString(4, trans.getEmpID());
             cstmt.setDate(5, trans.getCheckOutDate());
             cstmt.setDouble(6, trans.getTotalCharge());
             cstmt.setString(7, trans.getCreditCard());
             cstmt.setInt(8, trans.getExpMonth());
             cstmt.setInt(9, trans.getExpYear()); 
             cstmt.execute(); 
         }catch(SQLException  ex){
             JOptionPane.showMessageDialog(null,"Error while saving transaction"+ex.toString());
         }
         
     }
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error while saving transaction"+ex.toString());
        }
 
  } //end of save transaction
  
  
  
  
  // below calculates the cost of the room for a given customer.
  //
  
  public double getTax(){
      try{
          
          this.getConnection();
          String query = ("{? = call get_tax}");
          cstmt = conn.prepareCall(query);
          cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          cstmt.execute();
          rst = (ResultSet) cstmt.getObject(1);
          if(rst.next()){
            taxRate = rst.getDouble("tax");
             
            return taxRate;
          } 
           
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error retreving Tax rate "+ex.toString());
      }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionList.class.getName()).log(Level.SEVERE, null, ex);
        }
      return 0; 
  }
  
  public double getSubTotal(String roomNum){
       int roomNumber = Integer.parseInt(roomNum);
       try{
           this.getConnection();
           String query = "select price from room where roomNumber = ?";
           pst = conn.prepareStatement(query);
           pst.setInt(1, roomNumber);
           rst = pst.executeQuery();
           if(rst.next()){
               roomPrice = rst.getDouble("price");
               subTotal = roomPrice * taxRate;                
               return subTotal;
           }
       }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error retreving Sub Total "+ex.toString());
      } 
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionList.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 0;
  }
  
  public double getGrandTotal(String roomNum){
      int roomNumber = Integer.parseInt(roomNum);
       try{
           this.getConnection();
           String query = "select price from room where roomNumber = ?";
           pst = conn.prepareStatement(query);
           pst.setInt(1, roomNumber);
           rst = pst.executeQuery();
           if(rst.next()){
               roomPrice = rst.getDouble("price");
               grandTotal = roomPrice * taxRate;
               conn.close();
               return grandTotal;
           }
       }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error retreving Grand Total "+ex.toString());
      } 
       return 0;
  }
  
 }





