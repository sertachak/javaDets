import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainLambda {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Efo", 2);
        Employee employee2 = new Employee("Coko", 1);
        Employee employee3 = new Employee("Mete", 2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.sort((emply1, emply2) -> emply1.getName().compareTo(emply2.getName()));


        for(Employee employee : employeeList){
            System.out.println(employee.getName());
        }

    }
}

interface UpperConcat{
    String upperConcat(String s1, String s2);
}

class AnotherClass{

    public String doSomething(){
        UpperConcat uc = ((s1, s2) -> {
            System.out.println("here");
             return s1.toUpperCase() + s2.toUpperCase();
        });
        return null;
    }

}
