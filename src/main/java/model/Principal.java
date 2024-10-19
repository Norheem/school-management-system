package model;

import baseClass.Person;
import enums.Gender;

public class Principal extends Person {


    public Principal() {
    }

    public Principal(int id, String firstName, String lastName, int age, Gender gender, int salary) {
        super(id, firstName, lastName, age, gender, salary);
    }



}
