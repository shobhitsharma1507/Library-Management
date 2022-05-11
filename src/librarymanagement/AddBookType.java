/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import javax.swing.JOptionPane;
import modelDAO.BookTypeDAO;
import modelTO.BookTypeTO;

/**
 *
 * @author Shobhit
 */
public class AddBookType extends javax.swing.JInternalFrame {

    boolean isUpdate;
    String oldtype;

    public AddBookType() {
        initComponents();
    }

    public AddBookType(boolean update, String bookType) {
        this();
        isUpdate = update;
        oldtype = bookType;
        if (isUpdate) {
            jAddBtn.setText("Update");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFBType = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jAddBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Add New Type");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("New Book Type :");

        jAddBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jAddBtn.setText("ADD");
        jAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jTFBType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jTFBType))
                .addGap(34, 34, 34)
                .addComponent(jAddBtn)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddBtnActionPerformed
        String message = "";
        String bType = jTFBType.getText().trim();
        BookTypeTO bt = new BookTypeTO();
        bt.setBookType(bType);
        BookTypeDAO dao = new BookTypeDAO();
        if (isUpdate && !bType.isEmpty()) {
            if (dao.updateRecord(bType, oldtype)) {
                message += "Record is updated in database";
            }
        } else if (!bType.isEmpty()) {
            if (dao.insertRecord(bt)) {
                message += "Record is inserted in database";
            } else {
                message += "Insertion Failure due to:" + dao.getEror();
            }
        } else {
            message += "Field is Empty";
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jAddBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTFBType;
    // End of variables declaration//GEN-END:variables
}