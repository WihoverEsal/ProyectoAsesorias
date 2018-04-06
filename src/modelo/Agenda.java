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
public class Agenda {

    private ArrayList<DiaAsesoria> agenda;

    public Agenda() {
        agenda = new ArrayList<>();
    }

    public Agenda(ArrayList<DiaAsesoria> agenda) {
        this();
        this.agenda = agenda;
    }        
    
    /**
     * @return the agenda
     */
    public ArrayList<DiaAsesoria> getAgenda() {
        return agenda;
    }

    /**
     * @param agenda the agenda to set
     */
    public void setAgenda(ArrayList<DiaAsesoria> agenda) {
        this.agenda = agenda;
    }

}
