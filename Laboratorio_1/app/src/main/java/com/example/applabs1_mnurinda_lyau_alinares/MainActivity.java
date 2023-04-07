package com.example.applabs1_mnurinda_lyau_alinares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Esto se imprime desde el metodo OnCreate", Toast.LENGTH_SHORT).show();
        //La actividad esta creada
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Esto se imprime desde el metodo OnStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Esto se imprime desde el metodo OnRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Esto se imprime desde el metodo OnResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Esto se imprime desde el metodo OnPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Esto se imprime desde el metodo OnStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Esto se imprime desde el metodo OnDestroy", Toast.LENGTH_SHORT).show();
    }
}