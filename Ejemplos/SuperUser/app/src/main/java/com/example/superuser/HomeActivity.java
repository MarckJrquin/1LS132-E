package com.example.superuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView nombre, cedula, edad, usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.InicializarControles();
        this.MapearDatos();
    }

    private void InicializarControles() {
        nombre = (TextView)findViewById(R.id.lblNombre);
        cedula = (TextView)findViewById(R.id.lblCedula);
        edad = (TextView)findViewById(R.id.lblEdad);
        usuario = (TextView)findViewById(R.id.lblUsuario);
    }

    private void MapearDatos(){
        try {

            SharedPreferences usuarioLogueado = getSharedPreferences("Login", Context.MODE_PRIVATE);

            nombre.setText(usuarioLogueado.getString("n",""));
            cedula.setText(usuarioLogueado.getString("c",""));
            edad.setText(Integer.toString(usuarioLogueado.getInt("e",0)));
            usuario.setText(usuarioLogueado.getString("u",""));

        }catch (Exception e){

        }
    }

    public void Logout(View v){
        SharedPreferences usuarioLogueado = getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = usuarioLogueado.edit();

        editor.putString("n","");
        editor.putString("c","");
        editor.putInt("e",0);
        editor.putString("u","");
        editor.putString("p","");

        editor.commit();

        startActivity(new Intent(this,MainActivity.class));

    }
}