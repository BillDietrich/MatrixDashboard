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


public class OS {
    
   int id;
   String name;

   // constructors
   public OS(int id, String name) {
       this.id = id;
       this.name = name;
   }
   public OS(int id) {
       this.id = id;
       this.name = null;
   }
   
   public static void createtable() {
    System.out.println("OS.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE oss " +
                   "(id INTEGER not NULL, " +
                   " name TEXT UNIQUE, " + 
                   " PRIMARY KEY ( id ))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("OS.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("OS.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("OS.droptable: called"); 
    Database.droptable("oss");
   }
   
   public static ArrayList<OS> getalloss() {
    System.out.println("OS.getalloss: called"); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM oss";
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         OS p = new OS(id,name);
         thelist.add(p);
        System.out.println("OS.getalloss: got id == " + id + ", name '" + name + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("OS.getalloss: error: " + e.getMessage());        
    }finally{
       System.out.println("OS.getalloss: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("OS.writetodatabase: called, id == " + id + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO oss VALUES(" + id + ",'" + name + "')";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("OS.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("OS.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("OS.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM oss WHERE id=" + id;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.name = rs.getString("name");
        System.out.println("OS.readfromdatabase: got id == " + this.id + ", name '" + this.name + "'");
      } else
       System.out.println("OS.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("OS.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("OS.readfromdatabase: finished");        
    }
   }

}
