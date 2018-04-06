/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author lgarcia
 */
public class HoraAsesoria {

    private boolean disponible;
    private int indiceHora;

    public HoraAsesoria() {
    }
    
    //indiceHora va de 0 a 15
    public HoraAsesoria(boolean disponible, int indiceHora) {
        this.disponible = disponible;
        this.indiceHora = indiceHora;
    }

    /**
     * @return the disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return the indiceHora
     */
    public int getIndiceHora() {
        return indiceHora;
    }

    /**
     * @param indiceHora the indiceHora to set
     */
    public void setIndiceHora(int indiceHora) {
        this.indiceHora = indiceHora;
    }
    
    public String getHora(){
        String hora = null;
        if(this.getIndiceHora() == 0){
            hora = "7:00";
        }
        return hora;
    }

}
