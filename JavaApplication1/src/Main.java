
import datasource.Generator;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f4e
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = Generator.Connect("root", "faro84bli");
        if(conn != null)
            Generator.CreateDB(conn, "soldipubblici");
        else
            System.out.println("Error");
    }
    
}
