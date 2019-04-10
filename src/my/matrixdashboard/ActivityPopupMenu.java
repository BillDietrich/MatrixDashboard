/* 
 * Copyright <2019> <Bill Dietrich>
 * 
 * Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby granted, provided that the above copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package my.matrixdashboard;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActivityPopupMenu {

  final JPopupMenu popupMenu = new javax.swing.JPopupMenu();
  final JMenuItem propertiesMenuItem = new javax.swing.JMenuItem("Properties of this Activity");
  final JMenuItem cloneActivityMenuItem = new javax.swing.JMenuItem("Clone this Activity");
  final JMenuItem newActivityMenuItem = new javax.swing.JMenuItem("Add new Activity");
  final JMenuItem deleteActivityMenuItem = new javax.swing.JMenuItem("Delete this Activity");
  
  Activity a = null;
  
  public ActivityPopupMenu(Activity a, Role r, Client c) {
    
    this.a = a;

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
    System.out.println("ActivityPopupMenu.doPopupMenu: called");
    JTable source = (JTable)(evt.getSource());
    
    popupMenu.show(source, evt.getX(), evt.getY());
   }

}
