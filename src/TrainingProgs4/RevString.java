package TrainingProgs4;

public class RevString {
    public static void main(String[] args) {

        System.out.println(rev("i love programming"));
    }

    public static String rev(String s) {
        String res = "";
        int i = s.length() - 1;
        int j = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res = res + s.substring(i + 1, j + 1) + " ";
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.trim();
    }
}