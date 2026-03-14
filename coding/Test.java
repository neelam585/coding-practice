//package com.src;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args){
        Employee e1 = new Employee(1,"ABC","HR",new BigDecimal(10000));
        Employee e2 = new Employee(2,"DEF",null,new BigDecimal(20000));
        Employee e3 = new Employee(3,"GHI","IT",new BigDecimal(50000));
        Employee e4 = new Employee(4,"JKL","HR",new BigDecimal(60000));
        Employee e5 = new Employee(5,"MNO","HR",new BigDecimal(180000));
        Employee e6 = new Employee(6,"PQR","IT",new BigDecimal(15000));
        List<Employee>  employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        BigDecimal totalSalary = getTotalSalary(employeeList,"HR");
        System.out.println("Total salary of employees: "+totalSalary);

    }

    private static BigDecimal getTotalSalary(List<Employee> employeeList, String department) {
        //write logic to get sum of salary of employees belonging to a department
        //BigDecimal sum = employeeList.stream().filter(n-> Boolean.parseBoolean(n.department)).reduce(BigDecimal.ZERO,(a, b)->a.getSalary().add(b.getSalary()));
        BigDecimal sum = employeeList.stream()
                .filter(employee -> department.equals(employee.getDepartment())) // filter by department
                .map(Employee::getSalary) // extract the salary from each employee
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //BigDecimal suma = employeeList.stream().filter(n-> Boolean.parseBoolean(n.department)).reduce(BigDecimal.ZERO,(a, b)->a.add(b));
        //return BigDecimal.ZERO;

        // Group employees by department and sum their salaries
       /* Map<String, Double> departmentSalaries = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, // Group by department
                        Collectors.summingDouble(Employee::getSalary) // Sum salaries within each department
                ));*/
        return sum;
    }

    private static class Employee{
        private int empId;
        private String empName;
        private String department;
        private BigDecimal salary;

        public Employee(int empId, String empName, String department, BigDecimal salary) {
            this.empId = empId;
            this.empName = empName;
            this.department = department;
            this.salary = salary;
        }

        public Employee(){}

        public int getEmpId() {
            return empId;
        }

        public void setEmpId(int empId) {
            this.empId = empId;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }
    }
}



