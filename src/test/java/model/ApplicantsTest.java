package model;

import enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantsTest {

    private Applicants applicants;

    @BeforeEach
    void applicantMethod() {
        applicants = new Applicants(10, "Segun", "Balogun", 19, Gender.MALE);
    }

    @Test
    void testApplicantMethodId() {
        assertEquals(10, applicants.getId());
    }

    @Test
    void testApplicantMethodFirstName() {
        assertEquals("Segun", applicants.getFirstName());
    }

    @Test
    void testApplicantMethodLastName() {
        assertEquals("Balogun", applicants.getLastName());
    }

    @Test
    void testApplicantMethodAge() {
        assertEquals(19, applicants.getAge());
    }

    @Test
    void testApplicantMethodGender() {
        assertEquals(Gender.MALE, applicants.getGender());
    }

}