import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

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


/*        for(Employee employee : employeeList){
            System.out.println(employee.getName());
        }*/

        employeeList.forEach(employee -> System.out.println(employee.getName()));


        printEmployeeByAge(employeeList, "Employess over 2", employee -> employee.getAge() > 1);

        Function<Employee, String> getLastName = (Employee employee) ->{
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

    }

    public static void printEmployeeByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        Predicate<Employee> lowerThanThree = employee -> employee.getAge() < 3;
        System.out.println(ageText);
        employees.forEach(employee -> {
            if(ageCondition.and(lowerThanThree).test(employee)){
                System.out.println(employee.getName());

            }
        });
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
