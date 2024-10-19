package service.impl;

import model.Principal;
import service.PrincipalService;

public class PrincipalServiceImpl implements PrincipalService {

    @Override
    public void displayDetails(Principal principal) {
        System.out.println();
        System.out.println(
                "#########PRINCIPAL'S INFO#########" + "\n" +
                        "Principal ID : " + principal.getId() + "\n" +
                        "Principal Full Name : " + principal.getFirstName() + " " + principal.getLastName() + "\n" +
                        "Principal Age : " + principal.getAge() + "\n" +
                        "Principal Gender : " + principal.getGender() + "\n" +
                        "Principal Salary : " + principal.getSalary()
                );
        System.out.println();
    }

}


