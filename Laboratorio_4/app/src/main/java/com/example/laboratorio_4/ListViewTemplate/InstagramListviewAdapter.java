package com.example.laboratorio_4.ListViewTemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laboratorio_4.R;

import java.util.ArrayList;
import java.util.List;

public class InstagramListviewAdapter extends ArrayAdapter<Chat>
{

    private  List<Chat> opciones = new ArrayList<>();

    public InstagramListviewAdapter(Context context, List<Chat> datos){
        super(context, R.layout.listview_layout_template, datos);
        opciones= datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_layout_template, null);

        ImageView lblImage = (ImageView) item.findViewById(R.id.profile_image);
        lblImage.setImageResource(opciones.get(position).getImage());

        TextView lblName = (TextView)item.findViewById(R.id.sender_name);
        lblName.setText(opciones.get(position).getName());

        TextView lblMessage = (TextView)item.findViewById(R.id.message_preview);
        lblMessage.setText(opciones.get(position).getMessage());

        TextView lblTime = (TextView)item.findViewById(R.id.timestamp);
        lblTime.setText(opciones.get(position).getTime());

        return(item);
    }
}
