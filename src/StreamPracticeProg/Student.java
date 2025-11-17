package StreamPracticeProg;

public class Student {

        private double gpa;


        private String name;


        private String major;


        private int age;


        private int yearOfStudy;


        private int backlogs;

        public Student(double gpa, String name, String major, int age, int yearOfStudy, int backlogs) {


            this.gpa = gpa;


            this.name = name;


            this.major = major;


            this.age = age;


            this.yearOfStudy = yearOfStudy;


            this.backlogs = backlogs;


        }

        public double getGpa() {


            return gpa;


        }

        public String getName() {


            return name;


        }

        public String getMajor() {


            return major;


        }

        public int getAge() {


            return age;


        }

        public int getYearOfStudy() {


            return yearOfStudy;


        }

        public int getBacklogs() {


            return backlogs;


        }

        @Override


        public String toString() {


            return "Student{" +


                    "gpa=" + gpa +


                    ", name='" + name + '\'' +


                    ", major='" + major + '\'' +


                    ", age=" + age +


                    ", yearOfStudy=" + yearOfStudy +


                    ", backlogs=" + backlogs +


                    '}';


        }


    }
