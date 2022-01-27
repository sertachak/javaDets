import java.util.ArrayList;
import java.util.List;

public class Department {

    private final String departmentName;
    private List<Employee> employees;

    public Department(String departmentName){
        this.departmentName = departmentName;
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void addEmployee(Employee emp){
       employees.add(emp);
    }
}
