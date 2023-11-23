public class SupportStaff extends Employee{
    public SupportStaff(String name, double salary, String password) {
        super(name, salary, password);
    }

    @Override
    public String toString() {
        return "Name='" + getName() + '\'' +
                ",Salary='" + getSalary() + '\'';
    }
}
