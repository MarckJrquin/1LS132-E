package com.example.menuintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean  onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.miCall:
                Intent i = new Intent().setAction(Intent.ACTION_DIAL);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OpenBrowser(View v){
        Intent i = new Intent().setAction(Intent.ACTION_VIEW).setData(Uri.parse("https://utp.ac.pa/"));
        startActivity(i);
    }

    public void OpenDial(View v){
        Intent i = new Intent().setAction(Intent.ACTION_DIAL);
        startActivity(i);
    }

    public void MakeCall(View v){
        Intent i = new Intent().setAction(Intent.ACTION_CALL).setData(Uri.parse("tel:2365555"));
        startActivity(i);
    }

    public void OpenWS(View v){
        Intent i = new Intent().setAction(Intent.ACTION_VIEW).setPackage("com.whatsapp").setData(Uri.parse("https://api.whatsapp.com/send?phone=XXX"));
        startActivity(i);
    }

    public void OpenGaleria(View v){
        Intent i = new Intent().setAction(Intent.ACTION_VIEW).setType("image/*");
        startActivity(i);
    }

    public void OpenMail(View v){
        Intent i = new Intent().setAction(Intent.ACTION_VIEW).setData(Uri.parse("mailto:juan.zamora@utp.ac.pa"));
        startActivity(i);
    }

    public void OpenPlayer(View v){
        Intent i = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.google.android.music");
        startActivity(i);
    }

    public void OpenCamera(View v){
        Intent i = new Intent().setAction(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivityForResult(i,1);
        }
    }

    public void OpenSetup(View v){
        Intent i = new Intent().setAction(Settings.ACTION_DISPLAY_SETTINGS);
        startActivity(i);
    }

    public void OpenPlayStore(View v){
        Intent i = new Intent().setPackage("com.android.vending");
        startActivity(i);
    }

    public void ChangeActivity(View v){
        Intent i = new Intent(getApplicationContext(),TwoPackActivity.class);
        startActivity(i);
    }

    public void ChangeActivityWithData(View v){
        Intent i = new Intent(getApplicationContext(),ThreeActivity.class);
        i.putExtra("texto","ESTO VIENE DESDE EL PRIMERO ACTIVITY");
        startActivity(i);
    }

    public void ChangeActivityWithBundle(View v){

        Bundle b = new Bundle();
        b.putString("texto","ESTO VIENE DESDE EL PRIMERO ACTIVITY");

        Intent i = new Intent(getApplicationContext(),FourthActivity.class);
        i.putExtras(b);
        startActivity(i);
    }
}