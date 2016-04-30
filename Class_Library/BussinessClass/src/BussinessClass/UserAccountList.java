/*
 UserAccountList Class
 */
package BussinessClass;

import BussinessClass.UserAccount;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author Asefaw Mekuria
 */
public class UserAccountList {
    
    private final int size = 10;
    private UserAccount[] arrUserAccountList;
    
    public UserAccountList() {
        arrUserAccountList = new UserAccount[size];
    }
    public UserAccount search(String userName) throws Exception{
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(userName.equals (arrUserAccountList[i].getUserName())) {
                   return arrUserAccountList[i];
                } 
            }
        }
        catch(Exception e) {
            throw new Exception("Error in search()"+e.toString());
        }
        return null;
    }
    public boolean add(UserAccount newUserAccount) throws Exception {
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(arrUserAccountList[i] == null){
                    arrUserAccountList[i] = newUserAccount;
                    return true;
                }
            }
        
        }
        catch(Exception e) {
            throw new Exception("Error in add()"+e.toString());
        }
        return false;
    }
    public boolean add(String userName, String pass,String EMAIL) throws Exception {
        UserAccount newUserAccountObj;
        newUserAccountObj = UserAccount.getInstance(userName,pass,EMAIL);
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(arrUserAccountList[i] == null){
                    arrUserAccountList[i] = newUserAccountObj;
                    return true;
                }
            }
        }
        catch(Exception e) {
            throw new Exception("Error in add(u,p,e)"+e.toString());
        }
        return false;
    }
    public boolean edit(String userName, UserAccount userAccountObj) throws Exception{
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(arrUserAccountList[i] != null){
                    if(userName.equals(arrUserAccountList[i].getUserName())) {
                        arrUserAccountList[i].setPassword(userAccountObj.getPassword());
                        arrUserAccountList[i].setEmail(userAccountObj.getEmail());
                        return true;
                    }
                }
            }
        }
        catch(Exception e) {
            throw new Exception("Error in edit()"+e.toString());
        }
        return false;
    }
    public boolean edit(String userName, String newPass, String newEmail) throws Exception{
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(arrUserAccountList[i] != null) {
                    if(userName.equals(arrUserAccountList[i].getUserName())) {
                        arrUserAccountList[i].setPassword(newPass);
                        arrUserAccountList[i].setEmail(newEmail);
                        return true;
                    }
                } 
            }
        }
        catch(Exception e) {
            throw new Exception("Error in edit(u,p,e)"+e.toString());
        }
        return false;
    }
    public boolean remove(String userID) throws Exception {
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(userID.equals(arrUserAccountList[i].getUserName())) {
                  arrUserAccountList[i] = null;
                  return true;
                } 
            }
        }
        catch(Exception e) {
            throw new Exception("Error in remove()"+e.toString());
        }
        return false;
    }
    public boolean changeUsername(String userID, String newUserName) throws Exception {
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(arrUserAccountList[i] != null){
                    if(userID.equals(arrUserAccountList[i].getUserName())) {
                        arrUserAccountList[i].setUserName(newUserName);
                        return true;
                    }
                }
            }
        }
        catch(Exception e) {
            throw new Exception("Error in changeUsername()"+e.toString());
        }
        return false;
    }
    public boolean changePassword(String userID, String newPassword) throws Exception {
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(arrUserAccountList[i] != null){
                    if(userID.equals(arrUserAccountList[i].getUserName())) {
                        arrUserAccountList[i].setPassword(newPassword);
                        return true;
                    }
                }
            }
        }
        catch(Exception e) {
            throw new Exception("Error in changePassword()"+e.toString());
        }
        
        return false;
    }
    public boolean changeEmail(String userID, String newEmail) throws Exception {
        try {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                if(arrUserAccountList[i] != null){
                    if(userID.equals(arrUserAccountList[i].getUserName())) {
                        arrUserAccountList[i].setEmail(newEmail);
                        return true;
                    }
                }
            }
        }
        catch(Exception e) {
            throw new Exception("Error in changeEmail()"+e.toString());
        }
        return false;
    }
    public void clear() {
        try {
            Arrays.fill(arrUserAccountList, null);
        }catch(Exception e) {
            
        }
    }
    public boolean authenticate(String userName, String password) throws Exception {
        
        load();
        for(int i = 0; i < arrUserAccountList.length; i++){
            if(arrUserAccountList[i].authenticate(userName, password)) {
             clear();
                return true;
            }
        } 
        
        clear();
        return false;
    }
    public void load() throws Exception {
        database_Load();
    }
    public void save() throws IOException {
        database_Save();
    }
    public void database_Load()throws Exception {
        try{
            Path objDirPath = Paths.get("userAccountData.txt");
            if(Files.notExists(objDirPath)) { 
                Files.createFile(objDirPath); 
            }
            BufferedReader objInStream = new BufferedReader( new FileReader("userAccountData.txt"));
            String line;
            line = objInStream.readLine();
            while (line != null) {
                String [] arrLine = line.split(",");
                
                UserAccount tempAccountObj = UserAccount.getInstance();
                tempAccountObj.setUserAccountID(arrLine[0]);
                tempAccountObj.setUserName(arrLine[1]);
                tempAccountObj.setPassword(arrLine[2]);
                tempAccountObj.setEmail(arrLine[3]);
                 
                add(tempAccountObj);
                
                line = objInStream.readLine();
            }
            objInStream.close();
        }
        catch (Exception objE) { 
        throw new Exception("Error in load() method" + objE.toString()); 
        }
    }
    public void database_Save() throws IOException {
        //STUB METHOD or NOT IMPLEMENTED.
        String userAccountID,userName, password, email;
        try{
            try (PrintWriter objOutStream = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("userAccountData.txt")))) {
                for(int i = 0;i<arrUserAccountList.length;i++){
                    if(arrUserAccountList[i] != null) {
                        userAccountID = arrUserAccountList[i].getUserAccountID();
                        userName = arrUserAccountList[i].getUserName();
                        password =  arrUserAccountList[i].getPassword();
                        email = arrUserAccountList[i].getEmail();
                        
                        objOutStream.println(userAccountID+","+userName+","+password+","+email);
                    }
                }
                objOutStream.close();
            }
        }
        catch(IOException e) {
            throw new IOException("I/O Error in Save() method" + e.toString());
        }
    }
}
