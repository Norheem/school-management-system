package service;

import model.Classes;
import model.Course;
import model.Student;
import model.Teacher;

public interface ClassesService {

    void showClasses(Classes classes);

    void showTeacher(Teacher teacher, Classes classes, Course course);

    String showStudent(Student student, Classes classes, Course course);
}
