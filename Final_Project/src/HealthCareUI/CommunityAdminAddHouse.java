/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HealthCareUI;

import HealthCare.City;
import HealthCare.Community;
import HealthCare.House;
import HealthCare.SystemAdmin;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author taswa
 */
public class CommunityAdminAddHouse extends javax.swing.JPanel {

    /**
     * Creates new form CommunityAddCommunity
     */
    public CommunityAdminAddHouse() {
        initComponents();
        fillTable();
//        fillTable1();
        fillTable2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        btnAdminAddDcotor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("House No.");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 110, 35));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 170, 32));

        btnAdminAddDcotor.setFont(new java.awt.Font("Yrsa SemiBold", 1, 18)); // NOI18N
        btnAdminAddDcotor.setText("Add House");
        btnAdminAddDcotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminAddDcotorActionPerformed(evt);
            }
        });
        add(btnAdminAddDcotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 120, 30));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "House Name", "Community Name", "House Object"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, 197));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "City Name", "City Object"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, 197));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Community Name", "city", "Community Object"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, 197));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/pavan/Downloads/pa.jpg")); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void btnAdminAddDcotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminAddDcotorActionPerformed
        // TODO add your handling code here:
        if(jTable2.getSelectedRow()>-1) {
          City c = (City)jTable2.getValueAt(jTable2.getSelectedRow(),1);
          Community b = (Community)jTable2.getValueAt(jTable2.getSelectedRow(),2);
         House a= new House(Integer.parseInt((name.getText())),b);
         SystemAdmin.houseList.add(a);
         fillTable2();
        }
        else{
             JOptionPane.showMessageDialog(null, "Please Select City");
        }
    }//GEN-LAST:event_btnAdminAddDcotorActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()>-1){
            City c = (City)jTable1.getValueAt(jTable1.getSelectedRow(), 1);
            fillTable1(c);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminAddDcotor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables

private void fillTable() {
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setRowCount(0);
       for(City  p : SystemAdmin.cityList ){
           
           Object[] row = new Object[2];
           row[0]= p.cityName;
           row[1]= p;
           
           
           
           model.addRow(row);
       }}

private void fillTable1(City c) {
       DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
       model.setRowCount(0);
       for(Community  p : SystemAdmin.communityList ){
           if(p.getCity() == c){
                Object[] row = new Object[3];
                row[0]= p.getCommunityName();
                row[1]= p.getCity();
                row[2]=p;



                model.addRow(row);
           }
       }}
private void fillTable2() {
       DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
       model.setRowCount(0);
       for(House  p : SystemAdmin.houseList ){
           
           Object[] row = new Object[3];
           row[0]= p.houseNo;
           row[1]= p.community;
           row[2]=p;
           
           
           
           model.addRow(row);
       }}}
