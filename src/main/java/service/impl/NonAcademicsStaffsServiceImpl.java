package service.impl;

import enums.Gender;
import model.NonAcademicsStaffs;
import service.NonAcademicsStaffsService;

public class NonAcademicsStaffsServiceImpl implements NonAcademicsStaffsService {

    @Override
    public void displayNonAcademicsStaff(NonAcademicsStaffs nonAcademicsStaffs) {
        System.out.println();
        System.out.println(
                "#########NON ACADEMICS STAFF'S INFO DISPLAY#########" + "\n" +
                        "ID : " + nonAcademicsStaffs.getId() + "\n" +
                        "Full Name : " + nonAcademicsStaffs.getFirstName() + " " + nonAcademicsStaffs.getLastName() + "\n" +
                        "Age : " + nonAcademicsStaffs.getAge() + "\n" +
                        "Gender : " + nonAcademicsStaffs.getGender() + "\n" +
                        "Salary : " + nonAcademicsStaffs.getSalary()
                );
    }

    @Override
    public void role(NonAcademicsStaffs nonAcademicsStaff) {
        if (nonAcademicsStaff.getGender() == Gender.MALE) {
            System.out.println("The role of Mr " + nonAcademicsStaff.getFirstName() + " " + nonAcademicsStaff.getLastName() + " is to monitor the student when they aren't in class");
            System.out.println();
        } else {
            System.out.println("The role of Mrs " + nonAcademicsStaff.getFirstName() + " " + nonAcademicsStaff.getLastName() + " is to monitor the student when they aren't in class");
            System.out.println();
        }

    }
}
