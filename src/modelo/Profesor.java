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
public class Profesor extends Usuario {

    private ArrayList<UEA> ueas;
    private Agenda agendaProf;

    public Profesor() {
    }

    public Profesor(ArrayList<UEA> ueas, Agenda agendaProf) {
        this.ueas = ueas;
        this.agendaProf = agendaProf;
    }

    /**
     * @return the ueas
     */
    public ArrayList<UEA> getUeas() {
        return ueas;
    }

    /**
     * @param ueas the ueas to set
     */
    public void setUeas(ArrayList<UEA> ueas) {
        this.ueas = ueas;
    }

    /**
     * @return the agendaProf
     */
    public Agenda getAgendaProf() {
        return agendaProf;
    }

    /**
     * @param agendaProf the agendaProf to set
     */
    public void setAgendaProf(Agenda agendaProf) {
        this.agendaProf = agendaProf;
    }

}
