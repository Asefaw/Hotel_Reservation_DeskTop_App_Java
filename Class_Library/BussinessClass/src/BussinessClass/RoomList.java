
package BussinessClass;
 
import java.sql.CallableStatement;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
 import java.util.HashMap;

import javax.swing.JOptionPane;
 
 public class RoomList {
    private int empID;
    private String roomNumb;
    private String custID;
    private String firstName,lastName;
    private String dateofBirth;
    private String address,city,state,zipCode;
    private String phone,email;
    private java.sql.Date checkoutDate;
    private java.util.Date today = new Date();
    private Connection conn;
    private PreparedStatement pst;
    private CallableStatement stmt;
    private ResultSet rst;
    String db_url = "jdbc:oracle:thin:@localhost:1521:oradb";
      String db_user = "hoteladmin";
      String db_pass = "admin"; 
            
   private HashMap<String, Transaction> transactionList;
   
  public RoomList()
  {
    transactionList = new HashMap<>();
   }
  
  public RoomList(int empID,String rNumb,String custID,String fn,String ln,String dob,String addr,String city,String state,String zip,String phone,String email,String checkoutD){
      this.setEmpID(empID);
      this.setroomnumb(rNumb);
      this.setCustomerID(custID);
      this.setFirstName(fn);
      this.setLastname(ln);
      this.setDateofBirth(dob);
      this.setAddress(addr);
      this.setCity(city);
      this.setSate(state);
      this.setZipCode(zip);
      this.setPhone(phone);
      this.setEmail(email);
      this.setCheckoutDate(checkoutD);
  }
  
  
   //makes a database connection
    public void getConnection(){
       
        try{ 
            conn = DriverManager.getConnection(db_url, db_user, db_pass);
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    
  
  public void setEmpID(int id){
      empID = id;
  }
  
  public void setroomnumb(String rNumb) {
      this.roomNumb = rNumb;
  }
  
  private void setCustomerID(String custid){
      this.custID = custid;
  }
  
  public void setFirstName(String fn){
     this.firstName = fn;
  }
  
  public void  setLastname(String ln){
      this.lastName = ln;
  }
  
  public void setDateofBirth(String dob){
//      SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
//        LocalDate objDOB = LocalDate.parse(dob);
//         age = LocalDate.now().getYear() - objDOB.getYear();
         
       SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
        LocalDate objDOB = LocalDate.parse(dob);
        int theAge = LocalDate.now().getYear() - objDOB.getYear();
        if(theAge >= 18) {
            this.dateofBirth = dob;
        }
  }
  
  public void setAddress(String addr){
      this.address = addr;
  }
  
  public void setCity(String city){
      this.city = city;
  }
  
  public void setSate(String state){
      this.state = state;
  }
  
  public void setZipCode(String zip){
      this.zipCode = zip;
  }
  
  public void setPhone(String ph){
      this.phone = ph;
  }
  
  public void setEmail(String email){
     this.email = email;
  } 

  public void setCheckoutDate(String date){
      Date DOB;
      
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            DOB = df.parse(date);
            this.checkoutDate = new java.sql.Date(DOB.getTime());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error with checkoutDate/roomlist"+ex.toString());
        }       
  }
//end of setters
  
  
  //Getters
  public int getEmpID(){
      return empID;
  }
  
  public String getroomnumb() {
      return roomNumb;
  }
  
  private String getCustomerID(){
      return custID;
  }
  
  public String getFirstName(){
      return firstName;
  }
  
  public String getLastname(){
      return lastName;
  }
  
  public java.sql.Date getDateofBirth() {
      java.sql.Date dateof_Birth = null;
      try {
      Date DOB;
      
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DOB = df.parse(dateofBirth);
            dateof_Birth = new java.sql.Date(DOB.getTime());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error with DOB/roomlist"+ex.toString());
        }
      return dateof_Birth;
  }
  
  public String getAddress(){
      return address;
  }
  
  public String getCity(){
      return city;
  }
  
  public String getSate(){
      return state;
  }
  
  public String getZipCode(){
      return zipCode;
  }
  
  public String getPhone(){
      return phone;
  }
  
  public String getEmail(){
      return email;
  }
  public java.sql.Date getCheckOutDate(){
      return checkoutDate;
  }
  
  
  //Add 
  public boolean add(String key, Transaction tr){
      if(!transactionList.containsKey(key)){
          transactionList.put(key, tr);
          return true;
      }
      return false;
  } //end of add
   
  public ResultSet loadRooms() throws SQLException
   {
    Room room = new Room();
     try {
       String sql = ("{? = call get_rooms(?)}");
      
      this.getConnection();
      stmt = conn.prepareCall(sql); 
      stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
      stmt.setString(2, "YES");
      stmt.execute();
      
      rst = (ResultSet) stmt.getObject(1);
       
      return rst; 
     }
     catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex.toString());
     }
     this.conn.close();
     return null;
   }
 
 /*
  public void saveTransaction() throws Exception{
     
      String sql = "INSERT INTO transaction(roomNumber,checkInDate,customerID,employeeID,checkOutDate)"
              + "VALUES(?,?,?,?,?)";
//       java.sql.Date check_in = new java.sql.Date(this.today.getTime());
      getConnection();
          transactionList.forEach((key,value)->{             
              try {
                  pst.setInt(1, Integer.parseInt(transactionList.get(key).getroomnumb()));
                  pst.setDate(2, new java.sql.Date(this.today.getTime()));
                  pst.setString(3, transactionList.get(key).getCustomerID());
                  pst.setInt(4,transactionList.get(key).getEmpID());
                  pst.setDate(5, transactionList.get(key).getCheckOutDate());
                  pst.execute();
                  updateRoom(Integer.parseInt(transactionList.get(key).getroomnumb()));
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex.toString()+"Error while saving transaction");
              }
          });  
          conn.close();
  } //end of save transaction
  
  public void updateRoom(int rN){
      getConnection();
      String sql = "UPDATE room SET available=NO WHERE roomNumber = ?";
      try{
          pst = conn.prepareStatement(sql);
          pst.setInt(1, rN);
          pst.executeQuery();
          conn.close();
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while updating room"+ex.toString());
      }
      
  } */ 
 
  // load presidential rooms
  
  public ResultSet loadPresidentialRooms(String roomT) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_type(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setString(2, roomT);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading Presidential Rooms"+ex.toString());
      }
      conn.close();
      return null;
  }
  
  // load penthouse rooms
  
  public ResultSet loadPenthouseRooms(String roomT) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_type(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setString(2, roomT);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading Penthouse Rooms"+ex.toString());
      }
      conn.close();
      return null;
  } //  end of load penthouse rooms
  
  // load Honeymoon rooms
  public ResultSet loadHoneyMoonRooms(String roomT) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_type(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setString(2, roomT);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading HoneyMoon Rooms"+ex.toString());
      } 
      conn.close();
      return null;
  } // end of load Honeymoon rooms
  
  
   // load Family rooms
  public ResultSet loadFamilyRooms(String roomT) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_type(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setString(2, roomT);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading Family Rooms"+ex.toString());
      }
      conn.close();
      return null;
  }  // load End of family rooms
  
  
   // load Single rooms
  public ResultSet loadSingleRooms(String roomT) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_type(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setString(2, roomT);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading Single Rooms"+ex.toString());
      }
      conn.close();
      return null;
  } // load End of Single rooms
  
   // load First Floor
    public ResultSet loadFirstFL(int floor) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_floor(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setInt(2, floor);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading First FL Rooms"+ex.toString());
      }
      conn.close();
      return null;
  }// end of load first Floor
  
    // load Second Floor
    public ResultSet loadSecondFL(int floor) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_floor(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setInt(2, floor);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading Second FL  Rooms"+ex.toString());
      }
      conn.close();
      return null;
  }// end of load Second Floor
    
      // load Third Floor
    public ResultSet loadThirdFL(int floor) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_floor(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setInt(2, floor);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex ){
          JOptionPane.showMessageDialog(null, "Error while loading Third FL  Rooms"+ex.toString());
      }
      conn.close();
      return null;
  }// end of load Third Floor
    
      // load Fourth Floor
    public ResultSet loadFourthFL(int floor) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_floor(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setInt(2, floor);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading Forth FL  Rooms"+ex.toString());
      }
      conn.close();
      return null;
  }// end of load Fourth Floor
    
      // load Fifth Floor
    public ResultSet loadFifthFL(int floor) throws SQLException{
      this.getConnection();
      try{
          String sql = ("{? = call get_room_by_floor(?)");
          stmt = conn.prepareCall(sql);
          stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
          stmt.setInt(2, floor);
          stmt.execute();
          rst = (ResultSet) stmt.getObject(1);
          return rst;
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Error while loading Fifth FL  Rooms"+ex.toString());
      }
      conn.close();
      return null;
  }// end of load FifthFloor
 }





