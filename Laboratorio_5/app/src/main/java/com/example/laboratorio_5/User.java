package com.example.laboratorio_5;

import android.os.Bundle;

public class User {

    private int image;
    private String email;
    private String password;
    private String name;
    private String id;
    private String message;

    public  User(){

    }

    public User(int image, String email, String password, String name, String id, String message) {
        this.image = image;
        this.email = email;
        this.password = password;
        this.name = name;
        this.id = id;
        this.message = message;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Bundle UserToBundle(){
        Bundle b = new Bundle();
        b.putString("email", this.getEmail());
        b.putString("password", this.getPassword());
        b.putString("name", this.getName());
        b.putString("id", this.getId());
        b.putString("message", this.getMessage());
        return b;
    }

    public User restoreBundle(Bundle b){
        return new User(
                R.drawable.profile_picture,
                b.getString("email"),
                b.getString("password"),
                b.getString("name"),
                b.getString("id"),
                b.getString("message")
        );
    }
}
