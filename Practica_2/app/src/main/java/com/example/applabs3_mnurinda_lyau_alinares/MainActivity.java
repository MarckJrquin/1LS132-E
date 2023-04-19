package com.example.applabs3_mnurinda_lyau_alinares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNum1, txtNum2;
    private TextView tvRes;
    private Spinner spOperaciones;
    private Button btnCalcular;

    private CheckBox chkDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicialiarControles();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void InicialiarControles(){
        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);
        tvRes = (TextView) findViewById(R.id.textView2);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        spOperaciones = (Spinner) findViewById(R.id.spinner);

        chkDialog = (CheckBox) findViewById(R.id.chkDialog);

        String [] ListaOperaciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ListaOperaciones);
        spOperaciones.setAdapter(Adapter);
    }

    private void calcular(){

        try {

            int valor1 = Integer.parseInt(txtNum1.getText().toString());
            int valor2 = Integer.parseInt(txtNum2.getText().toString());
            String opcionSeleccionada = spOperaciones.getSelectedItem().toString();
            String checkbox = "";

            if(opcionSeleccionada.equals("Sumar")){
                int suma = valor1 + valor2;
                tvRes.setText(String.valueOf(suma));
                if(chkDialog.isChecked()){
                    checkbox += chkDialog.getText().toString();
                    new Mensajito("Resultado: ", String.valueOf(suma), "OKis").show(getSupportFragmentManager(), "XD");
                }
            } else if (opcionSeleccionada.equals("Restar")) {
                int resta = valor1 - valor2;
                tvRes.setText(String.valueOf(resta));
                if(chkDialog.isChecked()){
                    new Mensajito("Resultado: ", String.valueOf(resta), "OKis").show(getSupportFragmentManager(), "XD");
                }
            } else if (opcionSeleccionada.equals("Multiplicar")) {
                int multiplicacion = valor1 * valor2;
                tvRes.setText(String.valueOf(multiplicacion));
                if(chkDialog.isChecked()){
                    new Mensajito("Resultado: ", String.valueOf(multiplicacion), "OKis").show(getSupportFragmentManager(), "XD");
                }
            } else if (opcionSeleccionada.equals("Dividir")) {
                float division = (Float.parseFloat(String.valueOf(valor1)) / Float.parseFloat(String.valueOf(valor2)));
                tvRes.setText(String.valueOf(division));
                if(chkDialog.isChecked()){
                    new Mensajito("Resultado: ", String.valueOf(division), "OKis").show(getSupportFragmentManager(), "XD");
                }
            }



        } catch (Exception e){
            Toast.makeText(this, "Error en la operacion de los datos "+e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

}