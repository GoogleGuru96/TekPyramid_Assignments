package TrainingProgs3;

    import java.util.Scanner;
public class DivStrng {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String str = sc.nextLine();

            System.out.print("Enter number of parts (N): ");
            int div = sc.nextInt();

            int length = str.length();

            /*if (length % div != 0) {
                System.out.println("String cannot be divided into " + div + " equal parts.");
            }
            else {/*/
                int partSize = length / div;
                System.out.println("Each part will have " + partSize + " characters.");

                System.out.println("\nDivided parts:");
                for (int i = 0; i < length; i=i+partSize) {
                    System.out.println(str.substring(i, i + partSize));
                }
            sc.close();
            }
        }
