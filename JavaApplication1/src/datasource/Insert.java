/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import datamodel.AnagrafeCodiceGestionaleUscita;
import datamodel.AnagrafeComparto;
import datamodel.AnagrafeComune;
import datamodel.AnagrafeEnteSiope;
import datamodel.AnagrafeRegioniProvince;
import datamodel.AnagrafeSottocomparto;
import datamodel.EntiUsciteMensili;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author f4e
 */
public class Insert {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/soldipubblici";
    
    public static void InsertInto_ANAG_COMPARTI(String userName, String password, ArrayList<AnagrafeComparto> comparti)
    {        
        try
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            if(comparti != null)
            {
                for(AnagrafeComparto comparto : comparti) {
                    
                    // the mysql insert statement
                    String query = " INSERT INTO ANAG_COMPARTI (COD_COMPARTO, DESCRIZIONE_COMPARTO)"
                      + " values (?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, comparto.getCOD_COMPARTO());
                    preparedStmt.setString (2, comparto.getDESCRIZIONE_COMPARTO());

                    // execute the preparedstatement
                    preparedStmt.execute();
                }
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }   
    }
    
    public static void InsertInto_ANAG_SOTTOCOMPARTI(String userName, String password, ArrayList<AnagrafeSottocomparto> sottoComparti)
    {        
        try
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            if(sottoComparti != null)
            {
                for(AnagrafeSottocomparto sottoComparto : sottoComparti) {
                    
                    // the mysql insert statement
                    String query = " INSERT INTO ANAG_SOTTOCOMPARTI (SOTTOCOMPARTO, DESCRIZIONE, COD_COMPARTO)"
                      + " values (?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, sottoComparto.getSOTTOCOMPARTO());
                    preparedStmt.setString (2, sottoComparto.getDESCRIZIONE());
                    preparedStmt.setString (3, sottoComparto.getCOD_COMPARTO());

                    // execute the preparedstatement
                    preparedStmt.execute();
                }
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }   
    }
    
    public static void InsertInto_ANAG_CODGEST_USCITE(String userName, String password, ArrayList<AnagrafeCodiceGestionaleUscita> anagrafeCodiceGestionaleUscite)
    {        
        try
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            if(anagrafeCodiceGestionaleUscite != null)
            {
                
                Statement deleteStatement = conn.createStatement();

                String _deleteTableData = "TRUNCATE TABLE ANAG_CODGEST_USCITE";
                deleteStatement.executeUpdate(_deleteTableData);
                
                for(AnagrafeCodiceGestionaleUscita anagrafeCodiceGestionaleUscita : anagrafeCodiceGestionaleUscite) {
                    
                    // the mysql insert statement
                    String query = " INSERT INTO ANAG_CODGEST_USCITE (COD_GEST, COD_CATEG, DESCRIZIONE_CGU, DATA_INIZIO_VALIDITA, DATA_FINE_VALIDITA)"
                      + " values (?, ?, ?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, anagrafeCodiceGestionaleUscita.getCOD_GEST());
                    preparedStmt.setString (2, anagrafeCodiceGestionaleUscita.getCOD_CATEG());
                    preparedStmt.setString (3, anagrafeCodiceGestionaleUscita.getDESCRIZIONE_CGU());
                    preparedStmt.setString (4, anagrafeCodiceGestionaleUscita.getDATA_INIZIO_VALIDITA());
                    preparedStmt.setString (5, anagrafeCodiceGestionaleUscita.getDATA_FINE_VALIDITA());

                    // execute the preparedstatement
                    preparedStmt.execute();
                }
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }   
    }
    
    public static void InsertInto_ANAG_REG_PROV(String userName, String password, ArrayList<AnagrafeRegioniProvince> anagrafeRegioniProvince)
    {        
        try
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            if(anagrafeRegioniProvince != null)
            {
                
                Statement deleteStatement = conn.createStatement();

                String _deleteTableData = "TRUNCATE TABLE ANAG_REG_PROV";
                deleteStatement.executeUpdate(_deleteTableData);
                
                for(AnagrafeRegioniProvince anagrafeRegioniProvincia : anagrafeRegioniProvince) {
                    
                    // the mysql insert statement
                    String query = " INSERT INTO ANAG_REG_PROV (RIPART_GEO, COD_REGIONE, DESCRIZIONE_REGIONE, COD_PROVINCIA, DESCRIZIONE_PROVINCIA)"
                      + " values (?, ?, ?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, anagrafeRegioniProvincia.getRIPART_GEO());
                    preparedStmt.setString (2, anagrafeRegioniProvincia.getCOD_REGIONE());
                    preparedStmt.setString (3, anagrafeRegioniProvincia.getDESCRIZIONE_REGIONE());
                    preparedStmt.setString (4, anagrafeRegioniProvincia.getCOD_PROVINCIA());
                    preparedStmt.setString (5, anagrafeRegioniProvincia.getDESCRIZIONE_PROVINCIA());

                    // execute the preparedstatement
                    preparedStmt.execute();
                }
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }   
    }
    
    public static void InsertInto_ANAG_ENTI_SIOPE(String userName, String password, ArrayList<AnagrafeEnteSiope> anagrafeEntiSiope)
    {        
        try
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            if(anagrafeEntiSiope != null)
            {
                
                Statement deleteStatement = conn.createStatement();

                String _deleteTableData = "TRUNCATE TABLE ANAG_ENTI_SIOPE";
                deleteStatement.executeUpdate(_deleteTableData);
                
                int count = 0;
                
                for(AnagrafeEnteSiope anagrafeEnteSiope : anagrafeEntiSiope) {
                    
                    count++;
                    // the mysql insert statement
                    String query = " INSERT INTO ANAG_ENTI_SIOPE (COD_ENTE, DATA_INC_SIOPE, DATA_ESC_SIOPE, COD_FISCALE, "
                            + "DESCR_ENTE, COD_COMUNE, COD_PROVINCIA, NUM_ABITANTI, SOTTOCOMPARTO_SIOPE)"
                            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, anagrafeEnteSiope.getCOD_ENTE());
                    preparedStmt.setString (2, anagrafeEnteSiope.getDATA_INC_SIOPE());
                    preparedStmt.setString (3, anagrafeEnteSiope.getDATA_ESC_SIOPE());
                    preparedStmt.setString (4, anagrafeEnteSiope.getCOD_FISCALE());
                    preparedStmt.setString (5, anagrafeEnteSiope.getDESCR_ENTE());
                    preparedStmt.setString (6, anagrafeEnteSiope.getCOD_COMUNE());
                    preparedStmt.setString (7, anagrafeEnteSiope.getCOD_PROVINCIA());
                    preparedStmt.setString (8, anagrafeEnteSiope.getNUM_ABITANTI());
                    preparedStmt.setString (9, anagrafeEnteSiope.getSOTTOCOMPARTO_SIOPE());

                    // execute the preparedstatement
                    preparedStmt.execute();
                    
                    if(count%500==0)
                        System.out.println(count + "/" + anagrafeEntiSiope.size());
                }
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }   
    }
    
    public static void InsertInto_ANAGRAFE_COMUNI(String userName, String password, ArrayList<AnagrafeComune> anagrafeComuni)
    {        
        try
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            if(anagrafeComuni != null)
            {
                
                Statement deleteStatement = conn.createStatement();

                String _deleteTableData = "TRUNCATE TABLE ANAGRAFE_COMUNI";
                deleteStatement.executeUpdate(_deleteTableData);
                
                int count = 0;
                
                for(AnagrafeComune anagrafeComune : anagrafeComuni) {
                    
                    count++;
                    // the mysql insert statement
                    String query = " INSERT INTO ANAGRAFE_COMUNI (COD_COMUNE, DESCR_COMUNE, COD_PROVINCIA)"
                            + " values (?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, anagrafeComune.getCOD_COMUNE());
                    preparedStmt.setString (2, anagrafeComune.getDESCR_COMUNE());
                    preparedStmt.setString (3, anagrafeComune.getCOD_PROVINCIA());

                    // execute the preparedstatement
                    preparedStmt.execute();
                    
                    if(count%500==0)
                        System.out.println(count + "/" + anagrafeComuni.size());
                }
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }   
    }
    
    public static void InsertInto_ENTI_USCITE_MENSILI(String userName, String password, ArrayList<EntiUsciteMensili> entiUsciteMensili)
    {        
        try
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, userName, password);

            if(entiUsciteMensili != null)
            {
                
                Statement deleteStatement = conn.createStatement();

                String _deleteTableData = "TRUNCATE TABLE ENTI_USCITE_MENSILI";
                deleteStatement.executeUpdate(_deleteTableData);
                
                int count = 0;
                
                for(EntiUsciteMensili entiUsciteMensile : entiUsciteMensili) {
                    
                    count++;
                    // the mysql insert statement
                    String query = " INSERT INTO ENTI_USCITE_MENSILI (COD_ENTE, ANNO, PERIODO, CODICE_GESTIONALE, IMP_USCITE_ATT)"
                            + " values (?, ?, ?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, entiUsciteMensile.getCOD_ENTE());
                    preparedStmt.setString (2, entiUsciteMensile.getANNO());
                    preparedStmt.setString (3, entiUsciteMensile.getPERIODO());
                    preparedStmt.setString (4, entiUsciteMensile.getCODICE_GESTIONALE());
                    preparedStmt.setString (5, entiUsciteMensile.getIMP_USCITE_ATT());

                    // execute the preparedstatement
                    preparedStmt.execute();
                    
                    if(count%500==0)
                        System.out.println(count + "/" + entiUsciteMensili.size());
                }
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }   
    }
}
