import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeGender {
    private int id;
    private String name;
    private String gender;
    private int age;
    private double salary;

    // Constructor
    public EmployeeGender(int id, String name, String gender, int age, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    // Getter for gender
    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    // For printing employee details (optional)
    @Override
    public String toString() {
        return id + " - " + name + " (" + gender + "), Age: " + age + ", Salary: " + salary;
    }


    public static void main(String[] args) {
        // Sample employee list
        List<EmployeeGender> employees = Arrays.asList(
                new EmployeeGender(1, "Alice", "Female", 28, 50000),
                new EmployeeGender(2, "Bob", "Male", 32, 60000),
                new EmployeeGender(3, "Cathy", "Female", 26, 55000),
                new EmployeeGender(4, "David", "Male", 35, 70000),
                new EmployeeGender(5, "Eva", "Female", 30, 65000),
                new EmployeeGender(6, "Eva", "Female", 30, 65000)
        );

        // Using Stream API to group by gender and count
        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(EmployeeGender::getGender, Collectors.counting()));
//Gender Count: {Male=2, Female=3}

        // Print result
        System.out.println("Gender Count: " + genderCount);
        Set<String> duplicateNames = employees.stream()
                .collect(Collectors.groupingBy(EmployeeGender::getName, Collectors.counting())) // name -> count
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // keep only duplicates
                .map(Map.Entry::getKey)               // extract the name
                .collect(Collectors.toSet());         // collect to Set

        System.out.println("Duplicate names: " + duplicateNames); //Duplicate names: [Eva]
    }
}
