package com.example.intentadvance.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.intentadvance.Models.Eventos;
import com.example.intentadvance.R;

import java.util.ArrayList;
import java.util.List;

public class EventosAdapter extends ArrayAdapter<Eventos> {

    List<Eventos> eventos = new ArrayList<>();

    public EventosAdapter(Context context, List<Eventos> datos) {
        super(context, R.layout.listview_eventos, datos);
        eventos = datos;
    }

    public View getView(int pos,View v, ViewGroup gv){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_eventos, null);

        TextView dia = (TextView)item.findViewById(R.id.lblDia);
        dia.setText(Integer.toString(eventos.get(pos).getDia()));

        TextView diaL = (TextView)item.findViewById(R.id.lblDiaL);
        diaL.setText(eventos.get(pos).getDiaL());

        TextView mes = (TextView)item.findViewById(R.id.lblMes);
        mes.setText(eventos.get(pos).getMes());

        TextView titulo = (TextView)item.findViewById(R.id.lblTitulo);
        titulo.setText(eventos.get(pos).getTitulo());

        TextView contenido = (TextView)item.findViewById(R.id.lblContenido);
        contenido.setText(eventos.get(pos).getContenido());

        TextView enlace = (TextView)item.findViewById(R.id.lblEnlace);
        enlace.setText(eventos.get(pos).getEnlace());

        return item;
    }
}
