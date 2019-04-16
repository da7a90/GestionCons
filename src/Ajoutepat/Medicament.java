package Ajoutepat;

/**
 *
 * @author akentawi
 */
public class Medicament{
private String code;
private String libelle;
private String indication;

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     *
     * @return
     */
    public String getIndication() {
        return indication;
    }

    /**
     *
     * @return
     */
    public String getPosologie() {
        return posologie;
    }
private String posologie;

    /**
     *
     * @param code
     * @param libelle
     * @param indication
     * @param posologie
     */
    public Medicament(String code,String libelle,String indication,String posologie){
this.code=code;
this.indication=indication;
this.libelle=libelle;
this.posologie=posologie;
}

}