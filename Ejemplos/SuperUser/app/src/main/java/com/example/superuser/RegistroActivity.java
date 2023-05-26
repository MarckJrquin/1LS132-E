package com.example.superuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RegistroActivity extends AppCompatActivity {

    EditText nombre, cedula, edad, usuario, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.InicializarControles();
    }

    private void InicializarControles() {
        nombre = (EditText)findViewById(R.id.txtNombreRegist);
        cedula = (EditText)findViewById(R.id.txtCedulaRegist);
        edad = (EditText)findViewById(R.id.txtEdadRegist);
        usuario = (EditText)findViewById(R.id.txtUserRegist);
        contrasena = (EditText)findViewById(R.id.txtPassRegist);
    }

    public void GuardarPersona(View v){
        try {
            String guardar =
                    nombre.getText().toString() +"|"+
                    cedula.getText().toString() +"|"+
                    edad.getText().toString() +"|"+
                    usuario.getText().toString() +"|"+
                    contrasena.getText().toString() +"~";

            int res = GuardarArchivo(guardar);
            if(res == 1){
                this.Notify("Cooool, se guardo el Dato io");
            }else
                this.Notify("Exploto Iooooo, correeeeeeee ");

        }catch (Exception e){
            this.Notify("Errorcito =>"+e.getMessage());
        }
    }

    private void Notify(String mensajito){
        Toast.makeText(this,mensajito,Toast.LENGTH_LONG).show();
    }

    public int GuardarArchivo(String guardar){
        try
        {
            String oldTexto = "";
            BufferedReader bf =
                    new BufferedReader(new InputStreamReader(
                            openFileInput("credenciales.txt")));
            String texto = bf.readLine();
            if(!texto.isEmpty()){
                oldTexto = texto;
            }

            OutputStreamWriter fout = new OutputStreamWriter(
                    openFileOutput("credenciales.txt", Context.MODE_PRIVATE));
            fout.write(oldTexto + guardar);
            fout.close();

            return 1;
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
        return 0;
    }

}