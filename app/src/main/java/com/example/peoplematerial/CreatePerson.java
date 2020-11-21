package com.example.peoplematerial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class CreatePerson extends AppCompatActivity {
    private EditText identification, name, lastName;
    private ImageView photo;
    private Uri uri;
    private Person p;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);

        identification = findViewById(R.id.txtIdentification);
        name = findViewById(R.id.txtName);
        lastName = findViewById(R.id.txtLastName);
        photo = findViewById(R.id.imgSelectedPicture);

        storageReference = FirebaseStorage.getInstance().getReference();
    }

    public void save(View v){
        String identification, name, lastName, photoId, id;

        InputMethodManager imp = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        identification = this.identification.getText().toString();
        name = this.name.getText().toString();
        lastName = this.lastName.getText().toString();

        id = Data.getId();

        p = new Person(id,identification,name,lastName);
        p.save();
        updatePhoto(id);
        clear();
        imp.hideSoftInputFromWindow(this.identification.getWindowToken(),0);

        Snackbar.make(v, "Person was save successfully!", Snackbar.LENGTH_LONG).show();

    }

     public void updatePhoto(String id){
        StorageReference child = storageReference.child(id);
        UploadTask uploadTask = child.putFile(uri);
     }

    public void clear(View v){
        clear();
    }

    public void clear(){
        identification.setText("");
        name.setText("");
        lastName.setText("");
        photo.setImageResource(android.R.drawable.ic_menu_gallery);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(CreatePerson.this,MainActivity.class);
        startActivity(i);
    }

    public void selectPhoto(View v){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select a photo"),1);
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            uri = data.getData();
            if(uri != null) {
                photo.setImageURI(uri);
            }
        }
    }
}