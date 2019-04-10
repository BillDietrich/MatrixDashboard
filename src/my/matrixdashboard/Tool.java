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


public class Tool {
    
   int id;
   String name;         // set by user
   String pathtype;     // Database.PATHTYPE_*
   String path;         // URL or local OS file path, for launching or for talking to running app
   String port;         // URL port number
   String APIkey;

   // constructors
   public Tool(int id, String name, String pathtype, String path, String port, String APIkey) {
       this.id = id;
       this.name = name;
       this.pathtype = pathtype;
       this.path = path;
       this.port = port;
       this.APIkey = APIkey;
   }
   public Tool(int id) {
       this.id = id;
       this.name = null;
       this.pathtype = null;
       this.path = null;
       this.port = null;
       this.APIkey = null;
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
                   " port TEXT, " + 
                   " APIkey TEXT, " + 
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
        String port = rs.getString("port");
        String APIkey = rs.getString("APIkey");
        Tool t = new Tool(id,name,pathtype,path,port,APIkey);
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
      String sql = "INSERT OR REPLACE INTO tools VALUES(" + id + ",'" + name + "','" + pathtype + "','" + path + "','" + port + "','" + APIkey + "')";
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
        this.port = rs.getString("port");
        this.APIkey = rs.getString("APIkey");
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
