
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *  Representa una jornada de una liga en la cual hay varios partidos
 *  Una jornada está compuesta por varios partidos
 * @author 1gdaw01
 */
public class Jornada {
    /**
     * En una jornada controlamos el numero de jornada,la fecha de inicio y la fecha de finalización de la misma
     */
    private int idJornada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    private ArrayList<Partido> listaPartidos = new ArrayList();
    private Liga oLiga;
    
    /**
     * Constructor jornada con los parametros 
     * @param fechaInicio fecha de inicio de la jornada(LocaDate)
     * @param fechaFin  fecha de finalización de la jornada(LocaDate)
     */
    public Jornada(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Constructor vacio de Jornada
     */
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

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public Liga getoLiga() {
        return oLiga;
    }

    public void setoLiga(Liga oLiga) {
        this.oLiga = oLiga;
    }

   
    
    
    
    
}
