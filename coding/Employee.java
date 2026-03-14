import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary, String hr) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + ": $" + salary;
    }


    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 80000, "HR"),
                new Employee("Jane", 95000, "HR"),
                new Employee("Alex", 120000, "HR"),
                new Employee("Sara", 110000, "HR"),
                new Employee("Tom", 105000, "HR")
        );
        // Stream to get top 3 highest salaries
        List<Employee> top3HighestSalaries = employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))  // Sort descending by salary
                .limit(3)  // Get top 3
                .collect(Collectors.toList());
        // Print top 3 employees
       // top3HighestSalaries.forEach(System.out::println); OR
        System.out.println(top3HighestSalaries);

        // 3rd highest salary
        Employee highest3Salary = employees.stream()
                .sorted((a,b)->Double.compare(b.getSalary(),a.getSalary()))
                .skip(2)
                .findFirst().get();
        System.out.println(highest3Salary);

 //output: Tom: $105000.0

        //find the max salary
        Employee maxSalary = employees.stream()
                .max((a,b)->Double.compare(a.getSalary(),b.getSalary())).get();
        System.out.println("maxSalary: "+maxSalary);

        Optional<Employee> maxSalar = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        //maxSalary: Alex: $120000.0

    }
}
