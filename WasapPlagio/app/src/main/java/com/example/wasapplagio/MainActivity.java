package com.example.wasapplagio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstChats;
    ChatAdapter adapterComp;


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

        Bundle b = getIntent().getExtras();
        if (b != null){
            Chats chat = new Chats().restoreBundle(b);
            List<Chats> chats = LlenarListViewCompuesto();
            chats.add(chat);

            //adapter complejo
            adapterComp = new ChatAdapter(getApplicationContext(), chats);
        }else {
            //adapter complejo
            adapterComp = new ChatAdapter(getApplicationContext(), LlenarListViewCompuesto());
        }

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.miNew) {
            Intent i = new Intent(getApplicationContext(), FormActivity.class);
            startActivity(i);
        } else if (itemId == R.id.miNew2) {
            Toast.makeText(getApplicationContext(), "Opción no habilitada", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public boolean onMenuItemSelected(int featureId, @NonNull MenuItem item) {
     */
        /*
        switch (item.getItemId()){
            case R.id.miNew:
                Intent i = new Intent(getApplicationContext(), FormActivity.class);
                startActivity(i);
                break;
            case R.id.miNew2:
                Toast.makeText(getApplicationContext(), "Opcion no habilitaad", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
        */

        /*
        int itemId = item.getItemId();

        if (itemId == R.id.miNew) {
            Intent i = new Intent(getApplicationContext(), FormActivity.class);
            startActivity(i);
        } else if (itemId == R.id.miNew2) {
            Toast.makeText(getApplicationContext(), "Opción no habilitada", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
    */

}
