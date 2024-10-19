package service.impl;

import enums.Gender;
import model.Classes;
import model.Course;
import model.Principal;
import model.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public void expelledStudent(Student student, Principal principal, Course course, String reason, String duration) {
       if (principal.getGender() == Gender.MALE) {
           System.out.println();
           System.out.println("#########EXPELLED STUDENT'S INFO#########");
           System.out.println("Student ID : " + student.getId());
           System.out.println("Student Full Name : " + student.getFirstName() + " " + student.getLastName());
           System.out.println("Reason for Expulsion : " + reason);
           System.out.println("Student Expulsion Duration : " + duration);
           System.out.println("Expelled By : " + "Mr " + principal.getFirstName() + " " + principal.getLastName() + " the school principal");
       } else {
           System.out.println();
           System.out.println("#########EXPELLED STUDENT'S INFO#########");
           System.out.println("Student ID : " + student.getId());
           System.out.println("Student Full Name : " + student.getFirstName() + " " + student.getLastName());
           System.out.println("Reason for Expulsion : " + reason);
           System.out.println("Student Expulsion Duration : " + duration);
           System.out.println("Expelled By : " + "Mrs " + principal.getFirstName() + " " + principal.getLastName() + " the school principal");
       }
    }


    @Override
    public void studentDetails(Student student, Course course, Classes classes) {
        System.out.println();
        System.out.println("######### STUDENT'S PROFILE #########");
        System.out.println("Student ID : " + student.getId() + "\n" +
                "Student Full Name : " + student.getFirstName() + " " + student.getLastName() + "\n" +
                "Student Age : " + student.getAge() + "\n" +
                "Student Gender : " + student.getGender() + "\n" +
                "Student Class " + classes + "\n" +
                "Course Studying : " + course.getCourseOffer()

        );
        System.out.println();
    }



}
