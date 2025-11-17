package StreamPracticeProg2;


import java.util.*;
import java.util.stream.Collectors;

public class Employee2Main {
    public static void main(String[] args) {

        // ---------------------------------------
        // SAMPLE EMPLOYEE DATA ADDED HERE
        // ---------------------------------------

        List<Employee2> employees = List.of(
                new Employee2(1, "Guru", "IT", "Developer", 26, 3, 75000, 7, false),
                new Employee2(2, "Karan", "Sales", "Executive", 30, 2, 45000, 6, true),
                new Employee2(3, "Vishal", "Marketing", "Analyst", 28, 4, 40000, 7, true),
                new Employee2(4, "Ramesh", "Finance", "Manager", 40, 10, 120000, 9, false),
                new Employee2(5, "Suresh", "IT", "Architect", 36, 12, 110000, 8, false),
                new Employee2(6, "Anita", "IT", "Tester", 24, 1, 62000, 6, false),
                new Employee2(7, "John", "Sales", "Lead", 32, 7, 70000, 9, false),
                new Employee2(8, "Meena", "HR", "Recruiter", 29, 4, 58000, 7, false)
        );

        // ---------------------------------------
        // TASK 1: Filter, Sort, ID * 10
        // ---------------------------------------

        List<Integer> processedIDs = employees.stream()
                .filter(e ->
                        e.getYearsOfExperience() < 5 &&
                                e.getPerformanceRating() < 8 &&
                                e.getSalary() >= 60000 && e.getSalary() <= 120000
                )
                .sorted(Comparator.comparingDouble(Employee2::getSalary)
                        .thenComparing(Comparator.comparingInt(Employee2::getYearsOfExperience).reversed()))
                .map(e -> e.getId() * 10)
                .collect(Collectors.toList());

        // ---------------------------------------
        // TASK 2: Filter, salary sum, avg age
        // ---------------------------------------

        List<Employee2> remaining = employees.stream()
                .filter(e ->
                        !(e.isPartTime()
                                && e.getSalary() < 50000
                                && (e.getDepartment().equalsIgnoreCase("Sales")
                                || e.getDepartment().equalsIgnoreCase("Marketing")))
                )
                .collect(Collectors.toList());

        double salarySum = remaining.stream()
                .filter(e -> e.getYearsOfExperience() > 3)
                .mapToDouble(Employee2::getSalary)
                .sum();

        OptionalDouble averageAge = remaining.stream()
                .filter(e -> e.getPerformanceRating() >= 7)
                .mapToInt(Employee2::getAge)
                .average();

        // ---------------------------------------
        // OUTPUT SECTION
        // ---------------------------------------

        System.out.println("\n================ RESULTS ================");

        System.out.println("\nTask 1 → IDs * 10 after filtering & sorting:");
        System.out.println(processedIDs);

        System.out.println("\nTask 2 → Employees after removing part-time Sales/Marketing (<50k):");
        remaining.forEach(System.out::println);

        System.out.println("\nTask 2 → Sum of salaries (experience > 3 years): " + salarySum);

        if (averageAge.isPresent()) {
            System.out.println("Task 2 → Average age (rating ≥ 7): " + averageAge.getAsDouble());
        } else {
            System.out.println("Task 2 → No employees with rating ≥ 7.");
        }
    }
}