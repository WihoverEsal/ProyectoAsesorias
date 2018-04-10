/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;


public class Agenda {
    
    private ArrayList<String> diasAs;
    private ArrayList<HoraAsesoria> horasAs;
    
    public Agenda(){
        diasAs = new ArrayList<>();
        horasAs = new ArrayList<>();
    }
    
    public Agenda(ArrayList<String> diasAs, ArrayList<HoraAsesoria> horasAs){
        this.diasAs = diasAs;
        this.horasAs = horasAs;
    }
    
    
    public void addDia(String dia){
        diasAs.add(dia);
    }
    
    public void addHora(HoraAsesoria hora){
        horasAs.add(hora);
    }
    
    public ArrayList<String> getDias(){
        return diasAs;
    }
    
    public ArrayList<HoraAsesoria> getHoras(){
        return horasAs;
    }
    
}