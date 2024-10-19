package service.impl;

import enums.Gender;
import model.Classes;
import model.Course;
import model.Teacher;
import service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

    @Override
    public void teacherProfile(Teacher teacher, Course course) {
        System.out.println();
        System.out.println(
                "#########TEACHER'S INFO#########" + "\n" +
                        "Teacher ID : " + teacher.getId() + "\n" +
                        "Teacher Full Name : " + teacher.getFirstName() + " " + teacher.getLastName() + "\n" +
                        "Teacher Age : " + teacher.getAge() + "\n" +
                        "Teacher Gender : " + teacher.getGender() + "\n" +
                        "Teacher Salary : " + teacher.getSalary() + "\n" +
                        "Course Teaching : " + course.getCourseOffer()
        );
        System.out.println();
    }

    @Override
    public void role(Teacher teacher, Classes classes, Course course) {
        if (teacher.getGender() == Gender.MALE) {
            System.out.println("The role of Mr " + teacher.getFirstName() + " " + teacher.getLastName() + " is to teach the " + classes.getClassLevel() + " class " + course.getCourseOffer() +
                    " so that they will understand and improve their skills");
            System.out.println();
        } else {
            System.out.println("The role of Mrs " + teacher.getFirstName() + " " + teacher.getLastName() + " is to teach the " + classes.getClassLevel() + " class " + course.getCourseOffer() +
                    " so that they will understand and improve their skills");
            System.out.println();
        }
    }

}
