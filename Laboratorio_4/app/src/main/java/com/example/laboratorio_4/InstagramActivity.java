package com.example.laboratorio_4;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laboratorio_4.ListViewTemplate.InstagramListviewAdapter;
import com.example.laboratorio_4.ListViewTemplate.Chat;

import java.util.ArrayList;
import java.util.List;

public class InstagramActivity extends AppCompatActivity {

    ListView lstOpciones;

    List<Chat> chats = new ArrayList<Chat>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        this.InitializeControls();
        //this.LoadListView();
        this.LoadListViewTemplate();
    }

    private void InitializeControls()
    {
        lstOpciones = (ListView)findViewById(R.id.lstOpciones);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada = ((Chat)a.getItemAtPosition(position)).getName();

                //Alternativa 2:
                //String opcionSeleccionada =
                //      ((TextView)v.findViewById(R.id.LblTitulo))
                //          .getText().toString();

                Toast.makeText(InstagramActivity.this,"Opción seleccionada: " + opcionSeleccionada, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void LoadListView()
    {
        List<String> opciones = this.GetElementsToListView();

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones);

        lstOpciones.setAdapter(adaptador);

    }

    private void LoadListViewTemplate()
    {
        List<Chat> opciones = this.GetElementsToListViewTemplate();

        InstagramListviewAdapter adapter = new InstagramListviewAdapter(this, opciones);

        lstOpciones.setAdapter(adapter);
    }

    private List<String> GetElementsToListView()
    {
        List<String> opciones = new ArrayList<String>();

        opciones.add("Parciales");
        opciones.add("Laboratorios");
        opciones.add("Quices");
        opciones.add("Practicas");
        opciones.add("Asistencia");
        opciones.add("Portafolio");

        return  opciones;

    }

    private List<Chat> GetElementsToListViewTemplate()
    {
        //List<Chat> opciones = new ArrayList<Chat>();

        chats.add(new Chat(R.drawable.profile_picture, "Edwin R. Arrocha", "Suerte", "11m"));
        chats.add(new Chat(R.drawable.profile_picture, "L. Marie 🍁", "HAHAHHAHAHAHA","24m"));
        chats.add(new Chat(R.drawable.profile_picture, "Coralia", "Reacted 🤣 to your message","1d"));
        chats.add(new Chat(R.drawable.profile_picture, "Sam", "1,385 ida y vuelta","1d"));
        chats.add(new Chat(R.drawable.profile_picture, "Alejandra 🐚", "Graciass graciass","5d"));

        return chats;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.newItem) {
            this.AgregarChat();
        }

        return super.onOptionsItemSelected(item);
    }

    private void AgregarChat() {
        chats.add(new Chat(R.drawable.profile_picture,"nuevo usuario","nuevo mensaje","1sec"));
        InstagramListviewAdapter adapter2 = new InstagramListviewAdapter(this,chats);
        lstOpciones.setAdapter(adapter2);
    }
}
