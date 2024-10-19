package service;

import model.Classes;
import model.Course;
import model.Principal;
import model.Student;

public interface StudentService {

    void expelledStudent(Student student, Principal principal, Course course, String reason, String duration);

    void studentDetails(Student student, Course course, Classes classes);
}
