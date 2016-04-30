/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessClass;

import java.util.UUID;

/**
 *
 * @author class
 */
public class UserAccount {
        private String userAccountID;
        private String userName;
        private String password;
        private String email;
        private final String adminAccount = "admin"; //Administrator User Name
        private final String adminPassword = "999"; //Administrator Password
    
    
    public String getUserAccountID(){
        return userAccountID;
    }
    public void setUserAccountID(String userID) {
        userAccountID = userID;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String u){
        userName = u;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String p) {
        password = p;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String e) {
        email = e;
    }
    
    public String getAdminAccount(){
        return adminAccount;
    }
    public String getAdminPassword(){
        return adminPassword;
    }
    //Default Constractor
    private UserAccount() {
        userAccountID = UUID.randomUUID().toString();
        userName = "";
        password = "";
        email = "";        
    }
    //Parametrized Constarctor
    private UserAccount(String U, String pass, String E) {
        userAccountID = UUID.randomUUID().toString();
        setUserName(U);
        setPassword(pass);
        setEmail(E);
    }
    public static UserAccount getInstance() {
        
         UserAccount userAccountObject = new UserAccount();
        return userAccountObject;
        
    }
    public static UserAccount getInstance(String U,String P,String Email) {
        
        UserAccount userAccountObject = new UserAccount(U, P, Email);
        return userAccountObject;
    }
    
    public boolean authenticate(String U, String P) { 
            if(userName.equals(U) && password.equals(P)) {
                return true;
            }
            else {
                return false;
            }
    }
    public void load(String key) {
        database_Load(key);
    }
    public void insert() {
        database_Insert();
    }
    public void update() {
        database_Update();
    }
    public void delete() {
        database_Delete();
    }
    private void database_Load(String key) {
    }
    private void database_Insert(){
        //STUB METHOD  NOT IMPLEMENTED.
    }
    private void database_Update(){
        //STUB METHOD  NOT IMPLEMENTED.
    }
    private void database_Delete(){
        //STUB METHOD  NOT IMPLEMENTED.
    }
   
}
