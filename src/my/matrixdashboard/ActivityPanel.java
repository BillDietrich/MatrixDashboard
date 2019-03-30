/*
 * To change this license header, choose License Headers in Activity Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.matrixdashboard;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class ActivityPanel extends JPanel {

   // for display in table cell
  JPanel p = null;
  JLabel nameLabel = null;
  JLabel roleLabel = null;
  JLabel clientLabel = null;
  final javax.swing.GroupLayout activityPanelLayout = new javax.swing.GroupLayout(this);

   // for right-click context menu
  final JPopupMenu popupMenu = new javax.swing.JPopupMenu();
  final JMenuItem propertiesMenuItem = new javax.swing.JMenuItem("Properties of this Activity");
  final JMenuItem cloneActivityMenuItem = new javax.swing.JMenuItem("Clone this Activity");
  final JMenuItem newActivityMenuItem = new javax.swing.JMenuItem("Add new Activity");
  final JMenuItem deleteActivityMenuItem = new javax.swing.JMenuItem("Delete this Activity");
  
  Activity a = null;

  public ActivityPanel(Activity a, Role r, Client c) {
      
    super(new BorderLayout(0, 0));
    setBorder(BorderFactory.createEmptyBorder());
    
    this.a = a;

    nameLabel = new JLabel(a.name);
    nameLabel.setHorizontalAlignment(JLabel.LEFT);

    String abbrev = r.abbrev;
    if (abbrev.equals(Database.NONEABBREV))
        abbrev = "";
    roleLabel = new JLabel(abbrev);
    roleLabel.setHorizontalAlignment(JLabel.LEFT);

    String cname = c.name;
    if (cname.equals(Database.NONENAME))
        cname = "";
    clientLabel = new JLabel(cname);
    clientLabel.setHorizontalAlignment(JLabel.LEFT);

    p = new JPanel();
    p.setOpaque(false);
    p.setPreferredSize(new java.awt.Dimension(100, 60));
/*    
    p.setLayout(activityPanelLayout);
    activityPanelLayout.setAutoCreateGaps(true);
    activityPanelLayout.setAutoCreateContainerGaps(true);
    GroupLayout.SequentialGroup sGroup = activityPanelLayout.createSequentialGroup();
    // ??? got lost about here
*/
    p.add(nameLabel, BorderLayout.WEST);
    p.add(roleLabel, BorderLayout.CENTER);
    p.add(clientLabel, BorderLayout.EAST);

    add(p, BorderLayout.WEST);

    propertiesMenuItem.setComponentPopupMenu(popupMenu);
    propertiesMenuItem.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e) {
            JDialog dialog = new JDialog(MatrixDashboardUI.mdui, "Activity Properties", true);
            ActivityDialog ad = new ActivityDialog(MatrixDashboardUI.mdui, dialog, a, ActivityDialog.DIALOGTYPE_PROPERTIES);
            dialog.getContentPane().add(ad);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    });
    popupMenu.add(propertiesMenuItem);
    
    cloneActivityMenuItem.setComponentPopupMenu(popupMenu);
    cloneActivityMenuItem.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e) {
            JDialog dialog = new JDialog(MatrixDashboardUI.mdui, "Clone Activity", true);
            ActivityDialog ad = new ActivityDialog(MatrixDashboardUI.mdui, dialog, a, ActivityDialog.DIALOGTYPE_CLONE);
            dialog.getContentPane().add(ad);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    });
    popupMenu.add(cloneActivityMenuItem);
    
    newActivityMenuItem.setComponentPopupMenu(popupMenu);
    newActivityMenuItem.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e) {
            JDialog dialog = new JDialog(MatrixDashboardUI.mdui, "New Activity", true);
            ActivityDialog ad = new ActivityDialog(MatrixDashboardUI.mdui, dialog, a, ActivityDialog.DIALOGTYPE_NEW);
            dialog.getContentPane().add(ad);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    });
    popupMenu.add(newActivityMenuItem);
    
    deleteActivityMenuItem.setComponentPopupMenu(popupMenu);
    deleteActivityMenuItem.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e) {
            JDialog dialog = new JDialog(MatrixDashboardUI.mdui, "Delete Activity", true);
            ActivityDialog ad = new ActivityDialog(MatrixDashboardUI.mdui, dialog, a, ActivityDialog.DIALOGTYPE_DELETE);
            dialog.getContentPane().add(ad);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    });
    popupMenu.add(deleteActivityMenuItem);

    popupMenu.setPreferredSize(new java.awt.Dimension(180, 100));
 }

 
   public void doPopupMenu(java.awt.event.MouseEvent evt) {
    System.out.println("ActivityPanel.doPopupMenu: called");
    JTable source = (JTable)(evt.getSource());
    
    popupMenu.show(source, evt.getX(), evt.getY());
   }
 

  public void updateValue(Activity a) {
    System.out.println("ActivityPanel.updateValue: called, a.id == " + a.id + ", a.name == '" + a.name + "'");
    nameLabel.setText(Objects.toString(a.name, ""));
  }

}
