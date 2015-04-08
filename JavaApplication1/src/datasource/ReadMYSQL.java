/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author f4e
 */
public class ReadMYSQL {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/soldipubblici";
    
    public static void Read_ANAG_COMPARTI(String userName, String password)
    {
        try
        {
            // create our mysql database connection
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM ANAG_COMPARTI";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String firstName = rs.getString("COD_COMPARTO");
                String lastName = rs.getString("DESCRIZIONE_COMPARTO");
                System.out.println(firstName + "," + lastName);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public static void Read_ANAG_SOTTOCOMPARTI(String userName, String password)
    {
        try
        {
            // create our mysql database connection
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM ANAG_SOTTOCOMPARTI";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String firstName = rs.getString("SOTTOCOMPARTO");
                String lastName = rs.getString("DESCRIZIONE");
                String lastName2 = rs.getString("COD_COMPARTO");
                System.out.println(firstName + "," + lastName + "," + lastName2);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public static void Read_ANAG_CODGEST_USCITE(String userName, String password)
    {
        try
        {
            // create our mysql database connection
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM ANAG_CODGEST_USCITE";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            int count = 0;
            // iterate through the java resultset
            while (rs.next())
            {
                count++;
                String firstName = rs.getString("COD_GEST");
                String lastName = rs.getString("COD_CATEG");
                String lastName2 = rs.getString("DESCRIZIONE_CGU");
                String lastName3 = rs.getString("DATA_INIZIO_VALIDITA");
                String lastName4 = rs.getString("DATA_FINE_VALIDITA");
                System.out.println(firstName + "," + lastName + "," + lastName2);
            }
            st.close();
            System.out.println(count);
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public static void Read_ANAG_REG_PROV(String userName, String password)
    {
        try
        {
            // create our mysql database connection
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM ANAG_REG_PROV";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            int count = 0;
            // iterate through the java resultset
            while (rs.next())
            {
                count++;
                String firstName = rs.getString("RIPART_GEO");
                String lastName = rs.getString("COD_REGIONE");
                String lastName2 = rs.getString("DESCRIZIONE_REGIONE");
                String lastName3 = rs.getString("COD_PROVINCIA");
                String lastName4 = rs.getString("DESCRIZIONE_PROVINCIA");
                System.out.println(firstName + "," + lastName + "," + lastName2);
            }
            st.close();
            System.out.println(count);
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public static void Read_ANAG_ENTI_SIOPE(String userName, String password)
    {
        try
        {
            // create our mysql database connection
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM ANAG_ENTI_SIOPE";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            int count = 0;
            // iterate through the java resultset
            while (rs.next())
            {
                count++;
                String firstName = rs.getString("COD_ENTE");
                String lastName = rs.getString("DATA_INC_SIOPE");
                String lastName2 = rs.getString("DATA_ESC_SIOPE");
                String lastName3 = rs.getString("COD_FISCALE");
                String lastName4 = rs.getString("DESCR_ENTE");
                String lastName5 = rs.getString("COD_COMUNE");
                String lastName6 = rs.getString("COD_PROVINCIA");
                String lastName7 = rs.getString("NUM_ABITANTI");
                String lastName8 = rs.getString("SOTTOCOMPARTO_SIOPE");
                System.out.println(firstName + "," + lastName + "," + lastName2);
            }
            st.close();
            System.out.println(count);
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public static void Read_ANAGRAFE_COMUNI(String userName, String password)
    {
        try
        {
            // create our mysql database connection
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM ANAGRAFE_COMUNI";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            int count = 0;
            // iterate through the java resultset
            while (rs.next())
            {
                count++;
                String firstName = rs.getString("COD_COMUNE");
                String lastName = rs.getString("DESCR_COMUNE");
                String lastName2 = rs.getString("COD_PROVINCIA");
                System.out.println(firstName + "," + lastName + "," + lastName2);
            }
            st.close();
            System.out.println(count);
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public static void Read_ENTI_USCITE_MENSILI(String userName, String password)
    {
        try
        {
            // create our mysql database connection
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM ENTI_USCITE_MENSILI";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            int count = 0;
            // iterate through the java resultset
            while (rs.next())
            {
                count++;
                String firstName = rs.getString("COD_ENTE");
                String lastName = rs.getString("ANNO");
                String lastName2 = rs.getString("PERIODO");
                String lastName3 = rs.getString("CODICE_GESTIONALE");
                String lastName4 = rs.getString("IMP_USCITE_ATT");
                System.out.println(firstName + "," + lastName + "," + lastName2);
            }
            st.close();
            System.out.println(count);
        }
        catch (Exception e)
        {
            System.err.println("Got an exception in reading! ");
            System.err.println(e.getMessage());
        }
    }
}
