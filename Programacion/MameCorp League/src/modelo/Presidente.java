/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *  Representa un presidente de un equipo 
 *  Un equipo tiene un unico presidente
 *  Un presidente representa a un solo equipo
 * @author 1gdaw01
 */
public class Presidente {
    /**
     * Un presidente tine una id, un nombre y un apellido
     */
    private int idPresidente;
    private String nombre;
    private String apellido;
   
    private Equipo oEquipo;

    /**
     * El constructor lleno de presidente contiene los siguentes parametros
     * @param nombre nombre del presidente(String)
     * @param apellido Apellido del presidente(String)
     * @param oEquipo Equipo al que representta como presidente(Equipo)
     */
    public Presidente(String nombre, String apellido, Equipo oEquipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.oEquipo = oEquipo;
    }

    public Presidente() {
    }

    public int getIdPresidente() {
        return idPresidente;
    }

    public void setIdPresidente(int idPresidente) {
        this.idPresidente = idPresidente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Equipo getoEquipo() {
        return oEquipo;
    }

    public void setoEquipo(Equipo oEquipo) {
        this.oEquipo = oEquipo;
    }
    
    
    
    
}
