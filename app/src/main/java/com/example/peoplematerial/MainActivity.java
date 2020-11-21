package com.example.peoplematerial;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;
    private PersonAdapter adapter;
    private LinearLayoutManager llm;
    private ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        list = findViewById(R.id.lstPeople);
        people = Datos.getPeople();
        llm = new LinearLayoutManager(this);
        adapter = new PersonAdapter(people);
        llm.setOrientation(RecyclerView.VERTICAL);

        list.setLayoutManager(llm);
        list.setAdapter(adapter);
    }

    public void add(View v){
        Intent intent;
        intent = new Intent(MainActivity.this, CreatePerson.class);
        startActivity(intent);
        //finish();
    }
}