/*
Homw Work 2 Creating and testing a Class
 */
package BussinessClass;

 
import BussinessClass.Person;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import oracle.jdbc.driver.OracleDriver;
import javax.swing.JOptionPane;

/**
 *
 * @author Asefaw Mekuria
 */
public class Employee extends Person{
    
        Connection conn; 
        private String jobTitle;
        private PreparedStatement pst;
        private CallableStatement stmt;
        private ResultSet rst;
        private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
        private String db_user = "hoteladmin";
        private String db_pass = "admin"; 
        private String first_name,last_name, user_name;
        private int empID;
   
    
    
    public String getJobTitle(){
        return jobTitle;
    }
    public void setJobTitle(String title){
        jobTitle = title;
    }
    
   @Override
    public void setDateOfBirth(String newBDate){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate objDOB = LocalDate.parse(newBDate, formatter);
        int theAge = LocalDate.now().getYear() - objDOB.getYear();
        if(theAge >= 16) {
            super.setDateOfBirth(newBDate);
        }
        else {
            throw new UnsupportedOperationException("Policy Violation - Under age Employee");
        }
    }
    //Default Constractor
    public Employee() {
        super();
        jobTitle = "";
    }
    //Parametrized Constractor
    public Employee(String SSN,String fName, String lName, String dob,String addr,String ct,String st,String zip,String phone,String email,String title) {
        super(SSN,fName,lName,dob,addr,ct,st,zip,phone,email);
        this.jobTitle = title;
    }
     
    
    //makes a database connection
    public void getConnection(){
        try{
            conn = DriverManager.getConnection(db_url,db_user,db_pass);
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    // login authetication method
     public boolean employeeAuthenticate(String uname, String pass) throws SQLException {
     try {        
        String sql = ("{ ? = call EMP_Verify(?,?) }" );        
        getConnection();
        stmt = conn.prepareCall(sql);
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setString(2, uname);
        stmt.setString(3, pass);
        stmt.execute();
        rst = (ResultSet) stmt.getObject(1);
        
        if (rst.next()) { 
             
            user_name = rst.getString("userName");
            first_name = rst.getString("firstName");
            last_name = rst.getString("lastName");
            return true;
            
       } 
         
        }catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex); 
           
        }
     //conn.close();
    return false;
   } //end of authentication
     
   
     //session of employee
     public ResultSet getSession(String uName){
         try {        
        String sql = "Select * from employee where userName = ?";        
        getConnection();
        this.pst = conn.prepareStatement(sql);
        pst.setString(1, uName);
        rst = pst.executeQuery();            
            return rst;
        
         
        }catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        }
         //conn.close();
         return null;
     }
    
    public void load(String id) {
        Database_Load(id);
    }
    public void insert() {
        Database_Insert();
    }
    public void update() {
        Database_Update();
    }
    public void delete(String id) {
        
        Database_Delete(id);
    }
    protected void Database_Load(String input) {
        try {
            throw new Exception("load feature under Construction");
        } catch (Exception ex) {
            
        }
    }
    protected void Database_Insert() {
        try {
            throw new Exception("Insert feature under Construction");
        } catch (Exception ex) {
            
        }
    }
    protected void Database_Update() {
        try {
            throw new Exception("Update feature under Construction");
        } catch (Exception ex) {
            
        }
    }
    protected void Database_Delete(String input) {
       try {
            throw new Exception("Delete feature under Construction");
        } catch (Exception ex) {
            
        }
    }

    @Override
    public void print() {
    }
    
}
