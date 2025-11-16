package TrainingProgs4;
import java.util.Scanner;

public class StrngRotStrng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        if (isRotation(s1, s2)) {
            System.out.println(s2 + " is a rotation of " + s1);
        } else {
            System.out.println(s2 + " is NOT a rotation of " + s1);
        }
    }

    public static boolean isRotation(String s1, String s2) {
        // Condition 1: Lengths must match
        if (s1.length() != s2.length()) {
            return false;
        }

        // Condition 2: Check if s2 exists in s1+s1
        String temp = s1 + s2;
        return temp.contains(s2);
    }
}