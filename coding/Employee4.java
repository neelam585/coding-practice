import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

class Employee4 {
    private String name;
    private int age;
    private int salary;

    Employee4(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Employee4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        List<Employee4> employees = Arrays.asList(
                new Employee4("Amit", 31, 20000),
                new Employee4("Aman", 31, 19000),
                new Employee4("Sita", 35, 22000),
                new Employee4("Ganesh", 25, 10000)
        );

        // ✅ Filter (age > 30) and sort by age then salary
        List<Employee4> result = employees.stream()
                .filter(e -> e.getAge() > 30) // only age > 30
                .sorted(Comparator.comparingInt((Employee4 e) -> e.getAge())
                        .thenComparingInt(e -> e.getSalary()))
                .collect(Collectors.toList());
           //System.out.println(result);
        // Print result
        result.forEach(System.out::println);
    }
}
