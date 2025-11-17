package StreamPracticeProg2;

    import java.util.*;
import java.util.stream.Collectors;
public class Student1Main {

        public static void main(String[] args) {

            // -------------------------------------------------------
            // SAMPLE DATA (You can replace with scanner input if needed)
            // -------------------------------------------------------

            List<Student1> students = List.of(
                    new Student1("Arun", "Mathematics", 25, 2, 3.7, 0, false),
                    new Student1("Gita", "Mathematics", 24, 2, 3.8, 1, false),
                    new Student1("Ravi", "Mathematics", 23, 3, 3.9, 2, false),
                    new Student1("Savi", "Mathematics", 27, 1, 3.6, 1, false),
                    new Student1("Manu", "Mathematics", 26, 2, 3.5, 1, false),
                    new Student1("Hari", "Mathematics", 28, 2, 3.8, 0, false),
                    new Student1("Laksh", "Mathematics", 24, 3, 3.9, 2, false),
                    new Student1("Teju", "Mathematics", 23, 2, 3.6, 0, false)

            );

            // =======================================================
            //                       TASK 2
            // =======================================================

            System.out.println("\n=========== TASK 2 RESULTS ===========");

            // (A) Filter: GPA < avg GPA AND age > 18 AND major = Bio/Chem
            double avgGpa = students.stream().mapToDouble(Student1::getGpa).average().orElse(0);

            List<Student1> task2Filtered = students.stream()
                    .filter(s -> s.getGpa() < avgGpa)
                    .filter(s -> s.getAge() > 18)
                    .filter(s -> s.getMajor().equalsIgnoreCase("Biology")
                            || s.getMajor().equalsIgnoreCase("Chemistry"))
                    .collect(Collectors.toList());

            System.out.println("\nTask 2 → Filtered Students:");
            task2Filtered.forEach(System.out::println);

            // (B) Total years for remaining: joined last 4 yrs AND major CS/Engg
            int totalYears = task2Filtered.stream()
                    .filter(s -> s.getYearsOfEnrollment() <= 4)
                    .filter(s -> s.getMajor().equalsIgnoreCase("Computer Science")
                            || s.getMajor().equalsIgnoreCase("Engineering"))
                    .mapToInt(Student1::getYearsOfEnrollment)
                    .sum();

            System.out.println("\nTask 2 → Total Years of Enrollment (conditions applied): " + totalYears);

            // (C) Student with highest enrollment (age < 30 AND GPA > 3.7)
            Optional<Student1> topEnrolled = task2Filtered.stream()
                    .filter(s -> s.getAge() < 30)
                    .filter(s -> s.getGpa() > 3.7)
                    .max(Comparator.comparingInt(Student1::getYearsOfEnrollment));

            System.out.println("\nTask 2 → Student with highest enrollment:");
            System.out.println(topEnrolled.orElse(null));

            // =======================================================
            //                       TASK 3
            // =======================================================

            System.out.println("\n\n=========== TASK 3 RESULTS ===========");

            // (A) Filter: joined < 3yrs AND Math major AND GPA<3.0 AND on probation
            List<Student1> task3Filtered = students.stream()
                    .filter(s -> s.getYearsOfEnrollment() < 3)
                    .filter(s -> s.getMajor().equalsIgnoreCase("Mathematics"))
                    .filter(s -> s.getGpa() < 3.0)
                    .filter(Student1::isOnProbation)
                    .collect(Collectors.toList());

            System.out.println("\nTask 3 → Filtered Students:");
            task3Filtered.forEach(System.out::println);

            // (B) Sum of GPAs: age > 22 AND GPA > avg GPA
            double avgGpaAll = students.stream().mapToDouble(Student1::getGpa).average().orElse(0);

            double gpaSum = task3Filtered.stream()
                    .filter(s -> s.getAge() > 22)
                    .filter(s -> s.getGpa() > avgGpaAll)
                    .mapToDouble(Student1::getGpa)
                    .sum();

            System.out.println("\nTask 3 → Sum of GPAs: " + gpaSum);

            // (C) Average age: department has >10 students & avg GPA > 3.5
            long mathCount = students.stream()
                    .filter(s -> s.getMajor().equalsIgnoreCase("Mathematics"))
                    .count();

            double deptAvgGpa = students.stream()
                    .filter(s -> s.getMajor().equalsIgnoreCase("Mathematics"))
                    .mapToDouble(Student1::getGpa)
                    .average().orElse(0);

            OptionalDouble mathAvgAge = OptionalDouble.empty();

            if (mathCount > 10 && deptAvgGpa > 3.5) {
                mathAvgAge = students.stream()
                        .filter(s -> s.getMajor().equalsIgnoreCase("Mathematics"))
                        .mapToInt(Student1::getAge)
                        .average();
            }

            System.out.println("\nTask 3 → Average Age (special condition): " +
                    (mathAvgAge.isPresent() ? mathAvgAge.getAsDouble() : "Condition not met"));

            // (D) Factorial of average age if conditions on all students met
            int totalYearsAll = students.stream().mapToInt(Student1::getYearsOfEnrollment).sum();
            double overallAvgGpa = avgGpaAll;

            if (totalYearsAll > 30 && overallAvgGpa < 3.9 && mathAvgAge.isPresent()) {
                int factInput = (int) mathAvgAge.getAsDouble();
                long factorial = factorial(factInput);

                System.out.println("\nTask 3 → Factorial of average age: " + factorial);
            } else {
                System.out.println("\nTask 3 → Factorial condition not met.");
            }
        }

        // Helper factorial
        public static long factorial(int n) {
            if (n <= 1) return 1;
            return n * factorial(n - 1);
        }
    }
