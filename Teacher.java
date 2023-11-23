import java.util.ArrayList;

public class Teacher extends Employee{
    private String department;
    private final ArrayList<PrimaryStudent> primaryStudents = new ArrayList<>();
    private final ArrayList<HighSchoolStudent> highSchoolStudents = new ArrayList<>();
    public Teacher(String name, double salary, String password) {
        super(name, salary, password);
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    public void addPrimaryStudent(PrimaryStudent primaryStudent){
        primaryStudents.add(primaryStudent);
    }
    public void addHighSchoolStudent(HighSchoolStudent highSchoolStudent){
        highSchoolStudents.add(highSchoolStudent);
    }

    public ArrayList<PrimaryStudent> getPrimaryStudents() {
        return primaryStudents;
    }

    public ArrayList<HighSchoolStudent> getHighSchoolStudents() {
        return highSchoolStudents;
    }



    public String getPrimaryStudents1() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < primaryStudents.size(); i++){
            if (i == primaryStudents.size()-1) output.append(primaryStudents.get(i).getID());
            else output.append(primaryStudents.get(i).getID()).append(",");
        }
        return output.toString();
    }

    public String getHighSchoolStudents1() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < highSchoolStudents.size(); i++){
            if (i == highSchoolStudents.size()-1) output.append(highSchoolStudents.get(i).getID());
            else output.append(highSchoolStudents.get(i).getID()).append(",");
        }
        return output.toString();
    }








    public void primaryStudents() {
        if (primaryStudents.size() != 0){
            System.out.println("Primary Students");
            for (PrimaryStudent primaryStudent : primaryStudents) {
                System.out.println(primaryStudent.getName() + " ID: " + primaryStudent.getID());
            }
        }
        else System.out.println("There are no primary students that are being taught by teacher "+getName());
    }
    public void highSchoolStudents() {
        if (highSchoolStudents.size() != 0){
            System.out.println("HighSchool Students");
            for (HighSchoolStudent highSchoolStudent : highSchoolStudents) {
                System.out.println(highSchoolStudent.getName() + " ID: " + highSchoolStudent.getID());
            }
        }
        else System.out.println("There are no highSchool students that are being taught by teacher "+getName());
    }

    public void gradePrimaryStudentByID(int studentID,String examDetails, double grade){
        int index = -1;
        for (int i = 0;i  < primaryStudents.size(); i++){
            if (primaryStudents.get(i).getID() == studentID){
                index = i;
                break;
            }
        }
        if (index != -1){
        primaryStudents.get(index).getGrades().add(getName()+" : "+department+" : "+examDetails+" : "+grade);}
    }
    public void gradeHighSchoolStudentByID(int studentID,String examDetails, double grade){
        int index = -1;
        for (int i = 0;i  < highSchoolStudents.size(); i++){
            if (highSchoolStudents.get(i).getID() == studentID){
                index = i;
                break;
            }
        }
        if (index != -1){
        highSchoolStudents.get(index).getGrades().add(getName()+" : "+department+" : "+examDetails+" : "+grade);}
    }

    @Override
    public String toString() {
        return "Name='" + getName() + '\'' +
                ",Department='" + department + '\'' + ",Salary='" + getSalary() + '\'';
    }


}
