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
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    RadioGroup rbgTipoLogin;
    EditText usuario,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InicializarControles();
        ValidarSession();
    }

    private void ValidarSession() {
        SharedPreferences login = getSharedPreferences("Login",Context.MODE_PRIVATE);
        int estado = login.getInt("estado",0);
        if (estado == 1){
            startActivity(new Intent(this,MainActivity.class));
        }

    }

    private void InicializarControles() {
        usuario = (EditText)findViewById(R.id.txtUsuario);
        password = (EditText)findViewById(R.id.txtContrasena);

        rbgTipoLogin = (RadioGroup)findViewById(R.id.rbgTipoLogin);
    }

    public void Loguear(View v){
        try {
            SharedPreferences credenciales = getSharedPreferences("Credenciales",Context.MODE_PRIVATE);
            String usuarioRegistrado = credenciales.getString("usuario","");
            String passwordRegistrado = credenciales.getString("password","");

            String user = usuario.getText().toString();
            String contra = password.getText().toString();

            boolean existeUsuario = VerificarUsuariosArchivo(user,contra);
            if (existeUsuario){

            }

            if (user.equals(usuarioRegistrado) && contra.equals(passwordRegistrado)){

                int tipoLogin = rbgTipoLogin.getCheckedRadioButtonId();
                SharedPreferences login = getSharedPreferences("Login",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = login.edit();

                switch (tipoLogin){
                    case R.id.rbtSharedPreferences:
                        editor.putInt("estado",1);
                        editor.putString("nombre","kakaroto Sanjur");
                        editor.putString("usuario","kakaroto");
                        editor.commit();
                        break;
                    case R.id.rbtArchivo:
                            boolean existeUsuaro = VerificarUsuariosArchivo(user,contra);
                            if (existeUsuaro){
                                editor.putInt("estado",1);
                                editor.putString("nombre","kakaroto Sanjur");
                                editor.putString("usuario","kakaroto");
                                editor.commit();
                            }
                        break;
                    default:
                        break;
                }
                startActivity(new Intent(this,MainActivity.class));
            }else{
                Toast.makeText(this,"Ta locoooo, quien tu ere?",Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){
            Toast.makeText(this,"Gokuuuuuuu "+ e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private boolean VerificarUsuariosArchivo(String user, String contra) {
        try {
            List<Usuarios> usuarios = ConvertirArchivoList();

            for (Usuarios usuario : usuarios){
                if (user.equals(usuario.getUsuario()) && contra.equals(usuario.getPassword())){
                    return true;
                }
            }

        }catch (Exception e){
            Toast.makeText(this,"Gokuuuuuuu "+ e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return true;
    }

    private List<Usuarios> ConvertirArchivoList() {
        try{
            List<Usuarios> usuarios = new ArrayList<>();
            String texto = new BufferedReader(
                    new InputStreamReader(openFileInput("credenciales.txt"))).readLine();

            String[] arrUsuarios = texto.split("~");

            for (String usuario : arrUsuarios){
                String[] arrUsuario = usuario.split("\\|");
                Usuarios newUsuario = new Usuarios(
                        arrUsuario[0],
                        arrUsuario[1],
                        arrUsuario[2],
                        arrUsuario[3]
                );

                usuarios.add(newUsuario);
            }
            return usuarios;

        }catch (Exception e){

        }
        return new ArrayList<Usuarios>();
    }

    public void Register(View v){
        startActivity(new Intent(this,RegisterActivity.class));
    }
}