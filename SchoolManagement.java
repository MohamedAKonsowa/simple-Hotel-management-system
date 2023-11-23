import java.util.ArrayList;

public class SchoolManagement {
    private static final ArrayList<PrimaryStudent> primaryStudent = new ArrayList<>();
    private static final ArrayList<HighSchoolStudent> highSchoolStudent = new ArrayList<>();
    private static final ArrayList<Department> department = new ArrayList<>();
    private static final ArrayList<Teacher> teacher = new ArrayList<>();
    private static final ArrayList<SupportStaff> supportStaff = new ArrayList<>();


    public static void addPrimaryStudent(String name, String address, String password, int primaryStudentID){
        primaryStudent.add(new PrimaryStudent(name, address, password,primaryStudentID));
    }
    public static void addHighSchoolStudent(String name, String address, String password, int highSchoolStudentID){
        highSchoolStudent.add(new HighSchoolStudent(name, address, password, highSchoolStudentID));
    }
    public void addDepartment(String name){
        department.add(new Department(name));
    }
    public static void addTeacher(String name, double salary, String password){
        teacher.add(new Teacher(name, salary, password));
    }
    public static void addSupportStaff(String name, double salary, String password){
        supportStaff.add(new SupportStaff(name, salary, password));
    }
    public static ArrayList<PrimaryStudent> getPrimaryStudent(){
        return primaryStudent;
    }
    public static ArrayList<HighSchoolStudent> getHighSchoolStudent(){
        return highSchoolStudent;
    }
    public static ArrayList<Department> getDepartment() {
        return department;
    }
    public static ArrayList<Teacher> getTeacher() {
        return teacher;
    }
    public static ArrayList<SupportStaff> getSupportStaff() {
        return supportStaff;
    }
}
