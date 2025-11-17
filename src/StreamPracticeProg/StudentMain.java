package StreamPracticeProg;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Map.entry;

    public class StudentMain {


        public static void main(String[] args) {


            Set<Student> students = new HashSet<>(Arrays.asList(

                    new Student(3.8, "Alice Johnson", "Computer Science", 20, 2, 0),
                    new Student(3.9, "Eva Thompson", "Computer Science", 19, 1, 0),
                    new Student(3.7, "Isabella Clark", "Computer Science", 20, 2, 0),
                    new Student(3.4, "Liam Scott", "Computer Science", 22, 3, 1),
                    new Student(3.6, "Mia Lewis", "Computer Science", 23, 4, 0),
                    new Student(3.2, "Noah Walker", "Computer Science", 21, 2, 1),
                    new Student(3.5, "Olivia Hall", "Computer Science", 22, 3, 0),
                    new Student(3.2, "Bob Smith", "Mechanical Engineering", 22, 3, 1),
                    new Student(3.4, "Paul Reed", "Mechanical Engineering", 24, 4, 0),
                    new Student(3.1, "Quentin Gray", "Mechanical Engineering", 23, 3, 2),
                    new Student(3.6, "Rachel Young", "Mechanical Engineering", 21, 2, 1),
                    new Student(3.3, "Samuel King", "Mechanical Engineering", 25, 5, 0),
                    new Student(3.7, "Tina Brooks", "Mechanical Engineering", 22, 3, 0),
                    new Student(2.9, "Catherine Adams", "Civil Engineering", 21, 1, 2),
                    new Student(3.6, "David Brown", "Electrical Engineering", 23, 4, 0),
                    new Student(2.5, "Frank Martin", "Business Administration", 24, 4, 3),
                    new Student(3.4, "Grace Parker", "Psychology", 22, 3, 1),
                    new Student(3.1, "Henry Wilson", "Mathematics", 21, 2, 2),
                    new Student(2.8, "Jack Turner", "History", 23, 4, 4)

            ));


//        Write a program that takes a set of Student objects as input and performs the following operations:
//        Group the students by their major into a Map where the key is the major and
//        the value is a set of students in that major,
//        but only for majors with more than 5 students and an average GPA above 3.0.
//                Sort the students within each major in ascending order of their GPA,
//                and then by their age in descending order.
//                Return the Map containing the grouped and sorted students.


            Map<String, Set<Student>> collect1= students.stream().collect(Collectors.groupingBy(Student::getMajor, Collectors.toSet()))
                    .entrySet().stream().filter(e -> e.getValue().size() > 5 && e.getValue().stream()
                            .mapToDouble(Student::getGpa).average().orElse(0) > 3)
                    .map(stringSetEntry -> {
                        Set<Student> collect = stringSetEntry.getValue().stream().sorted(Comparator.comparing(Student::getGpa)
                                .thenComparing(Student::getAge).reversed()).collect(Collectors.toCollection(LinkedHashSet::new));
                        return entry(stringSetEntry.getKey(), collect);

                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            System.out.println(collect1);


        }
    }
