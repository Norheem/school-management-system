package service;

import model.Applicants;
import model.Course;

public interface ApplicantService {

    void displayApplicantDetails(Applicants applicants);

    void checkAdmissionStatus(Applicants applicants, Course course, String hasPaid);
}
