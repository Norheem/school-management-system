package model;

import enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;

    @BeforeEach
    void studentMethod() {
        student = new Student(4, "Jane", "Doe", 22, Gender.FEMALE);
    }

    @Test
    void testStudentMethodId() {
        assertEquals(4, student.getId());
    }

    @Test
    void testStudentMethodFirstName() {
        assertEquals("Jane", student.getFirstName());
    }

    @Test
    void testStudentMethodLastName() {
        assertEquals("Doe", student.getLastName());
    }

    @Test
    void testStudentMethodAge() {
        assertEquals(22, student.getAge());
    }

    @Test
    void testStudentMethodGender() {
        assertEquals(Gender.FEMALE, student.getGender());
    }

}
