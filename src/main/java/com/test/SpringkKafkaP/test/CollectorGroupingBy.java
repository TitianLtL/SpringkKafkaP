package com.test.SpringkKafkaP.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorGroupingBy {
    public static void main(String[] args) {
        // Sample data
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 1000d),
                new Employee("Bob", "HR", 2000d),
                new Employee("Charlie", "IT", 30000d),
                new Employee("Charlie", "SEL", 30000d),
                new Employee("David", "HR", 1000d)
        );

        Map<String, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dep,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));

        // Print the result
        System.out.println(namesByDept);
        // Output: {HR=[Bob, David], IT=[Alice, Charlie]}

        Map<String, Employee> findThem = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::dep,
                        Collectors.collectingAndThen(
                            Collectors.maxBy(
                                    Comparator.comparingDouble(Employee::sal))
                            ,Optional::get)
                        )
                );
        System.out.println(findThem);
    }

}

record Employee (String name, String dep, Double sal){
}