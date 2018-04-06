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
public class Usuario {

    private String nombre;
    private String identificador;
    private String clavePass;

    public Usuario() {
    }

    public Usuario(String nombre, String identificador, String clavePass) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.clavePass = clavePass;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the clavePass
     */
    public String getClavePass() {
        return clavePass;
    }

    /**
     * @param clavePass the clavePass to set
     */
    public void setClavePass(String clavePass) {
        this.clavePass = clavePass;
    }

}
