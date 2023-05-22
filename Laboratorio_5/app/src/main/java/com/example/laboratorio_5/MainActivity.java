package com.example.laboratorio_5;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_CREATE_USER = 1;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initControls();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userValidation();
            }
        });
    }

    public void initControls() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        if(userList.isEmpty()){
            // Uso de variables estáticas para almacenar los datos de los usuarios
            userList.add(new User(R.drawable.profile_picture, "marck@gmail.com", "12345", "Marcos Ñurinda", "20-53-4479", "Laboratorio 5"));
            userList.add(new User(R.drawable.profile_picture, "nilsa@outlook.com", "12345", "Nilsa Correa", "8-123-456", "Laboratorio 5"));
            userList.add(new User(R.drawable.profile_picture, "leslie@gmail.com", "12345", "Leslie Moran", "4-987-6543", "Laboratorio 5"));
            userList.add(new User(R.drawable.profile_picture, "leidy@outlook.com", "12345", "Leidy Almeida", "8-345-622", "Laboratorio 5"));
        }
    }

    public void userValidation(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        // Implementacion de la lógica de autenticación
        // autenticación básica
        if (validateCredentials(email, password)) {
            Intent intent = new Intent(getApplicationContext(), UserProfileActivity.class);
            intent.putExtra("userList", new ArrayList<>(userList));
            startActivityForResult(intent, REQUEST_CODE_CREATE_USER);
        } else {
            Toast.makeText(MainActivity.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateCredentials(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true; // Credenciales válidas
            }
        }
        return false; // Credenciales inválidas
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CREATE_USER && resultCode == RESULT_OK && data != null) {
            ArrayList<User> updatedUserList = data.getParcelableArrayListExtra("userListUpdate");
            if (updatedUserList != null) {
                userList = updatedUserList;
            }
        }
    }

}













