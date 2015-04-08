/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f4e
 */
public class Generator {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/";
    
    public static Connection Connect(String username, String password)
    {
        Connection conn = null;
        
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            conn = DriverManager.getConnection(DB_URL, username, password);
        } catch (Exception ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void CreateDB(Connection conn, String databaseName)
    {
        Statement stmt = null;
        try
        {
            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();
      
            ResultSet resultSet = conn.getMetaData().getCatalogs();

            while (resultSet.next()) {

                String myDatabaseName = resultSet.getString(1);
                if(myDatabaseName.equals(databaseName))
                {
                    System.out.println("Database already exsists...");
                    return;
                }
            }
            
            String sql = "CREATE DATABASE " + databaseName;
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(stmt!=null)
                stmt.close();
            }
            catch(SQLException se2)
            {
            }
            try
            {
                if(conn!=null)
                conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
    }
}
