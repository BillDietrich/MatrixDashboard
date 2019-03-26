/*
 * To change this license header, choose License Headers in AppFunc Properties.
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
public class AppFunc {
    
   int id;
   int projectid;
   int appareaid;
   String name;

   // constructors
   public AppFunc(int id, int projectid, int appareaid, String name) {
       this.id = id;
       this.projectid = projectid;
       this.appareaid = appareaid;
       this.name = name;
   }
   public AppFunc(int id, int projectid, int appareaid) {
       this.id = id;
       this.projectid = projectid;
       this.appareaid = appareaid;
       this.name = null;
   }
   
   public static void createtable() {
    System.out.println("AppFunc.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE appfuncs " +
                   "(id INTEGER not NULL, " +
                   " projectid INTEGER not NULL, " +
                   " appareaid INTEGER not NULL, " +
                   " name TEXT, " + 
                   " PRIMARY KEY ( id ), " +
                   " FOREIGN KEY(projectid) REFERENCES projects(id), " +
                   " FOREIGN KEY(appareaid) REFERENCES appareas(id))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("AppFunc.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("AppFunc.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("AppFunc.droptable: called"); 
    Database.droptable("appfuncs");
   }
   
   public static ArrayList<AppFunc> getallappfuncs(int projectid, int appareaid) {
    System.out.println("AppFunc.getallappfuncs: called, projectid == " + projectid + ", appareaid == " + appareaid); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM appfuncs WHERE projectid=" + projectid + " AND appareaid=" + appareaid;
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         AppFunc p = new AppFunc(id, projectid, appareaid, name);
         thelist.add(p);
        System.out.println("AppFunc.getallappfuncs: got id == " + id + ", name '" + name + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("AppFunc.getallappfuncs: error: " + e.getMessage());        
    }finally{
       System.out.println("AppFunc.getallappfuncs: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("AppFunc.writetodatabase: called, id == " + id + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO appfuncs VALUES(" + id + "," + projectid + "," + appareaid + ",'" + name + "')";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("AppFunc.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("AppFunc.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("AppFunc.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM appfuncs WHERE id=" + id + " AND projectid=" + projectid + " AND appareaid=" + appareaid;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.projectid = rs.getInt("projectid");
         this.appareaid = rs.getInt("appareaid");
         this.name = rs.getString("name");
        System.out.println("AppFunc.readfromdatabase: got id == " + this.id + ", projectid == " + this.projectid + ", appareaid == " + this.appareaid + ", name '" + this.name + "'");
      } else
       System.out.println("AppFunc.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("AppFunc.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("AppFunc.readfromdatabase: finished");        
    }
   }

}
