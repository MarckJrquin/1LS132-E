package com.example.laboratorio_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    List<User> userList;

    public UserAdapter(Context context, List<User> users){
        super(context, R.layout.listview_users, users);
        userList = users;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_users, null);

        ImageView image = (ImageView) item.findViewById(R.id.imageViewProfilePhoto);
        image.setImageAlpha(userList.get(position).getImage());

        TextView email = (TextView) item.findViewById(R.id.textViewEmail);
        email.setText(userList.get(position).getEmail());

        TextView name = (TextView) item.findViewById(R.id.textViewName);
        name.setText(userList.get(position).getName());

        TextView id = (TextView) item.findViewById(R.id.textViewID);
        id.setText(userList.get(position).getId());

        TextView message = (TextView) item.findViewById(R.id.textViewMessage);
        message.setText(userList.get(position).getMessage());

        return item;
    }

}
