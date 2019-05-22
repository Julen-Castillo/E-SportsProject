
package modelo;

import java.util.ArrayList;

/**
 *  Representa un Equipo que participa en la liga
 *  Un equipo está compuesto por jugadores
 *  Un eqipo tiene un presidente
 *  Un equipo juega varios partidos
 * @author 1gdaw01
 */
public class Equipo {
    /**
     * Un equipo está compuesto por un id, un nombre, un presupuesto y la cantidad de puntos conseguidos
     */
    private int idEquipo;
    private String nombre;
    private int presupuesto;
    private int puntos;

    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Presidente> listaPresidentes;
    private ArrayList<Partido> listaPartidos;

    public Equipo() {
    }

    /**
     * Constructor lleno de equipo
     * @param nombre nombre del equipo(String)
     * @param presupuesto presupuesto del equipo(int)
     * @param puntos puntos conseguidos por el equipo(int)
     */
    public Equipo(String nombre, int presupuesto, int puntos) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.puntos = puntos;
    }
    
    /**
     * 
     * @return devuelve el idEquipo
     */
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

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
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
