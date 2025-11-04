package TrainingProgs;

public class RemoveDupArry {
        public static void main(String[] args) {
            int[] arr = {10, 20, 10, 30, 40, 20, 50, 10};
            int n = arr.length;
            boolean[] visited = new boolean[n];

            System.out.println("Duplicate elements:");

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                int count = 1;

                for (int j = i + 1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        visited[j] = true;
                        count++;
                    }
                }

                if (count > 1) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
