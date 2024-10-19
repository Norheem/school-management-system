package model;

import enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrincipalTest {
    
    private Principal principal;

    @BeforeEach
    void principalMethod() {
        principal = new Principal(1, "John", "Doe", 50, Gender.MALE, 50000);
    }

    @Test
    void testPrincipalMethodId() {
        assertEquals(1, principal.getId());
    }

    @Test
    void testPrincipalMethodFirstName() {
        assertEquals("John", principal.getFirstName());
    }

    @Test
    void testPrincipalMethodSecondName() {
        assertEquals("Doe", principal.getLastName());
    }

    @Test
    void testPrincipalMethodAge() {
        assertEquals(50, principal.getAge());
    }

    @Test
    void testPrincipalMethodGender() {
        assertEquals(Gender.MALE, principal.getGender());
    }

    @Test
    void testPrincipalMethodSalary() {
        assertEquals(50000, principal.getSalary());
    }

}