package com.example.peoplematerial;

public class Person {
    private String id;
    private String name;
    private String lastName;
    private String photoId;

    public Person(String id, String name, String lastName, String photoId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.photoId = photoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public void save(){
        Datos.save(this);
    }
}
