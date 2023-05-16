package com.example.tarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ProgressBar progressBar;
    DatePicker datePicker;
    TimePicker timePicker;
    Button button;
    Button buttonClear;
    TextView textViewResult;


    /*Calendar calendar;
    SimpleDateFormat dateFormatter;
    SimpleDateFormat timeFormatter;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Evitar que aparezca el teclado numérico automáticamente
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        InitControls();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
            }
        });
    }


    private void InitControls(){
        editText = (EditText) findViewById(R.id.editTextNumber);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        datePicker = (DatePicker) findViewById(R.id.dateSpinner);
        timePicker = (TimePicker) findViewById(R.id.timeSpinner);
        button = (Button) findViewById(R.id.button);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
    }


    public void showData(){
        //Set ProgressBar Value
        String inputText = editText.getText().toString();
        int progressValue = 0;
        if(inputText.isEmpty()){
            Toast.makeText(this, "Error en campo vacio", Toast.LENGTH_SHORT).show();
        }else{
            progressBar.setVisibility(View.VISIBLE);
            progressValue = Integer.parseInt(inputText);

            if (progressValue>=0 && progressValue<=100){
                try {
                    int finalProgressValue = progressValue;
                    new CountDownTimer(20000, 1){
                        int newProgress = 0;
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (newProgress == finalProgressValue) {
                                onFinish();
                            } else {
                                progressBar.setProgress(newProgress+1);
                                newProgress++;
                            }
                        }
                        @Override
                        public void onFinish() {}
                    }.start();
                }catch (Exception e){
                    Toast.makeText(this, "Error en el pb; error: "+e, Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Error en el rango", Toast.LENGTH_SHORT).show();
            }
        }

        // DatePicker Variables
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();

        // TimePicker Variables
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        // Fecha y Tiempo Actual
        /*String formattedDate = dateFormatter.format(calendar.getTime());
        String formattedTime = timeFormatter.format(calendar.getTime());*/

        String result = "Número ingresado: " + inputText + "\n" +
                        "Progreso: " + progressValue + "\n" +
                        "Fecha seleccionada: " + day + "/" + month + "/" + year + "\n" +
                        "Hora seleccionada: " + hour + ":" + minute + "\n"; /*+
                        "Fecha actual: " + formattedDate + "\n" +
                        "Hora actual: " + formattedTime;*/

        textViewResult.setText(result);
    }

    public void clearData(){
        progressBar.setProgress(0);
        editText.setText("");
        textViewResult.setText("");
        progressBar.setVisibility(View.GONE);
    }
}