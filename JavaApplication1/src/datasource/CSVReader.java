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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author f4e
 */
public class CSVReader 
{  
    public static ArrayList<AnagrafeComparto> ReadCSV_ANAG_COMPARTI(String path) 
    {
        ArrayList<AnagrafeComparto> anagrafeComparti = new ArrayList<AnagrafeComparto>();
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] lineCSV = line.split(cvsSplitBy);
                AnagrafeComparto comparto = new AnagrafeComparto();
                comparto.setCOD_COMPARTO(lineCSV[0]);
                comparto.setDESCRIZIONE_COMPARTO(lineCSV[1]);
                anagrafeComparti.add(comparto);
            }
	} 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
	} 
        catch (IOException e)
        {
            e.printStackTrace();
	} 
        finally
        {
            if (br != null) 
            {
		try 
                {
                    br.close();
		}
                catch (IOException e)
                {
                    e.printStackTrace();
		}
            }
	}
        
        System.out.println("Done");
        return anagrafeComparti;
    }
    
    public static ArrayList<AnagrafeSottocomparto> ReadCSV_ANAG_SOTTOCOMPARTI(String path) 
    {
        ArrayList<AnagrafeSottocomparto> sottocomparti = new ArrayList<AnagrafeSottocomparto>();
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] lineCSV = line.split(cvsSplitBy);
                AnagrafeSottocomparto sottocomparto = new AnagrafeSottocomparto();
                sottocomparto.setSOTTOCOMPARTO(lineCSV[0]);
                sottocomparto.setDESCRIZIONE(lineCSV[1]);
                sottocomparto.setCOD_COMPARTO(lineCSV[2]);
                sottocomparti.add(sottocomparto);
            }
	} 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
	} 
        catch (IOException e)
        {
            e.printStackTrace();
	} 
        finally
        {
            if (br != null) 
            {
		try 
                {
                    br.close();
		}
                catch (IOException e)
                {
                    e.printStackTrace();
		}
            }
	}
        
        System.out.println("Done");
        return sottocomparti;
    }
    
    public static ArrayList<AnagrafeCodiceGestionaleUscita> ReadCSV_ANAG_CODGEST_USCITE(String path) 
    {
        ArrayList<AnagrafeCodiceGestionaleUscita> anagrafeCodiceGestionaleUscite = new ArrayList<AnagrafeCodiceGestionaleUscita>();
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] lineCSV = line.split(cvsSplitBy);
                AnagrafeCodiceGestionaleUscita anagrafeCodiceGestionaleUscita = new AnagrafeCodiceGestionaleUscita();
                anagrafeCodiceGestionaleUscita.setCOD_GEST(lineCSV[0]);
                anagrafeCodiceGestionaleUscita.setCOD_CATEG(lineCSV[1]);
                anagrafeCodiceGestionaleUscita.setDESCRIZIONE_CGU(lineCSV[2]);
                anagrafeCodiceGestionaleUscita.setDATA_INIZIO_VALIDITA(lineCSV[3]);
                anagrafeCodiceGestionaleUscita.setDATA_FINE_VALIDITA(lineCSV[4]);
                anagrafeCodiceGestionaleUscite.add(anagrafeCodiceGestionaleUscita);
            }
	} 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
	} 
        catch (IOException e)
        {
            e.printStackTrace();
	} 
        finally
        {
            if (br != null) 
            {
		try 
                {
                    br.close();
		}
                catch (IOException e)
                {
                    e.printStackTrace();
		}
            }
	}
        
        System.out.println("Done");
        return anagrafeCodiceGestionaleUscite;
    }
    
    public static ArrayList<AnagrafeRegioniProvince> ReadCSV_ANAG_REG_PROV(String path) 
    {
        ArrayList<AnagrafeRegioniProvince> anagrafeRegioniProvince = new ArrayList<AnagrafeRegioniProvince>();
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] lineCSV = line.split(cvsSplitBy);
                AnagrafeRegioniProvince anagrafeRegioniProvincia = new AnagrafeRegioniProvince();
                anagrafeRegioniProvincia.setRIPART_GEO(lineCSV[0]);
                anagrafeRegioniProvincia.setCOD_REGIONE(lineCSV[1]);
                anagrafeRegioniProvincia.setDESCRIZIONE_REGIONE(lineCSV[2]);
                anagrafeRegioniProvincia.setCOD_PROVINCIA(lineCSV[3]);
                anagrafeRegioniProvincia.setDESCRIZIONE_PROVINCIA(lineCSV[4]);
                anagrafeRegioniProvince.add(anagrafeRegioniProvincia);
            }
	} 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
	} 
        catch (IOException e)
        {
            e.printStackTrace();
	} 
        finally
        {
            if (br != null) 
            {
		try 
                {
                    br.close();
		}
                catch (IOException e)
                {
                    e.printStackTrace();
		}
            }
	}
        
        System.out.println("Done");
        return anagrafeRegioniProvince;
    }
    
    public static ArrayList<AnagrafeEnteSiope> ReadCSV_ANAG_ENTI_SIOPE(String path) 
    {
        ArrayList<AnagrafeEnteSiope> anagrafeEntiSiope = new ArrayList<AnagrafeEnteSiope>();
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] lineCSV = line.split(cvsSplitBy);
                AnagrafeEnteSiope anagrafeEnteSiope = new AnagrafeEnteSiope();
                anagrafeEnteSiope.setCOD_ENTE(lineCSV[0]);
                anagrafeEnteSiope.setDATA_INC_SIOPE(lineCSV[1]);
                anagrafeEnteSiope.setDATA_ESC_SIOPE(lineCSV[2]);
                anagrafeEnteSiope.setCOD_FISCALE(lineCSV[3]);
                anagrafeEnteSiope.setDESCR_ENTE(lineCSV[4]);
                anagrafeEnteSiope.setCOD_COMUNE(lineCSV[5]);
                anagrafeEnteSiope.setCOD_PROVINCIA(lineCSV[6]);
                anagrafeEnteSiope.setNUM_ABITANTI(lineCSV[7]);
                anagrafeEnteSiope.setSOTTOCOMPARTO_SIOPE(lineCSV[8]);
                anagrafeEntiSiope.add(anagrafeEnteSiope);
            }
	} 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
	} 
        catch (IOException e)
        {
            e.printStackTrace();
	} 
        finally
        {
            if (br != null) 
            {
		try 
                {
                    br.close();
		}
                catch (IOException e)
                {
                    e.printStackTrace();
		}
            }
	}
        
        System.out.println("Done");
        return anagrafeEntiSiope;
    }
    
    public static ArrayList<AnagrafeComune> ReadCSV_ANAGRAFE_COMUNI(String path) 
    {
        ArrayList<AnagrafeComune> anagrafeComuni = new ArrayList<AnagrafeComune>();
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] lineCSV = line.split(cvsSplitBy);
                AnagrafeComune anagrafeComune = new AnagrafeComune();
                anagrafeComune.setCOD_COMUNE(lineCSV[0]);
                anagrafeComune.setDESCR_COMUNE(lineCSV[1]);
                anagrafeComune.setCOD_PROVINCIA(lineCSV[2]);
                anagrafeComuni.add(anagrafeComune);
            }
	} 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
	} 
        catch (IOException e)
        {
            e.printStackTrace();
	} 
        finally
        {
            if (br != null) 
            {
		try 
                {
                    br.close();
		}
                catch (IOException e)
                {
                    e.printStackTrace();
		}
            }
	}
        
        System.out.println("Done");
        return anagrafeComuni;
    }
    
    public static ArrayList<EntiUsciteMensili> ReadCSV_ENTI_USCITE_MENSILI(String path) 
    {
        ArrayList<EntiUsciteMensili> entiUsciteMensili = new ArrayList<EntiUsciteMensili>();
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] lineCSV = line.split(cvsSplitBy);
                EntiUsciteMensili entiUsciteMensile = new EntiUsciteMensili();
                entiUsciteMensile.setCOD_ENTE(lineCSV[0]);
                entiUsciteMensile.setANNO(lineCSV[1]);
                entiUsciteMensile.setPERIODO(lineCSV[2]);
                entiUsciteMensile.setCODICE_GESTIONALE(lineCSV[3]);
                entiUsciteMensile.setIMP_USCITE_ATT(lineCSV[4]);
                entiUsciteMensili.add(entiUsciteMensile);
                
                if(entiUsciteMensili.size() == 50000)
                    break;
            }
	} 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
	} 
        catch (IOException e)
        {
            e.printStackTrace();
	} 
        finally
        {
            if (br != null) 
            {
		try 
                {
                    br.close();
		}
                catch (IOException e)
                {
                    e.printStackTrace();
		}
            }
	}
        
        System.out.println("Done");
        return entiUsciteMensili;
    }
    
}
