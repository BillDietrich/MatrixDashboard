/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.matrixdashboard;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author user1
 */
public class CellDialog extends javax.swing.JPanel {

    CellPanel cp = null;
    JFrame f = null;
    JDialog d = null;

    /**
     * Creates new form CellDialog
     */
    public CellDialog(JFrame f, JDialog d, CellPanel cp) {
        System.out.println("CellDialog.constructor: called, cp == " + cp);
        this.f = f;
        this.d = d;
        this.cp = cp;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jAppPagesLabel = new javax.swing.JLabel();
        jAppPagesComboBox = new javax.swing.JComboBox<>();
        jDocsLabel = new javax.swing.JLabel();
        jDocsComboBox = new javax.swing.JComboBox<>();
        jToolsLabel = new javax.swing.JLabel();
        jToolsComboBox = new javax.swing.JComboBox<>();
        jBugReportsLabel = new javax.swing.JLabel();
        jBugReportsComboBox = new javax.swing.JComboBox<>();
        jAppPagesRadioButton = new javax.swing.JRadioButton();
        jDocsRadioButton = new javax.swing.JRadioButton();
        jToolsRadioButton = new javax.swing.JRadioButton();
        jBugReportsRadioButton = new javax.swing.JRadioButton();
        jCellPathTypeLabel = new javax.swing.JLabel();
        jCellPathNameLabel = new javax.swing.JLabel();
        jPathTypeLabel = new javax.swing.JLabel();
        jPathTypeComboBox = new javax.swing.JComboBox<>();
        jPathLabel = new javax.swing.JLabel();
        jPathTextField = new javax.swing.JTextField();
        jNameTextField = new javax.swing.JTextField();
        jChooseFileButton = new javax.swing.JButton();
        jChooseToolComboBox = new javax.swing.JComboBox<>();
        jArgsLabel = new javax.swing.JLabel();
        jArgsTextField = new javax.swing.JTextField();
        jDeleteButton = new javax.swing.JButton();
        jCancelButton = new javax.swing.JButton();
        jSaveButton = new javax.swing.JButton();
        jCloseCellButton1 = new javax.swing.JButton();
        jRunButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(438, 429));

        jAppPagesLabel.setText("App pages");

        jAppPagesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDocsLabel.setText("Docs");

        jDocsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jToolsLabel.setText("Tools");

        jToolsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBugReportsLabel.setText("Bug reports");

        jBugReportsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jAppPagesRadioButton.setText("jAppPageRadioButton");

        jDocsRadioButton.setText("jAppPageRadioButton");

        jToolsRadioButton.setText("jAppPageRadioButton");

        jBugReportsRadioButton.setText("jAppPageRadioButton");

        jCellPathTypeLabel.setText("App page");

        jCellPathNameLabel.setText("Name");

        jPathTypeLabel.setText("Path type");

        jPathTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPathLabel.setText("Path");

        jPathTextField.setText("jTextField1");

        jNameTextField.setText("page name");
        jNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNameTextFieldActionPerformed(evt);
            }
        });

        jChooseFileButton.setText("Choose File");

        jChooseToolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jArgsLabel.setText("jLabel1");

        jArgsTextField.setText("jTextField1");

        jDeleteButton.setBackground(new java.awt.Color(247, 4, 4));
        jDeleteButton.setText("Delete");

        jCancelButton.setText("Cancel");

        jSaveButton.setText("Save");

        jCloseCellButton1.setText("Close Cell");

        jRunButton.setBackground(new java.awt.Color(63, 241, 65));
        jRunButton.setText("Run");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAppPagesRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDocsRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToolsRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBugReportsRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAppPagesLabel)
                            .addComponent(jDocsLabel)
                            .addComponent(jToolsLabel)
                            .addComponent(jBugReportsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jAppPagesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBugReportsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCloseCellButton1)
                                .addGap(63, 63, 63))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jToolsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDocsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jCellPathTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(192, 192, 192))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jCellPathNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPathTypeLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jNameTextField)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jPathTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jChooseToolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jChooseFileButton))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPathLabel)
                                                .addComponent(jArgsLabel))
                                            .addGap(24, 24, 24)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPathTextField)
                                                .addComponent(jArgsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jDeleteButton)
                                        .addGap(146, 146, 146)
                                        .addComponent(jRunButton)
                                        .addGap(48, 48, 48)
                                        .addComponent(jCancelButton)
                                        .addGap(34, 34, 34)
                                        .addComponent(jSaveButton)
                                        .addGap(15, 15, 15))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAppPagesLabel)
                    .addComponent(jAppPagesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAppPagesRadioButton)
                    .addComponent(jCloseCellButton1))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDocsLabel)
                    .addComponent(jDocsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDocsRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToolsLabel)
                    .addComponent(jToolsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolsRadioButton))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBugReportsLabel)
                    .addComponent(jBugReportsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBugReportsRadioButton))
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCellPathTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCellPathNameLabel)
                    .addComponent(jNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPathTypeLabel)
                    .addComponent(jPathTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChooseFileButton)
                    .addComponent(jChooseToolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPathLabel)
                    .addComponent(jPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jArgsLabel)
                    .addComponent(jArgsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDeleteButton)
                    .addComponent(jCancelButton)
                    .addComponent(jSaveButton)
                    .addComponent(jRunButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> jAppPagesComboBox;
    private javax.swing.JLabel jAppPagesLabel;
    private javax.swing.JRadioButton jAppPagesRadioButton;
    private javax.swing.JLabel jArgsLabel;
    private javax.swing.JTextField jArgsTextField;
    private javax.swing.JComboBox<String> jBugReportsComboBox;
    private javax.swing.JLabel jBugReportsLabel;
    private javax.swing.JRadioButton jBugReportsRadioButton;
    private javax.swing.JButton jCancelButton;
    private javax.swing.JLabel jCellPathNameLabel;
    private javax.swing.JLabel jCellPathTypeLabel;
    private javax.swing.JButton jChooseFileButton;
    private javax.swing.JComboBox<String> jChooseToolComboBox;
    private javax.swing.JButton jCloseCellButton1;
    private javax.swing.JButton jDeleteButton;
    private javax.swing.JComboBox<String> jDocsComboBox;
    private javax.swing.JLabel jDocsLabel;
    private javax.swing.JRadioButton jDocsRadioButton;
    private javax.swing.JTextField jNameTextField;
    private javax.swing.JLabel jPathLabel;
    private javax.swing.JTextField jPathTextField;
    private javax.swing.JComboBox<String> jPathTypeComboBox;
    private javax.swing.JLabel jPathTypeLabel;
    private javax.swing.JButton jRunButton;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jToolsComboBox;
    private javax.swing.JLabel jToolsLabel;
    private javax.swing.JRadioButton jToolsRadioButton;
    // End of variables declaration//GEN-END:variables
}