/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tmeku4692
 */
public abstract class Person {
    private String ssNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Integer age;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    private static int count = 0;
   
    
    public String getSSNumber(){
        return ssNumber;
    }
    public void setSSNumber(String ssn) {
        ssNumber = ssn;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String fName) {
        firstName = fName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lName) {
        lastName = lName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dob){
        dateOfBirth = dob;
            int newAge;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
            LocalDate birthDate = LocalDate.parse(dob, formatter);
            LocalDate currentDate = LocalDate.now();
            newAge = currentDate.getYear() - birthDate.getYear();
            age = newAge;
    }
    public Integer getAge(){
        return age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String addr) {
        address = addr;
    }
    
    public String getCity(){
        return city;
    }
    public void setCity(String c){
        city = c;
    }
    
    public String getState(){
        return state;
    }
    public void setState(String st){
        state = st;
    }
    
    public String getipCode(){
        return zipCode;
    }
    public void setZipCode(String zip){
        zipCode = zip;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String telephone) {
        phone = telephone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String Email) {
        email = Email;
    }
    public static Integer getCount() {
        return count;
    }
    public static void setCount( Integer cnt) {
        count = cnt;
    }
    //Default Constractor
    public Person() {
        ssNumber = "";
        firstName = "";
        lastName = "";
        dateOfBirth = "0000-00-00";
        age = 0;
        address = "";
        city = "";
        state = "";
        zipCode = "";
        phone = "";
        email = "";
        count++;
    }
    //Parametrized Constractor
    public Person(String SSN,String fName, String lName, String dob,String addr,String ct,String st,String zip,String phone,String email) {
        this.setSSNumber(SSN);
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setDateOfBirth(dob);
        this.setAddress(addr);
        this.setCity(ct);
        this.setState(st);
        this.setZipCode(zip);
        this.setPhone(phone);
        this.setEmail(email);  
        count++;
    }
    public abstract void print();;
      
}
