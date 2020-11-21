package com.example.peoplematerial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPerson extends AppCompatActivity {
    private ImageView photo;
    private TextView lblIdValue, lblNameValue, lblLastNameValue;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);

        intent = getIntent();
        Bundle person = intent.getBundleExtra("person");

        lblIdValue = findViewById(R.id.lblIdValue);
        lblNameValue = findViewById(R.id.lblNameValue);
        lblLastNameValue = findViewById(R.id.lblLastNameValue);

        lblIdValue.setText(person.getString("id"));
        lblNameValue.setText(person.getString("name"));
        lblLastNameValue.setText(person.getString("lastName"));

    }
}