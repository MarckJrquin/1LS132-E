package com.example.laboratorio_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormCreateNewUserActivity extends AppCompatActivity {

    EditText email, password, name, id, message;
    Button buttonAddNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_create_new_user);
        this.initControls();

        buttonAddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void initControls() {
        email = (EditText) findViewById(R.id.editTextEmail);
        password = (EditText) findViewById(R.id.editTextPassword);
        name = (EditText) findViewById(R.id.editTextName);
        id = (EditText) findViewById(R.id.editTextID);
        message = (EditText) findViewById(R.id.editTextMessage);
        buttonAddNewUser = (Button) findViewById(R.id.buttonAddNewUser);
    }

    public void addUser(){
        try {
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();
            String userName = name.getText().toString();
            String userId = id.getText().toString();
            String userMessage = message.getText().toString();

            if (TextUtils.isEmpty(userEmail)) {
                email.setError("Ingrese un correo electrónico");
                return;
            }

            if (!isValidEmail(userEmail)) {
                email.setError("Ingrese un correo electrónico válido");
                return;
            }

            if (TextUtils.isEmpty(userPassword)) {
                password.setError("Ingrese una contraseña");
                return;
            }

            if (TextUtils.isEmpty(userName)) {
                name.setError("Ingrese un nombre");
                return;
            }

            if (TextUtils.isEmpty(userId)) {
                id.setError("Ingrese una cédula");
                return;
            }

            if (TextUtils.isEmpty(userMessage)) {
                message.setError("Ingrese un mensaje");
                return;
            }

            User newUser = new User( R.drawable.profile_picture, userEmail, userPassword, userName, userId, userMessage);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("newUser", newUser);
            setResult(RESULT_OK, resultIntent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isValidEmail(String email) {
        // Verificación de formato del correo electrónico usando una expresión regular
        // Uso de expresión regular predefinida de Android o personalizarla según necesidades
        // ejemplo básico:
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
}