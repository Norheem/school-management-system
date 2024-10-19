package model;

import enums.ClassLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassesTest {

    private Classes classes;

    @BeforeEach
    void classesMethod() {
        classes = new Classes(ClassLevel.BEGINNER);
    }

    @Test
    void testClassMethodLevel() {
        assertEquals(ClassLevel.BEGINNER, classes.getClassLevel());
    }

}