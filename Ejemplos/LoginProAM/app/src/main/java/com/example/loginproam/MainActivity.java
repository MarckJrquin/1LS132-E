package com.example.loginproam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            PopularDatos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void PopularDatos() throws Exception {
        SharedPreferences login = getSharedPreferences("Login", Context.MODE_PRIVATE);

        TextView dato = (TextView)findViewById(R.id.usuario);
        dato.setText("Alohaaaaa => "+login.getString("nombre",""));

        BufferedReader bf = new BufferedReader(
                new InputStreamReader(openFileInput("credenciales.txt")));

        String texto = bf.readLine();
        int x = 1;
    }

    public void Logout(View v){
        SharedPreferences login = getSharedPreferences("Login", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = login.edit();
        editor.putInt("estado",0);
        editor.commit();

        startActivity(new Intent(this,LoginActivity.class));
    }
}