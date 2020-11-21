package com.example.peoplematerial;

public class Person {
    private String id;
    private String identification;
    private String name;
    private String lastName;

    public Person(){}

    public Person(String id, String identification, String name, String lastName) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
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

    public void save(){
        Data.save(this);
    }

    public  void delete(){
        Data.delete(this);
    }
}
