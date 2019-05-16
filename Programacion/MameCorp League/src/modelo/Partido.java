/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author 1gdaw01
 */
public class Partido {
    
    private Equipo equipoLocal;
    private Jornada oJornada;
    private int idEquipoVisitante;
    private Equipo equipoVencedor;
    private String tipoPartido;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int killsEquipoLocal;
    private int killsEquipoVisitante;
    private int oroEquipoLocal;
    private int oroEquipoVisitante;

    public Partido(Equipo equipoLocal, Jornada oJornada, int idEquipoVisitante, Equipo equipoVencedor, String tipoPartido, LocalDate fechaInicio, LocalDate fechaFin, int killsEquipoLocal, int killsEquipoVisitante, int oroEquipoLocal, int oroEquipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.oJornada = oJornada;
        this.idEquipoVisitante = idEquipoVisitante;
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

    public Jornada getoJornada() {
        return oJornada;
    }

    public void setoJornada(Jornada oJornada) {
        this.oJornada = oJornada;
    }

    public int getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(int idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
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
