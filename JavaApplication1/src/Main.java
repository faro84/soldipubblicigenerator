
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
        
        Generator.CreateDB("root", "faro84bli", "soldipubblici");
        
        Generator.CreateTable_ANAGRAFE_COMUNI("root", "faro84bli");
        Generator.CreateTable_ANAG_CODGEST_USCITE("root", "faro84bli");
        Generator.CreateTable_ANAG_COMPARTI("root", "faro84bli");
        Generator.CreateTable_ANAG_ENTI_SIOPE("root", "faro84bli");
        Generator.CreateTable_ANAG_REG_PROV("root", "faro84bli");
        Generator.CreateTable_ANAG_SOTTOCOMPARTI("root", "faro84bli");
        Generator.CreateTable_ENTI_USCITE_MENSILI("root", "faro84bli");
    }
    
}
