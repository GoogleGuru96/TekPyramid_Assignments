package DSAAssgmnt;

import java.util.Stack;

public class MinStack {

        private Stack<Integer> stack;      // main stack
        private Stack<Integer> minStack;   // keeps track of minimum elements

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);

            // If minStack is empty OR new value <= current minimum
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            int removed = stack.pop();

            // If removed element was the minimum, pop from minStack also
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return minStack.peek();
        }

        public static void main(String[] args) {
            MinStack minStack = new MinStack();

            minStack.push(5);
            minStack.push(3);
            minStack.push(7);
            minStack.push(2);

            System.out.println("Minimum = " + minStack.getMin()); // 2

            minStack.pop(); // removes 2
            System.out.println("Minimum = " + minStack.getMin()); // 3

            minStack.pop(); // removes 7
            System.out.println("Top = " + minStack.top());        // 3
            System.out.println("Minimum = " + minStack.getMin()); // 3
        }
    }


