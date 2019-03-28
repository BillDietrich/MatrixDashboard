/*
 * To change this license header, choose License Headers in CellTool Properties.
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
public class CellTool {
    
   int id;
   int cellid;
   int toolid;

   // constructors
   public CellTool(int id, int cellid, int toolid) {
       this.id = id;
       this.cellid = cellid;
       this.toolid = toolid;
   }
   
   public static void createtable() {
    System.out.println("CellTool.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE celltools " +
                   "(id INTEGER not NULL, " +
                   " cellid INTEGER not NULL, " +
                   " toolid INTEGER not NULL, " +
                   " PRIMARY KEY ( id ), " +
                   " FOREIGN KEY(cellid) REFERENCES cells(id), " +
                   " FOREIGN KEY(toolid) REFERENCES tools(id)" +
                   ")";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("CellTool.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("CellTool.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("CellTool.droptable: called"); 
    Database.droptable("celltools");
   }
   
   public static ArrayList<CellTool> getallcelltools(int cellid) {
    System.out.println("CellTool.getallcelltools: called, cellid == " + cellid); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM celltools WHERE cellid=" + cellid;
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         int toolid = rs.getInt("toolid");
         CellTool ct = new CellTool(id,cellid,toolid);
         thelist.add(ct);
        System.out.println("CellTool.getallcelltools: got id == " + id + ", toolid " + toolid);
      }
      rs.close();
    }catch(Exception e){
       System.out.println("CellTool.getallcelltools: error: " + e.getMessage());        
    }finally{
       System.out.println("CellTool.getallcelltools: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("CellTool.writetodatabase: called, id == " + id + ", cellid == " + cellid + ", toolid == " + toolid);        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO celltools VALUES(" + id + "," + cellid + "," + toolid + ")";
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("CellTool.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("CellTool.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("CellTool.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM celltools WHERE id=" + id + " AND cellid=" + cellid;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.cellid = rs.getInt("cellid");
         this.toolid = rs.getInt("toolid");
        System.out.println("CellTool.readfromdatabase: got id == " + this.id + ", toolid " + this.toolid);
      } else
       System.out.println("CellTool.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("CellTool.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("CellTool.readfromdatabase: finished");        
    }
   }

}
