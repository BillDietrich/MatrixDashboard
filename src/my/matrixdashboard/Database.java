/*
 * To change this license header, choose License Headers in Project Properties.
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
public class Database {

   public static Connection conn = null;
   public static final int NONEID = 1;
   public static final String NONENAME = "---none---";
   public static final String NONEABBREV = "-";
   
   public static final String PATHTYPE_NONE = "N";
   public static final String PATHTYPE_EXECUTE = "X";
   public static final String PATHTYPE_BROWSEURL = "B";
   public static final String PATHTYPE_EDITFILE = "E";
   public static final String PATHTYPE_OPENFILE = "O";
   
   public static final String PATHTYPENAME_NONE = " ";
   public static final String PATHTYPENAME_EXECUTE = "Execute";
   public static final String PATHTYPENAME_BROWSEURL = "Browse URL";
   public static final String PATHTYPENAME_EDITFILE = "Edit File";
   public static final String PATHTYPENAME_OPENFILE = "Open File";
   
   static int pathtypeLetterToIndex(String c) {
      switch (c) {
          case PATHTYPE_NONE: return 0;
          case PATHTYPE_EXECUTE: return 1;
          case PATHTYPE_BROWSEURL: return 2;
          case PATHTYPE_EDITFILE: return 3;
          case PATHTYPE_OPENFILE: return 4;
          default: return 99;
      }
   }

   
   
   public void open() {
    try{
       Class.forName("org.sqlite.JDBC");
       System.out.println("Database.open: Connecting to database...");
       conn = DriverManager.getConnection("jdbc:sqlite:matrixdashboard.sqlite3");
    }catch(Exception e){
       System.out.println("Database.open: error: " + e.getMessage());        
    }finally{
       System.out.println("Database.open: Finished1");        
    }

    Statement stmt = null;
    try{
      stmt = conn.createStatement();
      String sql = "SELECT name FROM sqlite_master WHERE type='table'";
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
        String name = rs.getString("name");
        System.out.println("Database.open: table '" + name + "'");
      }
    }catch(Exception e){
       System.out.println("Database.open: error: " + e.getMessage());        
    }finally{
       System.out.println("Database.open: finished2");        
    }
   }
   
   public void close() {
    System.out.println("Database.close: called");        
    try{
       conn.close();
    }catch(Exception e){
       System.out.println("Database.close: error: " + e.getMessage());        
    }finally{
       System.out.println("Database.close: finished");        
    }
   }
   
   public static void droptable(String name) {
    System.out.println("Database.droptable: called, name == '" + name + "'"); 
    Statement stmt = null;
    try{
      stmt = conn.createStatement();
      String sql = "DROP TABLE '" + name + "'";
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Database.droptable: error: " + e.getMessage());        
    }finally{
       System.out.println("Database.droptable: finished");        
    }
   }
   
   public void create() {
    System.out.println("Database.create: called"); 
    Statement stmt = null;
    try{
      stmt = conn.createStatement();
      String sql = "CREATE DATABASE matrixdashboard";
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Database.create: error: " + e.getMessage());        
    }finally{
       System.out.println("Database.create: finished");        
    }
   }
}
