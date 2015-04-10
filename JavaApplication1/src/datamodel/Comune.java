/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.HashSet;

/**
 *
 * @author f4e
 */
public class Comune {
    
    private String codice;
    private String descrizione;
    private Provincia provincia;
    private double totalePagamenti;
    private HashSet<String> enti;

    public Comune(){
        totalePagamenti = 0;
        enti= new HashSet<String>();
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
     * @return the totalePagamenti
     */
    public double getTotalePagamenti() {
        return totalePagamenti;
    }

    /**
     * @param totalePagamenti the totalePagamenti to set
     */
    public void setTotalePagamenti(double totalePagamenti) {
        this.totalePagamenti = totalePagamenti;
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
     * @return the provincia
     */
    public Provincia getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the enti
     */
    public HashSet<String> getEnti() {
        return enti;
    }

    /**
     * @param enti the enti to set
     */
    public void setEnti(HashSet<String> enti) {
        this.enti = enti;
    }
    
    public void addEnte(String ente) {
        this.enti.add(ente);
    }
    
}
