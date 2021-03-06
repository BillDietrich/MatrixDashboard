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
   public static final String PATHTYPE_OWASPZAP = "Z";
   
   public static final char PATHTYPEC_NONE = 'N';
   public static final char PATHTYPEC_EXECUTE = 'X';
   public static final char PATHTYPEC_BROWSEURL = 'B';
   public static final char PATHTYPEC_EDITFILE = 'E';
   public static final char PATHTYPEC_OPENFILE = 'O';
   public static final char PATHTYPEC_OWASPZAP = 'Z';
   
   public static final String PATHTYPENAME_NONE = " ";
   public static final String PATHTYPENAME_EXECUTE = "Execute";
   public static final String PATHTYPENAME_BROWSEURL = "Browse URL";
   public static final String PATHTYPENAME_EDITFILE = "Edit File";
   public static final String PATHTYPENAME_OPENFILE = "Open File";
   public static final String PATHTYPENAME_OWASPZAP = "OWASP ZAP API";
   
   static int pathtypeStringToIndex(String c) {
      switch (c.charAt(0)) {
          case PATHTYPEC_NONE: return 0;
          case PATHTYPEC_EXECUTE: return 1;
          case PATHTYPEC_BROWSEURL: return 2;
          case PATHTYPEC_EDITFILE: return 3;
          case PATHTYPEC_OPENFILE: return 4;
          case PATHTYPEC_OWASPZAP: return 5;
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
