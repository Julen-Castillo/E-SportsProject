/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *  Representa a una Liga 
 *  Una liga esta compuesta por varias jornadas
 *  Las jornadas son disputadas por distintos equipos
 * @author 1gdaw01
 */
public class Liga {
    /**
     * La liga se identifica por un id, el nombre, la fecha de inicio y la fecha de fin y un controlador para saber si esstá en curso o no
     */
    private int idLiga;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean enCurso;

    private ArrayList<Jornada> listaJornadas;

    /**
     * Constructor con parametros de Liga
     * @param nombre nombre de la liga(String)
     * @param fechaInicio fecha en la que se inicia la liga(LocalDate)
     * @param fechaFin fecha en la que finaliza la liga(LocalDate)
     * @param enCurso controlador para saber si la liga está en curso o está parada(Boolean)
     * @param listaJornadas  una lista con las jornadas que componen la liga(ArrayList)
     */
    public Liga(String nombre, LocalDate fechaInicio, LocalDate fechaFin, boolean enCurso, ArrayList<Jornada> listaJornadas) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.enCurso = enCurso;
        this.listaJornadas = listaJornadas;
    }
  
    public Liga() {
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEnCurso() {
        return enCurso;
    }

    public void setEnCurso(boolean enCurso) {
        this.enCurso = enCurso;
    }

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }
    

    
    
    
    
    
}
