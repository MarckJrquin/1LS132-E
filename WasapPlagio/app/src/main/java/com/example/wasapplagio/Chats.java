package com.example.wasapplagio;

import android.os.Bundle;

public class Chats {


    private int Foto;
    private String Nombre;
    private String Chat;
    private String Hora;
    private String ChatCount;

    public Chats(){

    }


    public Chats(String nombre, String chat, String hora, String chatCount, int foto) {
        Nombre = nombre;
        Chat = chat;
        Hora = hora;
        ChatCount = chatCount;
        Foto = foto;
    }


    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getChat() {
        return Chat;
    }

    public void setChat(String chat) {
        Chat = chat;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getChatCount() {
        return ChatCount;
    }

    public void setChatCount(String chatCount) {
        ChatCount = chatCount;
    }


    public Bundle ChatToBundle(){
        Bundle b = new Bundle();
        b.putString("nombre", this.getNombre());
        b.putString("chat", this.getChat());
        b.putString("hora", this.getHora());
        b.putInt("count", Integer.parseInt(this.getChatCount()));
        return b;
    }


    public Chats restoreBundle(Bundle b){
        return new Chats(
                b.getString("nombre"),
                b.getString("chat"),
                b.getString("hora"),
                Integer.toString(b.getInt("count")),
                R.drawable.ic_launcher_background
        );
    }


}
