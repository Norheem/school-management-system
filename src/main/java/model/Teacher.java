package model;

import baseClass.Person;
import enums.Gender;

public class Teacher extends Person {

    public Teacher(int id, String firstName, String lastName, int age, Gender gender, int salary) {
        super(id, firstName, lastName, age, gender, salary);
    }

    public Teacher() {
    }


}
