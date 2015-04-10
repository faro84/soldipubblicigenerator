
import datamodel.AnagrafeCodiceGestionaleUscita;
import datamodel.AnagrafeComparto;
import datamodel.AnagrafeComune;
import datamodel.AnagrafeEnteSiope;
import datamodel.AnagrafeRegioniProvince;
import datamodel.AnagrafeSottocomparto;
import datamodel.Ente;
import datamodel.EntiUsciteMensili;
import datamodel.RipartizioneGeograficaInfo;
import datasource.CSVReader;
import datasource.Generator;
import datasource.Insert;
import datasource.ReadMYSQL;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        boolean read = true;
        
        if(!read)
        {
            Generator.CreateDB("root", "faro84bli", "soldipubblici");

            Generator.CreateTable_ANAGRAFE_COMUNI("root", "faro84bli");
            Generator.CreateTable_ANAG_CODGEST_USCITE("root", "faro84bli");
            Generator.CreateTable_ANAG_COMPARTI("root", "faro84bli");
            Generator.CreateTable_ANAG_ENTI_SIOPE("root", "faro84bli");
            Generator.CreateTable_ANAG_REG_PROV("root", "faro84bli");
            Generator.CreateTable_ANAG_SOTTOCOMPARTI("root", "faro84bli");
            Generator.CreateTable_ENTI_USCITE_MENSILI("root", "faro84bli");

            //ArrayList<AnagrafeComparto> comparti = CSVReader.ReadCSV_ANAG_COMPARTI("data\\ANAG_COMPARTI.csv");
            //ArrayList<AnagrafeSottocomparto> sottocomparti = CSVReader.ReadCSV_ANAG_SOTTOCOMPARTI("data\\ANAG_SOTTOCOMPARTI.csv");
            //ArrayList<AnagrafeCodiceGestionaleUscita> anagrafeCodiceGestionaleUscite = CSVReader.ReadCSV_ANAG_CODGEST_USCITE("data\\ANAG_CODGEST_USCITE.csv");
            //ArrayList<AnagrafeRegioniProvince> anagrafeRegioniProvince = CSVReader.ReadCSV_ANAG_REG_PROV("data\\ANAG_REG_PROV.csv");
            //ArrayList<AnagrafeEnteSiope> anagrafeEnteSiope = CSVReader.ReadCSV_ANAG_ENTI_SIOPE("data\\ANAG_ENTI_SIOPE.csv");
            //ArrayList<AnagrafeComune> anagrafeComuni = CSVReader.ReadCSV_ANAGRAFE_COMUNI("data\\ANAGRAFE_COMUNI.csv");
            //ArrayList<EntiUsciteMensili> entiUsciteMensili = CSVReader.ReadCSV_ENTI_USCITE_MENSILI("c:\\ENTI_USCITE_MENSILI.csv");
            try {
                System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Insert.InsertInto_ANAG_COMPARTI("root", "faro84bli", comparti);   
            //Insert.InsertInto_ANAG_SOTTOCOMPARTI("root", "faro84bli", sottocomparti);
            //Insert.InsertInto_ANAG_CODGEST_USCITE("root", "faro84bli", anagrafeCodiceGestionaleUscite);
            //Insert.InsertInto_ANAG_REG_PROV("root", "faro84bli", anagrafeRegioniProvince);
            //Insert.InsertInto_ANAG_ENTI_SIOPE("root", "faro84bli", anagrafeEnteSiope);
            //Insert.InsertInto_ANAGRAFE_COMUNI("root", "faro84bli", anagrafeComuni);
            //Insert.InsertInto_ENTI_USCITE_MENSILI("root", "faro84bli", entiUsciteMensili);
        }
        else
        {
            //ReadMYSQL.Read_ANAG_COMPARTI("root", "faro84bli");
            //ReadMYSQL.Read_ANAG_SOTTOCOMPARTI("root", "faro84bli");
            //ReadMYSQL.Read_ANAG_CODGEST_USCITE("root", "faro84bli");
            //ReadMYSQL.Read_ANAG_REG_PROV("root", "faro84bli");
            //ReadMYSQL.Read_ANAG_ENTI_SIOPE("root", "faro84bli");
            //ReadMYSQL.Read_ANAGRAFE_COMUNI("root", "faro84bli");
            //ReadMYSQL.Read_ENTI_USCITE_MENSILI("root", "faro84bli");
            ArrayList<RipartizioneGeograficaInfo> rip = ReadMYSQL.ReadAndGenerate_ANAG_REG_PROV("root", "faro84bli");
            ReadMYSQL.ReadAndGenerate_ANAGRAFE_COMUNI("root", "faro84bli", rip);
            HashMap<String, Ente> entiSet = ReadMYSQL.ReadAndGenerate_ANAG_ENTI_SIOPE("root", "faro84bli", rip);
            ReadMYSQL.ReadGenerate_ENTI_USCITE_MENSILI("root", "faro84bli", rip, entiSet);
            
        }
    }
    
}
