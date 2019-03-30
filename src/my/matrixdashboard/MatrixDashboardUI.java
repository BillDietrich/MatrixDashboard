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
import javax.swing.table.*;


/**
 *
 * @author user1
 */
public class MatrixDashboardUI extends javax.swing.JFrame {

    static MatrixDashboardUI mdui;
    Database db;
    ArrayList<Project> projects;
    int ncurrentproject;
    ArrayList<AppArea> appareas;    // for current project
    int ncurrentapparea;
    ArrayList<AppFunc> appfuncs;    // for current project+apparea
    int ncurrentappfunc;
    ArrayList<Activity> activities;    // for current project
    ArrayList<Role> roles;             // for current activities
    ArrayList<Client> clients;         // for current activities

    ArrayList<ActivityPanel> activitypanels;    // for current project
    
    /**
     * Creates new form MatrixDashboardUI
     */
    public MatrixDashboardUI() {
        //setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600,300));
        setPreferredSize(new Dimension(1000,600));
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

        jActivityPopupMenu1 = new javax.swing.JPopupMenu();
        jActivityPropertiesMenuItem1 = new javax.swing.JMenuItem();
        jCloneActivityMenuItem2 = new javax.swing.JMenuItem();
        jNewActivityMenuItem3 = new javax.swing.JMenuItem();
        jActivityPanel = new javax.swing.JPanel();
        jAppAreasComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMainTable1 = new javax.swing.JTable();
        jProjectsComboBox1 = new javax.swing.JComboBox<>();

        jActivityPropertiesMenuItem1.setText("Properties");
        jActivityPropertiesMenuItem1.setComponentPopupMenu(jActivityPopupMenu1);

        jCloneActivityMenuItem2.setText("Clone Activity");
        jCloneActivityMenuItem2.setComponentPopupMenu(jActivityPopupMenu1);

        jNewActivityMenuItem3.setText("New Activity");
        jNewActivityMenuItem3.setComponentPopupMenu(jActivityPopupMenu1);

        jActivityPanel.setInheritsPopupMenu(true);
        jActivityPanel.setPreferredSize(new java.awt.Dimension(100, 20));
        jActivityPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jActivityPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jActivityPanelLayout = new javax.swing.GroupLayout(jActivityPanel);
        jActivityPanel.setLayout(jActivityPanelLayout);
        jActivityPanelLayout.setHorizontalGroup(
            jActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jActivityPanelLayout.setVerticalGroup(
            jActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jAppAreasComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AppArea 1", "AppArea 2", "AppArea 3", "AppArea 4" }));
        jAppAreasComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAppAreasComboBox1ActionPerformed(evt);
            }
        });

        jMainTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMainTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jMainTable1.setPreferredSize(new java.awt.Dimension(600, 400));
        jMainTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jMainTable1);
        if (jMainTable1.getColumnModel().getColumnCount() > 0) {
            jMainTable1.getColumnModel().getColumn(0).setResizable(false);
            jMainTable1.getColumnModel().getColumn(1).setResizable(false);
            jMainTable1.getColumnModel().getColumn(2).setResizable(false);
            jMainTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jProjectsComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Project 1", "Project 2", "Project 3", "Project 4" }));
        jProjectsComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProjectsComboBox1ActionPerformed(evt);
            }
        });
        jProjectsComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jProjectsComboBox1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jProjectsComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jAppAreasComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAppAreasComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProjectsComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAppAreasComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAppAreasComboBox1ActionPerformed
        // TODO add your handling code here:
        //System.out.println("jAppAreasComboBox1ActionPerformed: called, evt == " + evt);        
        JComboBox comboBox = (JComboBox) evt.getSource();
        String selected = (String)(comboBox.getSelectedItem());
        System.out.println("jAppAreasComboBox1ActionPerformed: " + selected);

        for (int i=0 ; i<appareas.size() ; i++) {
            if (appareas.get(i).name.equals(selected)) {
                if (i != ncurrentapparea)
                    changeselectedapparea(i);
                return;
            }
        }
        System.out.println("jAppAreasComboBox1ActionPerformed: combobox selected apparea not in list");
    }//GEN-LAST:event_jAppAreasComboBox1ActionPerformed

    private void jProjectsComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jProjectsComboBox1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jProjectsComboBox1PropertyChange

    private void jProjectsComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProjectsComboBox1ActionPerformed

        //System.out.println("jProjectsComboBox1ActionPerformed: called, evt == " + evt);
        JComboBox comboBox = (JComboBox) evt.getSource();
        String selected = (String)(comboBox.getSelectedItem());
        System.out.println("jProjectsComboBox1ActionPerformed: " + selected);

        for (int i=0 ; i<projects.size() ; i++) {
            if (projects.get(i).name.equals(selected)) {
                if (i != ncurrentproject)
                changeselectedproject(i);
                return;
            }
        }
        System.out.println("jProjectsComboBox1ActionPerformed: combobox selected project not in list");
    }//GEN-LAST:event_jProjectsComboBox1ActionPerformed

    private void jActivityPanelMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void createemptydatabase(){
        try{
            Activity.droptable();
        }catch(Exception e) {
        };
        try{
            Role.droptable();
        }catch(Exception e) {
        };
        try{
            Client.droptable();
        }catch(Exception e) {
        };
        try{
            OS.droptable();
        }catch(Exception e) {
        };
        try{
            Browser.droptable();
        }catch(Exception e) {
        };
        try{
            Device.droptable();
        }catch(Exception e) {
        };
        try{
            MDCell.droptable();
        }catch(Exception e) {
        };
        try{
            CellPath.droptable();
        }catch(Exception e) {
        };
        try{
            CellTool.droptable();
        }catch(Exception e) {
        };
        try{
            Tool.droptable();
        }catch(Exception e) {
        };
        try{
            AppFunc.droptable();
        }catch(Exception e) {
        };
        try{
            AppArea.droptable();
        }catch(Exception e) {
        };
        try{
            Project.droptable();
        }catch(Exception e) {
        };

        try{
            Project.createtable();
        }catch(Exception e) {
        };
        try{
            AppArea.createtable();
        }catch(Exception e) {
        };
        try{
            AppFunc.createtable();
        }catch(Exception e) {
        };
        try{
            Device.createtable();
        }catch(Exception e) {
        };
        try{
            Browser.createtable();
        }catch(Exception e) {
        };
        try{
            OS.createtable();
        }catch(Exception e) {
        };
        try{
            Client.createtable();
        }catch(Exception e) {
        };
        try{
            Role.createtable();
        }catch(Exception e) {
        };
        try{
            Activity.createtable();
        }catch(Exception e) {
        };
        try{
            Tool.createtable();
        }catch(Exception e) {
        };
        try{
            MDCell.createtable();
        }catch(Exception e) {
        };
        try{
            CellTool.createtable();
        }catch(Exception e) {
        };
        try{
            CellPath.createtable();
        }catch(Exception e) {
        };
    }                                                 

    private void createinitproject(){
        
        Project pInit = new Project(1,"Init");
        try{
            pInit.writetodatabase();
        }catch(Exception e) {
        };
        int nextid = 2;
        for ( ; nextid<4 ; nextid++) {
            Project p = new Project(nextid,"proj"+nextid);
            p.writetodatabase();
        }

        try{
            this.projects = Project.getallprojects();
        }catch(Exception e) {
        };
        ncurrentproject = 0;
       
        int nextaaid = 1;
        for (Project project : projects) {
            AppArea aaStandard = new AppArea(nextaaid++, project.id, "Standard" + project.id);
            try{
                aaStandard.writetodatabase();
            }catch(Exception e) {
            };
            AppArea aaCustom1 = new AppArea(nextaaid++, project.id, "Custom" + project.id);
            try{
                aaCustom1.writetodatabase();
            }catch(Exception e) {
            };
        }

        try{
            this.appareas = AppArea.getallappareas(this.projects.get(ncurrentproject).id);
        }catch(Exception e) {
        };
        ncurrentapparea = 0;
       
        int nextafid = 1;
        for (Project project : projects) {
            ArrayList<AppArea> appareas = new ArrayList<AppArea>();    // for project
            AppFunc af;
            try{
                appareas = AppArea.getallappareas(project.id);
            }catch(Exception e) {
            };
            for (AppArea apparea : appareas) {
                af = new AppFunc(nextafid++, project.id, apparea.id, "Login" + project.id + apparea.id);
                try{
                    af.writetodatabase();
                }catch(Exception e) {
                };
                af = new AppFunc(nextafid++, project.id, apparea.id, "Logout" + project.id + apparea.id);
                try{
                    af.writetodatabase();
                }catch(Exception e) {
                };
                af = new AppFunc(nextafid++, project.id, apparea.id, "PW Change" + project.id + apparea.id);
                try{
                    af.writetodatabase();
                }catch(Exception e) {
                };
                af = new AppFunc(nextafid++, project.id, apparea.id, "PW Reset" + project.id + apparea.id);
                try{
                    af.writetodatabase();
                }catch(Exception e) {
                };
            }
        }

        int nextrid = Database.NONEID;
        Role r = null;
        r = new Role(nextrid++, Database.NONENAME, Database.NONEABBREV);
        try{
            r.writetodatabase();
        }catch(Exception e) {
        };
        r = new Role(nextrid++, "User", "U");
        try{
            r.writetodatabase();
        }catch(Exception e) {
        };
        r = new Role(nextrid++, "Admin", "A");
        try{
            r.writetodatabase();
        }catch(Exception e) {
        };

        int nextdid = Database.NONEID;
        Device d = null;
        d = new Device(nextdid++, Database.NONENAME);
        try{
            d.writetodatabase();
        }catch(Exception e) {
        };
        d = new Device(nextdid++, "PC");
        try{
            d.writetodatabase();
        }catch(Exception e) {
        };
        d = new Device(nextdid++, "Smartphone");
        try{
            d.writetodatabase();
        }catch(Exception e) {
        };

        int nextbid = Database.NONEID;
        Browser b = null;
        b = new Browser(nextbid++, Database.NONENAME);
        try{
            b.writetodatabase();
        }catch(Exception e) {
        };
        b = new Browser(nextbid++, "Firefox");
        try{
            b.writetodatabase();
        }catch(Exception e) {
        };
        b = new Browser(nextbid++, "Chrome");
        try{
            b.writetodatabase();
        }catch(Exception e) {
        };

        int nextoid = Database.NONEID;
        OS o = null;
        o = new OS(nextoid++, Database.NONENAME);
        try{
            o.writetodatabase();
        }catch(Exception e) {
        };
        o = new OS(nextoid++, "Linux");
        try{
            o.writetodatabase();
        }catch(Exception e) {
        };
        o = new OS(nextoid++, "Windows");
        try{
            o.writetodatabase();
        }catch(Exception e) {
        };

        int nextcid = Database.NONEID;
        Client c = null;
        c = new Client(nextcid++, Database.NONENAME, 1, 1, 1);
        try{
            c.writetodatabase();
        }catch(Exception e) {
        };
        c = new Client(nextcid++, "PFL", 2, 2, 2);
        try{
            c.writetodatabase();
        }catch(Exception e) {
        };
        c = new Client(nextcid++, "SCW", 3, 3, 3);
        try{
            c.writetodatabase();
        }catch(Exception e) {
        };
       
        int nextaid = 1;
        for (Project project : projects) {
            Activity a = null;
            for (int i=0 ; i<3 ; i++) {
                a = new Activity(nextaid++, project.id, ("Activity" + project.id + "-" + nextaid), (i%3)+1, (i%3)+1);
                try{
                    a.writetodatabase();
                }catch(Exception e) {
                };
            }
        }

        /*
        try{
            this.activities = Activity.getallactivities(this.projects.get(ncurrentproject).id);
        }catch(Exception e) {
        };
        */

        Tool t = null;
        int nexttid = 1;
        t = new Tool(nexttid++, "Burp", Database.PATHTYPE_EXECUTABLE, "some1pathhere");
        try{
            t.writetodatabase();
        }catch(Exception e) {
        };
        t = new Tool(nexttid++, "ZAP", Database.PATHTYPE_EXECUTABLE, "some2pathhere");
        try{
            t.writetodatabase();
        }catch(Exception e) {
        };

        MDCell cell = null;
        int nextcellid = 1;
        // make an orphan cell just for testing
        cell = new MDCell(nextcellid++, 1, 1, 1);
        try{
            cell.writetodatabase();
        }catch(Exception e) {
        };

        CellTool ct = null;
        int nextctid = 1;
        ct = new CellTool(nextctid++, 1, 1);
        try{
            ct.writetodatabase();
        }catch(Exception e) {
        };

        CellPath cp = null;
        int nextcpid = 1;
        cp = new CellPath(nextcpid++, 1, Database.CELLPATHTYPE_APPPAGE, "Login page", Database.PATHTYPE_OSOPEN, "some3path");
        try{
            cp.writetodatabase();
        }catch(Exception e) {
        };
        cp = new CellPath(nextcpid++, 1, Database.CELLPATHTYPE_DOC, "User manual", Database.PATHTYPE_OSOPEN, "some4path");
        try{
            cp.writetodatabase();
        }catch(Exception e) {
        };
    }                         
    
    private void changeselectedproject(int nnewproject) {
        ncurrentproject = nnewproject;
        try{
            this.appareas = AppArea.getallappareas(this.projects.get(ncurrentproject).id);
        }catch(Exception e) {
        };
        setappareascomboboxcontents();
        
        try{
            this.activities = Activity.getallactivities(this.projects.get(ncurrentproject).id);
        }catch(Exception e) {
        }

        this.roles = new ArrayList<Role>();
        this.clients = new ArrayList<Client>();
        for (int i = 0 ; i<this.activities.size() ; i++) {
            Activity activity = this.activities.get(i);
            try{
                Role r = new Role(activity.roleid);
                r.readfromdatabase();
                this.roles.add(r);
            }catch(Exception e) {
                System.out.println("changeselectedproject: role error " + e);
            };
            try{
                Client c = new Client(activity.clientid);
                c.readfromdatabase();
                this.clients.add(c);
            }catch(Exception e) {
                System.out.println("changeselectedproject: client error " + e);
            };
        }
        
        changeselectedapparea(0);   // this will redraw main table at end
    }                                
    
    private void changeselectedapparea(int nnewapparea) {
        ncurrentapparea = nnewapparea;
        try{
            this.appfuncs = AppFunc.getallappfuncs(this.projects.get(ncurrentproject).id, this.appareas.get(ncurrentapparea).id);
        }catch(Exception e) {
        };
        setmaintable();
    }                          
    
    private void setprojectscomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(Project project : this.projects)
            names[i++] = project.name;
        jProjectsComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }                                
    
    private void setappareascomboboxcontents() {
        String[] names = new String[40];
        int i = 0;
        for(AppArea apparea : this.appareas)
            names[i++] = apparea.name;
        jAppAreasComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }               
    
    private void setmaintable() {
        System.out.println("setmaintable: called");

        // tricky:  column 0 is Activity name
        //          column 1 is Role name
        //          column 2 is Client name
        int nrows = this.activities.size();
        int ncolumns = this.appfuncs.size()+3;
        System.out.println("setmaintable: nrows == " + nrows + ", ncolumns == " + ncolumns);
        System.out.println("setmaintable: this.roles.size() == " + this.roles.size() + ", this.clients.size() == " + this.clients.size());
        
        Object [][] contents = new Object [nrows][ncolumns];
        String [] columnheaders = new String [ncolumns];
        this.activitypanels = new ArrayList<ActivityPanel>();
                
        columnheaders[0] = new String("");
        columnheaders[1] = new String("R");
        columnheaders[2] = new String("Client");
        for (int c=3 ; c<ncolumns ; c++)
            columnheaders[c] = new String(this.appfuncs.get(c-3).name);
        
        for (int r=0 ; r<nrows ; r++) {
            ActivityPanel ap = new ActivityPanel(this.activities.get(r), this.roles.get(r), this.clients.get(r));
            contents[r][0] = ap;
            this.activitypanels.add(ap);
            String abbrev = this.roles.get(r).abbrev;
            if (abbrev.equals(Database.NONEABBREV))
                abbrev = "";
            contents[r][1] = new String(abbrev);
            String cname = this.clients.get(r).name;
            if (cname.equals(Database.NONENAME))
                cname = "";
            contents[r][2] = new String(cname);
        }
        for (int r=0 ; r<nrows ; r++)
            for (int c=3 ; c<ncolumns ; c++)
                contents[r][c] = new String("cell" + r + c);
        
        jMainTable1.setModel(
          new javax.swing.table.DefaultTableModel(
            contents,
            columnheaders) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                   if (columnIndex == 0)
                       return ActivityPanel.class;
                   else if (columnIndex > 2)
                       return MDCell.class;
                   else
                       // role and client columns
                       return String.class;
                }
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
                public boolean isCellSelectable(int rowIndex, int columnIndex) {
                    return false;
                }
            }
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 530));
        jMainTable1.setPreferredSize(new java.awt.Dimension(800, 500));
        jMainTable1.getColumnModel().getColumn(0).setMinWidth(100);
        jMainTable1.getColumnModel().getColumn(1).setMinWidth(20);
        jMainTable1.getColumnModel().getColumn(2).setMinWidth(45);
        jMainTable1.getColumnModel().getColumn(1).setMaxWidth(20);
        jMainTable1.getColumnModel().getColumn(2).setMaxWidth(45);
        jMainTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jMainTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
        jMainTable1.getColumnModel().getColumn(2).setPreferredWidth(45);
        
        TableCellRenderer r = new MyTableCellRenderer();
        jMainTable1.setDefaultRenderer(Object.class, r);
        
        jMainTable1.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               
              System.out.println("setmaintable.mouseClicked: called, evt " + evt);
              
              Component table = evt.getComponent();
              System.out.println("setmaintable.mouseClicked: component " + table);
              
              JTable source = (JTable)(evt.getSource());
              int r = source.rowAtPoint(new Point (evt.getX(), evt.getY()));
              int c = source.columnAtPoint(new Point (evt.getX(), evt.getY()));
              System.out.println("setmaintable.mouseClicked: r,c == " + r + "," + c);
              
              if ((r >= 0) && (r < activities.size())) {
                Object o = jMainTable1.getModel().getValueAt(r,c);

                if (c == 0) {
                    // clicked on an Activity
                  ((ActivityPanel)o).doPopupMenu(evt);
                } else {
                    super.mouseClicked(evt);
                }
              } else {
                    super.mouseClicked(evt);                  
              }
           }
        });
        
    
    }
    
    private void start(){
        
        try{
            db = new Database();
        }catch(Exception e) {
        };
        
        try{
            db.open();
        }catch(Exception e) {
        };

/*        
        try{
            createemptydatabase();
        }catch(Exception e) {
        };
        try{
            createinitproject();
        }catch(Exception e) {
        };
*/

        try{
            this.projects = Project.getallprojects();
        }catch(Exception e) {
        };
        setprojectscomboboxcontents();
        changeselectedproject(0);
    }

    private void stop(){
        
        try{
           db.close();
        }catch(Exception e) {
        };
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatrixDashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrixDashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrixDashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrixDashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdui = new MatrixDashboardUI();
                mdui.start();
                mdui.setVisible(true);
            }
        });
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                mdui.stop();
            }
        }));
        
    }

    /*
    class Cell{
        String text;
    }
    */

    class MyTableCellRenderer implements TableCellRenderer{
        // cellLabel will be used to render each cell. Note that
        // this component is re-used for painting each cell, we
        // don't have separate instances for all cells.
        private JLabel cellLabel=new JLabel();

        @Override
        public Component getTableCellRendererComponent(
                                                        JTable table,
                                                        Object value,
                                                        boolean isSelected,
                                                        boolean hasFocus,
                                                        int row,
                                                        int column) {
            
            //if (row == 0)
            //    System.out.println("getTableCellRendererComponent: called, value.class == " + value.getClass() + ", value == '" + value + "', isSelected " + isSelected + ", hasFocus " + hasFocus + ", r,c == " + row + "," + column);

            Class c = table.getColumnClass(column);
            if (c.equals(String.class)) {
                cellLabel.setText((String)value);
                return cellLabel;                
            } else if (c.equals(ActivityPanel.class)) {
                //System.out.println("getTableCellRendererComponent: class is ActivityPanel, nameLabel == " + ((ActivityPanel)value).nameLabel);
                //System.out.println("getTableCellRendererComponent: nameLabel.getText() == " + ((ActivityPanel)value).nameLabel.getText());
                return activitypanels.get(row);
            } else if (c.equals(MDCell.class)) {
                cellLabel.setText((String)value);
                return cellLabel;                
            } else {
                System.out.println("getTableCellRendererComponent: unknown class c '" + c + "'"); 
                return null;
            }
        }    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jActivityPanel;
    private javax.swing.JPopupMenu jActivityPopupMenu1;
    private javax.swing.JMenuItem jActivityPropertiesMenuItem1;
    private javax.swing.JComboBox<String> jAppAreasComboBox1;
    private javax.swing.JMenuItem jCloneActivityMenuItem2;
    private javax.swing.JTable jMainTable1;
    private javax.swing.JMenuItem jNewActivityMenuItem3;
    private javax.swing.JComboBox<String> jProjectsComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
