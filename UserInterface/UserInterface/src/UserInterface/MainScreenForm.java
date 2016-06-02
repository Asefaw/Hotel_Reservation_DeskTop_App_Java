/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BussinessClass.EmployeeList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A
 */
public class MainScreenForm extends javax.swing.JFrame {

    /**
     * Creates new form MainScreenForm
     */
    
    private EmployeeList emp;
    private ResultSet rst;
    private String fname,lname,id;
    
    
    public MainScreenForm() {
        initComponents();
         
    }
    
    public MainScreenForm(String uName) {
        initComponents();
        
        emp = new EmployeeList();
        id = uName;
        getEmpSession();
        this.setLocationRelativeTo(null);
    }

    // enables botton when coming back from another form.
    public void enableCheckinButton(){
        this.checkinBtn.setEnabled(true);
    }
    
    public void enableCheckoutButton(){
        this.checkoutBtn.setEnabled(true);
    }
    // get employee username, id
     public void getEmpSession(){
        try {
             
            rst = emp.getEmpSession(id);
            if(rst.next()){
                fname = rst.getString("firstName");
                lname = rst.getString("lastName");
                id = rst.getString("ssNumber"); 
            }
            this.session.setText(fname+", "+lname+", "+id);
                 
        } catch (SQLException ex) {
            Logger.getLogger(WelcomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        mainDesktop = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        checkinBtn = new javax.swing.JButton();
        session = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkoutBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        EmpManagement = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainDesktop.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout mainDesktopLayout = new javax.swing.GroupLayout(mainDesktop);
        mainDesktop.setLayout(mainDesktopLayout);
        mainDesktopLayout.setHorizontalGroup(
            mainDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        mainDesktopLayout.setVerticalGroup(
            mainDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );

        desktopPane.add(mainDesktop);
        mainDesktop.setBounds(10, 90, 1140, 810);

        jPanel4.setBackground(javax.swing.UIManager.getDefaults().getColor("EditorPane.selectionBackground"));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setPreferredSize(new java.awt.Dimension(1190, 89));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setText("RESERVATION SCREEN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(246, 246, 246))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        desktopPane.add(jPanel4);
        jPanel4.setBounds(0, 0, 1190, 50);

        checkinBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        checkinBtn.setText("Check in");
        checkinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinBtnActionPerformed(evt);
            }
        });
        desktopPane.add(checkinBtn);
        checkinBtn.setBounds(210, 50, 127, 35);

        session.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        desktopPane.add(session);
        session.setBounds(760, 60, 160, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Loged As:");
        desktopPane.add(jLabel2);
        jLabel2.setBounds(680, 60, 70, 20);

        checkoutBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        checkoutBtn.setText("checkout");
        checkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnActionPerformed(evt);
            }
        });
        desktopPane.add(checkoutBtn);
        checkoutBtn.setBounds(400, 50, 133, 35);

        fileMenu.setMnemonic('f');
        fileMenu.setText("MENU");

        EmpManagement.setMnemonic('o');
        EmpManagement.setText("EMPLOYEE MANAGEMENT");
        EmpManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpManagementActionPerformed(evt);
            }
        });
        fileMenu.add(EmpManagement);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinBtnActionPerformed
        // TODO add your handling code here:
        CheckinScreen checkin = new CheckinScreen(id);
        mainDesktop.add(checkin);
        checkin.setVisible(true);
        this.checkoutBtn.setEnabled(false);

    }//GEN-LAST:event_checkinBtnActionPerformed

    private void checkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnActionPerformed
        // TODO add your handling code here:
        CheckoutScreen checkout = new CheckoutScreen();
        mainDesktop.add(checkout);
        checkout.setVisible(true);
        this.checkinBtn.setEnabled(false);

    }//GEN-LAST:event_checkoutBtnActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void EmpManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpManagementActionPerformed
          
    }//GEN-LAST:event_EmpManagementActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreenForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EmpManagement;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton checkinBtn;
    private javax.swing.JButton checkoutBtn;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JDesktopPane mainDesktop;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JLabel session;
    // End of variables declaration//GEN-END:variables

}
