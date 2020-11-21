package com.example.peoplematerial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailPerson extends AppCompatActivity {

    private TextView lblIdValue, lblNameValue, lblLastNameValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);

        Bundle person = getIntent().getExtras();

        String p = person.getString("person");
        
        lblIdValue = findViewById(R.id.lblIdValue);
        lblNameValue = findViewById(R.id.lblNameValue);
        lblLastNameValue = findViewById(R.id.lblLastNameValue);


    }
}