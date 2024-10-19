package service;

import model.Course;
import model.Student;
import model.Teacher;

public interface CourseService {

    String givenCourse(Student student, Course course);

    String teachCourse(Teacher teacher, Course course);

    void showAllCourses(Course course);
}
