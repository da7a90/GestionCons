package Ajoutepat;
public class Patient{
private String nom;
private int numss;

    /**
     *
     * @param nom
     * @param numss
     */
    public Patient(String nom,int numss){
this.nom=nom;
this.numss=numss;
}

    /**
     *
     * @return
     */
    public String getNom() {
        return this.nom;
    }

    /**
     *
     * @return
     */
    public int getNumss() {
        return this.numss;
    }

}