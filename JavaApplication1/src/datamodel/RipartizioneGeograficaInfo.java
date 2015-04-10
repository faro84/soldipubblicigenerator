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
public class RipartizioneGeograficaInfo {
    
    private String name;
    private ArrayList<Regione> regioni;
    
    public RipartizioneGeograficaInfo(){
        regioni = new ArrayList<Regione>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the regioni
     */
    public ArrayList<Regione> getRegioni() {
        return regioni;
    }

    /**
     * @param regioni the regioni to set
     */
    public void setRegioni(ArrayList<Regione> regioni) {
        this.regioni = regioni;
    }
    
    public void addRegione(Regione regione) {
        this.regioni.add(regione);
    }

    public String toJSON() {
        String Json = null;
        Json = "{" + System.getProperty("line.separator") + "\"name\": "+this.getName()+"," + System.getProperty("line.separator") + "";
        Json = Json + "\"children\": [" + System.getProperty("line.separator") + "";
        
        int i = 1;
        for(Regione regione : this.regioni)
        {
            if(i != this.regioni.size())
                Json = Json + regione.toJSON() + "," + System.getProperty("line.separator") + "";
            else
                Json = Json + regione.toJSON() + System.getProperty("line.separator") + "";
            i++;
        }
        Json = Json + "]" + System.getProperty("line.separator") + "";
        Json = Json + "}";
        return Json;
    }
    
}
