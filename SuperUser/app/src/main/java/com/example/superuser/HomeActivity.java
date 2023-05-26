package com.example.superuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView name, ID, age, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.initControllers();
        this.DataMapping();
    }

    private void initControllers() {
        name = (TextView) findViewById(R.id.lblName);
        ID = (TextView) findViewById(R.id.lblID);
        age = (TextView) findViewById(R.id.lblAge);
        username = (TextView) findViewById(R.id.lblUsername);
    }

    private void DataMapping(){
        try{
            SharedPreferences loggedUser = getSharedPreferences("login", Context.MODE_PRIVATE);

            name.setText(loggedUser.getString("name", ""));
            ID.setText(loggedUser.getString("ID", ""));
            age.setText(loggedUser.getString("age", ""));
            username.setText(loggedUser.getString("username", ""));
        } catch (Exception e){
            this.notify("Error => " + e.getMessage());
        }
    }

    public void Logout(View v){
        SharedPreferences loggedUser = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loggedUser.edit();

        editor.putString("name", "");
        editor.putString("ID", "");
        editor.putString("age", "");
        editor.putString("username", "");
        editor.putString("password", "");

        editor.commit();

        startActivity(new Intent(this, MainActivity.class));
    }

    private void notify(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}