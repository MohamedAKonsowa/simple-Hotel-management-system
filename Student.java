import java.util.ArrayList;

public class Student {
    private final String name;
    private String address;
    private int attendance;
    private String password;
    private final int ID;
    private final ArrayList<String> grades = new ArrayList<>();

    public Student(String name, String address, String password, int ID) {
        this.name = name;
        this.address = address;
        this.password = password;
        this.ID = ID;
    }

    public String getGrades1(){
        StringBuilder output = new StringBuilder();
        for (String grade : grades) output.append(grade).append(",");
        return output.toString();
    }
    public ArrayList<String> getGrades() {
        return grades;
    }
    public String getName(){
        return name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress() {return address;}
    public int getID() {
        return ID;
    }
    public int getAttendance() {
        return attendance;
    }
    public void submitAttendance(){
        attendance++;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
    @Override
    public String toString() {
        StringBuilder grade = new StringBuilder();
        for (String s : grades) {
            grade.append(s).append("\n");
        }
        return "Name='" + name + '\'' + ", Address='" + address + '\'' + ", Attendance='" + attendance + "'\n Grades : \n"+grade;
    }
}
