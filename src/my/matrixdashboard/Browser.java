/*
 * To change this license header, choose License Headers in Browser Properties.
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
public class Browser {
    
   int id;
   String name;

   // constructors
   public Browser(int id, String name) {
       this.id = id;
       this.name = name;
   }
   public Browser(int id) {
       this.id = id;
       this.name = null;
   }
   
   public static void createtable() {
    System.out.println("Browser.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE browsers " +
                   "(id INTEGER not NULL, " +
                   " name TEXT UNIQUE, " + 
                   " PRIMARY KEY ( id ))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Browser.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("Browser.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("Browser.droptable: called"); 
    Database.droptable("browsers");
   }
   
   public static ArrayList<Browser> getallbrowsers() {
    System.out.println("Browser.getallbrowsers: called"); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM browsers";
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         Browser p = new Browser(id,name);
         thelist.add(p);
        System.out.println("Browser.getallbrowsers: got id == " + id + ", name '" + name + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("Browser.getallbrowsers: error: " + e.getMessage());        
    }finally{
       System.out.println("Browser.getallbrowsers: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("Browser.writetodatabase: called, id == " + id + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO browsers VALUES(" + id + ",'" + name + "')";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Browser.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Browser.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("Browser.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM browsers WHERE id=" + id;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.name = rs.getString("name");
        System.out.println("Browser.readfromdatabase: got id == " + this.id + ", name '" + this.name + "'");
      } else
       System.out.println("Browser.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("Browser.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Browser.readfromdatabase: finished");        
    }
   }

}
