import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<String> someNumbers = Arrays.asList( "N1", "S3", "A7", "Z5", "3R", "N4", "N9", "N5");
        someNumbers.stream().filter( n-> n.startsWith("N")).sorted().forEach(System.out::println);
        someNumbers.forEach(System.out::println);

        Employee john = new Employee("John", 21);
        Employee coko = new Employee("Coko", 44);
        Employee efo = new Employee("Efo", 33);
        Employee sugar = new Employee("Sugar", 11);

        Department gang = new Department("Gang");
        Department boyz = new Department("Boyz");
        List<Department> departments = new ArrayList<>();
        departments.add(gang);
        departments.add(boyz);
        gang.addEmployee(john);
        boyz.addEmployee(coko);
        boyz.addEmployee(efo);
        gang.addEmployee(sugar);

        System.out.println("---------------------");

        departments.stream().flatMap(department -> department.getEmployees().stream()).forEach(System.out::println);


    }
}
