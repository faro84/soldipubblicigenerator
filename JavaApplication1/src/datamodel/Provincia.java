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
    
}
