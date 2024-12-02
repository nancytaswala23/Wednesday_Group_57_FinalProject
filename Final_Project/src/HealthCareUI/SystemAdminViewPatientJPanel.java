/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HealthCareUI;

import HealthCare.Doctor;
import HealthCare.Patient;
import HealthCare.SystemAdmin;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pranav
 */
public class SystemAdminViewPatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminDoctorJPanel
     */
    public SystemAdminViewPatientJPanel() {
        initComponents();
        fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        search1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        community = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        patientID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        gender = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search.setForeground(new java.awt.Color(0, 102, 204));
        search.setText("UPDATE PATIENT");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 759, -1, 49));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("View Patients");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(792, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

        patientTable.setBackground(new java.awt.Color(204, 255, 255));
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "GENDER", "CITY", "COMMUNITY", "USERNAME", "PASSWORD", "Patient Obj"
            }
        ));
        patientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 724, 294));

        search1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search1.setForeground(new java.awt.Color(0, 102, 204));
        search1.setText("DELETE PATIENT");
        search1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search1MouseClicked(evt);
            }
        });
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 424, -1, 49));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("Community");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 105, 35));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 193, 32));
        add(community, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 193, 32));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText(" Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 105, 35));
        add(patientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 193, 32));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Patient ID");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, 35));

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 720, 192, 32));

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 660, 193, 32));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 204));
        jLabel17.setText("Password");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 720, 105, 35));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Gender");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 105, 35));

        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 192, 32));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Username");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 660, 105, 35));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 204));
        jLabel15.setText("City");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 118, 35));

        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });
        add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 193, 32));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/pavan/Downloads/2.jpg")); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 48, 1160, 790));
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
if(!Pattern.compile("[a-zA-Z ]+").matcher(name.getText()).matches()){
            JOptionPane.showMessageDialog(this, "Please enter valid name");
            return;
//            ([a-z].[0-9])|([0-9].[a-z])
//           
        }
        
        if(!Pattern.compile("[a-zA-Z ]+").matcher(gender.getText()).matches()){
            JOptionPane.showMessageDialog(this, "Please enter valid Gender");
            return;
        }
        if(!Pattern.compile("[0-9]*$").matcher(patientID.getText()).matches()){
            JOptionPane.showMessageDialog(this, "Please enter valid ID");
            return;
            
        }
        if(!Pattern.compile("[a-zA-Z ]+").matcher(community.getText()).matches()){
            JOptionPane.showMessageDialog(this, "please enter valid Community");
            return;
       
        }
        if(!Pattern.compile("[a-zA-Z ]+").matcher(city.getText()).matches()){
            JOptionPane.showMessageDialog(this, "please enter valid City");
            return;
        }if(!Pattern.compile("^[a-zA-Z0-9._-]{3,}$").matcher(user.getText()).matches()){
            JOptionPane.showMessageDialog(this, "6");
            return;
        }
       
        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        int selectedRowIndex = patientTable.getSelectedRow();
       
        if (selectedRowIndex<0){
            JOptionPane.showMessageDialog(this, "Please select a Row to Update");
            return;
        }
       
       
       
       
       
       
        if(patientTable.getSelectedRowCount() == 1){
          Patient p = (Patient)model.getValueAt(patientTable.getSelectedRow(), 7);
         
          p.patientID=Integer.parseInt(patientID.getText());
          p.city=city.getText();
          p.community= community.getText();
        
          p.gender=gender.getText();
          p.name=name.getText();
          p.username=user.getText();
          p.password=pass.getText();
          
            //if single row is selected then update
         fillTable();
            JOptionPane.showMessageDialog(this, "Update Successful !!!");
        }
        else{
           
            if(patientTable.getRowCount () == 0){
                //if table is empty
                JOptionPane.showMessageDialog(this, "Table is empty !!!");
            }
            else{
                //if row is not selected or multiple row is selected
                JOptionPane.showMessageDialog(this, "Please select single row for update !!!");

            }
        }        
        

        
        

  
    }//GEN-LAST:event_searchActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void patientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMouseClicked
        // TODO add your handling code here:
        
        if(patientTable.getSelectedRow()>-1){   
            DefaultTableModel model = (DefaultTableModel)patientTable.getModel();
            Patient p = (Patient)model.getValueAt(patientTable.getSelectedRow(), 7);
            patientID.setText(String.valueOf(p.patientID));
            name.setText(p.name);
            gender.setText(p.gender);

            city.setText(p.city);
            community.setText(p.community);
            user.setText(p.username);
            pass.setText(p.password);
        }else{
            JOptionPane.showMessageDialog(this,"Select the patient");
        }
                                     

    }//GEN-LAST:event_patientTableMouseClicked

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void search1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseClicked
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel)patientTable.getModel();
        Patient p = (Patient)model.getValueAt(patientTable.getSelectedRow(), 7);
        if(p!= null){
            SystemAdmin.patientList.remove(p);
            fillTable();
        }
    }//GEN-LAST:event_search1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField city;
    private javax.swing.JTextField community;
    private javax.swing.JTextField gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField patientID;
    private javax.swing.JTable patientTable;
    private javax.swing.JButton search;
    private javax.swing.JButton search1;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables


       private void fillTable() {
       DefaultTableModel model = (DefaultTableModel)patientTable.getModel();
       model.setRowCount(0);
       for(Patient  p : SystemAdmin.patientList ){
           
           Object[] row = new Object[8];
           row[0]= p.patientID;
           row[1]= p.name;
           row[2]= p.gender;
           
           row[3]= p.city;
           row[4]= p.community;
           row[5]= p.username;
           row[6]= p.password;
           row[7]= p;
           
           
           model.addRow(row);
       }}}