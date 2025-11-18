package DSAAssgmnt;
    import java.util.*;

    public class SlidingWindowMaximum {

        public static int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] result = new int[n - k + 1];
            Deque<Integer> dq = new ArrayDeque<>();  // stores indices

            int idx = 0;

            for (int i = 0; i < n; i++) {

                // 1. Remove elements out of the current window
                while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    dq.pollFirst();
                }

                // 2. Maintain a monotonic decreasing deque
                while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                    dq.pollLast();
                }

                // 3. Add current element index
                dq.offerLast(i);

                // 4. If window has at least k elements, record max
                if (i >= k - 1) {
                    result[idx++] = nums[dq.peekFirst()];
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
            int k = 3;

            int[] res = maxSlidingWindow(nums, k);

            System.out.println("Sliding Window Maximum:");
            for (int x : res) {
                System.out.print(x + " ");
            }
        }
    }



