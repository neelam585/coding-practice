import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeePeek {
    private int empIdd;
    private String empNamee;
    private double empSalary;

    // Constructor
    public EmployeePeek(int empIdd, String empNamee, double empSalary) {
        this.empIdd = empIdd;
        this.empNamee = empNamee;
        this.empSalary = empSalary;
    }

    // Getters and Setters
    public int getEmpIdd() {
        return empIdd;
    }

    public String getEmpNamee() {
        return empNamee;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return empIdd + " - " + empNamee + " - " + empSalary;
    }



    public static void main(String[] args) {

        // Sample employee list
        List<EmployeePeek> list = Arrays.asList(
                new EmployeePeek(101, "Neelam", 4000),
                new EmployeePeek(102, "Rahul", 7000),
                new EmployeePeek(103, "Priya", 12000),
                new EmployeePeek(104, "Amit", 9000)
        );

        // Convert employee salaries and collect into Map
        Map<Integer, String> data = list.stream()
                .peek(e -> e.setEmpSalary(getEmpSalary(e.getEmpSalary()))) // double the salary
                //.map(e->e.getEmpSalary()*2)
                .filter(e -> e.getEmpSalary() > 8000)                     // filter > 8000
                .collect(Collectors.toMap(EmployeePeek::getEmpIdd, EmployeePeek::getEmpNamee));
        System.out.println("Filtered Employee Map: " + data);//Filtered Employee Map: {102=Rahul, 103=Priya, 104=Amit}

Map<Integer,String> collect1 = list.stream()
        .filter(e -> e.getEmpSalary() > 8000)
        .collect(Collectors.toMap(EmployeePeek::getEmpIdd,EmployeePeek::getEmpNamee));
System.out.println("collect1 "+ collect1);


        // Print updated employees for clarity
        //list.forEach(System.out::println);
    }

    // Helper method to modify salary
    private static double getEmpSalary(double currentSalary) {
        return currentSalary * 2;
    }
}
