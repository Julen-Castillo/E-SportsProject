/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * La clase sesion representa un usuario con el cual poder hacer Log In en nuestro proyecto
 * @author 1gdaw01
 */
public class Sesion {
    
    /**
     * Una Sesion contiene un id,nombre,contraseña y tipo de cuenta
     */
    private int idUsuario;
    private String nombreUsuario;
    private String password;
    private String tipoUsuario;

    /**
     * El constructor de la sesion contiene los siguientes parametros
     * @param nombreUsuario nombre con el que se va a hacer login
     * @param password  contraseña del usuario
     */
    public Sesion(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;

    }

    public Sesion() {
    }

  
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    
    
    
    
}
