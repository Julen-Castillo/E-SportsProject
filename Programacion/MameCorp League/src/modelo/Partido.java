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
    
    private int idPartido;
    private Equipo equipoLocal;
    private int idEquipoVisitante;
    private int vencedor;
    private String tipoPartido;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int killsEquipoLocal;
    private int killsEquipoVisitante;
    private int oroEquipoLocal;
    private int oroEquipoVisitante;
    private int idJornada;
    
    private Jornada Jor;

    public Partido() {
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public int getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(int idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    public int getVencedor() {
        return vencedor;
    }

    public void setVencedor(int vencedor) {
        this.vencedor = vencedor;
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

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public Jornada getJor() {
        return Jor;
    }

    public void setJor(Jornada Jor) {
        this.Jor = Jor;
    }
    
    
    
    
}
