package TrainingProgs3;

public class TotVowStrg {
    public static void main(String[] args) {
            String str = "Google Guru";
            int count = 0;

            // Convert string to lowercase to handle both uppercase and lowercase vowels
            str = str.toLowerCase();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                // Check if character is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }

            System.out.println("Total number of vowels: " + count);
        }
    }