package com.example.wasapplagio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

public class FormActivity extends AppCompatActivity {

    EditText nombre, chat, chats;
    TimePicker hora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.initControls();
    }


    public void initControls(){
        nombre = (EditText) findViewById(R.id.txtNombre);
        chat = (EditText) findViewById(R.id.txtChat);
        hora = (TimePicker) findViewById(R.id.tpHora);
        chats = (EditText) findViewById(R.id.txtChats);
    }


    public void AgregarChat(View view){
        try {
            Chats newChat = new Chats(
                    nombre.getText().toString(),
                    chat.getText().toString(),
                    hora.getHour() + ":" + hora.getMinute(),
                    chats.getText().toString(),
                    R.drawable.ic_launcher_background
            );

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtras(newChat.ChatToBundle());
            startActivity(i);
        }catch (Exception e){}
    }
}