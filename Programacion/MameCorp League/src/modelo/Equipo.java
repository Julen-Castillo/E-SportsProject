/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 1gdaw01
 */
public class Equipo {
    
    private int idEquipo;
    private String nombre;
    private int presupuesto;
    private int puntos;
    
    private Jugador J;
    private ArrayList<Presidente> listaPresidentes;
    private ArrayList<Partido> listaPartidos;

    public Equipo() {
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Jugador getJ() {
        return J;
    }

    public void setJ(Jugador J) {
        this.J = J;
    }

    public ArrayList<Presidente> getListaPresidentes() {
        return listaPresidentes;
    }

    public void setListaPresidentes(ArrayList<Presidente> listaPresidentes) {
        this.listaPresidentes = listaPresidentes;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
    
    
    
    
}
