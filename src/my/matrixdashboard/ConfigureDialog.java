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


public class ConfigureDialog extends javax.swing.JPanel {

    JFrame f = null;
    JDialog d = null;

    ArrayList<Project> projects;
    int ncurrentproject;
    ArrayList<AppArea> appareas;    // for current project
    int ncurrentapparea;
    ArrayList<AppFunc> appfuncs;    // for current project+apparea
    int ncurrentappfunc;
    ArrayList<Activity> activities;    // for current project

    ArrayList<Tool> tools;

    ArrayList<Client> clients;

    ArrayList<Role> roles;
    ArrayList<Device> devices;
    ArrayList<Browser> browsers;
    ArrayList<OS> oss;
    
    char cButtonSelected = ' ';
    

    /**
     * Creates new form ConfigureDialog
     */
    public ConfigureDialog(JFrame f, JDialog d) {
        System.out.println("ConfigureDialog.constructor: called");
        this.f = f;
        this.d = d;
        
        initComponents();
        //f.setTitle("Configure");
        buttonGroup1.add(jProjectsRadioButton);
        buttonGroup1.add(jAppAreasRadioButton);
        buttonGroup1.add(jAppFuncsRadioButton);
        buttonGroup1.add(jActivitiesRadioButton);
        buttonGroup1.add(jToolsRadioButton);
        buttonGroup1.add(jClientsRadioButton);
        buttonGroup1.add(jRolesRadioButton);
        buttonGroup1.add(jBrowsersRadioButton);
        buttonGroup1.add(jDevicesRadioButton);
        buttonGroup1.add(jOSsRadioButton);

        try{
            this.projects = Project.getallprojects();
        }catch(Exception e) {
        };
        ncurrentproject = 0;
 
        try{
            this.appareas = AppArea.getallappareas(this.projects.get(ncurrentproject).id);
        }catch(Exception e) {
        };
        ncurrentapparea = 0;
        
        try{
            this.appfuncs = AppFunc.getallappfuncs(this.projects.get(ncurrentproject).id, this.appareas.get(ncurrentapparea).id);
        }catch(Exception e) {
        };

        setprojectscomboboxcontents();
        setappareascomboboxcontents();
        setappfuncscomboboxcontents();
        
        jProjectsRadioButton.setSelected(true);
        String selected = (String)(jProjectsComboBox.getSelectedItem());
        setButtonTexts("Project", selected);
    }
    
    
    private void setprojectscomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(Project project : this.projects)
            names[i++] = project.name;
        jProjectsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }                                
    
    private void setappareascomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(AppArea apparea : this.appareas)
            names[i++] = apparea.name;
        jAppAreasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setappfuncscomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(AppFunc appfunc : this.appfuncs)
            names[i++] = appfunc.name;
        jAppAreasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setactivitiesscomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(Activity activity : this.activities)
            names[i++] = activity.name;
        jActivitiesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void settoolscomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(Tool tool : this.tools)
            names[i++] = tool.name;
        jToolsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setclientscomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(Client client : this.clients)
            names[i++] = client.name;
        jClientsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setrolescomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(Role role : this.roles)
            names[i++] = role.name;
        jRolesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setdevicescomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(Device device : this.devices)
            names[i++] = device.name;
        jDevicesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setbrowserscomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(Browser browser : this.browsers)
            names[i++] = browser.name;
        jBrowsersComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setosscomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(OS os : this.oss)
            names[i++] = os.name;
        jOSsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
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
        jProjectsComboBox = new javax.swing.JComboBox<>();
        jDeleteButton = new javax.swing.JButton();
        jNewButton = new javax.swing.JButton();
        jEditButton = new javax.swing.JButton();
        jProjectsRadioButton = new javax.swing.JRadioButton();
        jCloneButton = new javax.swing.JButton();
        jAppAreasRadioButton = new javax.swing.JRadioButton();
        jAppAreasComboBox = new javax.swing.JComboBox<>();
        jAppFuncsRadioButton = new javax.swing.JRadioButton();
        jAppFuncsComboBox = new javax.swing.JComboBox<>();
        jActivitiesRadioButton = new javax.swing.JRadioButton();
        jActivitiesComboBox = new javax.swing.JComboBox<>();
        jToolsRadioButton = new javax.swing.JRadioButton();
        jToolsComboBox = new javax.swing.JComboBox<>();
        jRolesComboBox = new javax.swing.JComboBox<>();
        jRolesRadioButton = new javax.swing.JRadioButton();
        jBrowsersComboBox = new javax.swing.JComboBox<>();
        jBrowsersRadioButton = new javax.swing.JRadioButton();
        jDevicesComboBox = new javax.swing.JComboBox<>();
        jDevicesRadioButton = new javax.swing.JRadioButton();
        jOSsComboBox = new javax.swing.JComboBox<>();
        jOSsRadioButton = new javax.swing.JRadioButton();
        jClientsRadioButton = new javax.swing.JRadioButton();
        jClientsComboBox = new javax.swing.JComboBox<>();
        jCellFormatButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(438, 500));
        setPreferredSize(new java.awt.Dimension(438, 500));

        jProjectsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jProjectsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProjectsComboBoxActionPerformed(evt);
            }
        });

        jDeleteButton.setBackground(new java.awt.Color(247, 4, 4));
        jDeleteButton.setText("Delete");
        jDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteButtonActionPerformed(evt);
            }
        });

        jNewButton.setText("New");
        jNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewButtonActionPerformed(evt);
            }
        });

        jEditButton.setText("Edit");
        jEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditButtonActionPerformed(evt);
            }
        });

        jProjectsRadioButton.setText("Projects");
        jProjectsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProjectsRadioButtonActionPerformed(evt);
            }
        });

        jCloneButton.setText("Clone");
        jCloneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCloneButtonActionPerformed(evt);
            }
        });

        jAppAreasRadioButton.setText("AppAreas");
        jAppAreasRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAppAreasRadioButtonActionPerformed(evt);
            }
        });

        jAppAreasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jAppAreasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAppAreasComboBoxActionPerformed(evt);
            }
        });

        jAppFuncsRadioButton.setText("AppFuncs");
        jAppFuncsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAppFuncsRadioButtonActionPerformed(evt);
            }
        });

        jAppFuncsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jAppFuncsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAppFuncsComboBoxActionPerformed(evt);
            }
        });

        jActivitiesRadioButton.setText("Activities");
        jActivitiesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActivitiesRadioButtonActionPerformed(evt);
            }
        });

        jActivitiesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jActivitiesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActivitiesComboBoxActionPerformed(evt);
            }
        });

        jToolsRadioButton.setText("Tools");
        jToolsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToolsRadioButtonActionPerformed(evt);
            }
        });

        jToolsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jToolsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToolsComboBoxActionPerformed(evt);
            }
        });

        jRolesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jRolesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRolesComboBoxActionPerformed(evt);
            }
        });

        jRolesRadioButton.setText("Roles");
        jRolesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRolesRadioButtonActionPerformed(evt);
            }
        });

        jBrowsersComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jBrowsersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowsersComboBoxActionPerformed(evt);
            }
        });

        jBrowsersRadioButton.setText("Browsers");
        jBrowsersRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowsersRadioButtonActionPerformed(evt);
            }
        });

        jDevicesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDevicesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDevicesComboBoxActionPerformed(evt);
            }
        });

        jDevicesRadioButton.setText("Devices");
        jDevicesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDevicesRadioButtonActionPerformed(evt);
            }
        });

        jOSsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jOSsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOSsComboBoxActionPerformed(evt);
            }
        });

        jOSsRadioButton.setText("Operating Systems");
        jOSsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOSsRadioButtonActionPerformed(evt);
            }
        });

        jClientsRadioButton.setText("Clients");
        jClientsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientsRadioButtonActionPerformed(evt);
            }
        });

        jClientsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jClientsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientsComboBoxActionPerformed(evt);
            }
        });

        jCellFormatButton.setText("Configure Cell Format");
        jCellFormatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCellFormatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProjectsRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProjectsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jClientsRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jClientsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCellFormatButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jActivitiesRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jActivitiesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jAppAreasRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jAppAreasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolsRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToolsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRolesRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRolesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBrowsersRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBrowsersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDevicesRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDevicesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jOSsRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jOSsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jAppFuncsRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jAppFuncsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDeleteButton)
                            .addComponent(jCloneButton)
                            .addComponent(jNewButton)
                            .addComponent(jEditButton))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProjectsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProjectsRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jNewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCloneButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEditButton)
                        .addGap(116, 116, 116)
                        .addComponent(jDeleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAppAreasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAppAreasRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAppFuncsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAppFuncsRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jActivitiesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jActivitiesRadioButton))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToolsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToolsRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jClientsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jClientsRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRolesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRolesRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBrowsersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBrowsersRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jDevicesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDevicesRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jOSsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jOSsRadioButton))
                        .addGap(18, 18, 18)
                        .addComponent(jCellFormatButton)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    

    private void jProjectsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProjectsComboBoxActionPerformed
        JComboBox comboBox = (JComboBox) evt.getSource();
        String selected = (String)(comboBox.getSelectedItem());
        System.out.println("jProjectsComboBoxActionPerformed: " + selected);

        int index = comboBox.getSelectedIndex();
    }//GEN-LAST:event_jProjectsComboBoxActionPerformed

    private void setButtonTexts(String sType, String sCurrentName) {
        System.out.println("setButtonTexts: called, sType '" + sType + "', sCurrentName '" + sCurrentName + "'");
                
        jNewButton.setText("New " + sType);
        if (sCurrentName.length() == 0) {
            jCloneButton.setText("Clone " + sType);
            jEditButton.setText("Edit " + sType);
            jDeleteButton.setText("Delete " + sType);
            jCloneButton.setEnabled(false);
            jEditButton.setEnabled(false);
            jDeleteButton.setEnabled(false);
        } else {            
            jCloneButton.setText("Clone " + sType + " '" + sCurrentName + "'");
            jEditButton.setText("Edit " + sType + " '" + sCurrentName + "'");
            jDeleteButton.setText("Delete " + sType + " '" + sCurrentName + "'");
            jCloneButton.setEnabled(true);
            jEditButton.setEnabled(true);
            jDeleteButton.setEnabled(true);
        }
    }
    

    private void jDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteButtonActionPerformed
        System.out.println("jDeleteButtonActionPerformed: called");
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(f, "A basic JOptionPane message dialog");
    }//GEN-LAST:event_jDeleteButtonActionPerformed

    private void jNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewButtonActionPerformed
        System.out.println("jNewButtonActionPerformed: called");
        // TODO add your handling code here:
    }//GEN-LAST:event_jNewButtonActionPerformed

    private void jEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditButtonActionPerformed
        System.out.println("jEditButtonActionPerformed: called");
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jEditButtonActionPerformed

    private void jCloneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCloneButtonActionPerformed
        System.out.println("jCloneButtonActionPerformed: called");
        // TODO add your handling code here:
    }//GEN-LAST:event_jCloneButtonActionPerformed

    private void jAppAreasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAppAreasComboBoxActionPerformed
        System.out.println("jAppAreasComboBoxActionPerformed: called");
        if (jAppAreasRadioButton.isSelected()) {
            String selected = (String)(jAppAreasComboBox.getSelectedItem());
            setButtonTexts("AppArea", selected);
        }
    }//GEN-LAST:event_jAppAreasComboBoxActionPerformed

    private void jAppFuncsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAppFuncsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAppFuncsComboBoxActionPerformed

    private void jActivitiesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActivitiesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jActivitiesComboBoxActionPerformed

    private void jToolsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToolsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToolsComboBoxActionPerformed

    private void jRolesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRolesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRolesComboBoxActionPerformed

    private void jBrowsersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowsersComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBrowsersComboBoxActionPerformed

    private void jDevicesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDevicesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDevicesComboBoxActionPerformed

    private void jDevicesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDevicesRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDevicesRadioButtonActionPerformed

    private void jOSsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOSsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jOSsComboBoxActionPerformed

    private void jOSsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOSsRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jOSsRadioButtonActionPerformed

    private void jClientsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClientsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jClientsComboBoxActionPerformed

    private void jProjectsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProjectsRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jProjectsRadioButtonActionPerformed

    private void jAppAreasRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAppAreasRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAppAreasRadioButtonActionPerformed

    private void jAppFuncsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAppFuncsRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAppFuncsRadioButtonActionPerformed

    private void jActivitiesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActivitiesRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jActivitiesRadioButtonActionPerformed

    private void jToolsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToolsRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToolsRadioButtonActionPerformed

    private void jClientsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClientsRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jClientsRadioButtonActionPerformed

    private void jRolesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRolesRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRolesRadioButtonActionPerformed

    private void jBrowsersRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowsersRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBrowsersRadioButtonActionPerformed

    private void jCellFormatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCellFormatButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCellFormatButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jActivitiesComboBox;
    private javax.swing.JRadioButton jActivitiesRadioButton;
    private javax.swing.JComboBox<String> jAppAreasComboBox;
    private javax.swing.JRadioButton jAppAreasRadioButton;
    private javax.swing.JComboBox<String> jAppFuncsComboBox;
    private javax.swing.JRadioButton jAppFuncsRadioButton;
    private javax.swing.JComboBox<String> jBrowsersComboBox;
    private javax.swing.JRadioButton jBrowsersRadioButton;
    private javax.swing.JButton jCellFormatButton;
    private javax.swing.JComboBox<String> jClientsComboBox;
    private javax.swing.JRadioButton jClientsRadioButton;
    private javax.swing.JButton jCloneButton;
    private javax.swing.JButton jDeleteButton;
    private javax.swing.JComboBox<String> jDevicesComboBox;
    private javax.swing.JRadioButton jDevicesRadioButton;
    private javax.swing.JButton jEditButton;
    private javax.swing.JButton jNewButton;
    private javax.swing.JComboBox<String> jOSsComboBox;
    private javax.swing.JRadioButton jOSsRadioButton;
    private javax.swing.JComboBox<String> jProjectsComboBox;
    private javax.swing.JRadioButton jProjectsRadioButton;
    private javax.swing.JComboBox<String> jRolesComboBox;
    private javax.swing.JRadioButton jRolesRadioButton;
    private javax.swing.JComboBox<String> jToolsComboBox;
    private javax.swing.JRadioButton jToolsRadioButton;
    // End of variables declaration//GEN-END:variables
}
