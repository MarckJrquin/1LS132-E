package com.example.menuintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Bundle i = getIntent().getExtras();
        String texto = i.getString("texto");

        TextView txt = (TextView)findViewById(R.id.lblTexto);
        txt.setText(texto);
    }
}