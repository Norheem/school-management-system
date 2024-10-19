package service.impl;

import model.Applicants;
import model.Course;
import service.ApplicantService;

public class ApplicantsServiceImpl implements ApplicantService {
    @Override
    public void displayApplicantDetails(Applicants applicants) {
        System.out.println();
        System.out.println(
                        "Applicant's ID : " + applicants.getId() + "\n" +
                        "Applicant's Full Name: " + applicants.getFirstName() + " " + applicants.getLastName() + "\n" +
                        "Applicant's Age: " + applicants.getAge() + "\n" +
                        "Applicant's Gender: " + applicants.getGender());
    }

    @Override
    public void checkAdmissionStatus(Applicants applicants, Course course, String hasPaid) {

        /**
         *  The condition to check if an applicant is eligible for admission of not
         *      1. The applicants must be 18 years or above
         */


        if ((hasPaid.equals("yes")) && applicants.getAge() >= 18 ) {
            System.out.println("CONGRATULATIONS!!! " + applicants.getFirstName() + " " + applicants.getLastName() + " You have been offered provisional admission" +
                    " into Decagon Institute to study " + course.getCourseOffer());
        } else if ((hasPaid.equals("no")) && applicants.getAge() >= 18){
            System.out.println("CONGRATULATIONS!!! " + applicants.getFirstName() + " " + applicants.getLastName() + " You have been offered provisional admission " +
                    "into Decagon Institute to study " + course.getCourseOffer() + "." + "\n"
            + " However you are to make your payment before deadline, failure to do so, your admission will be terminated");
        } else if ((hasPaid.equals("yes")) && applicants.getAge() < 18){
            System.out.println("HI! " + applicants.getFirstName() + " " + applicants.getLastName() + " we regret to inform you that you have been denied " +
                    "admission into Decagon Institute for Learning." + "\n" +
                    "REASON : " + "\n" + "Below Age bracket. " + "\n" +
                    "REQUIRE AGE 18 AND ABOVE" + "\n" +
                    "click here for refund");
        } else {
            System.out.println("HI! " + applicants.getFirstName() + " " + applicants.getLastName() + " we regret to inform you that you have been denied admission this year, try again when you clock 18");
        }


    }
}
