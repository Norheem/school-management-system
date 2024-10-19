package service.impl;

import enums.ClassLevel;
import model.Classes;
import model.Course;
import model.Student;
import model.Teacher;
import service.ClassesService;

public class ClassesServiceImpl implements ClassesService {
    @Override
    public void showClasses(Classes classes) {
        System.out.println("This show thw classes we provide for our students");

        for (ClassLevel display : ClassLevel.values()) {
            System.out.println("- " + display);
        }

    }

    @Override
    public void showTeacher(Teacher teacher, Classes classes, Course course) {
        System.out.println();
        System.out.println("The following are the classes the teacher is taken and course assigned for the teacher ");
        System.out.println("Teacher's ID : " + teacher.getId());
        System.out.println("Teacher's Full Name : " + teacher.getFirstName() + " " + teacher.getLastName());
        System.out.println("Course Teaching : " + course.getCourseOffer());
        System.out.println("Class Teaching : " + classes.getClassLevel());
    }

    @Override
    public String showStudent(Student student, Classes classes, Course course) {
        System.out.println();
        System.out.println("The following are the classes the teacher is taken and course assigned for the teacher ");
        System.out.println("Student's ID : " + student.getId());
        System.out.println("Student's Full Name : " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Course Learning : " + course.getCourseOffer());
        System.out.println("Present Class Level : " + classes.getClassLevel());

        return classes.getClassLevel().name();
    }

}
