package com.example.peoplematerial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{

    private ArrayList<Person> people;

    public PersonAdapter(ArrayList<Person> people){
        this.people = people;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person,parent,false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person p = people.get(position);
        holder.id.setText(p.getId());
        holder.name.setText(p.getName());
        holder.lastName.setText(p.getLastName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView photo;
        private TextView id;
        private TextView name;
        private TextView lastName;
        private View v;

        public PersonViewHolder(View itemView) {
            super(itemView);
            this.v = itemView;
            photo = v.findViewById(R.id.imgItemPhoto);
            id = v.findViewById(R.id.lblItemId);
            name = v.findViewById(R.id.lblItemName);
            lastName = v.findViewById(R.id.lblItemLastName);
        }
    }


}
