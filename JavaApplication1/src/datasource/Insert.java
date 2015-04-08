/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import datamodel.AnagrafeComparto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
}
