/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import datamodel.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
    
    public static ArrayList<RipartizioneGeograficaInfo> ReadAndGenerate_ANAG_REG_PROV(String userName, String password)
    {
        HashMap<String, RipartizioneGeograficaInfo> ripMap = new HashMap<String, RipartizioneGeograficaInfo>();
        HashMap<String, Regione> regMap = new HashMap<String, Regione>();
        
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
                RipartizioneGeograficaInfo rip = null;
                if(ripMap.containsKey(rs.getString("RIPART_GEO")))
                {
                    rip = ripMap.get(rs.getString("RIPART_GEO"));
                }
                else
                {
                    rip = new RipartizioneGeograficaInfo();
                    rip.setName(rs.getString("RIPART_GEO"));
                    ripMap.put(rip.getName(), rip);
                }
                
                Regione reg = null;
                if(regMap.containsKey(rs.getString("COD_REGIONE")))
                {
                    reg = regMap.get(rs.getString("COD_REGIONE"));
                }
                else
                {
                    reg = new Regione();
                    reg.setCodice(rs.getString("COD_REGIONE"));
                    reg.setDescrizione(rs.getString("DESCRIZIONE_REGIONE"));
                    reg.setRipartizione(rip);
                    regMap.put(reg.getCodice(), reg);
                    rip.addRegione(reg);
                }

                String firstName = rs.getString("RIPART_GEO");
                String lastName = rs.getString("COD_REGIONE");
                String lastName2 = rs.getString("DESCRIZIONE_REGIONE");
                String lastName3 = rs.getString("COD_PROVINCIA");
                String lastName4 = rs.getString("DESCRIZIONE_PROVINCIA");
                Provincia prov = null;
                
                prov = new Provincia();
                prov.setCodice(rs.getString("COD_PROVINCIA"));
                prov.setDescrizione(rs.getString("DESCRIZIONE_PROVINCIA"));
                prov.setRegione(reg);
                reg.addProvince(prov);
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
        
        return new ArrayList<RipartizioneGeograficaInfo>(ripMap.values());
    }
    
    public static HashMap<String, Ente> ReadAndGenerate_ANAG_ENTI_SIOPE(String userName, String password, ArrayList<RipartizioneGeograficaInfo> rip)
    {
        HashMap<String, Comune> com = new HashMap<String, Comune>();
        HashMap<String, Ente> enti = new HashMap<String, Ente>();
        for(RipartizioneGeograficaInfo rgi : rip)
        {
            for(Regione reg : rgi.getRegioni())
            {
                for(Provincia pro : reg.getProvince())
                {
                    for(Comune comune : pro.getComuni())
                        com.put(comune.getCodice(), comune);
                }
            }
        }
        
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
                Comune comune = com.get(rs.getString("COD_COMUNE"));
                String name = rs.getString("COD_COMUNE");
                if(comune != null) {
                    comune.addEnte(rs.getString("COD_ENTE"));
                    Ente ente = new Ente();
                    ente.setCodice(rs.getString("COD_ENTE"));
                    ente.setComune(comune);
                    enti.put(ente.getCodice(), ente);
                }
                
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
        return enti;
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
    
    public static void ReadAndGenerate_ANAGRAFE_COMUNI(String userName, String password, ArrayList<RipartizioneGeograficaInfo> rip)
    {
        HashMap<String, Provincia> prov = new HashMap<String, Provincia>();
        
        for(RipartizioneGeograficaInfo rgi : rip)
        {
            for(Regione reg : rgi.getRegioni())
            {
                for(Provincia pro : reg.getProvince())
                {
                    prov.put(pro.getCodice(), pro);
                }
            }
        }
        
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
                Provincia p = prov.get(rs.getString("COD_PROVINCIA"));
                Comune c = new Comune();
                c.setCodice(rs.getString("COD_COMUNE"));
                c.setDescrizione(rs.getString("DESCR_COMUNE"));
                c.setProvincia(p);
                p.addComune(c);
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
    
    public static void ReadGenerate_ENTI_USCITE_MENSILI(String userName, String password, ArrayList<RipartizioneGeograficaInfo> rip, HashMap<String, Ente> enti)
    {
        HashMap<String, Comune> com = new HashMap<String, Comune>();
        
        for(RipartizioneGeograficaInfo rgi : rip)
        {
            for(Regione reg : rgi.getRegioni())
            {
                for(Provincia pro : reg.getProvince())
                {
                    for(Comune comune : pro.getComuni())
                        com.put(comune.getCodice(), comune);
                }
            }
        }
        int count = 0;
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
            
            // iterate through the java resultset
            while (rs.next())
            {
                count++;
                //if(count == 4714)
                  //  System.out.println("");
                String firstName = rs.getString("COD_ENTE");
                if(firstName.isEmpty() || firstName == null)
                    System.out.println("firstName empty");
                Ente ente = enti.get(rs.getString("COD_ENTE"));
                if(ente != null) {
                    
                    String lastName4 = rs.getString("IMP_USCITE_ATT");

                    if(lastName4.isEmpty() || lastName4 == null)
                        System.out.println("last empty");
                    double spesa = replaceZeros(lastName4.replace("\"", ""));
                    ente.setTotaleSpese(ente.getTotaleSpese() + spesa);
                    Comune c = ente.getComune();
                    if(c != null)
                    {
                        System.out.println("comune null");
                        c.setTotalePagamenti(c.getTotalePagamenti() + spesa);
                        String lastName = rs.getString("ANNO");
                        String lastName2 = rs.getString("PERIODO");
                        String lastName3 = rs.getString("CODICE_GESTIONALE");
                    }
                }
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

    private static double replaceZeros(String str) {
        if(str == "" || str.isEmpty())
            return 0;
        if (str.matches("\\d+")){
            String s = str.replaceAll("^0+", "");
            if(s.equals("") || s.isEmpty())
                return 0;
            return Double.parseDouble(s);   
        }
        return Double.parseDouble(str);
    }
}
