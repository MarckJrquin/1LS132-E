 package com.example.intentadvance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item){

         switch (item.getItemId()){
             case R.id.miContacto:
                 Intent i = new Intent(getApplicationContext(),FormActivity.class);
                 startActivity(i);
                 break;
         }

        return super.onOptionsItemSelected(item);
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.principal,menu);
        return true;
    }

    public void VerEventos(View v){
        Intent i = new Intent(getApplicationContext(), EventosActivity.class);
        startActivity(i);
     }
}