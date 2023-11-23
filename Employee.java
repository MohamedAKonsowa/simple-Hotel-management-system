public class Employee {
    private final String name;
    private double salary;
    private String password;

    public Employee(String name, double salary, String password) {
        this.name = name;
        this.salary = salary;
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
