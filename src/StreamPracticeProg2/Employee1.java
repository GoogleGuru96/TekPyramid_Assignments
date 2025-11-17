package StreamPracticeProg2;


    public class Employee1 {

        private int id;
        private String name;
        private String department;
        private String jobTitle;
        private int age;
        private int yearsOfExperience;
        private double salary;
        private int performanceRating;

        public Employee1(int id, String name, String department, String jobTitle,
                         int age, int yearsOfExperience, double salary, int performanceRating) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.jobTitle = jobTitle;
            this.age = age;
            this.yearsOfExperience = yearsOfExperience;
            this.salary = salary;
            this.performanceRating = performanceRating;
        }

        public int getId() {
            return id;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public String getJobTitle() { return jobTitle; }
        public int getAge() { return age; }
        public int getYearsOfExperience() { return yearsOfExperience; }
        public double getSalary() { return salary; }
        public int getPerformanceRating() { return performanceRating; }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", age=" + age +
                    ", yearsOfExperience=" + yearsOfExperience +
                    ", salary=" + salary +
                    ", performanceRating=" + performanceRating +
                    '}';
        }
    }
