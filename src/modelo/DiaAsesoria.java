/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author lgarcia
 */
public class DiaAsesoria {

    public static int LUNES = 0;
    public static int MARTES = 1;
    public static int MIERCOLES = 2;
    public static int JUEVES = 3;
    public static int VIERNES = 4;

    private ArrayList<HoraAsesoria> horasAs;
    private int indiceDia;

    public DiaAsesoria() {
        horasAs = new ArrayList<>();
    }

    public DiaAsesoria(ArrayList<HoraAsesoria> horasAs, int indiceDia) {
        this();
        this.horasAs = horasAs;
        this.indiceDia = indiceDia;
    }

    /**
     * @return the horasAs
     */
    public ArrayList<HoraAsesoria> getHorasAs() {
        return horasAs;
    }

    /**
     * @param horasAs the horasAs to set
     */
    public void setHorasAs(ArrayList<HoraAsesoria> horasAs) {
        this.horasAs = horasAs;
    }

    /**
     * @return the indiceDia
     */
    public int getIndiceDia() {
        return indiceDia;
    }

    /**
     * @param indiceDia the indiceDia to set
     */
    public void setIndiceDia(int indiceDia) {
        this.indiceDia = indiceDia;
    }

}
