
package BussinessClass;

import java.sql.*;
import javax.swing.JOptionPane;

 public class Room {
     
   private int roomNumber;
   private int floor;  
   private String roomType;
   private String available;
   private double price;
    private PreparedStatement pst;
    private ResultSet rst;
    private final String db_url = "jdbc:mysql://localhost:3306/hotel";
    private final String db_user = "root";
    private final String db_pass = "Abush8739";
    private Connection conn;

   public Room() {
    this.roomNumber = 0;
    this.floor = 0;
     this.roomType = "";
     this.available = "";
     this.price = 0.0D;
   }
  
  public Room(int number, int fl, String type, String avail, double pr) { this.roomNumber = number;
     this.floor = fl;
    this.roomType = type;
     this.available = avail;
     this.price = pr;
  }
   
   public int getRoomNumber()
  {
  return this.roomNumber;
  }
  
   public int getFloor() {
    return this.floor;

   }

public String getRoomType() {
     return this.roomType;
   }
   
   public String isAvailable() {
     return this.available;
  }
   
 public double getPrice() {
   return this.price;
  }
   
 public void setRoomNumber(int num)
   {
   this.roomNumber = num;
   }
  
   public void setFloor(int fl) {
    this.floor = fl;
   }
   
   public void setRoomType(String type) {
    this.roomType = type;
 }
   
 public void setAvailable(String avl) {
   this.available = avl;
  }
  public void setPrice(double pr) {
     this.price = pr;
   }
   public void getConnection(){
        try{
            conn = DriverManager.getConnection(db_url,db_user,db_pass);
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
  public ResultSet loadRooms() {
      try{
          getConnection();
          String sql = "select * FROM room WHERE available = ?";
          pst = conn.prepareStatement(sql);
          pst.setString(1, "YES");
          rst = pst.executeQuery();
          return rst;
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
      }
      return null;
  }
}

