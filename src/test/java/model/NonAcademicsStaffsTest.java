package model;

import enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonAcademicsStaffsTest {

    private NonAcademicsStaffs nonAcademicsStaffs;

    @BeforeEach
    void nonAcademicsStaffsMethod() {
        nonAcademicsStaffs = new NonAcademicsStaffs(2, "Kenny", "Joy", 65, Gender.FEMALE, 20000);
    }

    @Test
    void testNonAcademicsStaffsMethodId() {
        assertEquals(2, nonAcademicsStaffs.getId());
    }

    @Test
    void testNonAcademicsStaffsMethodFirstName() {
        assertEquals("Kenny", nonAcademicsStaffs.getFirstName());
    }

    @Test
    void testNonAcademicsStaffsMethodLastName() {
        assertEquals("Joy", nonAcademicsStaffs.getLastName());
    }

    @Test
    void testNonAcademicsStaffsMethodAge() {
        assertEquals(65, nonAcademicsStaffs.getAge());
    }

    @Test
    void testNonAcademicsStaffsMethodGender() {
        assertEquals(Gender.FEMALE, nonAcademicsStaffs.getGender());
    }

    @Test
    void testNonAcademicsStaffsMethodSalary() {
        assertEquals(20000, nonAcademicsStaffs.getSalary());
    }

}