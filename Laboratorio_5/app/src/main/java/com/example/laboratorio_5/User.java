package com.example.laboratorio_5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

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


    protected User(Parcel in) {
        image = in.readInt();
        email = in.readString();
        password = in.readString();
        name = in.readString();
        id = in.readString();
        message = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(message);
    }
}
