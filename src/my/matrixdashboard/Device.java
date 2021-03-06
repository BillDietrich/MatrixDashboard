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


public class Device {
    
   int id;
   String name;

   // constructors
   public Device(int id, String name) {
       this.id = id;
       this.name = name;
   }
   public Device(int id) {
       this.id = id;
       this.name = null;
   }
   
   public static void createtable() {
    System.out.println("Device.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE devices " +
                   "(id INTEGER not NULL, " +
                   " name TEXT UNIQUE, " + 
                   " PRIMARY KEY ( id ))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Device.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("Device.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("Device.droptable: called"); 
    Database.droptable("devices");
   }
   
   public static ArrayList<Device> getalldevices() {
    System.out.println("Device.getalldevices: called"); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM devices";
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         Device p = new Device(id,name);
         thelist.add(p);
        System.out.println("Device.getalldevices: got id == " + id + ", name '" + name + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("Device.getalldevices: error: " + e.getMessage());        
    }finally{
       System.out.println("Device.getalldevices: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("Device.writetodatabase: called, id == " + id + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO devices VALUES(" + id + ",'" + name + "')";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Device.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Device.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("Device.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM devices WHERE id=" + id;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.name = rs.getString("name");
        System.out.println("Device.readfromdatabase: got id == " + this.id + ", name '" + this.name + "'");
      } else
       System.out.println("Device.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("Device.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Device.readfromdatabase: finished");        
    }
   }

}
