package DSAAssgmnt;

import java.util.Stack;

public class NextGreaterElement {


        public static int[] nextGreater(int[] arr) {
            int n = arr.length;
            int[] result = new int[n];
            Stack<Integer> stack = new Stack<>();  // stores indices

            for (int i = n - 1; i >= 0; i--) {

                // Pop all elements smaller or equal to current
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }

                // If stack is empty → no next greater element
                result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];

                // Push current index
                stack.push(i);
            }

            return result;
        }

        public static void main(String[] args) {
            int[] arr = {4, 5, 2, 25, 7, 8};
            int[] ans = nextGreater(arr);

            System.out.println("Next Greater Elements:");
            for (int x : ans) {
                System.out.print(x + " ");
            }
        }
    }


