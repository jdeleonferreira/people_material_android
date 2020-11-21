package com.example.peoplematerial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        InputMethodManager imp = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        id = this.id.getText().toString();
        name = this.name.getText().toString();
        lastName = this.lastName.getText().toString();

        p = new Person(id,name,lastName,"");
        p.save();
        clear();
        imp.hideSoftInputFromWindow(this.id.getWindowToken(),0);

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

    public void onBackPressed(){
        finish();
        Intent i = new Intent(CreatePerson.this,MainActivity.class);
        startActivity(i);
    }
}