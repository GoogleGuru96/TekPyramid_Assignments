package TrainingProgs;

public class RemoveDupArry1 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 40, 20, 50, 10};
        int n = arr.length;
        boolean[] visited = new boolean[n];

        // Create a new array to store unique elements
        int[] unique = new int[n];
        int index = 0;

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

            // If element occurs at least once, add it to unique array
            unique[index++] = arr[i];
        }

        // Print unique elements (trim unused slots)
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < index; i++) {
            System.out.print(unique[i] + " ");
        }
    }
}
