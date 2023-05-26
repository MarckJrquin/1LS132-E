package com.example.loginproam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RegisterActivity extends AppCompatActivity {

    EditText nombre, cedula, usuario, password;
    RadioGroup rbtTipoRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        InicializarControler();
    }

    private void InicializarControler() {
        nombre = (EditText)findViewById(R.id.txtName);
        cedula =(EditText)findViewById(R.id.txtCedula);
        usuario =(EditText)findViewById(R.id.txtUser);
        password =(EditText)findViewById(R.id.txtPassword);

        rbtTipoRegistro = (RadioGroup)findViewById(R.id.rbgTipoRegistro);
    }

    public void RegistrarUsuarios(View v){
        try {
            int rbtSeleccionado = rbtTipoRegistro.getCheckedRadioButtonId();
            switch (rbtSeleccionado){
                case R.id.rbtSharedPreferencesRegistro:
                    SharedPreferences login = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = login.edit();

                    editor.putString("nombre",nombre.getText().toString());
                    editor.putString("cedula",cedula.getText().toString());
                    editor.putString("usuario",usuario.getText().toString());
                    editor.putString("password",password.getText().toString());
                    editor.commit();

                    startActivity(new Intent(this,LoginActivity.class));

                    break;
                case R.id.rbtArchivoRegistro:
                    boolean existeArchivo = VerificarExistenciaArchivo ();
                    String registro = nombre.getText().toString() +"|"+
                            cedula.getText().toString()+"|"+
                            usuario.getText().toString()+"|"+
                            password.getText().toString() + "~";

                    if (existeArchivo){
                        SobreEscribirArchivo(registro);
                    }else{
                        OutputStreamWriter out = new OutputStreamWriter(
                                openFileOutput("credenciales.txt",Context.MODE_PRIVATE));

                        out.write(registro);
                        out.close();
                    }
                    break;
            }
        }catch (Exception e){
            Toast.makeText(this,"Errorcito => "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void SobreEscribirArchivo(String registro) {
        try {
            BufferedReader bf =
                    new BufferedReader(new InputStreamReader(
                            openFileInput("credenciales.txt")));
            String texto = bf.readLine();

            OutputStreamWriter out = new OutputStreamWriter(
                    openFileOutput("credenciales.txt",Context.MODE_PRIVATE));

            out.write(texto + registro);
            out.close();


        }catch (Exception e){
            Toast.makeText(this,"Errorcito => "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private boolean VerificarExistenciaArchivo() {
        try {
            BufferedReader bf =
                    new BufferedReader(new InputStreamReader(
                            openFileInput("credenciales.txt")));
            String texto = bf.readLine();
            bf.close();

            if(!texto.isEmpty())
                return true;
        }catch (Exception e){
            return false;
        }
        return false;
    }
}