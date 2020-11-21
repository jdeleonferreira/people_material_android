package com.example.peoplematerial;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Person> people = new ArrayList<>();

    public static void save(Person p){
        people.add(p);
    }

    public  static ArrayList<Person> getPeople(){
        return people;
    }
}
