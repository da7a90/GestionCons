package Ajoutepat;

/**
 *
 * @author akentawi
 */
public class Consultation{

    /**
     *
     * @return
     */
    public int getMatriculeMed() {
        return matriculeMed;
    }

    /**
     *
     * @return
     */
    public int getNumeroPat() {
        return numeroPat;
    }


private int num;

    /**
     *
     * @return
     */
    public int getNum() {
        return num;
    }
private int matriculeMed;
private int numeroPat;

    /**
     *
     * @param matriculeMed
     * @param numeroPat
     * @param num
     */
    public Consultation(int matriculeMed,int numeroPat,int num){
this.num=num;
this.matriculeMed=matriculeMed;
this.numeroPat=numeroPat;
}


    
}