package StreamPracticeProg2;

public class Student1 {

        private String name;
        private String major;
        private int age;
        private int yearsOfEnrollment;     // number of years enrolled
        private double gpa;
        private int numberOfIncompleteCourses;
        private boolean onProbation;       // needed for Task 3

        public Student1(String name, String major, int age, int yearsOfEnrollment,
                       double gpa, int numberOfIncompleteCourses, boolean onProbation) {
            this.name = name;
            this.major = major;
            this.age = age;
            this.yearsOfEnrollment = yearsOfEnrollment;
            this.gpa = gpa;
            this.numberOfIncompleteCourses = numberOfIncompleteCourses;
            this.onProbation = onProbation;
        }

        public String getName() { return name; }
        public String getMajor() { return major; }
        public int getAge() { return age; }
        public int getYearsOfEnrollment() { return yearsOfEnrollment; }
        public double getGpa() { return gpa; }
        public int getNumberOfIncompleteCourses() { return numberOfIncompleteCourses; }
        public boolean isOnProbation() { return onProbation; }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", major='" + major + '\'' +
                    ", age=" + age +
                    ", yearsOfEnrollment=" + yearsOfEnrollment +
                    ", gpa=" + gpa +
                    ", incompleteCourses=" + numberOfIncompleteCourses +
                    ", onProbation=" + onProbation +
                    '}';
        }
    }
