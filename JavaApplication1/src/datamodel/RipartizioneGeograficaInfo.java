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
    
}
