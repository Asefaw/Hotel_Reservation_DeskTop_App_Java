/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author Abush
 */
public class EmployeeList {
    private final int SIZE  = 10;
    private Employee[] arrEmployeeList;
    Employee objTemp = new Employee();
    
    public EmployeeList() {
        arrEmployeeList = new Employee[SIZE];
    }
    
    //authetication
    public boolean authenticate(String uname, String pass) throws SQLException{
        return objTemp.employeeAuthenticate(uname, pass);
  } //end of authnticate
    
    
// get session
    public ResultSet getEmpSession(String uName){
        return objTemp.getSession(uName);
    }


    //searching for employee
    public Employee search(String ssNumber) throws Exception {
        try{
            for(int i = 0;i<SIZE;i++){
                if(arrEmployeeList[i] != null){
                    if(ssNumber.equals(arrEmployeeList[i].getSSNumber())){
                        return arrEmployeeList[i];
                    }
                }
            }
        }catch(Exception e){
            throw new Exception("Error in search();"+e.toString());
        }
        return null;
    }
    public boolean add(Employee newEmployee) throws Exception {
        try {
            for(int i = 0; i < SIZE; i++) {
                if(arrEmployeeList[i] == null){
                    arrEmployeeList[i] = newEmployee;
                    return true;
                }
            }
        
        } catch(Exception e){
            throw new Exception("Error in add();"+e.toString());
        }
        return false;
    }
    public boolean add(String SSN,String fName, String lName,String dob,String address,String ct,String st,String zip, String phone,String email, String title) throws Exception {
        Employee newEmployeeObj;
        newEmployeeObj = new Employee(SSN,fName,lName,dob,address,ct,st,zip,phone,email,title);
        try { 
            for(int i = 0; i < SIZE; i++) {
                if(arrEmployeeList[i] == null){
                    arrEmployeeList[i] = newEmployeeObj;
                    return true;
                }
        }
        }catch(Exception e){
            throw new Exception("Error in add();"+e.toString());
        }
        return false;
    }
    public boolean edit(String SSN,Employee employeeObj) throws Exception{
        try {
            for(int i = 0; i < SIZE; i++) {
                if(arrEmployeeList[i] != null){
                    if(SSN.equals(arrEmployeeList[i].getSSNumber())) {
                        arrEmployeeList[i].setFirstName(employeeObj.getFirstName());
                        arrEmployeeList[i].setLastName(employeeObj.getLastName());
                        arrEmployeeList[i].setDateOfBirth(employeeObj.getDateOfBirth());
                        arrEmployeeList[i].setAddress(employeeObj.getAddress());
                        arrEmployeeList[i].setPhone(employeeObj.getPhone());
                        arrEmployeeList[i].setEmail(employeeObj.getEmail());
                        return true;
                    }
                }
            }
        }
        catch(Exception e){
            throw new Exception("Error in edit();"+e.toString());
        }
        return false;
    }
    public boolean edit(String SSN,String newfName, String newlName,String newdob,String newaddress, String newphone,String newemail, String newtitle) throws Exception {
        try {
            for(int i = 0; i < SIZE; i++) {
                if(arrEmployeeList[i] != null) {
                    if(SSN.equals(arrEmployeeList[i].getSSNumber())) {
                        arrEmployeeList[i].setFirstName(newfName);
                        arrEmployeeList[i].setLastName(newlName);
                        arrEmployeeList[i].setDateOfBirth(newdob);
                        arrEmployeeList[i].setAddress(newaddress);
                        arrEmployeeList[i].setPhone(newphone);
                        arrEmployeeList[i].setEmail(newemail);
                        arrEmployeeList[i].setJobTitle(newtitle);
                        return true;
                    }
                } 
            }
        }
        catch(Exception e){
            throw new Exception("Error in edit();"+e.toString());
        }
        return false;
    }
    public boolean remove(String SSN) throws Exception {
        try {
            for(int i = 0; i < arrEmployeeList.length; i++) {
                if(arrEmployeeList[i] != null){
                    if(SSN.equals(arrEmployeeList[i].getSSNumber())) {
                      arrEmployeeList[i] = null;
                      return true;
                    } 
                }
            }
        }catch(Exception e){
            throw new Exception("Error in remove();"+e.toString());
        }
        return false;
    }
    public boolean print(String SSN) throws Exception {
        try{
            for(int i = 0; i < SIZE; i++){
                if(arrEmployeeList[i] != null){
                    if(SSN.equals(arrEmployeeList[i].getSSNumber())){
                        arrEmployeeList[i].print();
                        return true;
                    }
                }
            }
        }catch(Exception e){
            throw new Exception("Error in print();"+e.toString());
        }
      return false;  
    }
    public void printAll() throws Exception {
        try{
            for(int i = 0; i < SIZE; i++){
                if(arrEmployeeList[i] != null){
                   arrEmployeeList[i].print();
                }
            }
        }catch(Exception e){
            throw new Exception("Error in printAll();"+e.toString());
        }  
    }
    public void clear() {
        
        Arrays.fill(arrEmployeeList, null);
        
    }
    public void load() throws Exception {
        
        database_Load();
    }
    public void save() throws IOException {
        database_Save();
    }
    public void database_Load()throws  Exception {
        String line;
        try {
            Path objDirPath = Paths.get("EmployeeData.txt");
            if(Files.notExists(objDirPath)) { 
                Files.createFile(objDirPath); 
            }
            BufferedReader inputReader = new BufferedReader(new FileReader("EmployeeData.txt"));
                line = inputReader.readLine();
                
                while(line != null) {
                    String[] arrLine = line.split(",");
                    Employee tempEmployeeObj = new Employee();
                    
                    tempEmployeeObj.setSSNumber(arrLine[0]);
                    tempEmployeeObj.setFirstName(arrLine[1]);
                    tempEmployeeObj.setLastName(arrLine[2]);
                    tempEmployeeObj.setDateOfBirth(arrLine[3]);
                    tempEmployeeObj.setAddress(arrLine[4]);
                    tempEmployeeObj.setPhone(arrLine[5]);
                    tempEmployeeObj.setEmail(arrLine[6]);
                    tempEmployeeObj.setJobTitle(arrLine[7]);

                    add(tempEmployeeObj);
                    line = inputReader.readLine();
                }
                inputReader.close();
        }catch(IOException e) {
            throw new Exception("Erron Database_Load();"+e.toString());
        }
    }
    public void database_Save() throws IOException {
        
        String SSN, fName, lName, dob,address,phone,email,title;
        try{
            try (PrintWriter objOutStream = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("employeeData.txt")))) {
                for(int i = 0;i<arrEmployeeList.length;i++){
                    if(arrEmployeeList[i] != null) {
                        objOutStream.println(
                            arrEmployeeList[i].getSSNumber()+","+  
                            arrEmployeeList[i].getFirstName()+","+   
                            arrEmployeeList[i].getLastName()+","+  
                            arrEmployeeList[i].getDateOfBirth()+","+  
                            arrEmployeeList[i].getAddress()+","+  
                            arrEmployeeList[i].getPhone()+","+          
                            arrEmployeeList[i].getEmail()+","+          
                            arrEmployeeList[i].getJobTitle()        
                        );                   
                    }
                }
                objOutStream.close();
            }
        }
        catch(IOException e) {
            throw new IOException ("Error in Database_Save()"+e.toString());
        }
    }
}
