package com.example.asistenciadeprofesores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombreProfesor, txtDescripcion;
    CheckBox chkProg, chkVag, chkCom;
    RadioGroup rgbExcusa;
    Spinner spnSalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarControles();

    }

    private void inicializarControles(){
        txtNombreProfesor = (EditText) findViewById(R.id.txtNombrePorfesor);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripción);

        chkProg = (CheckBox) findViewById(R.id.chkProgramando);
        chkVag = (CheckBox) findViewById(R.id.chkVagueando);
        chkCom = (CheckBox) findViewById(R.id.chkComiendo);

        rgbExcusa = (RadioGroup) findViewById(R.id.rbgExcusa);

        spnSalon = (Spinner) findViewById(R.id.spnSalon);
    }

    public void EnviarDatos(View view){
        try {
            String nombre = txtNombreProfesor.getText().toString();
            String descripcion = txtDescripcion.getText().toString();

            String motivos = obtenerCheckbox();

            String excusa = "";
            switch (rgbExcusa.getCheckedRadioButtonId()){
                case R.id.rbgExcusaSi:
                    excusa = "Si";
                    break;
                case R.id.rbgExcusaNo:
                    excusa = "No";
                    break;
                default:
                    excusa = "Ni le importa";
            }

            Toast.makeText(this, "Mis datos io => "+nombre+" "+descripcion+" "+motivos+" "+excusa, Toast.LENGTH_SHORT).show();

            new Mensajito("Imprimir Datos", "Mis datos io => "+nombre+" "+descripcion+" "+motivos+" "+excusa, "OKis").show(getSupportFragmentManager(), "XD");

        } catch (Exception e){
            Toast.makeText(this, "Error io => "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String obtenerCheckbox() {
        String checkboxs = "";
        if(chkProg.isChecked())
            checkboxs += chkProg.getText().toString();

        if(chkVag.isChecked())
            checkboxs += chkVag.getText().toString();

        if(chkCom.isChecked())
            checkboxs += chkCom.getText().toString();
        return checkboxs;
    }


}