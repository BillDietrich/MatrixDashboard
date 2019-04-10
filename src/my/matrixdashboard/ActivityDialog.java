/* 
 * Copyright <2019> <Bill Dietrich>
 * 
 * Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby granted, provided that the above copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package my.matrixdashboard;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// note that this is a PANEL used inside a DIALOG created somewhere else
public class ActivityDialog extends javax.swing.JPanel {

    Activity a = null;
    JFrame f = null;
    JDialog d = null;
    int dialogtype = 0;
    
   public static final int DIALOGTYPE_PROPERTIES = 1;
   public static final int DIALOGTYPE_NEW = 2;
   public static final int DIALOGTYPE_CLONE = 3;
   public static final int DIALOGTYPE_DELETE = 4;

    /**
     * Creates new form ActivityDialog
     */
    public ActivityDialog(JFrame f, JDialog d, Activity a, int dialogtype) {
        System.out.println("ActivityDialog.constructor: called, a.id == " + a.id + ", dialogtype == " + dialogtype);
        this.f = f;
        this.d = d;
        this.a = a;
        this.dialogtype = dialogtype;
       initComponents();
       // enable field controls
       switch (dialogtype) {
           case DIALOGTYPE_PROPERTIES:
           case DIALOGTYPE_NEW:
               break;
           case DIALOGTYPE_DELETE:
               jActivityNameTextField.setEnabled(false);
           case DIALOGTYPE_CLONE:
               jRoleComboBox.setEnabled(false);
               jBrowserComboBox.setEnabled(false);
               jDeviceComboBox.setEnabled(false);
               jOSComboBox.setEnabled(false);
               break;
           default:
                System.out.println("ActivityDialog.constructor: illegal dialogtype == " + dialogtype);
               break;
       }
       // set field values
       switch (dialogtype) {
           case DIALOGTYPE_NEW:
               break;
           case DIALOGTYPE_PROPERTIES:
           case DIALOGTYPE_CLONE:
           case DIALOGTYPE_DELETE:
               break;
           default:
                System.out.println("ActivityDialog.constructor: illegal dialogtype == " + dialogtype);
               break;
       }
       // set buttons
       switch (dialogtype) {
           case DIALOGTYPE_PROPERTIES:
           case DIALOGTYPE_NEW:
           case DIALOGTYPE_CLONE:
               jDeleteButton.setEnabled(false);
               jDeleteButton.setVisible(false);
               break;
           case DIALOGTYPE_DELETE:
                jSaveButton.setEnabled(false);
                jSaveButton.setVisible(false);
               break;
           default:
                System.out.println("ActivityDialog.constructor: illegal dialogtype == " + dialogtype);
               break;
       }
       switch (dialogtype) {
           case DIALOGTYPE_PROPERTIES:
               break;
           case DIALOGTYPE_NEW:
               jSaveButton.setText("Save New");
               break;
           case DIALOGTYPE_CLONE:
               jSaveButton.setText("Save Clone");
               break;
           case DIALOGTYPE_DELETE:
               break;
           default:
                System.out.println("ActivityDialog.constructor: illegal dialogtype == " + dialogtype);
               break;
       }
       setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jActivityNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRoleComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBrowserComboBox = new javax.swing.JComboBox<>();
        jDeviceComboBox = new javax.swing.JComboBox<>();
        jOSComboBox = new javax.swing.JComboBox<>();
        jSaveButton = new javax.swing.JButton();
        jCancelButton = new javax.swing.JButton();
        jDeleteButton = new javax.swing.JButton();

        setName("New Activity"); // NOI18N

        jLabel1.setText("Activity");

        jActivityNameTextField.setText("ActivityNameValue");
        jActivityNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActivityNameTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Role");

        jRoleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jRoleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRoleComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Client");

        jLabel4.setText("Browser");

        jLabel5.setText("Device");

        jLabel6.setText("OS");

        jBrowserComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jBrowserComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowserComboBoxActionPerformed(evt);
            }
        });

        jDeviceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDeviceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeviceComboBoxActionPerformed(evt);
            }
        });

        jOSComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jOSComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOSComboBoxActionPerformed(evt);
            }
        });

        jSaveButton.setText("Save");
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });

        jCancelButton.setText("Cancel");
        jCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButtonActionPerformed(evt);
            }
        });

        jDeleteButton.setBackground(new java.awt.Color(245, 18, 18));
        jDeleteButton.setText("Delete");
        jDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jActivityNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(36, 36, 36)
                            .addComponent(jOSComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDeviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(jBrowserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDeleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jActivityNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jRoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jBrowserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jDeviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jOSComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSaveButton)
                    .addComponent(jCancelButton)
                    .addComponent(jDeleteButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jActivityNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActivityNameTextFieldActionPerformed
        // TODO add your handling code here:
        System.out.println("ActivityDialog.jTextField1ActionPerformed: called");
    }//GEN-LAST:event_jActivityNameTextFieldActionPerformed

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("ActivityDialog.jSaveButtonActionPerformed: called");
        setVisible(false);
        d.dispatchEvent(new WindowEvent(d, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jSaveButtonActionPerformed

    private void jCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("ActivityDialog.jCancelButtonActionPerformed: called");
        setVisible(false);
        d.dispatchEvent(new WindowEvent(d, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jCancelButtonActionPerformed

    private void jDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("ActivityDialog.jDeleteButtonActionPerformed: called");
        setVisible(false);
        d.dispatchEvent(new WindowEvent(d, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jDeleteButtonActionPerformed

    private void jRoleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRoleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRoleComboBoxActionPerformed

    private void jBrowserComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowserComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBrowserComboBoxActionPerformed

    private void jDeviceComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeviceComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDeviceComboBoxActionPerformed

    private void jOSComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOSComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jOSComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jActivityNameTextField;
    private javax.swing.JComboBox<String> jBrowserComboBox;
    private javax.swing.JButton jCancelButton;
    private javax.swing.JButton jDeleteButton;
    private javax.swing.JComboBox<String> jDeviceComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jOSComboBox;
    private javax.swing.JComboBox<String> jRoleComboBox;
    private javax.swing.JButton jSaveButton;
    // End of variables declaration//GEN-END:variables
}
