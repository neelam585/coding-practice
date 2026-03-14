import java.util.*;
import java.util.stream.*;

 class Employee3 {
    private int id;
    private String name;
    private String dept;

    // Constructor
    public Employee3(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for dept
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    // toString method
    @Override
    public String toString() {
        return name;
    }
    public static void main(String[] args) {

        List<Employee3> employees = Arrays.asList(
                new Employee3(1, "Alice", "IT"),
                new Employee3(2, "Bob", "HR"),
                new Employee3(3, "Charlie", "IT"),
                new Employee3(4, "David", "Finance")
        );

        // 🔹 Group employees by department
        Map<String, List<Employee3>> deptMap = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.dept));
        Map<String, List<Employee3>> depEmp = employees.stream()
                .collect(Collectors.groupingBy(Employee3::getDept));
        System.out.println(depEmp);
        // 🔹 Print the result
        deptMap.forEach((dept, empList) ->
                System.out.println(dept + " -> " + empList)
        );

        // sort the name
        Map<Integer,String> mapWithName = employees.stream()
                .collect(Collectors.toMap(Employee3::getId,
                        Employee3::getName,
                        (e1,e2)->e1,
                        LinkedHashMap::new
                        ));
        List<String> sortName = mapWithName.values().stream().sorted().toList();
        System.out.println(sortName); //[Alice, Bob, Charlie, David]
//-------------------------------------------------------------------------------
        String s = "Java 8 is awesome!";

        List<String> list = Arrays.asList(s.split(" "));

        long countWord = list.stream().count();
        System.out.println(countWord); //4
        String[] strArray = s.split(" ");
        int count = strArray.length;
        System.out.println(count); // 4

    }
}// {Finance=[David], HR=[Bob], IT=[Alice, Charlie]}
/*Finance -> [David]
HR -> [Bob]
IT -> [Alice, Charlie]*/
