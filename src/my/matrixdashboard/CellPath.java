/*
 * To change this license header, choose License Headers in CellPath Properties.
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
public class CellPath {
    
   int id;
   int cellid;
   String cellpathtype;
   String pathname;
   String pathtype;
   String path;

   // constructors
   public CellPath(int id, int cellid, String cellpathtype, String pathname, String pathtype, String path) {
       this.id = id;
       this.cellid = cellid;
       this.cellpathtype = cellpathtype;
       this.pathname = pathname;
       this.pathtype = pathtype;
       this.path = path;
   }
   public CellPath(int id, int cellid) {
       this.id = id;
       this.cellid = cellid;
       this.cellpathtype = null;
       this.pathname = null;
       this.pathtype = null;
       this.path = null;
   }
   
   public static void createtable() {
    System.out.println("CellPath.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE cellpaths " +
                   "(id INTEGER not NULL, " +
                   " cellid INTEGER not NULL, " +
                   " cellpathtype TEXT, " + 
                   " pathname TEXT, " + 
                   " pathtype TEXT, " + 
                   " path TEXT, " + 
                   " PRIMARY KEY ( id ), " +
                   " FOREIGN KEY(cellid) REFERENCES cells(id))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("CellPath.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("CellPath.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("CellPath.droptable: called"); 
    Database.droptable("cellpaths");
   }
   
   public static ArrayList<CellPath> getallcellpaths(int cellid) {
    System.out.println("CellPath.getallcellpaths: called, cellid == " + cellid); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM cellpaths WHERE cellid=" + cellid;
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         String cellpathtype = rs.getString("cellpathtype");
         String pathname = rs.getString("pathname");
         String pathtype = rs.getString("pathtype");
         String path = rs.getString("path");
         CellPath cp = new CellPath(id,cellid,cellpathtype,pathname,pathtype,path);
         thelist.add(cp);
        System.out.println("CellPath.getallcellpaths: got id == " + id + ", cellpathtype '" + cellpathtype + "', pathname '" + pathname + "', pathtype '" + pathtype + "', path '" + path + "'");
      }
      rs.close();
    }catch(Exception e){
       System.out.println("CellPath.getallcellpaths: error: " + e.getMessage());        
    }finally{
       System.out.println("CellPath.getallcellpaths: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("CellPath.writetodatabase: called, id == " + id + ", cellid == " + cellid + ", pathname '" + pathname + "'");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO cellpaths VALUES(" + id + "," + cellid + ",'" + cellpathtype + "','" + pathname + "','" + pathtype + "','" + path + "')";
      // write fails silently if name violates the UNIQUE constraint !!!
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("CellPath.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("CellPath.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("CellPath.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM cellpaths WHERE id=" + id + " AND cellid=" + cellid;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.cellpathtype = rs.getString("cellpathtype");
         this.pathname = rs.getString("pathname");
         this.pathtype = rs.getString("pathtype");
         this.path = rs.getString("path");
        System.out.println("CellPath.readfromdatabase: got id == " + this.id + ", pathname '" + this.pathname + "'");
      } else
       System.out.println("CellPath.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("CellPath.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("CellPath.readfromdatabase: finished");        
    }
   }

}
