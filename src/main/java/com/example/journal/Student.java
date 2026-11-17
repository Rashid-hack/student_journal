package com.example.journal;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int age;
    private transient String password;

    public Student(int id, String name, int age, String password){
        this.name = name;
        this.id= id;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Ad: " + name + ", Yas: " + age;
    }
}
