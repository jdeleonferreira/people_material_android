package com.example.peoplematerial;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnPersonClickListener {

    private RecyclerView list;
    private PersonAdapter adapter;
    private LinearLayoutManager llm;
    private ArrayList<Person> people;
    private DatabaseReference databaseReference;
    private String db = "People";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        list = findViewById(R.id.lstPeople);

        people = new ArrayList<Person>();
        llm = new LinearLayoutManager(this);
        adapter = new PersonAdapter(people, this);
        llm.setOrientation(RecyclerView.VERTICAL);

        list.setLayoutManager(llm);
        list.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                people.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        Person p = snapshot.getValue(Person.class);
                        people.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Data.setPeople(people);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void add(View v){
        Intent intent;
        intent = new Intent(MainActivity.this, CreatePerson.class);
        startActivity(intent);
    }

    @Override
    public void onPersonClick(Person p) {

        Intent intent = new Intent(MainActivity.this, DetailPerson.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", p.getId());
        bundle.putString("identification", p.getIdentification());
        bundle.putString("name", p.getName());
        bundle.putString("lastName", p.getLastName());
        intent.putExtra("person",bundle);
        startActivity(intent);
    }
}