
package modelo;

import java.time.LocalDate;

/**
 *  Representa un partido 
 *  Un partido es disputado por dos equipos
 *  Un equipo puede jugar varios partidos
 *  Una jornada tiene varios partidos
 *  Un partido pertenece a una sola jornada
 * @author 1gdaw01
 */
public class Partido {
    /**
     * Un partido contiene los equipos que lo disputan,el numero de jornada,el equipo vencedor, el tipo de partido que es, la fehca en la que se ha disputado
     * las kills de ambos equipos 
     * el oro ganado de ambos equipos
     */
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Jornada oJornada;
    private Equipo equipoVencedor;
    private String tipoPartido;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int killsEquipoLocal;
    private int killsEquipoVisitante;
    private int oroEquipoLocal;
    private int oroEquipoVisitante;

    /**
     * El constructor lleno de Partido..
     * @param equipoLocal equipo locar
     * @param equipoVisitante equipo visitante
     * @param oJornada numero de jornada
     * @param equipoVencedor equipo vencedor de partido
     * @param tipoPartido tipo de partido(liga/amistoso)
     * @param fechaInicio fecha en la que se ha disputado
     * @param fechaFin fecha en la que ha acabado(la resta de las dos fechas da la duracion del encuentro)
     * @param killsEquipoLocal kills del equipo local
     * @param killsEquipoVisitante kills del equipo visitante
     * @param oroEquipoLocal oro obtenido por el equipo local
     * @param oroEquipoVisitante  oro obtenido por el equipo visitante
     */
    public Partido(Equipo equipoLocal, Equipo equipoVisitante, Jornada oJornada, Equipo equipoVencedor, String tipoPartido, LocalDate fechaInicio, LocalDate fechaFin, int killsEquipoLocal, int killsEquipoVisitante, int oroEquipoLocal, int oroEquipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.oJornada = oJornada;
        this.equipoVencedor = equipoVencedor;
        this.tipoPartido = tipoPartido;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.killsEquipoLocal = killsEquipoLocal;
        this.killsEquipoVisitante = killsEquipoVisitante;
        this.oroEquipoLocal = oroEquipoLocal;
        this.oroEquipoVisitante = oroEquipoVisitante;
    }

    

    public Partido() {
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Jornada getoJornada() {
        return oJornada;
    }

    public void setoJornada(Jornada oJornada) {
        this.oJornada = oJornada;
    }

    public Equipo getEquipoVencedor() {
        return equipoVencedor;
    }

    public void setEquipoVencedor(Equipo equipoVencedor) {
        this.equipoVencedor = equipoVencedor;
    }

    public String getTipoPartido() {
        return tipoPartido;
    }

    public void setTipoPartido(String tipoPartido) {
        this.tipoPartido = tipoPartido;
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

    public int getKillsEquipoLocal() {
        return killsEquipoLocal;
    }

    public void setKillsEquipoLocal(int killsEquipoLocal) {
        this.killsEquipoLocal = killsEquipoLocal;
    }

    public int getKillsEquipoVisitante() {
        return killsEquipoVisitante;
    }

    public void setKillsEquipoVisitante(int killsEquipoVisitante) {
        this.killsEquipoVisitante = killsEquipoVisitante;
    }

    public int getOroEquipoLocal() {
        return oroEquipoLocal;
    }

    public void setOroEquipoLocal(int oroEquipoLocal) {
        this.oroEquipoLocal = oroEquipoLocal;
    }

    public int getOroEquipoVisitante() {
        return oroEquipoVisitante;
    }

    public void setOroEquipoVisitante(int oroEquipoVisitante) {
        this.oroEquipoVisitante = oroEquipoVisitante;
    } 
}