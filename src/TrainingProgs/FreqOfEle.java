package TrainingProgs;

public class FreqOfEle {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 30, 40, 40, 20, 30};
        int n = arr.length;

        boolean[] Elements = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (Elements[i]) {

                continue;
            }

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    Elements[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " occured " + count + " times");
        }
    }
}
