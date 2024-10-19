package model;

import enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private Teacher teacher;

    @BeforeEach
    void teacherMethod() {
        teacher = new Teacher(12, "Ayo", "Lekan", 20, Gender.MALE, 2000);
    }
    @Test
    void testTeacherMethodId() {
        assertEquals(12, teacher.getId());
    }

    @Test
    void testTeacherMethodFirstName() {
        assertEquals("Ayo", teacher.getFirstName());

    }

    @Test
    void testTeacherMethodLastName() {
        assertEquals("Lekan", teacher.getLastName());
    }

    @Test
    void testTeacherMethodAge() {
        assertEquals(20, teacher.getAge());
    }

    @Test
    void testTeacherMethodGender() {
        assertEquals(Gender.MALE, teacher.getGender());
    }

    @Test
    void testTeacherMethodSalary() {
        assertEquals(2000, teacher.getSalary());
    }
}