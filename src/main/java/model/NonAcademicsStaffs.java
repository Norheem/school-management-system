package model;

import baseClass.Person;
import enums.Gender;


public class NonAcademicsStaffs extends Person {


    public NonAcademicsStaffs() {
    }

    public NonAcademicsStaffs(int id, String firstName, String lastName, int age, Gender gender, int salary) {
        super(id, firstName, lastName, age, gender, salary);
    }
    }


