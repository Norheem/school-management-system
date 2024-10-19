package model;

import enums.CourseOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    private Course course;

    @BeforeEach
    void courseMethod() {
        course = new Course(CourseOffer.JAVA);
    }

    @Test
    void testCourseMethod() {
        assertEquals(CourseOffer.JAVA, course.getCourseOffer());
    }

}