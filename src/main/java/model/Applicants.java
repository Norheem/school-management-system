package model;

import baseClass.Person;
import enums.Gender;

public class Applicants extends Person {

    public Applicants() {

        }


    public Applicants(int id, String firstName, String lastName, int age, Gender gender) {
        super(id, firstName, lastName, age, gender, 0);
    }

}
