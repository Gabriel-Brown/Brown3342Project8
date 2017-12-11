/******************************************************
‘***  Project 8 - Connecting to a database
‘***  Gabriel Brown
‘******************************************************
‘*** To Demonstrate Connecting to a database
‘***
‘******************************************************
‘*** 12/10/2017
‘******************************************************
‘*****************************************************/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.*;
/**
 *
 * @author Gabe
 */
public class MySQL {
   private String userName = "StoreCISK3342";
   private String password = "BEJSQQJraxtHdpvP"; //random password ;)
   private String url = "jdbc:mysql://rocketmen.us:3306/StoreCISK3342"; 
   

       public ByteArrayInputStream GetData()
       {
           Connection conn = null;
           ByteArrayInputStream bs = null;
           try
           {
               Class.forName ("com.mysql.jdbc.Driver").newInstance();             
               conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("Database connection established");
               Statement st = conn.createStatement();
               ResultSet rs = st.executeQuery("SELECT * FROM StoreCISK3342.StoreItems where ID = 1");
               rs.next();
               byte[] buf = rs.getBytes("data");
               
               bs = new ByteArrayInputStream(buf);
           }
           catch (Exception e)
           {
               System.err.println ("Cannot connect to database server");
           }
           finally
           {
               if (conn != null)
               {
                   try
                   {
                       conn.close ();
                       System.out.println ("Database connection terminated");
                   }
                   catch (Exception e) { /* ignore close errors */ }
               }
           }
           return bs;
       }
       
       public void SetData(ByteArrayOutputStream bs)
       {
           Connection conn = null;
           try
           {
               Class.forName ("com.mysql.jdbc.Driver").newInstance();             
               conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("Database connection established");
               String updateSQL = "UPDATE StoreCISK3342.StoreItems "
                + "SET data = ? "
                + "WHERE ID=1";
               PreparedStatement pstmt = conn.prepareStatement(updateSQL);
               pstmt.setBytes(1,bs.toByteArray());
               pstmt.executeUpdate();
               System.out.println("Wrote Objects in the Database.");
           }
           catch (Exception e)
           {
               System.err.println ("Cannot connect to database server");
           }
           finally
           {
               if (conn != null)
               {
                   try
                   {
                       conn.close ();
                       System.out.println ("Database connection terminated");
                   }
                   catch (Exception e) { /* ignore close errors */ }
               }
           }
       }
   
}
