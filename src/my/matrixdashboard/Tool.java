/*
 * To change this license header, choose License Headers in Tool Properties.
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
public class Tool {
    
   int id;
   String name;
   String pathtype;
   String path;

   // constructors
   public Tool(int id, String name, String pathtype, String path) {
       this.id = id;
       this.name = name;
       this.pathtype = pathtype;
       this.path = path;
   }
   public Tool(int id) {
       this.id = id;
       this.name = null;
       this.pathtype = null;
       this.path = null;
   }
   
   public static void createtable() {
    System.out.println("Tool.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE tools " +
                   "(id INTEGER not NULL, " +
                   " name TEXT UNIQUE, " + 
                   " pathtype TEXT, " + 
                   " path TEXT, " + 
                   " PRIMARY KEY ( id ))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Tool.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("Tool.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("Tool.droptable: called"); 
    Database.droptable("tools");
   }
   
   public static ArrayList<Tool> getalltools() {
    System.out.println("Tool.getalltools: called"); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM tools";
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         String pathtype = rs.getString("pathtype");
         String path = rs.getString("path");
         Tool t = new Tool(id,name,pathtype,path);
         thelist.add(t);
        System.out.println("Tool.getalltools: got id == " + id + ", name '" + name + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("Tool.getalltools: error: " + e.getMessage());        
    }finally{
       System.out.println("Tool.getalltools: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("Tool.writetodatabase: called, id == " + id + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO tools VALUES(" + id + ",'" + name + "','" + pathtype + "','" + path + "')";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Tool.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Tool.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("Tool.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM tools WHERE id=" + id;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.name = rs.getString("name");
         this.pathtype = rs.getString("pathtype");
         this.path = rs.getString("path");
        System.out.println("Tool.readfromdatabase: got id == " + this.id + ", name '" + this.name + "'");
      } else
       System.out.println("Tool.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("Tool.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Tool.readfromdatabase: finished");        
    }
   }

}
