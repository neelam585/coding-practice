import java.util.*;
import java.util.stream.*;

public class Employee1 {
    private String department;
    private int empId;

    // Constructor
    public Employee1(String department, int empId) {
        this.department = department;
        this.empId = empId;
    }

    // Getter methods
    public String getDepartment() {
        return department;
    }

    public int getEmpId() {
        return empId;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee1{" +
                "department='" + department + '\'' +
                ", empId=" + empId +
                '}';
    }

    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
                new Employee1("HR", 101),
                new Employee1("Finance", 202),
                new Employee1("HR", 305),
                new Employee1("Finance", 402),
                new Employee1("IT", 500)
        );

        // Group employees by department and find the employee with the highest empId in each department
        Map<String, Optional<Employee1>> highestEmpInEachDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee1::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employee1::getEmpId))
                ));
    System.out.println(highestEmpInEachDept);
        // Output the employee with the highest empId for each department
        highestEmpInEachDept.forEach((department, emp) -> {
            emp.ifPresent(e -> System.out.println("Department: " + department + " | Employee ID: " + e.getEmpId()));
        });
    }
}
