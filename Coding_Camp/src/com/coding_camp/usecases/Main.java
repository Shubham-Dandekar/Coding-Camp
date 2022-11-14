package com.coding_camp.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.coding_camp.dao.AdministratorDao;
import com.coding_camp.dao.AdministratorDaoImpl;
import com.coding_camp.dao.CourseDao;
import com.coding_camp.dao.CourseDaoImpl;
import com.coding_camp.dao.StudentDao;
import com.coding_camp.dao.StudentDaoImpl;
import com.coding_camp.exceptions.AdminException;
import com.coding_camp.exceptions.CourseException;
import com.coding_camp.exceptions.StudentException;
import com.coding_camp.model.Administrator;
import com.coding_camp.model.Course;
import com.coding_camp.model.Student;
import com.coding_camp.model.StudentCourseDTO;

public class Main {

    static int primaryKey;

    static boolean flag = true;

    public static void main(String[] args) {

        System.out.println("+--------------------------------------------------+");
        System.out.println("|           🏫 Welcome to Coding Camp 🏫           |");

        welcomeScreen();
    }

    private static void welcomeScreen() {
        Scanner scan = new Scanner(System.in);

        System.out.println("+--------------------------------------------------+");
        System.out.println("\nEnter numbers to perform actions.\n");

        System.out.println("1. Adminstrator");
        System.out.println("2. Student");
        System.out.println("0. Exit");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();

        switch (choice) {
            case 0:
                System.out.println("\nThank you for visiting Coding Camp,\nHave a great day...❤️❤️");
                break;

            case 1:

                System.out.println("\n+--------------------------------------------------+");
                System.out.println("\nWelcome to Administrstor Page\n");
                adminChoice();
                break;

            case 2:
                System.out.println("\n+--------------------------------------------------+");
                System.out.println("\nWelcome to Student Page\n");
                studentChoice();
                break;

            default:
                System.out.println("\nYou have entered wrong choice, try again...");
                break;
        }
    }

    private static void adminChoice() {
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Admistrator LogIn");
        System.out.println("0. Go to main page");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                welcomeScreen();
                break;

            case 1:
                System.out.println("Enter Administrstor's credentials to LogIn\n");
                String user = "admin";
                login(user);
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }

    private static void studentChoice() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Register a new student");
        System.out.println("2. Student LogIn");
        System.out.println("0. Go to main page");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                welcomeScreen();
                break;

            case 1:
                registerNewStudent();
                break;

            case 2:
                System.out.println("Enter Student's credentials to LogIn\n");
                String user = "student";
                login(user);
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }

    private static void login(String user) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = scan.next();
        System.out.print("Enter your password: ");
        String password = scan.next();

        if (user == "student") {
            StudentDao stdDao = new StudentDaoImpl();

            try {
                primaryKey = stdDao.studentLogIn(email, password);

                if (primaryKey == -1) {
                    System.out.println("Bad credentials...");

                    studentChoice();

                } else {
                    String name = stdDao.getStudentFirstName(primaryKey);
                    System.out.println("\n+--------------------------------------------------+\n");
                    System.out.println("Welcome " + name + ",\n");
                    while (flag) {
                        studentMenu();
                    }
                }
            } catch (StudentException e) {
                e.printStackTrace();
            }
        } else if (user == "admin") {
            AdministratorDao adminDao = new AdministratorDaoImpl();

            try {
                primaryKey = adminDao.AdminLogIn(email, password);

                if (primaryKey == -1) {
                    System.out.println("Bad credentials...");

                    adminChoice();

                } else {
                    String name = adminDao.getAdminFirstName(primaryKey);
                    System.out.println("\n+--------------------------------------------------+\n");
                    System.out.println("Welcome " + name + ",\n");
                    while (flag) {
                    	adminMenu();
                    }
                }
            } catch (AdminException e) {
                e.printStackTrace();
            }
        }
    }

    private static void studentMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Show student details");
        System.out.println("2. Edit student details");
        System.out.println("3. Show password");
        System.out.println("4. Change password");
        System.out.println("5. Enroll for new course");
        System.out.println("0. SignOut");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                flag = false;
                System.out.println("\nThank you for visiting Coding Camp,\nHave a great day...❤️❤️");
                System.exit(0);
                break;

            case 1:
                showStudentDetails();
                break;

            case 2:
                changeStudentMenu();
                break;

            case 3:
                getStudentPassword();
                break;

            case 4:
                changeStudentPassword();
                break;

            case 5:
                try {
                    registerStudentNewCourse();
                } catch (CourseException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }

    private static void changeStudentMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Change student's first name");
        System.out.println("2. Change student's last name");
        System.out.println("3. Change student's father name");
        System.out.println("4. Change student's mother name");
        System.out.println("5. Change student's gender");
        System.out.println("6. Change student's date of birth");
        System.out.println("7. Change student's address");
        System.out.println("8. Change student's contact no");
        System.out.println("0. Go back");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                studentMenu();
                break;

            case 1:
                changeStudentFirstName();
                break;

            case 2:
                changeStudentLastName();
                break;

            case 3:
                changeStudentFatherName();
                break;

            case 4:
                changeStudentMotherName();
                break;

            case 5:
                changeStudentGender();
                break;

            case 6:
                changeStudentDateOfBirth();
                break;

            case 7:
                changeStudentAddress();
                break;

            case 8:
                changeStudentContactNo();
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }

    private static void showStudentDetails() {
        StudentDao stdDao = new StudentDaoImpl();

        try {
            StudentCourseDTO students;
            try {
                students = stdDao.showStudentDetails(primaryKey);

                System.out.println("+--------------+------------+------------+-------------+-------------+"
                        + "--------+---------------+-----------------+------------+-----------------------"
                        + "---------+\n| Student_Code | First_Name | Last_Name  | Father_Name | Mother_Nam"
                        + "e | Gender | Date_Of_Birth | Address         | Contact_No | Email              "
                        + "            |\n+--------------+------------+------------+-------------+--------"
                        + "-----+--------+---------------+-----------------+------------+-----------------"
                        + "---------------+");

                System.out.printf("| %-12d | %-10s | %-10s | %-11s | %-11s | %-6s | %-13s | %-15s | %-10s |"
                        + " %-30s |\n", primaryKey, students.getFirstName(), students.getLastName(),
                        students.getFatherName(), students.getMotherName(), students.getGender(),
                        students.getDateOfBirth(), students.getAddress(), students.getContactNo(),
                        students.getEmail());

                System.out.println("+--------------+------------+------------+-------------+-------------+-"
                        + "-------+---------------+-----------------+------------+-------------------------"
                        + "-------+\n");

                List<Course> courses = new ArrayList<>();
                courses = students.getCourses();

                System.out.println("+-----------+-------------+------------+-----------------+\n"
                        + "| Course_Id | Course_Name | Course_Fee | Course_Duration |\n"
                        + "+-----------+-------------+------------+-----------------+");

                if (courses.size() != 0) {
                    courses.forEach(course -> {
                        System.out.printf("| %-9d | %-11s | %-10d | %-15s |\n", course.getId(), course.getName(),
                                course.getFee(), course.getDuration());
                        System.out.println("+-----------+-------------+------------+-----------------+");
                    });

                    System.out.println();
                }
            } catch (CourseException e) {
                e.printStackTrace();
            }

        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerNewStudent() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's first name (max 10 characters): ");
        String firstName = scan.next();

        System.out.print("Enter student's last name (max 10 characters): ");
        String lastName = scan.next();

        System.out.print("Enter student's father name (max 10 characters): ");
        String fatherName = scan.next();

        System.out.print("Enter student's mother name (max 10 characters): ");
        String motherName = scan.next();

        System.out.print("Enter student's gender (male/female): ");
        String gender = scan.next();

        System.out.print("Enter student's date of birth (yyyy-mm-dd): ");
        String dateOfBirth = scan.next();

        scan.nextLine();

        System.out.print("Enter student's address (State max 15 characters): ");
        String address = scan.nextLine();

        System.out.print("Enter student's contact no (10 digits): ");
        String contactNo = scan.next();

        System.out.print("Enter student's email (max 30 characters): ");
        String email = scan.next();

        System.out.print("Enter student's password(min 8 & max 16 characters): ");
        String password = scan.next();

        Student student = new Student(firstName, lastName, fatherName, motherName,
                gender, dateOfBirth, address, contactNo, email, password);

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.registerStudent(student);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteStudent() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter student code to delete student: ");
        int studentCode = scan.nextInt();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.deleteStudent(studentCode);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentFirstName() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's new first name: ");
        String fname = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentFirstName(fname, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentLastName() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's new last name: ");
        String lname = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentLastName(lname, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentFatherName() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's father name: ");
        String fathername = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentFatherName(fathername, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentMotherName() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's mother name: ");
        String mothername = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentMotherName(mothername, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentGender() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's gender: ");
        String gender = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentGender(gender, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentDateOfBirth() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's date of birth: ");
        String dob = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentDateOfBirth(dob, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getStudentPassword() {
        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.getStudentPassword(primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentPassword() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter new password: ");
        String password = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentPassword(password, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentAddress() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter new address: ");
        String address = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentAddress(address, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeStudentContactNo() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter new address: ");
        String contactNo = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.changeStudentContactNo(contactNo, primaryKey);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerStudentNewCourse() throws CourseException {
        CourseDao courseDao = new CourseDaoImpl();

        List<Course> courses = courseDao.getCourses();

        Scanner scan = new Scanner(System.in);

        System.out.println("Available courses:\n");

        System.out.println("+-----------+-------------+------------+-----------------+\n"
                + "| Course_Id | Course_Name | Course_Fee | Course_Duration |\n"
                + "+-----------+-------------+------------+-----------------+");

        if (courses.size() != 0) {
            courses.forEach(course -> {
                System.out.printf("| %-9d | %-11s | %-10d | %-15s |\n", course.getId(), course.getName(),
                        course.getFee(), course.getDuration());
                System.out.println("+-----------+-------------+------------+-----------------+");
            });
        }

        System.out.print("\nEnter course Id to be enrolled: ");
        int courseId = scan.nextInt();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.registerStudentNewCourse(primaryKey, courseId);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeStudentFromCourse() throws CourseException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter course name to be removed: ");
        String courseName = scan.next();

        StudentDao stdDao = new StudentDaoImpl();

        try {
            String message = stdDao.removeStudentFromCourse(primaryKey, courseName);

            System.out.println(message);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void adminMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Show admin details");
        System.out.println("2. Edit admin details");
        System.out.println("3. Show password");
        System.out.println("4. Change password");
        System.out.println("5. Add new course to coding camp");
        System.out.println("0. SignOut");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                flag = false;
                System.out.println("\nThank you for visiting Coding Camp,\nHave a great day...❤️❤️");
                System.exit(0);
                break;

            case 1:
                showAdminDetails();
                break;

            case 2:
                changeAdminMenu();
                break;

            case 3:
                getAdminPassword();
                break;

            case 4:
                changeAdminPassword();
                break;

            case 5:
                    addNewCourse();
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }
    
    private static void changeAdminMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Change admin's first name");
        System.out.println("2. Change admin's last name");
        System.out.println("3. Change admin's father name");
        System.out.println("4. Change admin's mother name");
        System.out.println("5. Change admin's gender");
        System.out.println("6. Change admin's date of birth");
        System.out.println("7. Change admin's address");
        System.out.println("8. Change admin's contact no");
        System.out.println("0. Go back");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                adminMenu();
                break;

            case 1:
                changeAdminFirstName();
                break;

            case 2:
                changeAdminLastName();
                break;

            case 3:
                changeAdminFatherName();
                break;

            case 4:
                changeAdminMotherName();
                break;

            case 5:
                changeAdminGender();
                break;

            case 6:
                changeAdminDateOfBirth();
                break;

            case 7:
                changeAdminAddress();
                break;

            case 8:
                changeAdminContactNo();
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }

    
    private static void showAdminDetails() {
    	AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            Administrator admin;
            admin = adminDao.showAdminDetails(primaryKey);

            System.out.println("+--------------+------------+------------+-------------+-------------+"
                    + "--------+---------------+-----------------+------------+-----------------------"
                    + "---------+\n| Admin_Code   | First_Name | Last_Name  | Father_Name | Mother_Nam"
                    + "e | Gender | Date_Of_Birth | Address         | Contact_No | Email              "
                    + "            |\n+--------------+------------+------------+-------------+--------"
                    + "-----+--------+---------------+-----------------+------------+-----------------"
                    + "---------------+");

            System.out.printf("| %-12d | %-10s | %-10s | %-11s | %-11s | %-6s | %-13s | %-15s | %-10s |"
                    + " %-30s |\n", primaryKey, admin.getFirstName(), admin.getLastName(),
                    admin.getFatherName(), admin.getMotherName(), admin.getGender(),
                    admin.getDateOfBirth(), admin.getAddress(), admin.getContactNo(),
                    admin.getEmail());

            System.out.println("+--------------+------------+------------+-------------+-------------+-"
                    + "-------+---------------+-----------------+------------+-------------------------"
                    + "-------+\n");

        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeAdminFirstName() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new first name: ");
        String fname = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminFirstName(fname, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void changeAdminLastName() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new last name: ");
        String lname = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminLastName(lname, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeAdminFatherName() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new father name: ");
        String fathername = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminFatherName(fathername, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeAdminMotherName() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new mother name: ");
        String mothername = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminMotherName(mothername, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeAdminGender() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new gender: ");
        String gender = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminGender(gender, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeAdminDateOfBirth() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new date of birth: ");
        String dob = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminDateOfBirth(dob, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getAdminPassword() {
        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.getAdminPassword(primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeAdminPassword() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new password: ");
        String password = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminPassword(password, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeAdminAddress() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new address: ");
        String address = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminAddress(address, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeAdminContactNo() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new contact no: ");
        String contact = scan.next();

        AdministratorDao adminDao = new AdministratorDaoImpl();

        try {
            String message = adminDao.changeAdminContactNo(contact, primaryKey);

            System.out.println(message);
        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void addNewCourse() {
    	Scanner scan = new Scanner(System.in);

        System.out.print("Enter course name: ");
        String name = scan.next();
        
        System.out.print("Enter course fee: ");
        int fee = scan.nextInt();
        
        System.out.print("Enter course duration: ");
        String duration = scan.next();
        
        Course course = new Course(name, fee, duration);

        CourseDao courseDao = new CourseDaoImpl();

        try {
            String message = courseDao.addCourse(course);

            System.out.println(message);
        } catch (CourseException e) {
            System.out.println(e.getMessage());
        }
    }
}