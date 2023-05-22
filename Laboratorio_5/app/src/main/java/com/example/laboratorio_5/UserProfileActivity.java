package com.example.laboratorio_5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserProfileActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CREATE_USER = 1;
    private ActivityResultLauncher<Intent> createUserLauncher;
    ListView lstUsers;
    UserAdapter adapterComp;

    private List<User> userList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        this.initControls();

        // Llama al método para configurar el createUserLauncher
        setupCreateUserLauncher();

        Bundle b = getIntent().getExtras();

        if (b != null && b.containsKey("userList")){
            LoadListview(b);
        }
    }

    private void setupCreateUserLauncher() {
        createUserLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            User newUser = data.getParcelableExtra("newUser");
                            if (newUser != null) {
                                userList.add(newUser);
                                adapterComp.notifyDataSetChanged();
                            }
                        }
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("userListUpdate", new ArrayList<>(userList));
        setResult(RESULT_OK, resultIntent);

        super.onBackPressed();
    }

    private void initControls() {
        lstUsers = (ListView)findViewById(R.id.lstUsers);
    }

    private void LoadListview(Bundle b) {
        userList = b.<User>getParcelableArrayList("userList");
        adapterComp = new UserAdapter(getApplicationContext(), userList);
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
            createUserLauncher.launch(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
