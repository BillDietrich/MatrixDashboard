/*
 * To change this license header, choose License Headers in Role Properties.
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
public class Role {
    
   int id;
   String name;
   String abbrev;

   // constructors
   public Role(int id, String name, String abbrev) {
       this.id = id;
       this.name = name;
       this.abbrev = abbrev;
   }
   public Role(int id) {
       this.id = id;
       this.name = null;
       this.abbrev = null;
   }
   
   public static void createtable() {
    System.out.println("Role.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE roles " +
                   "(id INTEGER not NULL, " +
                   " name TEXT UNIQUE, " + 
                   " abbrev TEXT UNIQUE, " + 
                   " PRIMARY KEY ( id ))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Role.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("Role.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("Role.droptable: called"); 
    Database.droptable("roles");
   }
   
   public static ArrayList<Role> getallroles() {
    System.out.println("Role.getallroles: called"); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM roles";
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         String abbrev = rs.getString("abbrev");
         Role r = new Role(id,name,abbrev);
         thelist.add(r);
        System.out.println("Role.getallroles: got id == " + id + ", name '" + name + "', abbrev '" + abbrev + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("Role.getallroles: error: " + e.getMessage());        
    }finally{
       System.out.println("Role.getallroles: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("Role.writetodatabase: called, id == " + id + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO roles VALUES(" + id + ",'" + name + "','" + abbrev + "')";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Role.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Role.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("Role.readfromdatabase: called, id == " + this.id);        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM roles WHERE id=" + this.id;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.name = rs.getString("name");
         this.abbrev = rs.getString("abbrev");
        System.out.println("Role.readfromdatabase: got id == " + this.id + ", name '" + this.name + "'");
      } else
       System.out.println("Role.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("Role.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Role.readfromdatabase: finished");        
    }
   }

}
