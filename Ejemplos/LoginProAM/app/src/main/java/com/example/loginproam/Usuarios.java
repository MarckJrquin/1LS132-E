package com.example.loginproam;

public class Usuarios {
    private String Nombre;
    private String Cedula;
    private String Usuario;
    private String Password;

    public Usuarios(String n,String c, String u, String p){
        this.Nombre = n;
        this.Cedula = c;
        this.Usuario = u;
        this.Password = p;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
