package com.home.thread.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeePractice {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));

        //Example: Sort employees by salary in descending order.

        List<Employee> salarySorted = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(salarySorted);

        //get total salary

        long sum = empList.stream().mapToLong(employee -> employee.getSalary()).sum();
        System.out.println(sum);

        //Example 1: Check if any employee earns more than 80,000.

        boolean b = empList.stream().anyMatch(emp -> emp.getSalary() > 100);
        System.out.println(b);

        //Example: Find the employee with the highest salary.

        Employee maxEmployee = empList.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(maxEmployee);

       // Example: Find the employee with the lowest salary.
        Employee minEmployee = empList.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(minEmployee);

    }
}
