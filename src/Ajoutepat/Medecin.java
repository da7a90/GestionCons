package Ajoutepat;
public class Medecin{
private String nom;
private int matricule;

    /**
     *
     * @param nom
     * @param matricule
     */
    public Medecin(String nom,int matricule){
this.nom=nom;
this.matricule=matricule;
}

    /**
     *
     * @return
     */
    public String getNom(){
return this.nom;
}

    /**
     *
     * @return
     */
    public int getMatricule(){
return this.matricule;
}
}