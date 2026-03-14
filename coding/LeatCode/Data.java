package LeatCode;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Data {
    private String name;
    private double salary;
    private String department;
    public Data(String name, double salary, String department){
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args){
      List<Data> emp = Arrays.asList(
              new Data("Neelam", 22, "TECH"),
              new Data("Santosh", 12, "TECH"),
              new Data("Sadhna", 10, "HR"),
              new Data("Ruchi",10, "Admin")
      );
        // highest salary emp with dep
        Map<String, Data> highestSalaryByDept =
                emp.stream()
                        .collect(Collectors.groupingBy(
                                Data::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(Data::getSalary)),
                                        Optional::get
                                )
                        ));

        highestSalaryByDept.forEach((dept, data) ->
                System.out.println(dept + " -> " + data));
//TECH -> Data{name='Neelam', salary=22.0, department='TECH'}
//HR -> Data{name='Sadhna', salary=10.0, department='HR'}
//Admin -> Data{name='Ruchi', salary=10.0, department='Admin'}

      // highest salary with dep
  Map.Entry<String,Double> depWithSala = emp.stream()
          .collect(Collectors.groupingBy(Data::getDepartment,Collectors.summingDouble(Data::getSalary)))
                  .entrySet().stream().max(Map.Entry.comparingByValue()).get(); //TECH=34.0
      System.out.println(depWithSala);
      // dep with emp name
        Map<String,List<String>> depWithName = emp.stream()
                .collect(Collectors.groupingBy(Data::getDepartment,Collectors.mapping(Data::getName,Collectors.toList())));
      System.out.println(depWithName); //{TECH=[Neelam, Santosh], HR=[Sadhna], Admin=[Ruchi]}
      // map Name with Salary(sorted)
        /*List<Map.Entry<String,Double>> nameWithSala = emp.stream().collect(Collectors.toMap(Data::getName,Data::getSalary))
                        .entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        System.out.println(nameWithSala); */// [Ruchi=10.0, Sadhna=10.0, Santosh=12.0, Neelam=22.0]
        Map<String,Double> nameWithSala = emp.stream().collect(Collectors.toMap(Data::getName,Data::getSalary));
         List<Map.Entry<String,Double>> sortedSal = nameWithSala.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        System.out.println(nameWithSala); // [Ruchi=10.0, Sadhna=10.0, Santosh=12.0, Neelam=22.0]
        //highest salary employee
Data maxSalary = emp.stream().sorted((a,b)->Double.compare(b.getSalary(),a.getSalary())).findFirst().get();

        String s1 = "Hello";
        //s1.concat(" World");
       s1= s1.concat(" World");
        System.out.println(s1);


}
}
