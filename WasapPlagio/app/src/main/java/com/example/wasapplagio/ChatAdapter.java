package com.example.wasapplagio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<Chats> {

    List<Chats> opciones;

    public ChatAdapter(Context context, List<Chats> datos){
        super(context, R.layout.listview_chats, datos);

        opciones = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_chats, null);

        TextView nombre = (TextView) item.findViewById(R.id.txtNombre);
        nombre.setText(opciones.get(position).getNombre());

        TextView chat = (TextView) item.findViewById(R.id.txtChat);
        chat.setText(opciones.get(position).getChat());

        TextView hora = (TextView) item.findViewById(R.id.txtHora);
        hora.setText(opciones.get(position).getHora());

        TextView count = (TextView) item.findViewById(R.id.txtChatCount);
        count.setText(opciones.get(position).getChatCount());

        ImageView foto = (ImageView) item.findViewById(R.id.imvFoto);
        foto.setImageAlpha(opciones.get(position).getFoto());

        return item;
    }
}
