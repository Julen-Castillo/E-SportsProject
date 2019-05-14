/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 1gdaw01
 */
public class Jornada {
    
    private int idJornada;
    private LocalDate fechaInicio;
    private LocalDate fechafIN;
    private int idLiga;
    
    private ArrayList<Partido> listaPartidos;
    private Liga L;

    public Jornada() {
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechafIN() {
        return fechafIN;
    }

    public void setFechafIN(LocalDate fechafIN) {
        this.fechafIN = fechafIN;
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public Liga getL() {
        return L;
    }

    public void setL(Liga L) {
        this.L = L;
    }
    
    
    
    
}
