package service.impl;

import enums.CourseOffer;
import model.Course;
import model.Student;
import model.Teacher;
import service.CourseService;

public class CourseServiceImpl implements CourseService {


    @Override
    public String givenCourse(Student student, Course course) {
        System.out.println();
        System.out.println(
                        "Student's ID : " + student.getId() + "\n" +
                        "Student's Full Name : " + student.getFirstName() + " " + student.getLastName() + "\n" +
                         "Student's Gender : " + student.getGender() + "\n" +
                        "Course Learning : " + course.getCourseOffer()
        );
        return course.getCourseOffer().name();
//        return "The student " + student.getFirstName() + " " + student.getLastName()
//                + " take " + course.getCourseOffer();
    }

    @Override
    public String teachCourse(Teacher teacher, Course course) {
        System.out.println();
        System.out.println(

                        "Teacher's ID : " + teacher.getId() + "\n" +
                        "Teacher's First Name : " + teacher.getFirstName() + " " +  teacher.getLastName() + "\n" +
                        "Teacher's Gender : " + teacher.getGender() + "\n" +
                        "Course Teaching : " + course.getCourseOffer()
        );
        return course.getCourseOffer().name();
//        return "The teacher " + teacher.getFirstName() + " " + teacher.getLastName()
//                + " teach " + course.getCourseOffer();
    }

    @Override
    public void showAllCourses(Course course) {
        System.out.println();
        System.out.println("This show thw classes we provide for our students");

        for (CourseOffer display : CourseOffer.values()) {
            System.out.println("- " + display);
        }
    }
}
