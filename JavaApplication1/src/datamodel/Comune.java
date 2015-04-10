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
public class Comune {
    
    private String codice;
    private String descrizione;
    private Provincia provincia;
    private double totalePagamenti;

    public Comune(){
        totalePagamenti = 0;
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
    
}
