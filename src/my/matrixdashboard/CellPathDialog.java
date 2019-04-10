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
import java.net.URI;
import java.io.*;


public class CellPathDialog extends javax.swing.JPanel {

    CellPath cpath = null;
    JFrame f = null;
    JDialog d = null;
        
    // each element is an index into cpanel.cellpaths()
    ArrayList<Integer> AppPageIndexes = null;
    ArrayList<Integer> DocIndexes = null;
    ArrayList<Integer> ToolIndexes = null;
    ArrayList<Integer> BugReportIndexes = null;
    
    int ncurrentselected_apppage_in_combobox = 0;
    int ncurrentselected_doc_in_combobox = 0;
    int ncurrentselected_tool_in_combobox = 0;
    int ncurrentselected_bugreport_in_combobox = 0;
    
    CellPath currentcpath = null;
    

    /**
     * Creates new form CellPathDialog
     */
    public CellPathDialog(JFrame f, JDialog d, CellPath cpath) {
        System.out.println("CellPathDialog.constructor: called, cpath.id == " + cpath.id + ", cpath.pathname '" + cpath.pathname + "'");
        this.f = f;
        this.d = d;
        this.cpath = cpath;
        
        initComponents();
        //f.setTitle(cpath.pathname);
        
        setpathtypescomboboxcontents();
        setchoosetoolcomboboxcontents();

        setpanecontents();
        setpanestate();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jCancelButton = new javax.swing.JButton();
        jSaveButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(438, 429));

        jCellPathTypeLabel.setText("App page");

        jCellPathNameLabel.setText("Name");

        jPathTypeLabel.setText("Path type");

        jPathTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPathTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPathTypeComboBoxActionPerformed(evt);
            }
        });

        jPathLabel.setText("Path");

        jPathTextField.setText("path");

        jNameTextField.setText("page name");
        jNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNameTextFieldActionPerformed(evt);
            }
        });

        jChooseFileButton.setText("Choose File");
        jChooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChooseFileButtonActionPerformed(evt);
            }
        });

        jChooseToolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jChooseToolComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChooseToolComboBoxActionPerformed(evt);
            }
        });

        jArgsLabel.setText("Args");

        jArgsTextField.setText("args");

        jCancelButton.setText("Cancel");
        jCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButtonActionPerformed(evt);
            }
        });

        jSaveButton.setText("Save");
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
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
                                .addComponent(jPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jArgsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCancelButton)
                        .addGap(34, 34, 34)
                        .addComponent(jSaveButton)
                        .addGap(15, 15, 15)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jCancelButton)
                    .addComponent(jSaveButton))
                .addContainerGap(224, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNameTextFieldActionPerformed
    
    private void setpanecontents() {
        System.out.println("CellPathDialog.setpanecontents: called, cpath.cellpathtype == '" + cpath.cellpathtype + "', cpath.pathname == '" + cpath.pathname + "'");
        switch (cpath.cellpathtype.charAt(0)) {
            case CellPath.CELLPATHTYPEC_APPPAGE:
                jCellPathTypeLabel.setText("App Page");
                break;
            case CellPath.CELLPATHTYPEC_DOC:
                jCellPathTypeLabel.setText("Document");
                break;
            case CellPath.CELLPATHTYPEC_TOOL:
                jCellPathTypeLabel.setText("Tool");
                break;
            case CellPath.CELLPATHTYPEC_BUGREPORT:
                jCellPathTypeLabel.setText("Bug Report");
                break;
        }
        System.out.println("CellPathDialog.setpanecontents: jCellPathTypeLabel text == '" + jCellPathTypeLabel.getText() + "'");
        jNameTextField.setText(cpath.pathname);
        
        if (cpath.cellpathtype.charAt(0) == CellPath.CELLPATHTYPEC_TOOL) {
            System.out.println("CellPathDialog.setpanecontents: it's a tool; cpath.toolid == " + cpath.toolid);
            System.out.println("CellPathDialog.setpanecontents: MatrixDashboardUI.mdui.tools.size() == " + MatrixDashboardUI.mdui.tools.size());
            for (Tool tool : MatrixDashboardUI.mdui.tools) {
                System.out.println("CellPathDialog.setpanecontents: check tool.id == " + tool.id);
                if (tool.id == cpath.toolid) {
                    System.out.println("CellPathDialog.setpanecontents: tool.id == " + tool.id + ", tool.name == '" + tool.name + "', tool.pathtype == '" + tool.pathtype + "', tool.path == '" + tool.path + "'");
                    jPathTypeComboBox.setSelectedIndex(Database.pathtypeStringToIndex(tool.pathtype));
                    jPathTextField.setText(tool.path);
                }
            }
        } else {
            System.out.println("CellPathDialog.setpanecontents: not a tool; use cpath.pathtype '" + cpath.pathtype + "'");
            jPathTypeComboBox.setSelectedIndex(Database.pathtypeStringToIndex(cpath.pathtype));
            jPathTextField.setText(cpath.path);
        }
        jArgsTextField.setText(cpath.args);
    }

    private void setpanestate() {
        System.out.println("CellPathDialog.setpanestate: called");
        if (cpath.cellpathtype.equals(CellPath.CELLPATHTYPE_TOOL)) {
            jChooseToolComboBox.setEnabled(true);
            jChooseFileButton.setEnabled(false);
            jPathTextField.setEnabled(false);
        } else {
            switch (cpath.pathtype) {
                case Database.PATHTYPENAME_EXECUTE:
                case Database.PATHTYPENAME_EDITFILE:
                case Database.PATHTYPENAME_OPENFILE:
                    jChooseToolComboBox.setEnabled(false);
                    jChooseFileButton.setEnabled(true);
                    jPathTextField.setEnabled(true);
                    break;
                default:
                    jChooseToolComboBox.setEnabled(false);
                    jChooseFileButton.setEnabled(false);
                    jPathTextField.setEnabled(true);
                    break;
            }
        }
    }
    
    private void setpathtypescomboboxcontents() {
        System.out.println("CellPathDialog.setpathtypescomboboxcontents: called");
        String[] names = new String[40];
        int i = 0;
        // order is important
        names[i++] = Database.PATHTYPENAME_NONE;
        names[i++] = Database.PATHTYPENAME_EXECUTE;
        names[i++] = Database.PATHTYPENAME_BROWSEURL;
        names[i++] = Database.PATHTYPENAME_EDITFILE;
        names[i++] = Database.PATHTYPENAME_OPENFILE;
        names[i++] = Database.PATHTYPENAME_OWASPZAP;
        jPathTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setchoosetoolcomboboxcontents() {
        System.out.println("CellPathDialog.setchoosetoolcomboboxcontents: called, MatrixDashboardUI.mdui.tools.size() == " + MatrixDashboardUI.mdui.tools.size());
        String[] names = new String[40];
        int i = 0;
        for(Tool tool : MatrixDashboardUI.mdui.tools) {
            names[i++] = tool.name;
        }
        jChooseToolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        System.out.println("jSaveButtonActionPerformed: called");
        // TODO add your handling code here:
        d.dispose();
    }//GEN-LAST:event_jSaveButtonActionPerformed

    private void jCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButtonActionPerformed
        System.out.println("jCancelButtonActionPerformed: called");
        // TODO add your handling code here:
        d.dispose();
    }//GEN-LAST:event_jCancelButtonActionPerformed

    private void jChooseToolComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChooseToolComboBoxActionPerformed
        int index = jChooseToolComboBox.getSelectedIndex();
        cpath.toolid = MatrixDashboardUI.mdui.tools.get(index).id;
    }//GEN-LAST:event_jChooseToolComboBoxActionPerformed

    private void jPathTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPathTypeComboBoxActionPerformed
        int index = jPathTypeComboBox.getSelectedIndex();
        cpath.cellpathtype = CellPath.cellpathtypeIndexToString(index);
    }//GEN-LAST:event_jPathTypeComboBoxActionPerformed

    private void jChooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChooseFileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChooseFileButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jArgsLabel;
    private javax.swing.JTextField jArgsTextField;
    private javax.swing.JButton jCancelButton;
    private javax.swing.JLabel jCellPathNameLabel;
    private javax.swing.JLabel jCellPathTypeLabel;
    private javax.swing.JButton jChooseFileButton;
    private javax.swing.JComboBox<String> jChooseToolComboBox;
    private javax.swing.JTextField jNameTextField;
    private javax.swing.JLabel jPathLabel;
    private javax.swing.JTextField jPathTextField;
    private javax.swing.JComboBox<String> jPathTypeComboBox;
    private javax.swing.JLabel jPathTypeLabel;
    private javax.swing.JButton jSaveButton;
    // End of variables declaration//GEN-END:variables
}
