package TrainingProgs2;

import java.util.Scanner;

public class ThrdLargstEleArry {
    public static void main(String[] args) {
        int[] arr = {10,80,20,70,30,60,40,50};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (num > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            }
            else if (num > secondLargest && num != largest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            }
            else if (num > thirdLargest && num != secondLargest && num != largest) {
                thirdLargest = num;
            }
        }

        System.out.println("The largest element in the array is: " + largest);
        System.out.println("The second largest element in the array is: " + secondLargest);
        System.out.println("The third largest element in the array is: " + thirdLargest);
    }
}
