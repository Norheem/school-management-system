package service;

import model.Classes;
import model.Course;
import model.Teacher;

public interface TeacherService {

    void teacherProfile(Teacher teacher, Course course);

    void role(Teacher teacher, Classes classes, Course course);
}
