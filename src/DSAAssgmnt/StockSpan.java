package DSAAssgmnt;
import java.util.*;

    public class StockSpan {

        public static int[] calculateSpan(int[] prices) {
            int n = prices.length;
            int[] span = new int[n];
            Stack<Integer> stack = new Stack<>();  // stores indices of days

            // First day span is always 1
            span[0] = 1;
            stack.push(0);

            for (int i = 1; i < n; i++) {

                // Pop indices where price is <= current price
                while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                    stack.pop();
                }

                // If stack empty → no greater element on left
                span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

                // Push current index
                stack.push(i);
            }

            return span;
        }

        public static void main(String[] args) {
            int[] prices = {100, 80, 60, 70, 60, 75, 85};
            int[] result = calculateSpan(prices);

            System.out.println("Stock Span:");
            for (int x : result) {
                System.out.print(x + " ");
            }
        }
    }

