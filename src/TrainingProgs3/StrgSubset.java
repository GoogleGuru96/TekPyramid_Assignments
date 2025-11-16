package TrainingProgs3;

public class StrgSubset {
        public static void main(String[] args) {
            String str = "Fun";
            int length = str.length();

            // Total number of subsets = 2^n
            int total = 1 << length; // same as (int)Math.pow(2, length)

            System.out.println("All subsets of :" +str);

            for (int i = 0; i < total; i++) {
                String subset = "";

                for (int j = 0; j < length; j++) {
                    // Check if jth bit in i is set, if yes include char
                    if ((i & (1 << j)) != 0) {
                        subset = subset+str.charAt(j);
                    }
                }

                System.out.println(subset);
            }
        }
    }
