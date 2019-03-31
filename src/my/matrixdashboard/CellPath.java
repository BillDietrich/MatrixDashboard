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
   String cellpathtype; // CellPath.CELLPATHTYPE_*
   String pathname;     // set by user
   String pathtype;     // Database.PATHTYPE_*
   String path;         // URL or local OS file path
   int toolid;
   String args;         // for launching a tool

   public static final String CELLPATHTYPE_APPPAGE = "A";
   public static final String CELLPATHTYPE_DOC = "D";
   public static final String CELLPATHTYPE_BUGREPORT = "B";
   public static final String CELLPATHTYPE_TOOL = "T";

   
   // constructors
   public CellPath(int id, int cellid, String cellpathtype, String pathname, String pathtype, String path, int toolid, String args) {
       this.id = id;
       this.cellid = cellid;
       this.cellpathtype = cellpathtype;
       this.pathname = pathname;
       this.pathtype = pathtype;
       this.path = path;
       this.toolid = toolid;
       this.args = args;
   }
   public CellPath(int id, int cellid) {
       this.id = id;
       this.cellid = cellid;
       this.cellpathtype = null;
       this.pathname = null;
       this.pathtype = null;
       this.path = null;
       this.toolid = 0;
       this.args = null;
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
                   " toolid INTEGER not NULL, " +
                   " args TEXT, " + 
                   " PRIMARY KEY ( id ), " +
                   " FOREIGN KEY(cellid) REFERENCES cells(id) " +
                   " FOREIGN KEY(toolid) REFERENCES tools(id))";

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
         int toolid = rs.getInt("toolid");
         String args = rs.getString("args");
         CellPath cp = new CellPath(id,cellid,cellpathtype,pathname,pathtype,path,toolid,args);
         thelist.add(cp);
        System.out.println("CellPath.getallcellpaths: got id == " + id + ", cellpathtype '" + cellpathtype + "', pathname '" + pathname + "', pathtype '" + pathtype + "', path '" + path + "', toolid " + toolid + ", args '" + args + "'");
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
    System.out.println("CellPath.writetodatabase: called, id == " + id + ", cellid == " + cellid + ", cellpathtype '" + cellpathtype + "', pathname '" + pathname + "', pathtype '" + pathtype + "', path '" + path + "', toolid " + toolid + ", args '" + args + "'");        
    String sql = "INSERT OR REPLACE INTO cellpaths VALUES(" + id + "," + cellid + ",'" + cellpathtype + "','" + pathname + "','" + pathtype + "','" + path + "'," + toolid + ",'" + args + "')";
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("CellPath.writetodatabase: SQL stmt: " + sql);
       System.out.println("CellPath.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("CellPath.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("CellPath.readfromdatabase: called, id == " + id + ", cellid == " + cellid);        
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
         int toolid = rs.getInt("toolid");
         String args = rs.getString("args");
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
