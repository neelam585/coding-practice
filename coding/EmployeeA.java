import java.util.*;
import java.util.stream.Collectors;

class EmployeeA {
    String name;
    int age;
    double salary;

    EmployeeA(String name, int age, double salary) {
        this.name = name;
        this.age = age;
       this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }

    public static void main(String[] args) {
        List<EmployeeA> employees = Arrays.asList(
                new EmployeeA("Alice", 28, 50000),
                new EmployeeA("Bob", 35, 60000),
                new EmployeeA("Charlie", 35, 70000),
                new EmployeeA("David", 28, 40000),
                new EmployeeA("Eve", 45, 80000)
                /*new EmployeeA("Alice", 28),
                new EmployeeA("Bob", 35),
                new EmployeeA("Charlie", 35),
                new EmployeeA("David", 28),
                new EmployeeA("Eve", 45)*/
        );

        //List of employee who has salary > 50000
        List<EmployeeA> name = employees.stream().filter(s->s.getSalary()>50000).toList();
        System.out.println("EmployeeName " +name);

        //calculate the average salary
        Double averageSalary = employees.stream().mapToDouble(EmployeeA::getSalary).average().getAsDouble();
        System.out.println(averageSalary);

// write a stream operation to find the distinct ages and their associated names.
        Map<Integer, List<String>> ageToNames = employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeA::getAge,
                        Collectors.mapping(EmployeeA::getName, Collectors.toList())
                ));
        System.out.println(ageToNames);//{35=[Bob, Charlie], 28=[Alice, David], 45=[Eve]}
        Map<Integer, List<EmployeeA>> groupedByAge = employees.stream()
                .collect(Collectors.groupingBy(EmployeeA::getAge));

        System.out.println("groupedByAge" +groupedByAge);

// name associate to salary
        Map<String, Double> nameToSalary = employees.stream()
                .collect(Collectors.toMap(
                        EmployeeA::getName,
                        EmployeeA::getSalary
                ));
        System.out.println(nameToSalary);
//{Bob=60000.0, Eve=80000.0, Alice=50000.0, Charlie=70000.0, David=40000.0}
    }

}