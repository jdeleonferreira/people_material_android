package com.example.peoplematerial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{

    private ArrayList<Person> people;
    private OnPersonClickListener clickListener;

    public PersonAdapter(ArrayList<Person> people, OnPersonClickListener clickListener){
        this.people = people;
        this.clickListener = clickListener;
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
        holder.id.setText(p.getIdentification());
        holder.name.setText(p.getName());
        holder.lastName.setText(p.getLastName());

        holder.v.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                clickListener.onPersonClick(p);
            }
        });
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

    public interface OnPersonClickListener{
        void onPersonClick(Person p);
    }

}
