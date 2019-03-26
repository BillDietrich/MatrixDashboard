/*
 * To change this license header, choose License Headers in AppArea Properties.
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
public class AppArea {
    
   int id;
   int projectid;
   String name;

   // constructors
   public AppArea(int id, int projectid, String name) {
       this.id = id;
       this.projectid = projectid;
       this.name = name;
   }
   public AppArea(int id, int projectid) {
       this.id = id;
       this.projectid = projectid;
       this.name = null;
   }
   
   public static void createtable() {
    System.out.println("AppArea.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE appareas " +
                   "(id INTEGER not NULL, " +
                   " projectid INTEGER not NULL, " +
                   " name TEXT, " + 
                   " PRIMARY KEY ( id ), " +
                   " FOREIGN KEY(projectid) REFERENCES projects(id))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("AppArea.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("AppArea.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("AppArea.droptable: called"); 
    Database.droptable("appareas");
   }
   
   public static ArrayList<AppArea> getallappareas(int projectid) {
    System.out.println("AppArea.getallappareas: called, projectid == " + projectid); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM appareas WHERE projectid=" + projectid;
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         AppArea p = new AppArea(id,projectid,name);
         thelist.add(p);
        System.out.println("AppArea.getallappareas: got id == " + id + ", name '" + name + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("AppArea.getallappareas: error: " + e.getMessage());        
    }finally{
       System.out.println("AppArea.getallappareas: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("AppArea.writetodatabase: called, id == " + id + ", projectid == " + projectid + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO appareas VALUES(" + id + "," + projectid + ",'" + name + "')";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("AppArea.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("AppArea.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("AppArea.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM appareas WHERE id=" + id + " AND projectid=" + projectid;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.projectid = rs.getInt("projectid");
         this.name = rs.getString("name");
        System.out.println("AppArea.readfromdatabase: got id == " + this.id + ", name '" + this.name + "'");
      } else
       System.out.println("AppArea.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("AppArea.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("AppArea.readfromdatabase: finished");        
    }
   }

}
