/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
    static final String DB_URL = "jdbc:mysql://localhost/soldipubblici";
    
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
    
    public static void CreateDB(String userName, String password, String databaseName)
    {
        Statement stmt = null;
        Connection conn = null;
        try
        {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            conn = DriverManager.getConnection(DB_URL, userName, password);
            
            ResultSet resultSet = conn.getMetaData().getCatalogs();

            while (resultSet.next()) {

                String myDatabaseName = resultSet.getString(1);
                if(myDatabaseName.equals(databaseName))
                {
                    System.out.println("Database already exsists...");
                    return;
                }
            }
            
            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();
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
    
    public static void CreateTable(String userName, String password, TableType type)
    {
        Statement stmt = null;
        Connection conn = null;
        try
        {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            conn = DriverManager.getConnection(DB_URL, userName, password);
            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = GetCreateTableSQL(type);

            stmt.executeUpdate(sql);
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
    
    public static void CreateTable_ANAG_COMPARTI(String userName, String password)
    {
        CreateTable(userName, password, TableType.ANAG_COMPARTI);
    }
    
    public static void CreateTable_ANAGRAFE_COMUNI(String userName, String password)
    {
        CreateTable(userName, password, TableType.ANAGRAFE_COMUNI);
    }
    
    public static void CreateTable_ANAG_CODGEST_USCITE(String userName, String password)
    {
        CreateTable(userName, password, TableType.ANAG_CODGEST_USCITE);
    }
    
    public static void CreateTable_ANAG_ENTI_SIOPE(String userName, String password)
    {
        CreateTable(userName, password, TableType.ANAG_ENTI_SIOPE);
    }
    
    public static void CreateTable_ANAG_REG_PROV(String userName, String password)
    {
        CreateTable(userName, password, TableType.ANAG_REG_PROV);
    }
    
    public static void CreateTable_ANAG_SOTTOCOMPARTI(String userName, String password)
    {
        CreateTable(userName, password, TableType.ANAG_SOTTOCOMPARTI);
    }
    
    public static void CreateTable_ENTI_USCITE_MENSILI(String userName, String password)
    {
        CreateTable(userName, password, TableType.ENTI_USCITE_MENSILI);
    }

    private static String GetCreateTableSQL(TableType type) {
        
        if(type == TableType.ANAG_COMPARTI)
            return "CREATE TABLE IF NOT EXISTS ANAG_COMPARTI " +
                        "(COD_COMPARTO VARCHAR(255) not NULL, " +
                        " DESCRIZIONE_COMPARTO VARCHAR(255), " + 
                        " PRIMARY KEY ( COD_COMPARTO ))";
        else if(type == TableType.ANAG_SOTTOCOMPARTI)
            return "CREATE TABLE IF NOT EXISTS ANAG_SOTTOCOMPARTI " +
                        "(SOTTOCOMPARTO VARCHAR(255) not NULL, " +
                        " DESCRIZIONE VARCHAR(255), " + 
                        " COD_COMPARTO VARCHAR(255), " + 
                        " PRIMARY KEY ( SOTTOCOMPARTO ))";
        else if(type == TableType.ANAG_CODGEST_USCITE)
            return "CREATE TABLE IF NOT EXISTS ANAG_CODGEST_USCITE " +
                        "(COD_GEST VARCHAR(255) not NULL, " +
                        " COD_CATEG VARCHAR(255), " + 
                        " DESCRIZIONE_CGU VARCHAR(255), " + 
                        " DATA_INIZIO_VALIDITA VARCHAR(255), " +
                        " DATA_FINE_VALIDITA VARCHAR(255), " +
                        " PRIMARY KEY ( COD_GEST ))";
        else if(type == TableType.ANAG_REG_PROV)
            return "CREATE TABLE IF NOT EXISTS ANAG_REG_PROV " +
                        "(RIPART_GEO VARCHAR(255) not NULL, " +
                        " COD_REGIONE VARCHAR(255), " + 
                        " DESCRIZIONE_REGIONE VARCHAR(255), " + 
                        " COD_PROVINCIA VARCHAR(255), " +
                        " DESCRIZIONE_PROVINCIA VARCHAR(255), " +
                        " PRIMARY KEY ( RIPART_GEO ))";
        else if(type == TableType.ANAG_ENTI_SIOPE)
            return "CREATE TABLE IF NOT EXISTS ANAG_REG_PROV " +
                        "(COD_ENTE VARCHAR(255) not NULL, " +
                        " DATA_INC_SIOPE VARCHAR(255), " + 
                        " DATA_ESC_SIOPE VARCHAR(255), " + 
                        " COD_FISCALE VARCHAR(255), " +
                        " DESCR_ENTE VARCHAR(255), " +
                        " COD_COMUNE VARCHAR(255), " +
                        " COD_PROVINCIA VARCHAR(255), " +
                        " NUM_ABITANTI VARCHAR(255), " +
                        " SOTTOCOMPARTO_SIOPE VARCHAR(255), " +
                        " PRIMARY KEY ( COD_ENTE ))";
        else if(type == TableType.ANAGRAFE_COMUNI)
            return "CREATE TABLE IF NOT EXISTS ANAGRAFE_COMUNI " +
                        "(COD_COMUNE VARCHAR(255) not NULL, " +
                        " DESCR_COMUNE VARCHAR(255), " + 
                        " COD_PROVINCIA VARCHAR(255), " + 
                        " PRIMARY KEY ( COD_COMUNE ))";
        else if(type == TableType.ENTI_USCITE_MENSILI)
            return "CREATE TABLE IF NOT EXISTS ENTI_USCITE_MENSILI " +
                        "(COD_ENTE VARCHAR(255) not NULL, " +
                        " ANNO VARCHAR(255), " + 
                        " PERIODO VARCHAR(255), " + 
                        " CODICE_GESTIONALE VARCHAR(255), " +
                        " IMP_USCITE_ATT VARCHAR(255))";
                   
        return null;
    }
}
