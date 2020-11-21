package com.example.peoplematerial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class CreatePerson extends AppCompatActivity {
    private EditText id, name, lastName;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);

        id = findViewById(R.id.txtIdentification);
        name = findViewById(R.id.txtName);
        lastName = findViewById(R.id.txtLastName);
    }

    public void save(View v){
        String id, name, lastName, photoId;
        Person p;
        id = this.id.getText().toString();
        name = this.name.getText().toString();
        lastName = this.lastName.getText().toString();

        p = new Person(id,name,lastName,"");
        p.save();
        clear();

        Snackbar.make(v, "Person was save successfully!", Snackbar.LENGTH_LONG).show();

    }

    public void clear(View v){
        clear();
    }

    public void clear(){
        id.setText("");
        name.setText("");
        lastName.setText("");
    }
}