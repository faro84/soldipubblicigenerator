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
public class AnagrafeComune {
    
    private String COD_COMUNE;
    private String DESCR_COMUNE;
    private String COD_PROVINCIA;

    /**
     * @return the COD_COMUNE
     */
    public String getCOD_COMUNE() {
        return COD_COMUNE;
    }

    /**
     * @param COD_COMUNE the COD_COMUNE to set
     */
    public void setCOD_COMUNE(String COD_COMUNE) {
        this.COD_COMUNE = COD_COMUNE;
    }

    /**
     * @return the DESCR_COMUNE
     */
    public String getDESCR_COMUNE() {
        return DESCR_COMUNE;
    }

    /**
     * @param DESCR_COMUNE the DESCR_COMUNE to set
     */
    public void setDESCR_COMUNE(String DESCR_COMUNE) {
        this.DESCR_COMUNE = DESCR_COMUNE;
    }

    /**
     * @return the COD_PROVINCIA
     */
    public String getCOD_PROVINCIA() {
        return COD_PROVINCIA;
    }

    /**
     * @param COD_PROVINCIA the COD_PROVINCIA to set
     */
    public void setCOD_PROVINCIA(String COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }
    
}
