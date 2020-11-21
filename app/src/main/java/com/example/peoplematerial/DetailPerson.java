package com.example.peoplematerial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class DetailPerson extends AppCompatActivity {
    private ImageView photo;
    private TextView lblIdValue, lblNameValue, lblLastNameValue;
    private Intent intent;
    private StorageReference storageReference;
    private Person p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);


        intent = getIntent();
        Bundle person = intent.getBundleExtra("person");

        lblIdValue = findViewById(R.id.lblIdValue);
        lblNameValue = findViewById(R.id.lblNameValue);
        lblLastNameValue = findViewById(R.id.lblLastNameValue);
        photo = findViewById(R.id.imgItemDetail);

        p = new Person(
                person.getString("id"),
                person.getString("identification"),
                person.getString("name"),
                person.getString("lastName")
        );

        storageReference = FirebaseStorage.getInstance().getReference();

        storageReference.child(p.getId()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(photo);
            }
        });

        lblIdValue.setText(p.getIdentification());
        lblNameValue.setText(p.getName());
        lblLastNameValue.setText(p.getLastName());

    }

    public void delete(View v){
        String positive, negative;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.strDeleteTitle);
        builder.setMessage(R.string.strDeletePersonMessage);
        positive = getString(R.string.strPositiveOption);
        negative = getString(R.string.strNegativeOption);

        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                p.delete();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DetailPerson.this, MainActivity.class);
        startActivity(intent);
    }
}