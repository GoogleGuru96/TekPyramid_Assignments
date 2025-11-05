package TrainingProgs3;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "amma";
        String s2 = "mama";
        System.out.println(isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s1, String s2) {
        while (s1.length() == s2.length()) {
            if (s1.length() == 0 && s2.length() == 0)
                return true;

            char c = s1.charAt(0);
            s1 = s1.replace(c + "", "");
            s2 = s2.replace(c + "", "");
        }
        return false;
    }
}
