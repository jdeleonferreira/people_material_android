package com.example.peoplematerial;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Data {
    private static String db = "People";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static StorageReference storageReference = FirebaseStorage.getInstance().getReference();
    private static ArrayList<Person> people = new ArrayList<>();

    public static String getId(){
        return databaseReference.push().getKey();
    }
    public static void save(Person p){
        databaseReference.child(db).child(p.getIdentification()).setValue(p);
    }

    public static void  delete(Person p){
        databaseReference.child(db).child(p.getIdentification()).removeValue();
        storageReference.child(p.getId()).delete();
    }

    public static void setPeople(ArrayList<Person> people){
        people = people;
    }



}
