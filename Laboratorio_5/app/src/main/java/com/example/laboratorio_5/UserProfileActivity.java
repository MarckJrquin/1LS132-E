package com.example.laboratorio_5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class UserProfileActivity extends AppCompatActivity {

    ListView lstUsers;
    UserAdapter adapterComp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        this.initControls();

        Bundle b = getIntent().getExtras();
        if (b != null){
            LoadListviewBundle(b);
        }else {
            LoadListview();
        }
    }

    private void initControls() {
        lstUsers = (ListView)findViewById(R.id.lstUsers);
    }

    private void LoadListviewBundle(Bundle b) {

        User user = new User().restoreBundle(b);
        List<User> users = this.LlenarListViewCompuesto();
        users.add(user);

        adapterComp = new UserAdapter(getApplicationContext(), users);
        lstUsers.setAdapter(adapterComp);
    }

    private void LoadListview() {
        adapterComp = new UserAdapter(getApplicationContext(), this.LlenarListViewCompuesto());
        lstUsers.setAdapter(adapterComp);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.createNewUser) {
            Intent i = new Intent(getApplicationContext(), FormCreateNewUserActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    private List<User> LlenarListViewCompuesto(){
        List<User> users = new ArrayList<User>();
        users.add(new User(R.drawable.profile_picture, "marck@gmail.com", "12345", "Marcos Ñurinda", "20-53-4479", "Laboratorio 5"));
        users.add(new User(R.drawable.profile_picture, "nilsa@outlook.com", "12345", "Nilsa Correa", "8-123-456", "Laboratorio 5"));
        users.add(new User(R.drawable.profile_picture, "leslie@gmail.com", "12345", "Leslie Moran", "4-987-6543", "Laboratorio 5"));
        users.add(new User(R.drawable.profile_picture, "leidy@outlook.com", "12345", "Leidy Almeida", "8-345-622", "Laboratorio 5"));
        return users;
    }
}
