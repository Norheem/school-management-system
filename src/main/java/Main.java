import enums.ClassLevel;
import enums.CourseOffer;
import enums.Gender;
import model.*;
import service.impl.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String desktopPath = System.getProperty("user.home") + "/Desktop/school.csv";
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();

        readAndWriteForTeacherAndStudent(desktopPath, teachers, students);

        System.out.println("Loaded Teachers : ");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

        System.out.println("\nLoaded Students: ");
        for (Student student : students) {
            System.out.println(student);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(desktopPath, true)) {
            Scanner scanner = new Scanner(System.in);

            String continueOption;
            int number;

            do {
                System.out.println("Welcome to Decagon Institute for Learning");
                System.out.println("1. Principal                          2. Teacher");
                System.out.println("3. Non-Academics Staffs               4. Students");
                System.out.println("5. Courses                             6. Classes");
                System.out.println("7. Applicants");
                System.out.println();
                System.out.println("Enter your category (1-7) :");
                number = scanner.nextInt();
                scanner.nextLine();

                if (number == 1) {

                    handlePrincipalInput(scanner);

                } else if (number == 2) {

                    Teacher teacher = handleTeacherInput(scanner, fileOutputStream);
                    teachers.add(teacher);

                } else if (number == 3) {

                    handleNonAcademicStaffInput(scanner);

                } else if (number == 4) {

                    Student student = handleStudentInput(scanner, fileOutputStream);
                    students.add(student);

                } else if (number == 5) {

                    handleCourseInput(scanner);


                } else if (number == 6) {

                    handleClassInput(scanner);

                } else if (number == 7) {

                    handleApplicantInput(scanner);

                } else {
                    System.out.println();
                    System.out.println("Invalid input");
                    System.out.println("Try from number (1-7) only");
                    System.out.println();
                }

                System.out.print("Do you want to perform another action? (yes/no): ");
                continueOption = scanner.nextLine().trim().toLowerCase();
            } while (continueOption.equals("yes"));

            System.out.println("\nThank you for using Decagon Institute System. Goodbye!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Teachers in the list: ");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

        System.out.println("Students in the list: ");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void handlePrincipalInput(Scanner scanner) {

        System.out.println("You are logging in as the principal");
        //Scanner userInput = new Scanner(System.in);

        // Prompt for ID
        System.out.print("Enter Principal's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        // Prompt for first Name
        System.out.print("Enter Principal's first name: ");
        String firstName = scanner.nextLine();

        // Prompt for last Name
        System.out.print("Enter Principal's's last name: ");
        String lastName = scanner.nextLine();

        // Prompt for age
        System.out.print("Enter Principal's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // Prompt for gender
        System.out.print("Enter Principal's gender (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        Gender gender;

        // Convert the input string to a Gender enum
        try {
            gender = Gender.valueOf(genderInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        // Prompt for salary
        System.out.print("Enter Principal's salary : ");
        int salary = scanner.nextInt();
        scanner.nextLine();


        Principal principal1 = new Principal(id, firstName, lastName, age, gender, salary);

        PrincipalServiceImpl principalData = new PrincipalServiceImpl();
        principalData.displayDetails(principal1);

    }

    private static Teacher handleTeacherInput(Scanner scanner, FileOutputStream fileOutputStream) throws IOException {

        String selectOption;

        System.out.println("You are logging in as the teacher");

        System.out.println();

        // Prompt for ID
        System.out.print("Enter Teacher's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Prompt for first Name
        System.out.print("Enter Teacher's first name: ");
        String firstName = scanner.nextLine();

        // Prompt for last Name
        System.out.print("Enter Teacher's last name: ");
        String lastName = scanner.nextLine();

        // Prompt for age
        System.out.print("Enter Teacher's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // Prompt for gender
        System.out.print("Enter Teacher's gender (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        Gender gender;

        // Convert the input string to a Gender enum
        try {
            gender = Gender.valueOf(genderInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        // Prompt for salary
        System.out.print("Enter Teacher's salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter course (e.g. JAVA, PYTHON, NODE, DOTNET, PHP, FLUTTER ) : ");
        String courseInput = scanner.nextLine();
        CourseOffer courseOffer;

        try {
            courseOffer = CourseOffer.valueOf(courseInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Enter class (e.g. BEGINNER, INTERMEDIATE, MASTER ) : ");
        String classInput = scanner.nextLine();
        ClassLevel classLevel;

        try {
            classLevel = ClassLevel.valueOf(classInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        do {
            System.out.println();
            System.out.println("What do you want to do? ");
            System.out.println("1. Check Teacher's Profile ");
            System.out.println("2. Check Teacher's Role ");

            int check;
            check = scanner.nextInt();
            scanner.nextLine();

            Teacher teacher1 = new Teacher(id, firstName, lastName, age, gender, salary);
            Course course1 = new Course(courseOffer);
            Classes class1 = new Classes(classLevel);


            TeacherServiceImpl teacherService = new TeacherServiceImpl();

            if (check == 1) {
                System.out.println("Welcome to Teacher's Profile Page");

                teacherService.teacherProfile(teacher1, course1);
            } else if (check == 2) {
                System.out.println();
                System.out.println("Page to Check Teacher's Role");

                teacherService.role(teacher1, class1, course1);
            } else {
                System.out.println("Invalid Input");
            }

            System.out.println("Do you want to perform another task? (yes/no): ");
            selectOption = scanner.nextLine().trim().toLowerCase();
        } while (selectOption.equals("yes"));
        System.out.println("\nGo to home page");

        // Save Teacher to CSV
        String header = "Teacher Id,Teacher First Name, Teacher Last Name, Teacher Age, Teacher Gender, Teacher Salary, Course Teaching, Class Teaching\n";
        fileOutputStream.write(header.getBytes());
        String teacherData =  id + ", " + firstName + ", " + lastName + ", " + age + ", " + gender + ", " + salary + ", " + courseOffer + ", " + classLevel + "\n";
        fileOutputStream.write(teacherData.getBytes());

        return new Teacher(id, firstName, lastName, age, gender, salary);

    }

    private static void handleNonAcademicStaffInput(Scanner scanner) {

        String selectOption;

        System.out.println("You are logging in as a non teaching staff");


        // Prompt for ID
        System.out.print("Enter Staff's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        // Prompt for first Name
        System.out.print("Enter Staff's first name: ");
        String firstName = scanner.nextLine();

        // Prompt for last Name
        System.out.print("Enter Staff's last name: ");
        String lastName = scanner.nextLine();

        // Prompt for age
        System.out.print("Enter Staff's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // Prompt for gender
        System.out.print("Enter Staff's gender (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        Gender gender;

        // Convert the input string to a Gender enum
        try {
            gender = Gender.valueOf(genderInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        // Prompt for salary
        System.out.print("Enter Staff's salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        NonAcademicsStaffs nonAcademicsStaffs1 = new NonAcademicsStaffs(id, firstName, lastName, age, gender, salary);

        NonAcademicsStaffsServiceImpl nonAcademicsStaffsDetails = new NonAcademicsStaffsServiceImpl();

        do {
            System.out.println();
            System.out.println("What do you want to do? ");
            System.out.println("1. Check Staff Profile ");
            System.out.println("2. Check Staff Role ");

            int check;
            check = scanner.nextInt();
            scanner.nextLine();

            if (check == 1) {
                System.out.println("Welcome to Staff Profile Page");

                nonAcademicsStaffsDetails.displayNonAcademicsStaff(nonAcademicsStaffs1);

            } else if (check == 2) {
                System.out.println();
                System.out.println("Page to Check Staff Role");

                nonAcademicsStaffsDetails.role(nonAcademicsStaffs1);
            } else {
                System.out.println("Invalid Input");
            }

            System.out.println("Do you want to perform another task? (yes/no): ");
            selectOption = scanner.nextLine().trim().toLowerCase();
        } while (selectOption.equals("yes"));
        System.out.println("\nGo to home page");
    }

    private static Student handleStudentInput(Scanner scanner, FileOutputStream fileOutputStream) throws IOException {

        String selectOption;

        System.out.println("This is student portal");


        // Prompt for ID
        System.out.print("Enter Student's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        // Prompt for first Name
        System.out.print("Enter Student's first name: ");
        String firstName = scanner.nextLine();

        // Prompt for last Name
        System.out.print("Enter Student's last name: ");
        String lastName = scanner.nextLine();

        // Prompt for age
        System.out.print("Enter Student's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // Prompt for gender
        System.out.print("Enter Student's gender (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        Gender gender;

        // Convert the input string to a Gender enum
        try {
            gender = Gender.valueOf(genderInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Enter Class (e.g. BEGINNER, INTERMEDIATE, MASTER ) : ");
        String classInput = scanner.nextLine();
        ClassLevel classLevel;

        try {
            classLevel = ClassLevel.valueOf(classInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }


        System.out.print("Enter course (e.g. JAVA, PYTHON, NODE, DOTNET, PHP, FLUTTER ) : ");
        String courseInput = scanner.nextLine();
        CourseOffer courseOffer;

        try {
            courseOffer = CourseOffer.valueOf(courseInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        // Prompt for first Name
        System.out.print("Enter Principal's first name: ");
        String principalFirstName = scanner.nextLine();

        // Prompt for last Name
        System.out.print("Enter Principal's last name: ");
        String principalLastName = scanner.nextLine();


        // Prompt for gender
        System.out.print("Enter Principal's gender (MALE/FEMALE): ");
        String principalGenderInput = scanner.nextLine();
        Gender principalGender;

        // Convert the input string to a Gender enum
        try {
            principalGender = Gender.valueOf(principalGenderInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }


        Student student = new Student(id, firstName, lastName, age, gender);

        Principal principal = new Principal(0, principalFirstName, principalLastName, 0, principalGender, 0);


        StudentServiceImpl studentData = new StudentServiceImpl();

        Course course = new Course(courseOffer);


        Classes classes = new Classes(classLevel);


        do {
            System.out.println("What do you want to do2? ");
            System.out.println("1. Check Student Profile ");
            System.out.println("2. Check Expelled Students");

            int check;
            check = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Welcome to Student Profile Page");

            if (check == 1) {
                System.out.println();
                studentData.studentDetails(student, course, classes);
            } else if (check == 2) {

                System.out.println("This page show details of the expelled student");

                System.out.println("Reason for Expulsion : ");
                String reason = scanner.nextLine();

                System.out.println("Duration for Expulsion : ");
                String duration = scanner.nextLine();

                studentData.expelledStudent(student, principal, course, reason, duration);

            } else {
                System.out.println();
                System.out.println("Invalid Input");
            }
            System.out.println("Do you want to perform another task? (yes/no): ");
            selectOption = scanner.nextLine().trim().toLowerCase();
        } while (selectOption.equals("yes"));
        System.out.println("\nGo to home page");


        // Save Student to CSV
        String header = "Student Id, Student First Name, Student Last Name, Student Age, Student Gender, Student Course, Student Class\n";
        fileOutputStream.write(header.getBytes());
        String studentInfo = id + ", " + firstName + ", " + lastName + ", " + age + ", " + gender + ",  " + courseOffer + ", " + classLevel + "\n";
        fileOutputStream.write(studentInfo.getBytes());

        return new Student(id, firstName, lastName, age, gender);
}

    private static void handleCourseInput(Scanner scanner) {

        String selectOption;

        System.out.println("You are in Course Details Page");

        do {

            System.out.println("What do you want to check? ");
            System.out.println("1. Check Course Given to Student ");
            System.out.println("2. Check Course Teacher Teaching");
            System.out.println("3. Show list of offered course ");

            int check;
            check = scanner.nextInt();
            scanner.nextLine();


            if (check == 1) {
                System.out.println("Welcome to Student Course Page");


                // Prompt for ID
                System.out.print("Enter Student's ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                // Prompt for first Name
                System.out.print("Enter Student's first name: ");
                String firstName = scanner.nextLine();

                // Prompt for last Name
                System.out.print("Enter Student's last name: ");
                String lastName = scanner.nextLine();

                // Prompt for gender
                System.out.print("Enter Staff's gender (MALE/FEMALE): ");
                String genderInput = scanner.nextLine();
                Gender gender;

                // Convert the input string to a Gender enum
                try {
                    gender = Gender.valueOf(genderInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }


                System.out.print("Enter course (e.g. JAVA, PYTHON, NODE, DOTNET, PHP, FLUTTER ) : ");
                String courseInput = scanner.nextLine();
                CourseOffer courseOffer;

                try {
                    courseOffer = CourseOffer.valueOf(courseInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }

                Student student = new Student(id, firstName, lastName, 0, gender);
                Course course = new Course(courseOffer);
                CourseServiceImpl studentCourseDetail = new CourseServiceImpl();
                studentCourseDetail.givenCourse(student, course);
            } else if (check == 2) {
                System.out.println("Welcome to Teacher's Learning Page");

                Scanner userInput = new Scanner(System.in);

                // Prompt for ID
                System.out.print("Enter Teacher's ID: ");
                int id = userInput.nextInt();
                userInput.nextLine();

                // Prompt for first Name
                System.out.print("Enter Teacher's first name: ");
                String firstName = userInput.nextLine();

                // Prompt for last Name
                System.out.print("Enter Teacher's last name: ");
                String lastName = userInput.nextLine();

                // Prompt for gender
                System.out.print("Enter Teacher's gender (MALE/FEMALE): ");
                String genderInput = userInput.nextLine();
                Gender gender;

                // Convert the input string to a Gender enum
                try {
                    gender = Gender.valueOf(genderInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }

                System.out.print("Enter course (e.g. JAVA, PYTHON, NODE, DOTNET, PHP, FLUTTER ) : ");
                String courseInput = scanner.nextLine();
                CourseOffer courseOffer;

                try {
                    courseOffer = CourseOffer.valueOf(courseInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }

                Course course = new Course(courseOffer);
                Teacher teacher = new Teacher(id, firstName, lastName, 0, gender, 0);

                CourseServiceImpl teacherCourseTeaching = new CourseServiceImpl();

                teacherCourseTeaching.teachCourse(teacher, course);
            } else if (check == 3) {

                System.out.println("You are about to view all courses in our school.");
                Course course = new Course();

                CourseServiceImpl showCourseList = new CourseServiceImpl();

                System.out.println("Do you want to display all available courses? (yes/no): ");
                String displayOption = scanner.nextLine().trim().toLowerCase();
                System.out.println();

                // Display classes if the user says 'yes'
                if (displayOption.equals("yes")) {
                    System.out.println("LOADING...");
                    showCourseList.showAllCourses(course);
                }

            } else {
                System.out.println("Invalid Input");
            }


            System.out.println("Do you want to perform another task? (yes/no): ");
            selectOption = scanner.nextLine().trim().toLowerCase();
        } while (selectOption.equals("yes"));
        System.out.println("\nGo to home page");
    }

    private static void handleClassInput(Scanner scanner) {

        String selectOption;

        System.out.println("You are in Class Details Page");

        do {
            System.out.println("What do you want to check? ");
            System.out.println("1. Check Class Teacher is teaching ");
            System.out.println("2. Check Class Student Belong");
            System.out.println("3. Show list of classes ");

            int check;
            check = scanner.nextInt();
            scanner.nextLine();

            if (check == 1) {
                System.out.println("You are about to check the class the teacher is teaching");

                // Prompt for ID
                System.out.print("Enter Teacher's ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                // Prompt for first Name
                System.out.print("Enter Teacher's first name: ");
                String firstName = scanner.nextLine();

                // Prompt for last Name
                System.out.print("Enter Teacher's last name: ");
                String lastName = scanner.nextLine();

                // Prompt for gender
                System.out.print("Enter Teacher's gender (MALE/FEMALE): ");
                String genderInput = scanner.nextLine();
                Gender gender;

                // Convert the input string to a Gender enum
                try {
                    gender = Gender.valueOf(genderInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }

                System.out.print("Enter course (e.g. JAVA, PYTHON, NODE, DOTNET, PHP, FLUTTER ) : ");
                String courseInput = scanner.nextLine();
                CourseOffer courseOffer;

                try {
                    courseOffer = CourseOffer.valueOf(courseInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }

                System.out.print("Enter Class (e.g. BEGINNER, INTERMEDIATE, MASTER ) : ");
                String classInput = scanner.nextLine();
                ClassLevel classLevel;

                try {
                    classLevel = ClassLevel.valueOf(classInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }

                Teacher teacher = new Teacher(id, firstName, lastName, 0, null, 0);
                Course course = new Course(courseOffer);
                Classes class1 = new Classes(classLevel);

                ClassesServiceImpl classesService = new ClassesServiceImpl();

                classesService.showTeacher(teacher, class1, course);
            } else if (check == 2) {

                System.out.println();

                System.out.println("You are about to check the class the student belong ");

                Scanner userInput = new Scanner(System.in);

                // Prompt for ID
                System.out.print("Enter Student's ID: ");
                int id = userInput.nextInt();
                userInput.nextLine();  // Consume newline left-over

                // Prompt for first Name
                System.out.print("Enter Student's first name: ");
                String firstName = userInput.nextLine();

                // Prompt for last Name
                System.out.print("Enter Student's last name: ");
                String lastName = userInput.nextLine();

                System.out.print("Enter Class (e.g. BEGINNER, INTERMEDIATE, MASTER ) : ");
                String classInput = scanner.nextLine();
                ClassLevel classLevel;

                try {
                    classLevel = ClassLevel.valueOf(classInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }


                System.out.print("Enter course (e.g. JAVA, PYTHON, NODE, DOTNET, PHP, FLUTTER ) : ");
                String courseInput = scanner.nextLine();
                CourseOffer courseOffer;

                try {
                    courseOffer = CourseOffer.valueOf(courseInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }

                Student student = new Student(id, firstName, lastName, 0, null);
                Course course = new Course(courseOffer);
                Classes classes = new Classes(classLevel);

                ClassesServiceImpl classesService = new ClassesServiceImpl();

                classesService.showStudent(student, classes, course);

            } else if (check == 3) {
                System.out.println("You are about to view all classes in our school.");
                Classes classes = new Classes();
                ClassesServiceImpl showClassList = new ClassesServiceImpl();

                System.out.println("Do you want to display all available classes? (yes/no): ");
                String displayOption = scanner.nextLine().trim().toLowerCase();

                // Display classes if the user says 'yes'
                if (displayOption.equals("yes")) {
                    System.out.println("LOADING...");
                    showClassList.showClasses(classes);
                }
            } else {
                System.out.println("Invalid input");
            }

            System.out.println("Do you want to perform another task? (yes/no): ");
            selectOption = scanner.nextLine().trim().toLowerCase();
        } while (selectOption.equals("yes"));
        System.out.println("\nGo to home page");
    }

    private static void handleApplicantInput(Scanner scanner) {

        String selectOption;

        System.out.println("Applicants page...");

        // Prompt for ID
        System.out.print("Enter Applicant's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        // Prompt for first Name
        System.out.print("Enter Applicant's first name: ");
        String firstName = scanner.nextLine();

        // Prompt for last Name
        System.out.print("Enter Applicant's's last name: ");
        String lastName = scanner.nextLine();

        // Prompt for age
        System.out.print("Enter Applicant's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // Prompt for gender
        System.out.print("Enter Applicant's gender (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        Gender gender;

        // Convert the input string to a Gender enum
        try {
            gender = Gender.valueOf(genderInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }


        System.out.print("Enter course (e.g. JAVA, PYTHON, NODE, DOTNET, PHP, FLUTTER ) : ");
        String courseInput = scanner.nextLine();
        CourseOffer courseOffer;

        try {
            courseOffer = CourseOffer.valueOf(courseInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        Applicants applicants = new Applicants(id, firstName, lastName, age, gender);

        ApplicantsServiceImpl applicantData = new ApplicantsServiceImpl();

        Course course = new Course(courseOffer);

        do {
            System.out.println("What do you want to do? ");
            System.out.println("1. Check Applicant's Data");
            System.out.println("2. Check Applicant's Admission status");

            int check;
            check = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Welcome to Applicant Page");

            if (check == 1) {
                System.out.println();
                applicantData.displayApplicantDetails(applicants);
            } else if (check == 2) {
                System.out.println();
                System.out.println("Have you pay the acceptance fee? (yes/no)");
                String hasPaid = scanner.nextLine().toLowerCase();
                applicantData.checkAdmissionStatus(applicants, course, hasPaid);
            } else {
                System.out.println();
                System.out.println("Invalid Input");
            }
            System.out.println("Do you want to perform another task? (yes/no): ");
            selectOption = scanner.nextLine().trim().toLowerCase();
        } while (selectOption.equals("yes"));
        System.out.println("\nGo to home page");
    }


    private static void readAndWriteForTeacherAndStudent(String filePath, ArrayList<Teacher> teachers, ArrayList<Student> students) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("Teacher")) {
                    // Create a Teacher object and add to ArrayList
                    int id = Integer.parseInt(data[1].trim());
                    String firstName = data[2].trim();
                    String lastName = data[3].trim();
                    int age = Integer.parseInt(data[4].trim());
                    Gender gender = Gender.valueOf(data[5].trim().toUpperCase());
                    int salary = Integer.parseInt(data[6].trim());
                    CourseOffer courseOffer = CourseOffer.valueOf(data[7].trim().toUpperCase());
                    ClassLevel classLevel = ClassLevel.valueOf(data[8].trim().toUpperCase());

                    Teacher teacher = new Teacher(id, firstName, lastName, age, gender, salary);
                    teachers.add(teacher);
                } else if (data[0].equals("Student")) {
                    // Create a Student object and add to ArrayList
                    int id = Integer.parseInt(data[1].trim());
                    String firstName = data[2].trim();
                    String lastName = data[3].trim();
                    int age = Integer.parseInt(data[4].trim());
                    Gender gender = Gender.valueOf(data[5].trim().toUpperCase());
                    CourseOffer courseOffer = CourseOffer.valueOf(data[6].trim().toUpperCase());
                    ClassLevel classLevel = ClassLevel.valueOf(data[7].trim().toUpperCase());

                    Student student = new Student(id, firstName, lastName, age, gender);
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}