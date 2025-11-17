package StreamPracticeProg2;


import java.util.*;
import java.util.stream.Collectors;

public class Employee1Main {

        public static void main(String[] args) {

            List<Employee1> employees = List.of(
                    new Employee1(1, "Guru", "IT", "Developer", 28, 3, 75000, 7),
                    new Employee1(2, "Karan", "IT", "Senior Dev", 32, 8, 90000, 9),
                    new Employee1(3, "Vishal", "HR", "Manager", 40, 15, 120000, 6),
                    new Employee1(4, "Ramesh", "Finance", "Analyst", 26, 2, 65000, 7),
                    new Employee1(5, "Suresh", "IT", "Architect", 38, 12, 115000, 9)
            );

            List<Integer> result = employees.stream()

                    // Task 1: Filter employees
                    .filter(e ->
                            e.getYearsOfExperience() < 5 &&            // joined in last 5 years
                                    e.getPerformanceRating() < 8 &&           // rating < 8
                                    e.getSalary() >= 60000 && e.getSalary() <= 120000 // salary between 60k–120k
                    )

                    // Task 2: Sort by salary ASC, then experience DESC
                    .sorted(Comparator.comparingDouble(Employee1::getSalary)
                            .thenComparing(Comparator.comparingInt(Employee1::getYearsOfExperience).reversed())
                    )

                    // Task 3: Return ID * 10
                    .map(e -> e.getId() * 10)

                    .collect(Collectors.toList());

            System.out.println("Filtered & Processed Employee IDs: " + result);
        }
    }
