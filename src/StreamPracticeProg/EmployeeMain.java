package StreamPracticeProg;

import java.util.Arrays;

import java.util.Comparator;

import java.util.List;

import java.util.Map;

import java.util.stream.Collectors;

import java.util.stream.Stream;

public class EmployeeMain {

        public static void main(String[] args) {


            List<Employee> employees = List.of(

                    new Employee("Alice Johnson", "IT", "Manager", 38, 4, 120000, 4),

                    new Employee("Bob Smith", "IT", "Developer", 29, 5, 125000, 5),

                    new Employee("Charlie Davis", "HR", "Manager", 45, 18, 150000, 3),

                    new Employee("Diana Patel", "Finance", "Analyst", 32, 7, 78000, 4 ),

                    new Employee("Ethan Brown", "Sales", "Manager", 41, 2, 110000, 2),

                    new Employee("Fiona Wilson", "Marketing", "Executive", 27, 3, 62000, 5),

                    new Employee("George Miller", "IT", "Developer", 36, 10, 98000, 3),

                    new Employee("Hannah Garcia", "HR", "Manager", 30, 6, 95000, 4),

                    new Employee("Ian Thompson", "Finance", "Manager", 50, 3, 175000, 5),

                    new Employee("Julia Roberts", "Sales", "Executive", 28, 4, 70000, 3)

            );



            //Implement a program that reads a list of Employee objects from the user and performs the following operations:

            //Filter out all employees who are managers and have a salary greater than 100,000, but have joined in the last 3 years.

            //Sort the remaining employees in descending order of their years of experience, and then by their performance ratings in ascending order.

            //Return a new list containing the names of the remaining employees, but with each name reversed and in uppercase.


            List<StringBuilder> builderList = employees.stream().filter(employee -> !(employee.getJobTitle().equals("Manager")
                            && employee.getSalary() > 100000 && employee.getYearsOfExperience() > 3))

                    .sorted(Comparator.comparing(Employee::getYearsOfExperience).reversed()

                            .thenComparing(Employee::getPerformanceRating))

                    .map(employee -> new StringBuilder(employee.getName()

                            .toUpperCase()).reverse()).toList();

            System.out.println(builderList);

        }

    }
