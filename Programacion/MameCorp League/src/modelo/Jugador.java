
package modelo;


/**
 *  Representa a un Jugador 
 *  Un jugador pertenece a un equipo
 * @author 1gdaw01
 */
public class Jugador {
    /**
     * Un jugador tiene un id,nombre,apellido,nickname,posicion,sueldo y un control de titularidad
     */
    private int idJugador;
    private String nombre;
    private String apellido;
    private String nickname;
    private String posicion;
    private int sueldo;
    private boolean titularidad;
    
    private Equipo oEquipo;

    /**
     * En el constructor del jugador controlamos los siguentes parametros
     * @param nombre nombre del jugador(String)
     * @param apellido apellido del jugador(String)
     * @param nickname nickname con el que juega(String)
     * @param posicion posicion que ocupa en el equipo(String)
     * @param sueldo sueldo que gana(int)
     * @param titularidad titularidad del jugador(Boolean)
     * @param oEquipo equipo al que pertenece(Objeto Equipo)
     */
    public Jugador(String nombre, String apellido, String nickname, String posicion, int sueldo, boolean titularidad, Equipo oEquipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.posicion = posicion;
        this.sueldo = sueldo;
        this.titularidad = titularidad;
        this.oEquipo = oEquipo;
    }

    

    
    
    public Jugador() {
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isTitularidad() {
        return titularidad;
    }

    public void setTitularidad(boolean titularidad) {
        this.titularidad = titularidad;
    }

    public Equipo getoEquipo() {
        return oEquipo;
    }

    public void setoEquipo(Equipo oEquipo) {
        this.oEquipo = oEquipo;
    }

    
    
    
    
    
}
