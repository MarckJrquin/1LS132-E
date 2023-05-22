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
    ListView lstUsers;
    UserAdapter adapterComp;
    private List<User> userList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        this.initControls();

        Bundle b = getIntent().getExtras();

        if (b != null && b.containsKey("userList")){
            LoadListview(b);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CREATE_USER && resultCode == RESULT_OK && data != null) {
            User newUser = data.getParcelableExtra("newUser");
            if (newUser != null) {
                userList.add(newUser);
                if (adapterComp != null) {
                    adapterComp.notifyDataSetChanged();

                    ArrayList<User> updatedUserList = data.getParcelableArrayListExtra("userListUpdate");
                    if (updatedUserList != null && !updatedUserList.isEmpty()) {
                        userList = updatedUserList;
                    }
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (userList != null && !userList.isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("userListUpdate", new ArrayList<>(userList));
            setResult(RESULT_OK, resultIntent);
        }
        super.onBackPressed();
    }

    private void initControls() {
        lstUsers = (ListView)findViewById(R.id.lstUsers);
    }

    private void LoadListview(Bundle bundle) {
        userList = bundle.getParcelableArrayList("userList");
        if (userList != null && !userList.isEmpty()) {
            adapterComp = new UserAdapter(getApplicationContext(), userList);
            lstUsers.setAdapter(adapterComp);
        }
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
            Intent intent = new Intent(getApplicationContext(), FormCreateNewUserActivity.class);
            startActivityForResult(intent, REQUEST_CODE_CREATE_USER);
        }
        return super.onOptionsItemSelected(item);
    }
}
