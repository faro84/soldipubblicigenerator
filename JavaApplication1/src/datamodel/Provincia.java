/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author f4e
 */
public class Provincia {
    
    private String codice;
    private String descrizione;
    private Regione regione;
    private ArrayList<Comune> comuni;
    
    public Provincia(){
        comuni = new ArrayList<Comune>();
    }

    /**
     * @return the codice
     */
    public String getCodice() {
        return codice;
    }

    /**
     * @param codice the codice to set
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * @return the comuni
     */
    public ArrayList<Comune> getComuni() {
        return comuni;
    }

    /**
     * @param comuni the comuni to set
     */
    public void setComuni(ArrayList<Comune> comuni) {
        this.comuni = comuni;
    }
    
    public void addComune(Comune comune) {
        this.comuni.add(comune);
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the regione
     */
    public Regione getRegione() {
        return regione;
    }

    /**
     * @param regione the regione to set
     */
    public void setRegione(Regione regione) {
        this.regione = regione;
    }
    
    public double getSpeseTotali() {
        double spese = 0;
        for(Comune c : comuni)
        {
            spese = spese + c.getTotalePagamenti();
        }
        return spese;
    }

    String toJSON() {
//        String Json = null;
//        Json = "{" + System.getProperty("line.separator") + "\"name\": "+this.getDescrizione()+"," + System.getProperty("line.separator") + "";
//        Json = Json + "\"children\": [" + System.getProperty("line.separator") + "";
//        
//        int i = 1;
//        for(Comune c : this.comuni)
//        {
//            if(i != this.comuni.size())
//                Json = Json + c.toJSON() + "," + System.getProperty("line.separator") + "";
//            else
//                Json = Json + c.toJSON() + System.getProperty("line.separator") + "";
//            i++;
//        }
//        Json = Json + "]" + System.getProperty("line.separator") + "";
//        Json = Json + "}";
//        return Json;
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        String Json = null;
        //Json = "{\"name\": "+this.getDescrizione()+",\"size\":" + Math.round(this.getTotalePagamenti()) + "}";
        Json = "{\"name\": "+this.getDescrizione()+",\"size\":" + randomInt + "}";
        return Json;
    }
    
}
