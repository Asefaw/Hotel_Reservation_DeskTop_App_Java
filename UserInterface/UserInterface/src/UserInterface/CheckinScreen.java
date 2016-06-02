 
package UserInterface;

import BussinessClass.EmployeeList;
import BussinessClass.Room;
import BussinessClass.RoomList;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tmeku4692
 */
public class CheckinScreen extends javax.swing.JInternalFrame {

    /**
     * Creates new form CheckinScreen
     */
    private String empfname,emplname;
    private String empID;
    private final Room room = new Room();
    private RoomList roomList = new RoomList(); 
    private final EmployeeList emp =  new EmployeeList();
    private GuestInfo guest;
    
    public CheckinScreen() {
        initComponents(); 
        loadRooms();
         
    }

    public CheckinScreen(String empid){
        initComponents();   
        loadRooms();
        empID = empid;
        
    }
    // enables button when coming back from another screen
    public void enableExitButton(){
        this.checkinExit.setEnabled(true);
    }
    //lodas roome from database to application
    private void loadRooms(){ 
        try{
            
            ResultSet rst = roomList.loadRooms();
            roomTable.setModel(DbUtils.resultSetToTableModel(rst));
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkinDesktop = new javax.swing.JDesktopPane();
        jPanel10 = new javax.swing.JPanel();
        floorNumber = new javax.swing.JComboBox();
        roomTypeCombo = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        checkinExit = new javax.swing.JButton();

        setBorder(null);
        setName("Checkin Screen"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1150, 880));

        checkinDesktop.setBackground(new java.awt.Color(0, 102, 102));
        checkinDesktop.setPreferredSize(new java.awt.Dimension(1150, 900));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        floorNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        floorNumber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5" }));
        floorNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floorNumberActionPerformed(evt);
            }
        });

        roomTypeCombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roomTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "penthouse Suite", "Presidential Suite", "Honeymoon Suite", "Family Suite", "Single room" }));
        roomTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomTypeComboActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Search for a room:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Filiter by No. Floor:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Filliter by room type:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel24))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floorNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel25))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(roomTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(floorNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(397, Short.MAX_VALUE))
        );

        roomTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        roomTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(roomTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Available Rooms");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Select the desired room and click the Reserve button to continue with the ckeckin.");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("RESERVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        checkinExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        checkinExit.setText("EXIT");
        checkinExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkinDesktopLayout = new javax.swing.GroupLayout(checkinDesktop);
        checkinDesktop.setLayout(checkinDesktopLayout);
        checkinDesktopLayout.setHorizontalGroup(
            checkinDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinDesktopLayout.createSequentialGroup()
                .addGroup(checkinDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkinDesktopLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(checkinDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkinExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(checkinDesktopLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(checkinDesktopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(365, 365, 365))
        );
        checkinDesktopLayout.setVerticalGroup(
            checkinDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinDesktopLayout.createSequentialGroup()
                .addGroup(checkinDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkinDesktopLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(checkinExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkinDesktopLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(checkinDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(checkinDesktopLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(checkinDesktopLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        checkinDesktop.setLayer(jPanel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        checkinDesktop.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        checkinDesktop.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        checkinDesktop.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        checkinDesktop.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        checkinDesktop.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        checkinDesktop.setLayer(checkinExit, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(checkinDesktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(checkinDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomTypeComboActionPerformed
        try {
            // TODO add your handling code here:
            // filtering rooms by type
            ResultSet rstRoom;
            String roomType;
            roomList = new RoomList(); 
            if(roomTypeCombo.getSelectedIndex() == 1){ 
                rstRoom = roomList.loadPenthouseRooms("Penthouse"); 
                roomTable.setModel(DbUtils.resultSetToTableModel(rstRoom));
            }
            else 
                if(roomTypeCombo.getSelectedIndex() == 2){
                rstRoom = roomList.loadPenthouseRooms("Presidential"); 
                roomTable.setModel(DbUtils.resultSetToTableModel(rstRoom));
            } 
            else 
                if(roomTypeCombo.getSelectedIndex() == 3){
                rstRoom = roomList.loadHoneyMoonRooms("Honeymoon"); 
                roomTable.setModel(DbUtils.resultSetToTableModel(rstRoom));
            }
            else 
                if(roomTypeCombo.getSelectedIndex() == 4){
                rstRoom = roomList.loadFamilyRooms("Family"); 
                roomTable.setModel(DbUtils.resultSetToTableModel(rstRoom));
            } else 
                if(roomTypeCombo.getSelectedIndex() == 5){
                rstRoom = roomList.loadSingleRooms("Single"); 
                roomTable.setModel(DbUtils.resultSetToTableModel(rstRoom));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckinScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_roomTypeComboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
         // to get session information
               int row;
        String roomNumb;
        row = roomTable.getSelectedRow();        
        roomNumb = roomTable.getValueAt(row, 0).toString();
        guest = new GuestInfo(empID,roomNumb); 
        if(String.valueOf(roomTable.getValueAt(row, 4)).equalsIgnoreCase("NO")){
            JOptionPane.showMessageDialog(null, "Room Not Available for Checking", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            checkinDesktop.add(guest);
            guest.setVisible(true);
            this.checkinExit.setEnabled(false);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.loadRooms();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void floorNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floorNumberActionPerformed
        //Filter rooms by floor
        roomList = new RoomList();
        ResultSet rstFL;
        try{
            if(this.floorNumber.getSelectedIndex()==1){
                //case 1:
                    rstFL = roomList.loadFirstFL(1);
                    roomTable.setModel(DbUtils.resultSetToTableModel(rstFL));
            }
            else 
                if(floorNumber.getSelectedIndex()==2){
                rstFL = roomList.loadSecondFL(2);
                roomTable.setModel(DbUtils.resultSetToTableModel(rstFL));
            }
            else 
                if(floorNumber.getSelectedIndex()==3){
                rstFL = roomList.loadThirdFL(3);
                roomTable.setModel(DbUtils.resultSetToTableModel(rstFL));
            }else 
                        if(floorNumber.getSelectedIndex()==4){
                rstFL = roomList.loadFourthFL(4);
                roomTable.setModel(DbUtils.resultSetToTableModel(rstFL));
            }else 
                if(floorNumber.getSelectedIndex()==1){
                rstFL = roomList.loadFifthFL(5);
                roomTable.setModel(DbUtils.resultSetToTableModel(rstFL));
            }else{ 
                JOptionPane.showMessageDialog(null, "No Rooms on This Floos at This Time");
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_floorNumberActionPerformed

    private void checkinExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinExitActionPerformed
        // TODO add your handling code here:
        Component source = (Component)evt.getSource();
        MainScreenForm Main = (MainScreenForm)SwingUtilities.windowForComponent(source);
        Main.enableCheckoutButton();
        this.dispose();
    }//GEN-LAST:event_checkinExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane checkinDesktop;
    private javax.swing.JButton checkinExit;
    private javax.swing.JComboBox floorNumber;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable roomTable;
    private javax.swing.JComboBox roomTypeCombo;
    // End of variables declaration//GEN-END:variables
}
