package TrainingProgs2;

public class PunctuationCount {
    public static void main(String[] args) {
        String str = "Hello, Guru! How are you doing today? I'm fine; thanks.";

        int count = 0;

        // List of punctuation characters we want to count
        String punctuations = ".,;:!?'-()\"";

        for (int i = 0; i < str.length(); i++) {
            if (punctuations.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }

        System.out.println("Total number of punctuations in the string: " + count);
    }
}
