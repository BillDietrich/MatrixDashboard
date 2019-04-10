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


public class MDCell {
    
   int id;
   int projectid;
   int appfuncid;
   int activityid;

   // constructors
   public MDCell(int id, int projectid, int appfuncid, int activityid) {
       this.id = id;
       this.projectid = projectid;
       this.appfuncid = appfuncid;
       this.activityid = activityid;
   }
   
   public static void createtable() {
    System.out.println("MDCell.createtable: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "CREATE TABLE cells " +
                   "(id INTEGER not NULL, " +
                   " projectid INTEGER not NULL, " +
                   " appfuncid INTEGER not NULL, " +
                   " activityid INTEGER not NULL, " +
                   " PRIMARY KEY ( id ), " +
                   " FOREIGN KEY(projectid) REFERENCES projects(id), " +
                   " FOREIGN KEY(appfuncid) REFERENCES appfuncs(id), " +
                   " FOREIGN KEY(activityid) REFERENCES activities(id))";

      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("MDCell.createtable: error: " + e.getMessage());
    }finally{
       System.out.println("MDCell.createtable: finished");        
    }
   }

   public static void droptable() {
    System.out.println("MDCell.droptable: called"); 
    Database.droptable("cells");
   }
   
   public static ArrayList<MDCell> getallcells(int projectid, int appfuncid, int activityid) {
    System.out.println("MDCell.getallcells: called, projectid == " + projectid + ", appfuncid == " + appfuncid + ", activityid == " + activityid); 
    ArrayList thelist = new ArrayList();
    Statement stmt;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM cells WHERE projectid=" + projectid + " AND appfuncid=" + appfuncid + " AND activityid=" + activityid;
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         int id = rs.getInt("id");
         MDCell c = new MDCell(id, projectid, appfuncid, activityid);
         thelist.add(c);
        System.out.println("MDCell.getallcells: got id == " + id);
      }
      rs.close();
    }catch(Exception e){
       System.out.println("MDCell.getallcells: error: " + e.getMessage());        
    }finally{
       System.out.println("MDCell.getallcells: finished, thelist.size() == " + thelist.size());        
    }
    
    return thelist;
   }

   public void writetodatabase() {
    System.out.println("MDCell.writetodatabase: called, id == " + id + ", projectid " + projectid + ", appfuncid " + appfuncid + ", activityid " + activityid);        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "INSERT OR REPLACE INTO cells VALUES(" + id + "," + projectid + "," + appfuncid + "," + activityid + ")";
      stmt.executeUpdate(sql);
    }catch(Exception e){
       System.out.println("MDCell.writetodatabase: error: " + e.getMessage());
    }finally{
       System.out.println("MDCell.writetodatabase: finished");        
    }
   }

   public void readfromdatabase() {
    System.out.println("MDCell.readfromdatabase: called");        
    Statement stmt = null;
    try{
      stmt = Database.conn.createStatement();
      String sql = "SELECT * FROM cells WHERE projectid=" + projectid + " AND appfuncid=" + appfuncid + " AND activityid=" + activityid;
      stmt.executeQuery(sql);
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()){
         this.id = rs.getInt("id");
         this.projectid = rs.getInt("projectid");
         this.appfuncid = rs.getInt("appfuncid");
         this.activityid = rs.getInt("activityid");
        System.out.println("MDCell.readfromdatabase: got id == " + this.id + ", projectid == " + this.projectid + ", appfuncid == " + this.appfuncid + ", activityid == " + this.activityid);
      } else
       System.out.println("MDCell.readfromdatabase: record not found");
    }catch(Exception e){
       System.out.println("MDCell.readfromdatabase: error: " + e.getMessage());
    }finally{
       System.out.println("MDCell.readfromdatabase: finished");        
    }
   }

}
