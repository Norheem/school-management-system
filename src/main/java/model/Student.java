package model;

import baseClass.Person;
import enums.Gender;

public class Student extends Person {

    public Student(int id, String firstName, String lastName, int age, Gender gender) {
        super(id, firstName, lastName, age, gender, 0);
    }


    public Student() {
    }


}
