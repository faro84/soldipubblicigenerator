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
public class EntiUsciteMensili {
    
    private String COD_ENTE;
    private String ANNO;
    private String PERIODO;
    private String CODICE_GESTIONALE;
    private String IMP_USCITE_ATT;

    /**
     * @return the COD_ENTE
     */
    public String getCOD_ENTE() {
        return COD_ENTE;
    }

    /**
     * @param COD_ENTE the COD_ENTE to set
     */
    public void setCOD_ENTE(String COD_ENTE) {
        this.COD_ENTE = COD_ENTE;
    }

    /**
     * @return the ANNO
     */
    public String getANNO() {
        return ANNO;
    }

    /**
     * @param ANNO the ANNO to set
     */
    public void setANNO(String ANNO) {
        this.ANNO = ANNO;
    }

    /**
     * @return the PERIODO
     */
    public String getPERIODO() {
        return PERIODO;
    }

    /**
     * @param PERIODO the PERIODO to set
     */
    public void setPERIODO(String PERIODO) {
        this.PERIODO = PERIODO;
    }

    /**
     * @return the CODICE_GESTIONALE
     */
    public String getCODICE_GESTIONALE() {
        return CODICE_GESTIONALE;
    }

    /**
     * @param CODICE_GESTIONALE the CODICE_GESTIONALE to set
     */
    public void setCODICE_GESTIONALE(String CODICE_GESTIONALE) {
        this.CODICE_GESTIONALE = CODICE_GESTIONALE;
    }

    /**
     * @return the IMP_USCITE_ATT
     */
    public String getIMP_USCITE_ATT() {
        return IMP_USCITE_ATT;
    }

    /**
     * @param IMP_USCITE_ATT the IMP_USCITE_ATT to set
     */
    public void setIMP_USCITE_ATT(String IMP_USCITE_ATT) {
        this.IMP_USCITE_ATT = IMP_USCITE_ATT;
    }
    
}
