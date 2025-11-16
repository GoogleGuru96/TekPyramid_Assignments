package TrainingProgs4;

public class RevString1 {
        public static void main(String[] args) {
            System.out.println(rev("i love programming"));
        }

        public static String rev(String s) {
            String[] words = s.split(" ");  // Split by spaces
            String result = "";

            for (int i = words.length - 1; i >= 0; i--) {
                result = result+words[i];
                if (i != 0) {
                    result += " ";
                }
            }

            return result;
        }
    }
