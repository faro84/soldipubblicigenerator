/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

/**
 *
 * @author f4e
 */
public class Ente {
    
    private String codice;
    private Comune comune;

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
     * @return the comune
     */
    public Comune getComune() {
        return comune;
    }

    /**
     * @param comune the comune to set
     */
    public void setComune(Comune comune) {
        this.comune = comune;
    }
    
}
