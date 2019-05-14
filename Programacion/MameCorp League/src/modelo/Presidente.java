/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 1gdaw01
 */
public class Presidente {
    
    private int idPresidente;
    private String nombre;
    private String apellido;
    private int idEquipo;
    
    private Equipo E;

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

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo getE() {
        return E;
    }

    public void setE(Equipo E) {
        this.E = E;
    }
    
    
}
