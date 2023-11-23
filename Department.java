public class Department {

    private final String name;
    private int noTeachers;
    public Department(String name) {
        this.name = name;
    }

    public void addTeacher(Teacher teacher){
        noTeachers++;
        teacher.setDepartment(name);
    }
    public int getNoTeachers(){
        return noTeachers;
    }
    public String getName(){
        return name;
    }
}
