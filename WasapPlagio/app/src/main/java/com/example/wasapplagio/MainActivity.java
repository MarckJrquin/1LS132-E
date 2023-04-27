package com.example.wasapplagio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstChats;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstChats = (ListView)findViewById(R.id.lstChats);

        // adapter sencillo
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                LlenarListViewSimple()
        );

        //adapter complejo
        ChatAdapter adapterComp = new ChatAdapter(
                getApplicationContext(),
                LlenarListViewCompuesto()
        );

        lstChats.setAdapter(adapterComp);
    }

    private List<String> LlenarListViewSimple(){
        List<String> chats = new ArrayList<String>();
        chats.add("Norman peluquin");
        chats.add("Norman peluquin");
        chats.add("Norman peluquin");

        return chats;
    }

    private List<Chats> LlenarListViewCompuesto(){
        List<Chats> chats = new ArrayList<Chats>();
        chats.add(new Chats("Norman Sparks", "Profe, me toy quedando", "4:40am", "140", R.drawable.ic_launcher_background));
        chats.add(new Chats("Sara Cedeno", "Profe, me toy quedando X2", "5:40am", "40", R.drawable.ic_launcher_background));
        chats.add(new Chats("Luigi Yau", "Profe, pongame i", "6:40am", "60", R.drawable.ic_launcher_background));
        chats.add(new Chats("Marcos Ñurinda", ":v", "7:40am", "10", R.drawable.ic_launcher_background));

        return chats;
    }
}
