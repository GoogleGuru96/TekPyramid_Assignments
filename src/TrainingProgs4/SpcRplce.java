package TrainingProgs4;

import java.util.Scanner;

public class SpcRplce {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            System.out.print("Enter the character to replace spaces with: ");
            char ch = sc.next().charAt(0);

            String result = input.replace(' ', ch);

            System.out.println("Original String : " + input);
            System.out.println("Modified String : " + result);
        }
    }
