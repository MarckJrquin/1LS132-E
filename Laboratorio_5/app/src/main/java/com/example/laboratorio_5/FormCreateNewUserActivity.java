package com.example.laboratorio_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
            User newUser = new User(
                    R.drawable.profile_picture,
                    email.getText().toString(),
                    password.getText().toString(),
                    name.getText().toString(),
                    id.getText().toString(),
                    message.getText().toString()
            );

            Intent i = new Intent(getApplicationContext(), UserProfileActivity.class);
            i.putExtras(newUser.UserToBundle());
            startActivity(i);
        }catch (Exception e){}
    }
}