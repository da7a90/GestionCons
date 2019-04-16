
package Ajoutepat;

import java.util.ArrayList;

/**
 *
 * @author akentawi
 */
public class Prescrit {
    int jours;

    /**
     *
     * @return
     */
    public int getJours() {
        return jours;
    }
    int id;
    String code;

    /**
     *
     * @param id
     * @param code
     * @param jours
     */
    public Prescrit(int id,String code,int jours){
this.jours= jours;
    this.id=id;
this.code= code;
}

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }
}
