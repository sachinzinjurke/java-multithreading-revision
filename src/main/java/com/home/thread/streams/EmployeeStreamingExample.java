package com.home.thread.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStreamingExample {

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

        //Find employee with max salary
        Optional<Employee> max = empList.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(max.get());

        //find male/female count

        Map<String, Long> count = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(count);

        //Find male/female count per depatr

        Map<String, Map<String, Long>> deptMaleFemaleCount = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println(deptMaleFemaleCount);

        //Find longest serving employees in the organization.

        Optional<Employee> first = empList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
        System.out.println(first);

        //highest salary in organization

        Optional<Employee> highestSalaryOrg = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();

        System.out.println(highestSalaryOrg);

        //second highest slary in orga
        Optional<Employee> secondHighest = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
        System.out.println("Second Highest Salary in the organisation : " + secondHighest.get().getSalary());

        //Print the top 3 highest salary earned employees in each department

        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName)).
                forEach((dept, employees) -> {
                    employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).forEach(System.out::println);
                });

        //Find highest paid salary in the organisation based on gender.
        Map<String, Optional<Employee>> genderMaxSalary = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        genderMaxSalary.forEach((gender,emp)-> System.out.println("Gender :: " + gender + " Employee:: " + emp) );





    }
}
