/*
 * To change this license header, choose License Headers in Client Properties.
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
public class Client {
    
   int id;
   String name;
   int deviceid;
   int browserid;
   int osid;

   // constructors
   public Client(int id, String name, int deviceid, int browserid, int osid) {
       this.id = id;
       this.name = name;
       this.deviceid = deviceid;
       this.browserid = browserid;
       this.osid = osid;
   }
   public Client(int id) {
       this.id = id;
       this.name = null;
       this.deviceid = 0;
       this.browserid = 0;
       this.osid = 0;
   }
   
   public static void createtable() {
    System.out.println("Client.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE clients " +
                   "(id INTEGER not NULL, " +
                   " name TEXT UNIQUE, " + 
                   " deviceid INTEGER not NULL, " +
                   " browserid INTEGER not NULL, " +
                   " osid INTEGER not NULL, " +
                   " PRIMARY KEY ( id ), " +
                   " FOREIGN KEY(deviceid) REFERENCES devices(id)," +
                   " FOREIGN KEY(browserid) REFERENCES activities(id)," +
                   " FOREIGN KEY(osid) REFERENCES oss(id)" +
                   ")";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Client.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("Client.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("Client.droptable: called"); 
    Database.droptable("clients");
   }
   
   public static ArrayList<Client> getallclients() {
    System.out.println("Client.getallclients: called"); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM clients";
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String name = rs.getString("name");
         int deviceid = rs.getInt("deviceid");
         int browserid = rs.getInt("browserid");
         int osid = rs.getInt("osid");
         Client p = new Client(id,name,deviceid,browserid,osid);
         thelist.add(p);
        System.out.println("Client.getallclients: got id == " + id + ", name '" + name + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("Client.getallclients: error: " + e.getMessage());        
    }finally{
       System.out.println("Client.getallclients: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("Client.writetodatabase: called, id == " + id + ", name '" + name + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO clients VALUES(" + id + ",'" + name + "'," + this.deviceid + "," + this.browserid + "," + this.osid + ")";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("Client.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Client.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("Client.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM clients WHERE id=" + id;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.name = rs.getString("name");
         this.deviceid = rs.getInt("deviceid");
         this.browserid = rs.getInt("browserid");
         this.osid = rs.getInt("osid");
        System.out.println("Client.readfromdatabase: got id == " + this.id + ", name '" + this.name + "'");
      } else
       System.out.println("Client.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("Client.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("Client.readfromdatabase: finished");        
    }
   }

}
