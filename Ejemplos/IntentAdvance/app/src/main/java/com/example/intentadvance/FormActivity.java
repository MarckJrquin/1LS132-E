package com.example.intentadvance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    EditText dia,dial,mes,titulo,contenido,enlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        InicializarControles();
    }

    private void InicializarControles() {
        dia = (EditText)findViewById(R.id.txtDia);
        dial = (EditText)findViewById(R.id.txtDiaL);
        mes = (EditText)findViewById(R.id.txtMes);
        titulo = (EditText)findViewById(R.id.txtTitulo);
        contenido = (EditText)findViewById(R.id.txtContenido);
        enlace = (EditText)findViewById(R.id.txtEnlace);
    }

    public void PassData(View v){
        try {
            Bundle b = new Bundle();
            b.putString("dia", dia.getText().toString());
            b.putString("dial", dial.getText().toString());
            b.putString("mes", mes.getText().toString());
            b.putString("titulo", titulo.getText().toString());
            b.putString("contenido", contenido.getText().toString());
            b.putString("enlace", enlace.getText().toString());

            Intent i = new Intent(getApplicationContext(), EventosActivity.class);
            i.putExtras(b);

            startActivity(i);

        }catch (Exception e){

        }
    }

}