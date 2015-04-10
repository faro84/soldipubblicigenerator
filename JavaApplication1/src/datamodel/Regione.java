/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.ArrayList;

/**
 *
 * @author f4e
 */
public class Regione {
    
    private String codice;
    private String descrizione;
    private RipartizioneGeograficaInfo ripartizione;
    private ArrayList<Provincia> province;
    
    public Regione(){
        province = new ArrayList<Provincia>();
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
     * @return the province
     */
    public ArrayList<Provincia> getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(ArrayList<Provincia> province) {
        this.province = province;
    }
    
    public void addProvince(Provincia provincia) {
        this.province.add(provincia);
    }

    /**
     * @return the ripartizione
     */
    public RipartizioneGeograficaInfo getRipartizione() {
        return ripartizione;
    }

    /**
     * @param ripartizione the ripartizione to set
     */
    public void setRipartizione(RipartizioneGeograficaInfo ripartizione) {
        this.ripartizione = ripartizione;
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

    String toJSON() {
        String Json = null;
        Json = "{" + System.getProperty("line.separator") + "\"name\": "+this.getDescrizione()+"," + System.getProperty("line.separator") + "";
        Json = Json + "\"children\": [" + System.getProperty("line.separator") + "";
        
        int i = 1;  
        for(Provincia prov : this.province)
        {
            if(i != this.province.size())
                Json = Json + prov.toJSON() + "," + System.getProperty("line.separator") + "";
            else
                Json = Json + prov.toJSON() + System.getProperty("line.separator") + "";
            i++;
        }
        Json = Json + "]" + System.getProperty("line.separator") + "";
        Json = Json + "}";
        return Json;
    }
    
}
