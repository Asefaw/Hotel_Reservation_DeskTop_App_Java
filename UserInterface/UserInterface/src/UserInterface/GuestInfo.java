/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;


import BussinessClass.Customer;
import BussinessClass.CustomerList;
import BussinessClass.RoomList;
import BussinessClass.Transaction;
import BussinessClass.TransactionList;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author A
 */
public class GuestInfo extends javax.swing.JInternalFrame {

  // Variables Declaration
    private String roomN;
    private String empID;
    private LocalDate today;
    private Transaction transaction = new Transaction();
    private Customer cust = new Customer();
    private CustomerList custList = new CustomerList();
    private TransactionList transList = new TransactionList();
    private int age ;
    private String custid,fn,ln,dob,addr,city,State,zip,Phone,Email,checkoutD;
    private String creditCard;
    private int exp_Month,exp_Year;
    private double totalCharge;
    private boolean customerAdded;
    private boolean customerSaved;
    private boolean transactionAdded;
    private boolean transactionSaved;
  
    // End of Variables Declaration
    public GuestInfo() {
        initComponents();
       
    }
    
    public GuestInfo(String empID,String roomN){
        initComponents();
        this.roomN = roomN;
        this.empID = empID;
        this.today = LocalDate.now();
        this.roomNumber.setText(roomN);
        this.employeeID.setText(empID);

        //Display the Tax information
        double tax = transList.getTax(); 
        
        //getting the subtotal of the cost
         double subTotal = transList.getSubTotal(roomN);
        
         
        //show on the screen
        
        this.taxField.setText(String.valueOf(tax)+" %"); 
        this.subTotalField.setText(String.valueOf(subTotal));
         
    }
    
    

    public void clearForm(){
        
    }
    
    //Continue() checks whether all fields have a valid input or not
    public void continueNextPage(){
        if( this.employeeID.getText().isEmpty()||
            this.customerID.getText().isEmpty() ||
            this.roomNumber.getText().isEmpty() ||
            this.FirstName.getText().isEmpty() ||
            this.LastName.getText().isEmpty() ||
            this.phone.getText().isEmpty() ||
            this.email.getText().isEmpty() ||
            this.AddressField.getText().isEmpty() ||
            this.cityField.getText().isEmpty() ||
            this.state.getSelectedItem().equals("") ||
            this.ZipCode.getText().isEmpty()
           ){
            this.ContinueBtn.setEnabled(false);
        }else{
            this.ContinueBtn.setEnabled(true);
        }
    
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        roomNumber = new javax.swing.JTextField();
        LastName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        AddressField = new javax.swing.JTextField();
        FirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        employeeID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ZipCode = new javax.swing.JTextField(5);
        jLabel5 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cust_ID_lable = new javax.swing.JLabel();
        customerID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        checkoutDate = new com.toedter.calendar.JDateChooser();
        dateOfBirth = new com.toedter.calendar.JDateChooser();
        ContinueBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        subTotalField = new javax.swing.JTextField();
        taxField = new javax.swing.JTextField();
        grandTotalField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        creditDebitMethod = new javax.swing.JRadioButton();
        cashMethod = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        cardNumber = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        expMonth = new com.toedter.calendar.JMonthChooser();
        expYear = new com.toedter.calendar.JYearChooser();
        jLabel21 = new javax.swing.JLabel();
        Save_Add = new javax.swing.JButton();
        saveAndSubmit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleBackground"));
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Fill in the Guest Information");

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CheckOut Date:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Address:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Date of Birth:");

        roomNumber.setEditable(false);
        roomNumber.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("State:");

        AddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Last Name");

        employeeID.setEditable(false);
        employeeID.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Room Number:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("City:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Employee ID:");

        ZipCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipCodeActionPerformed(evt);
            }
        });
        ZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ZipCodeKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("First Name:");

        state.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "  ", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("ZipCode:");

        cust_ID_lable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cust_ID_lable.setText("Customer ID:");

        customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDActionPerformed(evt);
            }
        });
        customerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerIDKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Phone:");

        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Email:");

        checkoutDate.setDateFormatString("yyyy-MM-dd");

        dateOfBirth.setDateFormatString("yyyy-MM-dd");

        ContinueBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ContinueBtn.setText("Continue");
        ContinueBtn.setEnabled(false);
        ContinueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FirstName)
                                    .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(roomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(25, 25, 25)
                                        .addComponent(employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(checkoutDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(132, 132, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ContinueBtn)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cust_ID_lable)
                                    .addGap(25, 25, 25)
                                    .addComponent(customerID, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(115, 115, 115)
                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel12)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel13)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(22, 22, 22)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                        .addComponent(dateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(checkoutDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cust_ID_lable)
                    .addComponent(customerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(roomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(ContinueBtn)
                .addGap(13, 13, 13))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Sub Total:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Tax:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setText("Grand Total:");

        subTotalField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subTotalField.setEnabled(false);

        taxField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        taxField.setEnabled(false);

        grandTotalField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grandTotalField.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Payment Method:");

        buttonGroup1.add(creditDebitMethod);
        creditDebitMethod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        creditDebitMethod.setText("Credit / Debit Card");
        creditDebitMethod.setEnabled(false);
        creditDebitMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditDebitMethodActionPerformed(evt);
            }
        });

        buttonGroup1.add(cashMethod);
        cashMethod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cashMethod.setText("Cash");
        cashMethod.setEnabled(false);
        cashMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashMethodActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Card Number:");

        cardNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cardNumber.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("expiration Date:");

        expMonth.setDayChooser(null);
        expMonth.setEnabled(false);
        expMonth.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        expYear.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("expiration Year:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(creditDebitMethod)
                                .addGap(18, 18, 18)
                                .addComponent(cashMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(expMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(expYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditDebitMethod)
                    .addComponent(cashMethod))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(expMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(expYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        Save_Add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Save_Add.setText("Save And Add another room");
        Save_Add.setEnabled(false);
        Save_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_AddActionPerformed(evt);
            }
        });

        saveAndSubmit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveAndSubmit.setText("Save And Submit");
        saveAndSubmit.setEnabled(false);
        saveAndSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAndSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(grandTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(taxField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(44, 44, 44)
                                        .addComponent(subTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Save_Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveAndSubmit)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subTotalField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(taxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(grandTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Save_Add)
                    .addComponent(saveAndSubmit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel14.setText("Payment Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateActionPerformed

    private void ZipCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeActionPerformed

    private void Save_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_AddActionPerformed
        
//        int age ;
//        String custid,fn,ln,dob,addr,city,State,zip,Phone,Email,checkoutD;
        
        String dobYr,dobMon,dobDay, dobMonth,dob_Day ;
        dobYr = String.valueOf(this.dateOfBirth.getCalendar().getTime().getYear()+1900);
        dobMon = String.valueOf(this.dateOfBirth.getCalendar().getTime().getMonth());
        dobDay = String.valueOf(this.dateOfBirth.getCalendar().getTime().getDate());
        
        String chkYr,chkMon,chkDay;
        chkYr = String.valueOf(this.checkoutDate.getCalendar().getTime().getYear()+1900);
        chkMon = String.valueOf(this.checkoutDate.getCalendar().getTime().getMonth());
        chkDay = String.valueOf(this.checkoutDate.getCalendar().getTime().getDate());
        
        
        // birthday date is less than 10 append 0 in fornt
        if(Integer.parseInt(dobMon) < 10){
            dobMonth = "0"+dobMon;
        }else{
            dobMonth = dobMon;
        }
        if(Integer.parseInt(dobDay) < 10){
            dob_Day = "0"+dobDay;
        }else{
            dob_Day = dobDay;
        }
        
        custid = this.customerID.getText().trim();
        fn = this.FirstName.getText().trim();
        ln = this.LastName.getText().trim();
        dob = dobYr+"-"+dobMonth+"-"+dob_Day;
        addr = this.AddressField.getText().trim();
        city = this.cityField.getText().trim();
        State = (String) this.state.getSelectedItem();
        zip  = this.ZipCode.getText().trim();
        Phone = this.phone.getText().trim();
        Email = this.email.getText().trim();
        checkoutD =  chkYr+"-"+chkMon+"-"+chkDay;
        totalCharge = Double.parseDouble(grandTotalField.getText().trim());
        creditCard = this.cardNumber.getText().trim();
        exp_Month = this.expMonth.getMonth();
        exp_Year = this.expYear.getYear();
        
        // create a cutomer object
        
        cust.setIdNumber(custid);
        cust.setFirstName(fn);
        cust.setLastName(ln);
        cust.setDateOfBirth(dob);
        cust.setAddress(addr);
        cust.setCity(city);
        cust.setState(State);
        cust.setZipCode(zip);
        cust.setZipCode(zip);
        cust.setPhone(Phone);
        cust.setEmail(Email);
        
            
      // End of creating object
        
        // Create and save a customer's Transacton
      
        transaction.setroomnumb(roomN);
        transaction.setCustomerID(custid);
        transaction.setEmpID(empID);
        transaction.setCheckoutDate(checkoutD);
        transaction.setTotalCharge(totalCharge);
        transaction.setCardNumber(creditCard);
        transaction.setExpMonth(exp_Month);
        transaction.setExpYear(exp_Year);
        
         
        
         
        
        
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
        LocalDate objDOB = LocalDate.parse(dob);
         age = LocalDate.now().getYear() - objDOB.getYear();
        
        if(age >= 18){
            try{
                
                customerAdded = this.custList.add(cust.getIdNumber(), cust); // adds customer object to memory
                 
                transactionAdded = this.transList.add(transaction.getroomnumb(), transaction);
                    if(customerAdded){
                        if(transactionAdded){                        
                            JOptionPane.showMessageDialog(null, "All Record Saved Succussfulyy!");                                 
                                String total = this.grandTotalField.getText();
                                
                                RecieptForm recieptForm = new RecieptForm(cust,transaction,total);
                                this.dispose(); 
                                recieptForm.setVisible(true);
                        }
                    }
            }catch(Exception ex){
                JOptionPane.showConfirmDialog(null, "error while save"+ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
            
        else{
            JOptionPane.showMessageDialog(null, "Policy Violated, Under Age Guest", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Save_AddActionPerformed

    private void AddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressFieldActionPerformed

    private void saveAndSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAndSubmitActionPerformed
        // TODO add your handling code here:
         String dobYr,dobMon,dobDay, dobMonth,dob_Day;
        dobYr = String.valueOf(this.dateOfBirth.getCalendar().getTime().getYear()+1900);
        dobMon = String.valueOf(this.dateOfBirth.getCalendar().getTime().getMonth());
        dobDay = String.valueOf(this.dateOfBirth.getCalendar().getTime().getDate());
        
        String chkYr,chkMon,chkDay;
        chkYr = String.valueOf(this.checkoutDate.getCalendar().getTime().getYear()+1900);
        chkMon = String.valueOf(this.checkoutDate.getCalendar().getTime().getMonth());
        chkDay = String.valueOf(this.checkoutDate.getCalendar().getTime().getDate());
        
        
        
        if(Integer.parseInt(dobMon) < 10){
            dobMonth = "0"+dobMon;
        }else{
            dobMonth = dobMon;
        }
        
        if(Integer.parseInt(dobDay) < 10){
            dob_Day = "0"+dobDay;
        }else{
            dob_Day = dobDay;
        }
        
        custid = this.customerID.getText().trim();
        fn = this.FirstName.getText().trim();
        ln = this.LastName.getText().trim();
        dob = dobYr+"-"+dobMonth+"-"+dob_Day;
        addr = this.AddressField.getText().trim();
        city = this.cityField.getText().trim();
        State = (String) this.state.getSelectedItem();
        zip  = this.ZipCode.getText().trim();
        Phone = this.phone.getText().trim();
        Email = this.email.getText().trim();
        checkoutD =  chkYr+"-"+chkMon+"-"+chkDay;
        totalCharge = Double.parseDouble(grandTotalField.getText().trim());
        creditCard = this.cardNumber.getText().trim();
        exp_Month = this.expMonth.getMonth();
        exp_Year = this.expYear.getYear();
        
        
        // create a cutomer object
        cust.setIdNumber(custid);
        cust.setFirstName(fn);
        cust.setLastName(ln);
        cust.setDateOfBirth(dob);
        cust.setAddress(addr);
        cust.setCity(city);
        cust.setState(State);
        cust.setZipCode(zip);
        cust.setZipCode(zip);
        cust.setPhone(Phone);
        cust.setEmail(Email);
        
             
      // End of creating object
        
        // Create and save a customer's Transacton
       
        transaction.setroomnumb(roomN);
        transaction.setCustomerID(custid);
        transaction.setEmpID(empID);
        transaction.setCheckoutDate(checkoutD);
        transaction.setTotalCharge(totalCharge);
        transaction.setCardNumber(creditCard);
        transaction.setExpMonth(exp_Month);
        transaction.setExpYear(exp_Year);
        
         
        
         
        
        
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
        LocalDate objDOB = LocalDate.parse(dob);
         age = LocalDate.now().getYear() - objDOB.getYear();
        
        if(age >= 18){
            try{
                
                customerAdded = custList.add(custid, cust); // adds customer object to memory
                
                transactionAdded = transList.add(roomN, transaction);
                
                    if(customerAdded){
                        if(transactionAdded){
                              
                            custList.saveCustomer();
                            transList.saveTransaction();                          
                                JOptionPane.showMessageDialog(null, "All Record Saved Succussfulyy!");                                 
                                String total = this.grandTotalField.getText();
                                
                                RecieptForm recieptForm = new RecieptForm(cust,transaction,total);
                                this.dispose(); 
                                recieptForm.setVisible(true);
                                 
                        }
                    }
            }catch(Exception ex){ 
                JOptionPane.showMessageDialog(null, "error while save"+ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
            
        else{
            JOptionPane.showMessageDialog(null, "Policy Violated, Under Age Guest", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_saveAndSubmitActionPerformed

    private void ContinueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueBtnActionPerformed
        
        
        
        // TODO add your handling code here:
        
        int checkOutDay = checkoutDate.getCalendar().getTime().getDate(); 
        int currentDay = new java.util.Date().getDate();
        int diff = checkOutDay - currentDay; 
        double grandTotal = transList.getGrandTotal(roomN) * diff;
        this.grandTotalField.setText(String.valueOf(grandTotal)); 
         
        this.creditDebitMethod.setEnabled(true);
        this.cashMethod.setEnabled(true);
        this.cardNumber.setEnabled(true);
        this.expMonth.setEnabled(true);
        this.expYear.setEnabled(true);
        this.Save_Add.setEnabled(true);
        this.saveAndSubmit.setEnabled(true);
    }//GEN-LAST:event_ContinueBtnActionPerformed

    private void cashMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashMethodActionPerformed
        // disable credit card if cash chosen
        this.cardNumber.setEnabled(false);
        this.expMonth.setEnabled(false);
        this.expYear.setEnabled(false);
        
        
        
      
    }//GEN-LAST:event_cashMethodActionPerformed

    private void creditDebitMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditDebitMethodActionPerformed
       // enable credit card if cash is not chosen
        this.cardNumber.setEnabled(true);
        this.expMonth.setEnabled(true);
        this.expYear.setEnabled(true);
    }//GEN-LAST:event_creditDebitMethodActionPerformed

    private void customerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_customerIDActionPerformed

    private void customerIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerIDKeyReleased
        // TODO add your handling code here:
        try{
            Integer.parseInt(customerID.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.ERROR_MESSAGE);
            customerID.setText("");
            customerID.requestFocus();
        }
    }//GEN-LAST:event_customerIDKeyReleased

    private void ZipCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZipCodeKeyReleased
        // making sure input is only a digit
        try{
            Integer.parseInt(ZipCode.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            ZipCode.setText("");
        } 
        this.continueNextPage();
    }//GEN-LAST:event_ZipCodeKeyReleased

    private void phoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyReleased
        // making sure input is only a digit
//        try{
//            Integer.parseInt(phone.getText());
//        }catch(NumberFormatException ex){
//            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
//            phone.setText("");
//        }
    }//GEN-LAST:event_phoneKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuestInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuestInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuestInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuestInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuestInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JButton ContinueBtn;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField LastName;
    private javax.swing.JButton Save_Add;
    private javax.swing.JTextField ZipCode;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cardNumber;
    private javax.swing.JRadioButton cashMethod;
    private com.toedter.calendar.JDateChooser checkoutDate;
    private javax.swing.JTextField cityField;
    private javax.swing.JRadioButton creditDebitMethod;
    private javax.swing.JLabel cust_ID_lable;
    private javax.swing.JTextField customerID;
    private com.toedter.calendar.JDateChooser dateOfBirth;
    private javax.swing.JTextField email;
    private javax.swing.JTextField employeeID;
    private com.toedter.calendar.JMonthChooser expMonth;
    private com.toedter.calendar.JYearChooser expYear;
    private javax.swing.JTextField grandTotalField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField roomNumber;
    private javax.swing.JButton saveAndSubmit;
    private javax.swing.JComboBox state;
    private javax.swing.JTextField subTotalField;
    private javax.swing.JTextField taxField;
    // End of variables declaration//GEN-END:variables
}
