import java.util.*;
import java.io.*;

public class Display {
    private int primaryStudentID = 0;// To Initialize Primary Students IDs
    private int highSchoolStudentID = 0;// To Initialize HighSchool Student IDs
    private int teacherID = 0;// To Initialize Teacher IDs
    private int supportStaffID = 0;// To Initialize SupportStaff IDs
    private int departmentID = 0;// To Initialize Department IDs


    private static final Scanner s1 = new Scanner(System.in);// Scanner
    private final SchoolManagement schoolManagement = new SchoolManagement();// Initializing SchoolManagement Class


    public void newPrimaryStudent(String name, String address, String password) {// New Primary Student
        SchoolManagement.addPrimaryStudent(name, address, password, primaryStudentID);// Initializing New Primary Student
    }// End of New Primary Student Methode

    public void newHighSchoolStudent(String name, String address, String password) {// New HighSchool Student
        SchoolManagement.addHighSchoolStudent(name, address, password, highSchoolStudentID);// Initializing New HighSchool Student
    }// End of New HighSchool Student Methode

    public void newDepartment(String name) {// New Department
        schoolManagement.addDepartment(name);// Initializing New Department
    }// End of New Department Methode

    public void newTeacher(String name, double salary, String password) {// New Teacher
        SchoolManagement.addTeacher(name, salary, password);// Initializing New Teacher
    }// End of New Teacher Methode

    public void newSupportStaff(String name, double salary, String password) {// New SupportStaff
        SchoolManagement.addSupportStaff(name, salary, password);// Initializing New SupportStaff
    }// End of New SupportStaff Methode

    public void clearFile() throws FileNotFoundException {// Erase Saved Data Before ReSaving
        File file = new File("DataV2.txt");// Initialize The file Location
        PrintWriter pw = new PrintWriter(file);// Initialize PrintWriter Class
        pw.print("");// Making The .txt File Empty
        pw.close();// Closing The Print Writer
    }// End Of Clear File Methode

    public void writing() throws IOException { // Saving The Data In A .txt File
        File file = new File("DataV2.txt");// Initialize The file Location
        FileWriter fileWriter = new FileWriter(file);// Initialize FileWriter Class
        BufferedWriter pw = new BufferedWriter(fileWriter);// Initialize BufferWriter Class
        for (int i = 0; i < SchoolManagement.getPrimaryStudent().size(); i++) {// Saving Primary Students Data
            pw.write("1'" + SchoolManagement.getPrimaryStudent().get(i).getName() + "'" + SchoolManagement.getPrimaryStudent().get(i).getAddress() + "'" + SchoolManagement.getPrimaryStudent().get(i).getPassword()
                    + "'" + SchoolManagement.getPrimaryStudent().get(i).getAttendance() + "'" + SchoolManagement.getPrimaryStudent().get(i).getGrades1());// Write PrimarySchool Student Data In The .txt File
            pw.write("\n");// Create A New Line In The .txt File
        }// End Of Saving Primary Students Data
        for (int i = 0; i < SchoolManagement.getHighSchoolStudent().size(); i++) {// Saving HighSchool Students Data
            pw.write("2'" + SchoolManagement.getHighSchoolStudent().get(i).getName() + "'" + SchoolManagement.getHighSchoolStudent().get(i).getAddress() + "'" + SchoolManagement.getHighSchoolStudent().get(i).getPassword()
                    + "'" + SchoolManagement.getHighSchoolStudent().get(i).getAttendance() + "'" + SchoolManagement.getHighSchoolStudent().get(i).getGrades1());// Write HighSchool Student Data In The .txt File
            pw.write("\n");// Create A New Line In The .txt File
        }// End Of Saving HighSchool Students Data
        for (int i = 0; i < SchoolManagement.getTeacher().size(); i++) {// Saving Teachers Data
            pw.write("3'" + SchoolManagement.getTeacher().get(i).getName() + "'" + SchoolManagement.getTeacher().get(i).getSalary() + "'" + SchoolManagement.getTeacher().get(i).getDepartment() + "'" + SchoolManagement.getTeacher().get(i).getPassword() + "'" + SchoolManagement.getTeacher().get(i).getPrimaryStudents1() + "'" + SchoolManagement.getTeacher().get(i).getHighSchoolStudents1());// Write Teacher Data In The .txt File
            pw.write("\n");// Create A New Line In The .txt File
        }// End Of Saving Teacher Data
        for (int i = 0; i < SchoolManagement.getSupportStaff().size(); i++) {// Saving SupportStaff Data
            pw.write("4'" + SchoolManagement.getSupportStaff().get(i).getName() + "'" + SchoolManagement.getSupportStaff().get(i).getSalary() + "'" + SchoolManagement.getSupportStaff().get(i).getPassword());// Write SupportStaff Data In The .txt File
            pw.write("\n");// Create A New Line In The .txt File
        }// End Of Saving SupportStaff Data
        pw.close();// Close The BufferWriter
    }// End of Writing Methode

    public void read() throws IOException {// Read The .txt File To Not Lose The Data After Restarting
        File file = new File("DataV2.txt");// Initialize The file Location
        BufferedReader br = new BufferedReader(new FileReader(file));// Initialize BufferReader Class
        String line;// Creating a String To Store The Read Line In
        while ((line = br.readLine()) != null) {// Checking If The .txt File Has Any Lines
            String[] reading = line.split("'");// Splitting The String By Every '
            switch (reading[0]) {// Checking What The Read line After Splinting Starts With
                case "1" -> {// On Finding The First Number In The Line = 1 , Save The Data After it To A New Primary Student
                    //reading[1] = Name
                    //reading[2] = Address
                    //reading[3] = Password
                    //reading[4] = Attendance
                    //reading[5] = Grades
                    SchoolManagement.addPrimaryStudent(reading[1], reading[2], reading[3], primaryStudentID);// Adding New Primary Student Class In The Primary Student ArrayList
                    SchoolManagement.getPrimaryStudent().get(primaryStudentID).setAttendance(Integer.parseInt(reading[4]));// Setting The Attendance To The Saved Attendance
                    if (reading.length >= 6) {// Checking If The Primary Student Has Any Grades
                        String[] grades = reading[5].split(",");// Split The Grades String By Every ,
                        for (String grade : grades) {// For Evert Index In The Grade Array Do The Following Command
                            SchoolManagement.getPrimaryStudent().get(primaryStudentID).getGrades().add(grade);// Adding the Grades To the Primary Student Class
                        }// End of The For Loop Saving The Grades In The Primary Student Class
                    }// End Of If Condition Confirming The Existing Of Grades
                    primaryStudentID++;// Moving to the Next Primary Student index
                }// End Of reading[0] == 1 Case
                case "2" -> {// On Finding The First Number In The Line = 2 , Save The Data After it To A New HighSchool Student
                    //reading[1] = Name
                    //reading[2] = Address
                    //reading[3] = Password
                    //reading[4] = Attendance
                    //reading[5] = Grades
                    SchoolManagement.addHighSchoolStudent(reading[1], reading[2], reading[3], primaryStudentID);// Adding New HighSchool Student Class In The HighSchool Student ArrayList
                    SchoolManagement.getHighSchoolStudent().get(highSchoolStudentID).setAttendance(Integer.parseInt(reading[4]));// Setting The Attendance To The Saved Attendance
                    if (reading.length >= 6) {// Checking If The HighSchool Student Has Any Grades
                        String[] grades = reading[5].split(",");// Split The Grades String By Every ,
                        for (String grade : grades) {// For Evert Index In The Grade Array Do The Following Command
                            SchoolManagement.getHighSchoolStudent().get(highSchoolStudentID).getGrades().add(grade);// Adding the Grades To the HighSchool Student Class
                        }// End of The For Loop Saving The Grades In The HighSchool Student Class
                    }// End Of If Condition Confirming The Existing Of Grades
                    highSchoolStudentID++;// Moving to the Next HighSchool Student index
                }// End Of reading[0] == 2 Case
                case "3" -> {// On Finding The First Number In The Line = 3 , Save The Data After it To A New Teacher
                //reading[1] = Name
                //reading[2] = Salary
                //reading[3] = Department
                //reading[4] = Password
                //reading[5] = Primary Students Under The Teacher
                //reading[6] = HighSchool Students Under The Teacher
                    SchoolManagement.addTeacher(reading[1], Double.parseDouble(reading[2]), reading[4]);// Adding New Teacher Class In The Teachers ArrayList
                    if (!reading[3].equals("null")) {// Check If The Department Of The Teacher Is Not Null
                        SchoolManagement.getTeacher().get(teacherID).setDepartment(reading[3]);// Setting The Teachers Department To reading[3]
                        boolean check = false;// Boolean To Check If The Department Already Exists
                        for (int i = 0; i < SchoolManagement.getDepartment().size(); i++) {// Loop To Check If The Department Already Exists And If It Does Find Its Index In The Department ArrayList
                            if (SchoolManagement.getDepartment().get(i).getName().equals(reading[3])) {// Checking Condition to Compare Department Names
                                check = true;// Converts Boolean to True To Indicate That The Department Exists
                                break;// Ending The Loop As It Has Fulfilled Its Purpose
                            }// End Of Checking Condition to Compare Department Names
                        }// End Of Loop To Check If The Department Exists And If So Find Its Index
                        if (!check) {// Confirming That The Department Doesn't Exist
                            newDepartment(reading[3]);// Creating New Department Class Of Name reading[3] In The Department ArrayList
                            int departmentIndex = 0;// Int To Store The Index Of The Newly Created Department In The Department ArrayList
                            for (int i = 0; i < SchoolManagement.getDepartment().size(); i++)// Loop To Find The Index Of The Newly Created Department In The Department ArrayList
                                if (SchoolManagement.getDepartment().get(i).getName().equals(reading[3])) {// Condition To Check If The New Department == The Name Of The Department[i] In The Array List
                                    departmentIndex = i;// Saving The Index of The New Department In Variable DepartmentIndex
                                    break;// End The Loop As It Is Not Required To Run After Fulfilling The Condition
                                }// End of Checking If New Department == The Name Of The Department[i] In The Array List
                            SchoolManagement.getDepartment().get(departmentIndex).addTeacher(SchoolManagement.getTeacher().get(teacherID));//Adding Teacher Of Index TeacherID to The Newly Created Department
                        }// End Of Condition If The Department Doesn't Exist
                        else {// If The Department Does Exist
                            int departmentIndex = 0;// Int To Store The Index Of The Newly Created Department In The Department ArrayList
                            for (int i = 0; i < SchoolManagement.getDepartment().size(); i++)// Loop To Find The Index Of The Newly Created Department In The Department ArrayList
                                if (SchoolManagement.getDepartment().get(i).getName().equals(reading[3])) {// Condition To Check If The New Department == The Name Of The Department[i] In The Array List
                                    departmentIndex = i;// Saving The Index of The New Department In Variable DepartmentIndex
                                    break;// End The Loop As It Is Not Required To Run After Fulfilling The Condition
                                }// End of Checking If New Department == The Name Of The Department[i] In The Array List
                            SchoolManagement.getDepartment().get(departmentIndex).addTeacher(SchoolManagement.getTeacher().get(teacherID));//Adding Teacher Of Index TeacherID to The Newly Created Department
                        }// End Of Condition If The Department Does Exist
                    }// End Of Confirming That The Department Is Not Null
                    if (reading.length > 5) {// Checking If The Teacher Has Any Primary Students
                        String[] PsID = reading[5].split(",");// Split The Primary Student IDs String By Every ,
                        // Binging Of Loop To Add Primary Students
                        for (String s : PsID)// For Every Primary Student ID Do The Following Command
                            SchoolManagement.getTeacher().get(teacherID).addPrimaryStudent(SchoolManagement.getPrimaryStudent().get(Integer.parseInt(s)));//Adding PrimaryStudent To The Newly Created Teacher's Primary Students ArrayList
                        // End Of Loop To Add Primary Students
                    }// End Of Condition If The Teacher Has Any Primary Students
                    if (reading.length > 6) {// Checking If The Teacher Has Any HighSchool Students
                        String[] HssID = reading[5].split(",");// Split The HighSchool Students IDs String By Every ,
                        // Binging Of Loop To Add HighSchool Students
                        for (String s : HssID)// For Every HighSchool Student ID Do The Following Command
                            SchoolManagement.getTeacher().get(teacherID).addHighSchoolStudent(SchoolManagement.getHighSchoolStudent().get(Integer.parseInt(s)));//Adding PrimaryStudent To The Newly Created Teacher's Primary Students ArrayList
                        // End Of Loop To Add HighSchool Students
                    }// End Of Condition If The Teacher Has Any HighSchool Students
                    teacherID++;// Moving to the Next Teacher index
                }// End Of reading[0] == 3 Case
                case "4" -> {
                    //reading[1] = Name
                    //reading[2] = Salary
                    //reading[3] = Password
                    SchoolManagement.addSupportStaff(reading[1], Double.parseDouble(reading[2]), reading[3]);// Initializing New SupportStaff Class In SupportStaff ArrayList
                    supportStaffID++;// Moving to the Next SupportStaff index
                }// End Of reading[0] == 4 Case
            }// End Of Switch Case For reading[0]
        }// End Of Line To Go Through All The Written Lines In The .txt File
    }// End Of Reading Methode

    public void primaryStudentLogin(){
        System.out.println("Enter your ID");
        int inputID = s1.nextInt();
        if (inputID < SchoolManagement.getPrimaryStudent().size()) {
            if (!SchoolManagement.getPrimaryStudent().get(inputID).getName().equals("Removed")) {
                System.out.println("Enter your password");
                String inputPassword = s1.next();
                if (SchoolManagement.getPrimaryStudent().get(inputID).getPassword().equals(inputPassword)) {
                    System.out.println("1- Show Attendance\n2- Change/Show data");
                    int choice1 = s1.nextInt();
                    if (choice1 == 1) { // Confirm Attendance
                        System.out.println(SchoolManagement.getPrimaryStudent().get(inputID).getAttendance());
                    } else if (choice1 == 2) { // Change Data
                        System.out.println("1- Change address\n2- Change password\n3- Show data");
                        int changeDataChoice = s1.nextInt();

                        if (changeDataChoice == 1) {
                            System.out.println("Input new address");
                            String newAddress = s1.next();
                            SchoolManagement.getPrimaryStudent().get(inputID).setAddress(newAddress);
                        } else if (changeDataChoice == 2) {
                            System.out.println("Enter your new password");
                            String newPassword = s1.next();
                            SchoolManagement.getPrimaryStudent().get(inputID).setPassword(newPassword);
                            System.out.println("Your password has been changed");
                        } else if (changeDataChoice == 3) { // Show data
                            System.out.println(SchoolManagement.getPrimaryStudent().get(inputID).toString());
                        } else System.out.println("Invalid choice");


                    } else System.out.println("Invalid Answer");
                } else System.out.println("The password you entered is wrong");
            } else System.out.println("Invalid ID");
        } else System.out.println("Invalid ID");
    }

    public void hIghSchoolStudentLogin(){
        System.out.println("Enter your ID");
        int inputID = s1.nextInt();
        if (inputID < SchoolManagement.getHighSchoolStudent().size()) {
            if (!SchoolManagement.getHighSchoolStudent().get(inputID).getName().equals("Removed")) {
                System.out.println("Enter you password");
                String inputPassword = s1.next();
                if (SchoolManagement.getHighSchoolStudent().get(inputID).getPassword().equals(inputPassword)) {
                    System.out.println("1- View attendance\n2- Chang/Show data");
                    int choice1 = s1.nextInt();
                    if (choice1 == 1) { // Confirm Attendance
                        System.out.println(SchoolManagement.getHighSchoolStudent().get(inputID).getAttendance());
                    } else if (choice1 == 2) { // Change Data

                        System.out.println("1- Change address\n2- Change password\n3- Show data");
                        int changeDataChoice = s1.nextInt();

                        if (changeDataChoice == 1) {
                            System.out.println("Input new address");
                            String newAddress = s1.next();
                            SchoolManagement.getHighSchoolStudent().get(inputID).setAddress(newAddress);
                        } else if (changeDataChoice == 2) {
                            System.out.println("Enter your new password");
                            String newPassword = s1.next();
                            SchoolManagement.getHighSchoolStudent().get(inputID).setPassword(newPassword);
                            System.out.println("Your password has been changed");
                        } else System.out.println("Invalid choice");

                    } else if (choice1 == 3) { // Show data
                        System.out.println(SchoolManagement.getHighSchoolStudent().get(inputID).toString());
                    } else System.out.println("Invalid Answer");
                } else System.out.println("The password you entered is wrong");
            } else System.out.println("Invalid ID");
        } else System.out.println("Invalid ID");
    }

    public void teacherLogin(){
        System.out.println("Enter your ID");
        int inputID = s1.nextInt();
        if (inputID < SchoolManagement.getTeacher().size()) {
            if (!SchoolManagement.getTeacher().get(inputID).getName().equals("Removed")) {

                System.out.println("Enter your password");
                String inputPassword = s1.next();

                if (SchoolManagement.getTeacher().get(inputID).getPassword().equals(inputPassword)) {
                    System.out.println("1- Change data\n2- View data\n3- Add primary student\n4- Add highSchool student\n5- Add grade to primary students by ID");
                    System.out.println("6- Add grade to highSchool students by ID\n7- Add attendance to primary student\n8- Add attendance to HighSchool student");

                    int actionChoice = s1.nextInt();
                    if (actionChoice == 1) { // Change Data
                        System.out.println("Enter your new password");
                        String newPassword = s1.next();
                        SchoolManagement.getTeacher().get(inputID).setPassword(newPassword);
                        System.out.println("Your password has been changed");
                    } else if (actionChoice == 2) { // View Data

                        System.out.println("Name : " + SchoolManagement.getTeacher().get(inputID).getName());
                        System.out.println("Salary : " + SchoolManagement.getTeacher().get(inputID).getSalary());
                        System.out.println("Department : " + SchoolManagement.getTeacher().get(inputID).getDepartment());

                    } else if (actionChoice == 3) { // Add primary student
                        System.out.println("Enter student ID");
                        int primaryStudentID = s1.nextInt();
                        if (primaryStudentID < SchoolManagement.getPrimaryStudent().size()) {
                            SchoolManagement.getTeacher().get(inputID).addPrimaryStudent(SchoolManagement.getPrimaryStudent().get(primaryStudentID));
                        } else System.out.println("Invalid ID");
                    } else if (actionChoice == 4) { // Add highSchool student
                        System.out.println("Enter student ID");
                        int highSchoolStudentID = s1.nextInt();
                        if (highSchoolStudentID < SchoolManagement.getHighSchoolStudent().size()) {
                            SchoolManagement.getTeacher().get(inputID).addHighSchoolStudent(SchoolManagement.getHighSchoolStudent().get(highSchoolStudentID));
                        }
                    } else if (actionChoice == 5) { // Add grade to primary students by ID
                        SchoolManagement.getTeacher().get(inputID).primaryStudents();
                        System.out.println("Enter student ID you want to add a grade to");
                        int addGradePrimaryStudentID = s1.nextInt();
                        boolean check = false;
                        for (int i = 0; i < SchoolManagement.getTeacher().get(inputID).getPrimaryStudents().size(); i++) {
                            if (SchoolManagement.getTeacher().get(inputID).getPrimaryStudents().get(i).getID() == addGradePrimaryStudentID) {
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("Please enter exam name withe the date  ex: Midterm 18-12-2022");
                            String examDetails = s1.next();
                            System.out.println("Enter the grade to be given");
                            double grade = s1.nextDouble();
                            SchoolManagement.getTeacher().get(inputID).gradePrimaryStudentByID(addGradePrimaryStudentID, examDetails, grade);
                        } else System.out.println("Invalid ID");
                    } else if (actionChoice == 6) { // Add grade to highSchool students by ID
                        SchoolManagement.getTeacher().get(inputID).highSchoolStudents();
                        int addGradeHighSchoolStudentID = s1.nextInt();
                        boolean check = false;
                        for (int i = 0; i < SchoolManagement.getTeacher().get(inputID).getHighSchoolStudents().size(); i++) {
                            if (SchoolManagement.getTeacher().get(inputID).getHighSchoolStudents().get(i).getID() == addGradeHighSchoolStudentID) {
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("Please enter exam name withe the date  ex: Midterm 18-12-2022");
                            String examDetails = s1.next();
                            System.out.println("Enter the grade to be given");
                            double grade = s1.nextDouble();
                            SchoolManagement.getTeacher().get(inputID).gradeHighSchoolStudentByID(addGradeHighSchoolStudentID, examDetails, grade);
                        } else System.out.println("Invalid ID");
                    } else if (actionChoice == 7) {
                        SchoolManagement.getTeacher().get(inputID).primaryStudents();
                        int studentID_attendance = s1.nextInt();
                        boolean check = false;
                        int counter = 0;
                        for (int i = 0; i < SchoolManagement.getTeacher().get(inputID).getPrimaryStudents().size(); i++) {
                            if (SchoolManagement.getTeacher().get(inputID).getPrimaryStudents().get(i).getID() == studentID_attendance) {
                                check = true;
                                counter = i;
                                break;
                            }
                        }
                        if (check) {
                            SchoolManagement.getTeacher().get(inputID).getPrimaryStudents().get(counter).submitAttendance();
                            System.out.println("Action successful");
                        } else {
                            System.out.println("Invalid Student ID");
                        }
                    } else if (actionChoice == 8) {
                        SchoolManagement.getTeacher().get(inputID).highSchoolStudents();
                        int studentID_attendance = s1.nextInt();
                        boolean check = false;
                        int counter = 0;
                        for (int i = 0; i < SchoolManagement.getTeacher().get(inputID).getHighSchoolStudents().size(); i++) {
                            if (SchoolManagement.getTeacher().get(inputID).getHighSchoolStudents().get(i).getID() == studentID_attendance) {
                                check = true;
                                counter = i;
                                break;
                            }
                        }
                        if (check) {
                            SchoolManagement.getTeacher().get(inputID).getHighSchoolStudents().get(counter).submitAttendance();
                            System.out.println("Action successful");
                        } else System.out.println("Invalid Student ID");
                    } else System.out.println("Invalid action choice");
                } else System.out.println("The password you entered is wrong");
            } else System.out.println("Invalid ID");

        } else System.out.println("Invalid ID");
    }

    public void supportStaffLogin(){
        System.out.println("Enter your ID");
        int inputID = s1.nextInt();
        if (inputID < SchoolManagement.getSupportStaff().size()) {
            if (!SchoolManagement.getSupportStaff().get(inputID).getName().equals("Removed")) {
                System.out.println("Enter your password");
                String inputPassword = s1.next();
                if (SchoolManagement.getSupportStaff().get(inputID).getPassword().equals(inputPassword)) {
                    System.out.println("1- Change data\n2- View data");
                    int actionChoice = s1.nextInt();
                    if (actionChoice == 1) { // Change Data
                        System.out.println("Enter your new password");
                        String newPassword = s1.next();
                        SchoolManagement.getSupportStaff().get(inputID).setPassword(newPassword);
                        System.out.println("Your password has been changed");
                    } else if (actionChoice == 2) { // View Data
                        System.out.println("Name : " + SchoolManagement.getSupportStaff().get(inputID).getName());
                        System.out.println("Salary : " + SchoolManagement.getSupportStaff().get(inputID).getSalary());
                    } else System.out.println("Invalid action choice");
                } else System.out.println("The password you entered is wrong");
            } else System.out.println("Invalid ID");
        } else System.out.println("Invalid input");
    }

    public void adminNewDepartment(){
        System.out.println("Choose your department type\n1- New department\n2- Old department");
        int departmentType = s1.nextInt();
        if (departmentType == 1) { // New Department
            System.out.println("Enter department name");
            String departmentName = s1.next();
            newDepartment(departmentName);
            System.out.println("Department ID is " + departmentID);
            departmentID++;
        } else if (departmentType == 2) { // Old Department
            System.out.println("Enter The department Name");
            String departmentNameInput = s1.next();
            boolean check = false;
            int departmentIndex = 0;
            for (int i = 0; i < SchoolManagement.getDepartment().size(); i++)
                if (SchoolManagement.getDepartment().get(i).getName().equals(departmentNameInput)) {
                    check = true;
                    departmentIndex = i;
                }
            if (check) {
                System.out.println("1- Add new teacher\n2- Teachers in department");
                int adminDepartmentAction = s1.nextInt();
                if (adminDepartmentAction == 1) { // Add new teacher
                    System.out.println("Put teacher ID to add to this department");
                    int teacherInputID = s1.nextInt();
                    if (teacherInputID < SchoolManagement.getTeacher().size()) {
                        SchoolManagement.getDepartment().get(departmentIndex).addTeacher(SchoolManagement.getTeacher().get(teacherInputID));
                    } else System.out.println("Invalid Teacher ID");
                } else if (adminDepartmentAction == 2) { // See teachers in department
                    int counter = 1;
                    for (int i = 0; i < SchoolManagement.getTeacher().size(); i++) {
                        if (SchoolManagement.getTeacher().get(i).getDepartment().equals(SchoolManagement.getDepartment().get(departmentIndex).getName())) {
                            System.out.println(counter + "- " + SchoolManagement.getTeacher().get(i).getName());
                        }
                    }
                } else System.out.println("Invalid action");
            } else System.out.println("Invalid ID");
        } else System.out.println("Invalid answer");
    }

    public void adminViewData(){
        if (SchoolManagement.getPrimaryStudent().size() != 0) {
            System.out.println("Primary Students");
            for (int i = 0; i < SchoolManagement.getPrimaryStudent().size(); i++) {
                System.out.println(SchoolManagement.getPrimaryStudent().get(i));
            }
        } else {
            System.out.println("Primary student number = 0");
        }
        System.out.println();
        System.out.println("HighSchool Students");
        if (SchoolManagement.getHighSchoolStudent().size() != 0) {
            for (int i = 0; i < SchoolManagement.getHighSchoolStudent().size(); i++) {
                System.out.println(SchoolManagement.getHighSchoolStudent().get(i));
            }
        } else System.out.println("HighSchool student number = 0");
        System.out.println();
        System.out.println("Teachers/Department");
        for (int i = 0; i < SchoolManagement.getDepartment().size(); i++) {
            for (int j = 0; j < SchoolManagement.getTeacher().size(); j++) {
                System.out.println(SchoolManagement.getDepartment().get(i).getName() + " Number of teachers = "
                        + SchoolManagement.getDepartment().get(i).getNoTeachers());
                if (SchoolManagement.getTeacher().get(j).getDepartment().equals(SchoolManagement.getDepartment().get(i).getName())) {
                    System.out.println(SchoolManagement.getTeacher().get(j));
                }
            }
            System.out.println();
        }
        if (SchoolManagement.getSupportStaff().size() != 0) {
            System.out.println("SupportStaff");
            for (int i = 0; i < SchoolManagement.getSupportStaff().size(); i++) {
                System.out.println(SchoolManagement.getSupportStaff().get(i));
            }
        } else System.out.println("SupportStaff number = 0");
    }

    public void adminRemoverPrimaryStudent(){
        System.out.println("Enter the ID you want to remove");
        int desireRemoveID = s1.nextInt();
        if (desireRemoveID < SchoolManagement.getPrimaryStudent().size()) {
            SchoolManagement.getPrimaryStudent().remove(desireRemoveID);
            SchoolManagement.getPrimaryStudent().add(desireRemoveID, new PrimaryStudent("Removed", "Removed", "Removed", 0));
        } else System.out.println("Invalid ID");
    }

    public void adminRemoveHighSchoolStudent(){
        System.out.println("Enter the ID you want to remove");
        int desireRemoveID = s1.nextInt();
        if (desireRemoveID < SchoolManagement.getHighSchoolStudent().size()) {
            SchoolManagement.getHighSchoolStudent().remove(desireRemoveID);
            SchoolManagement.getHighSchoolStudent().add(desireRemoveID, new HighSchoolStudent("Removed", "Removed", "Removed", 0));
        } else System.out.println("Invalid ID");
    }

    public void adminRemoveTeacher(){
        System.out.println("Enter the ID you want to remove");
        int desireRemoveID = s1.nextInt();
        if (desireRemoveID < SchoolManagement.getTeacher().size()) {
            SchoolManagement.getTeacher().remove(desireRemoveID);
            SchoolManagement.getTeacher().add(desireRemoveID, new Teacher("Removed", 0, "Removed"));
        } else System.out.println("Invalid ID");
    }

    public void adminRemoveSupportStaff(){
        System.out.println("Enter the ID you want to remove");
        int desireRemoveID = s1.nextInt();
        if (desireRemoveID < SchoolManagement.getSupportStaff().size()) {
            SchoolManagement.getSupportStaff().remove(desireRemoveID);
            SchoolManagement.getSupportStaff().add(desireRemoveID, new SupportStaff("Removed", 0, "Removed"));
        } else System.out.println("Invalid ID");
    }

    public void adminAddPrimaryStudent(){
        System.out.println("Enter student name");
        String PrimaryStudentName = s1.next();
        System.out.println("Enter student address");
        String PrimaryStudentAddress = s1.next();
        System.out.println("Enter student password");
        String PrimaryStudentPassword = s1.next();
        newPrimaryStudent(PrimaryStudentName, PrimaryStudentAddress, PrimaryStudentPassword);
        System.out.println("Your ID is " + primaryStudentID);
        primaryStudentID++;
    }

    public void adminAddHighSchoolStudent(){
        System.out.println("Enter student name");
        String HighSchoolStudentName = s1.next();
        System.out.println("Enter student address");
        String HighSchoolStudentAddress = s1.next();
        System.out.println("Enter student password");
        String HighSchoolStudentPassword = s1.next();
        newHighSchoolStudent(HighSchoolStudentName, HighSchoolStudentAddress, HighSchoolStudentPassword);
        System.out.println("Your ID is " + highSchoolStudentID);
        highSchoolStudentID++;
    }

    public void adminAddTeacher(){
        System.out.println("Enter Teacher name");
        String name = s1.next();
        System.out.println("Enter Teacher given salary");
        int salary = s1.nextInt();
        System.out.println("Enter Teacher password");
        String teacherPassword = s1.next();
        newTeacher(name, salary, teacherPassword);
        System.out.println("Your ID is " + teacherID);
        teacherID++;
    }

    public void adminAddSupportStaff(){
        System.out.println("Enter SupportStaff name");
        String name = s1.next();
        System.out.println("Enter SupportStaff given salary");
        int salary = s1.nextInt();
        System.out.println("Enter SupportStaff password");
        String supportStaffPassword = s1.next();
        newSupportStaff(name, salary, supportStaffPassword);
        System.out.println("Your ID is " + supportStaffID);
        supportStaffID++;
    }

    public void adminEditPrimaryStudent(){
        System.out.println("Enter student ID");
        int inputID = s1.nextInt();
        if (inputID < SchoolManagement.getPrimaryStudent().size()) {
            if (!SchoolManagement.getPrimaryStudent().get(inputID).getName().equals("Removed")) {
                System.out.println("1- Confirm Attendance\n2- Change data");
                int choice1 = s1.nextInt();
                if (choice1 == 1) { // Confirm Attendance
                    SchoolManagement.getPrimaryStudent().get(inputID).submitAttendance();
                } else if (choice1 == 2) { // Change Data
                    System.out.println("1- Change address\n2- Change password\n3- Show data");
                    int changeDataChoice = s1.nextInt();

                    if (changeDataChoice == 1) {
                        System.out.println("Input new address");
                        String newAddress = s1.next();
                        SchoolManagement.getPrimaryStudent().get(inputID).setAddress(newAddress);
                    } else if (changeDataChoice == 2) {
                        System.out.println("Enter your new password");
                        String newPassword = s1.next();
                        SchoolManagement.getPrimaryStudent().get(inputID).setPassword(newPassword);
                        System.out.println("Your password has been changed");
                    } else System.out.println("Invalid choice");
                } else if (choice1 == 3)
                    System.out.println(SchoolManagement.getPrimaryStudent().get(inputID).toString());// Show data
                else System.out.println("Invalid Answer");
            } else System.out.println("Invalid ID");
        } else System.out.println("Invalid ID");
    }

    public void adminEditHighSchoolStudent(){
        System.out.println("Enter student ID");
        int inputID = s1.nextInt();
        if (inputID < SchoolManagement.getHighSchoolStudent().size()) {
            if (!SchoolManagement.getHighSchoolStudent().get(inputID).getName().equals("Removed")) {
                System.out.println("1- Confirm Attendance\n2- Change data");
                int choice1 = s1.nextInt();
                if (choice1 == 1)
                    SchoolManagement.getHighSchoolStudent().get(inputID).submitAttendance();// Confirm Attendance
                else if (choice1 == 2) { // Change Data
                    System.out.println("1- Change address\n2- Change password\n3- Show data");
                    int changeDataChoice = s1.nextInt();
                    if (changeDataChoice == 1) {
                        System.out.println("Input new address");
                        String newAddress = s1.next();
                        SchoolManagement.getHighSchoolStudent().get(inputID).setAddress(newAddress);
                    } else if (changeDataChoice == 2) {
                        System.out.println("Enter your new password");
                        String newPassword = s1.next();
                        SchoolManagement.getHighSchoolStudent().get(inputID).setPassword(newPassword);
                        System.out.println("Your password has been changed");
                    } else System.out.println("Invalid choice");
                } else if (choice1 == 3)
                    System.out.println(SchoolManagement.getHighSchoolStudent().get(inputID).toString());// Show data
                else System.out.println("Invalid Answer");
            } else System.out.println("Invalid ID");
        } else System.out.println("Invalid ID");
    }

    public void adminEditTeacher(){
        System.out.println("Enter your ID");
        int inputID = s1.nextInt();
        if (inputID < SchoolManagement.getTeacher().size()) {
            if (!SchoolManagement.getTeacher().get(inputID).getName().equals("Removed")) {
                System.out.println("1- Change data\n2- View data\n3- Add primary student\n4- Add highSchool student\n5- Add grade to primary students by ID\n6- Add grade to highSchool students by ID");
                int actionChoice = s1.nextInt();
                if (actionChoice == 1) { // Change Data
                    System.out.println("Enter your new password");
                    String newPassword = s1.next();
                    SchoolManagement.getTeacher().get(inputID).setPassword(newPassword);
                    System.out.println("Your password has been changed");
                } else if (actionChoice == 2) { // View Data
                    System.out.println("Name : " + SchoolManagement.getTeacher().get(inputID).getName());
                    System.out.println("Salary : " + SchoolManagement.getTeacher().get(inputID).getSalary());
                    System.out.println("Department : " + SchoolManagement.getTeacher().get(inputID).getDepartment());
                } else if (actionChoice == 3) { // Add primary student
                    System.out.println("Enter student ID");
                    int primaryStudentID = s1.nextInt();
                    if (primaryStudentID < SchoolManagement.getPrimaryStudent().size()) {
                        SchoolManagement.getTeacher().get(inputID).addPrimaryStudent(SchoolManagement.getPrimaryStudent().get(primaryStudentID));
                    } else System.out.println("Invalid ID");
                } else if (actionChoice == 4) { // Add highSchool student
                    System.out.println("Enter student ID");
                    int highSchoolStudentID = s1.nextInt();
                    if (highSchoolStudentID < SchoolManagement.getHighSchoolStudent().size()) {
                        SchoolManagement.getTeacher().get(inputID).addHighSchoolStudent(SchoolManagement.getHighSchoolStudent().get(highSchoolStudentID));
                    }
                } else if (actionChoice == 5) { // Add grade to primary students by ID
                    SchoolManagement.getTeacher().get(inputID).primaryStudents();
                    System.out.println("Enter student ID you want to add a grade to");
                    int addGradePrimaryStudentID = s1.nextInt();
                    boolean check = false;
                    for (int i = 0; i < SchoolManagement.getTeacher().get(inputID).getPrimaryStudents().size(); i++) {
                        if (SchoolManagement.getTeacher().get(inputID).getPrimaryStudents().get(i).getID() == addGradePrimaryStudentID) {
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        System.out.println("Please enter exam name withe the date  ex: Midterm 18-12-2022");
                        String examDetails = s1.next();
                        System.out.println("Enter the grade to be given");
                        double grade = s1.nextDouble();
                        SchoolManagement.getTeacher().get(inputID).gradePrimaryStudentByID(addGradePrimaryStudentID, examDetails, grade);
                    } else System.out.println("Invalid ID");
                } else if (actionChoice == 6) { // Add grade to highSchool students by ID
                    SchoolManagement.getTeacher().get(inputID).highSchoolStudents();
                    int addGradeHighSchoolStudentID = s1.nextInt();
                    boolean check = false;
                    for (int i = 0; i < SchoolManagement.getTeacher().get(inputID).getHighSchoolStudents().size(); i++) {
                        if (SchoolManagement.getTeacher().get(inputID).getHighSchoolStudents().get(i).getID() == addGradeHighSchoolStudentID) {
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        System.out.println("Please enter exam name withe the date  ex: Midterm 18-12-2022");
                        String examDetails = s1.next();
                        System.out.println("Enter the grade to be given");
                        double grade = s1.nextDouble();
                        SchoolManagement.getTeacher().get(inputID).gradeHighSchoolStudentByID(addGradeHighSchoolStudentID, examDetails, grade);
                    } else System.out.println("Invalid ID");
                } else System.out.println("Invalid action choice");
            } else System.out.println("Invalid ID");
        } else System.out.println("Invalid ID");
    }

    public void adminEditSupportStaff(){
        System.out.println("Enter your ID");
        int inputID = s1.nextInt();
        if (inputID < SchoolManagement.getSupportStaff().size()) {
            if (!SchoolManagement.getSupportStaff().get(inputID).getName().equals("Removed")) {
                System.out.println("1- Change data\n2- View data");
                int actionChoice = s1.nextInt();
                if (actionChoice == 1) { // Change Data
                    System.out.println("1- Change salary\n2- Change password");
                    int changeDataChoice = s1.nextInt();
                    if (changeDataChoice == 1) {
                        System.out.println("Input new salary");
                        int newSalary = s1.nextInt();
                        SchoolManagement.getSupportStaff().get(inputID).setSalary(newSalary);
                    } else if (changeDataChoice == 2) {
                        System.out.println("Enter your new password");
                        String newPassword = s1.next();
                        SchoolManagement.getSupportStaff().get(inputID).setPassword(newPassword);
                        System.out.println("Your password has been changed");
                    } else System.out.println("Invalid choice");
                } else if (actionChoice == 2) { // View Data
                    System.out.println("Name : " + SchoolManagement.getSupportStaff().get(inputID).getName());
                    System.out.println("Salary : " + SchoolManagement.getSupportStaff().get(inputID).getSalary());
                } else System.out.println("Invalid action choice");
            } else System.out.println("Invalid ID");
        } else System.out.println("Invalid input");
    }

    public void adminEditData(){
        System.out.println("Select a type to remove an ID from\n1- Primary Students\n2- HighSchool Students\n3- Teachers\n4- Support Staff\n..........");
        System.out.println("Select type to create new account for\n5- Primary Students\n6- HighSchool Students\n7- Teachers\n8- Support Staff\n..........");
        System.out.println("Select type to Enter by ID from\n9- Primary Students\n10- HighSchool Students\n11- Teachers\n12- Support Staff");
        int adminEditAction = s1.nextInt();
        if (adminEditAction == 1) { // Remove Primary Student
            adminRemoverPrimaryStudent();
        } else if (adminEditAction == 2) { // Remove HighSchool Student
            adminRemoveHighSchoolStudent();
        } else if (adminEditAction == 3) { // Remove Teacher
            adminRemoveTeacher();
        } else if (adminEditAction == 4) { // Remove SupportStaff
            adminRemoveSupportStaff();
        } else if (adminEditAction == 5) { // Add Primary Student
            adminAddPrimaryStudent();
        } else if (adminEditAction == 6) { // Add HighSchool Student
            adminAddHighSchoolStudent();
        } else if (adminEditAction == 7) { // Add Teacher
            adminAddTeacher();
        } else if (adminEditAction == 8) { // Add SupportStaff
            adminAddSupportStaff();
        } else if (adminEditAction == 9) { // Edit Primary Student By ID
            adminEditPrimaryStudent();
        } else if (adminEditAction == 10) { // Edit HighSchool Student By ID
            adminEditHighSchoolStudent();
        } else if (adminEditAction == 11) { // Edit Teacher By ID
            adminEditTeacher();
        } else if (adminEditAction == 12) { // Edit SupportStaff By ID
            adminEditSupportStaff();
        } else System.out.println("Invalid choice");
    }

    public void adminLogin() throws IOException {
        System.out.println("Enter admin password");
        String adminPassword = s1.next();
        if (adminPassword.equals("123")) {
            System.out.println("Choose action\n1- Department\n2- View data\n3- Edit data\n4- Save data");
            int adminAction = s1.nextInt();
            if (adminAction == 1) { // New Department
                adminNewDepartment();
            } else if (adminAction == 2) { // View Data
                adminViewData();
            } else if (adminAction == 3) { // Edit data
                adminEditData();
            } else if (adminAction == 4) {
                System.out.println("1- Confirm saving changes\n2- Exit");
                int adminAction4 = s1.nextInt();
                if (adminAction4 == 1) {
                    System.out.println(SchoolManagement.getPrimaryStudent().size());
                    clearFile();
                    writing();
                    System.out.println(SchoolManagement.getPrimaryStudent().size());
                } else if (adminAction4 == 2) System.out.println("Exiting");
                else System.out.println("Invalid choice");
            }
            else System.out.println("Invalid action");
        } else System.out.println("The administration password you have entered is incorrect");
    }

    public void start() throws IOException {
        read();
        for (; ; ) {
            System.out.println("select role\n1- Student\n2- Staff");
            int roleChoose1 = s1.nextInt();
            if (roleChoose1 == 1) {
                System.out.println("Select Student Type\n1- Primary Student\n2- Secondary Student");
                int answer1 = s1.nextInt();
                if (answer1 == 1) { // Level Primary Student
                    primaryStudentLogin();
                }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                else if (answer1 == 2) { // Level HighSchool Student
                    hIghSchoolStudentLogin();
                } else System.out.println("Invalid answer");

            } else if (roleChoose1 == 2) { // Staff

                System.out.println("Select role\n1- Teacher\n2- SupportStaff\n3- Admin");
                int roleChoose2 = s1.nextInt();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (roleChoose2 == 1) { // Teacher
                    teacherLogin();
                }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                else if (roleChoose2 == 2) { // SupportStaff
                    supportStaffLogin();
                }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                else if (roleChoose2 == 3) { // Admin
                    System.out.println("Enter to Exit the programme without saving");
                    int adminChoice = s1.nextInt();
                    if (adminChoice == 1){break;}
                    else adminLogin();
                } else System.out.println("Invalid answer");
            } else System.out.println("Invalid answer");
        }
    }
}
