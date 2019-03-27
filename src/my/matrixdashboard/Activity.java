/*
 * To change this license header, choose License Headers in Activity Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.matrixdashboard;

import java.sql.*;
import java.util.*;


/**
 *
 * @author user1
 */
public class Activity {
    
   int id;
   int projectid;
   String name;
   int roleid;
   int clientid;

   // constructors
   public Activity(int id, int projectid, String name, int roleid, int clientid) {
       this.id = id;
       this.projectid = projectid;
       this.name = name;
       this.roleid = roleid;
       this.clientid = clientid;
   }
   public Activity(int id, int projectid) {
       this.id = id;
       this.projectid = projectid;
       this.name = null;
       this.roleid = 0;
       this.clientid = 0;
   }
   
   public static void createtable() {
    System.out.println("Activity.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE activities " +
                   "(id INTEGER not NULL, " +
                   " projectid INTEGER not NULL, " +
                   " name TEXT, " + 
                   " roleid INTEGER not NULL, " +
                   " clientid INTEGER not NULL, " +
                   " PRIMARY KEY ( id ), " +
                   " FOREIGN KEY(projectid) REFERENCES projects(id)," +
                   " FOREIGN KEY(roleid) REFERENCES roles(id)," +
                   " FOREIGN KEY(clientid) REFERENCES clients(id)" +
                   ")";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Activity.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("Activity.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("Activity.droptable: called"); 
    Database.droptable("activities");
   }
   
   public static ArrayList<Activity> getallactivities(int projectid) {
    System.out.println("Activity.getallactivities: called, projectid == " + projectid); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM activities WHERE projectid=" + projectid;
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         int roleid = rs.getInt("roleid");
         int clientid = rs.getInt("clientid");
         Activity a = new Activity(id,projectid,name,roleid,clientid);
         thelist.add(a);
        System.out.println("Activity.getallactivities: got id == " + id + ", name '" + name + "', roleid == " + roleid + ", clientid == " + clientid);
      }
      rs.close();
    }catch(Exception e){
       System.out.println("Activity.getallactivities: error: " + e.getMessage());        
    }finally{
       System.out.println("Activity.getallactivities: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("Activity.writetodatabase: called, id == " + id + ", projectid == " + projectid + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO activities VALUES(" + id + "," + projectid + ",'" + name + "'," + roleid + "," + clientid + ")";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Activity.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Activity.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("Activity.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM activities WHERE id=" + id + " AND projectid=" + projectid;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.projectid = rs.getInt("projectid");
         this.name = rs.getString("name");
         this.roleid = rs.getInt("roleid");
         this.clientid = rs.getInt("clientid");
        System.out.println("Activity.readfromdatabase: got id == " + this.id + ", name '" + this.name + "'");
      } else
       System.out.println("Activity.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("Activity.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Activity.readfromdatabase: finished");        
    }
   }

}
