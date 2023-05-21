package com.example.intentadvance.Models;

public class Eventos {
    private int dia;
    private String diaL;
    private String mes;
    private String titulo;
    private String contenido;
    private String enlace;

    public Eventos(int d,String dl,String m,String t,String c,String e){
        dia = d;
        diaL = dl;
        mes = m;
        titulo = t;
        contenido = c;
        enlace = e;
    }

    public int getDia() {
        return dia;
    }

    public String getDiaL() {
        return diaL;
    }

    public String getMes() {
        return mes;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getEnlace() {
        return enlace;
    }
}
