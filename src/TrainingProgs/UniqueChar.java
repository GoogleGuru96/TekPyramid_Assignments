package TrainingProgs;

public class UniqueChar {
    public static void main(String[] args) {
        String str= "googleguru";
        String s1= "";

        for(int i=str.length();i>0;i--) {
            char ch = str.charAt(0);
            s1 = str.replace(ch + "", "");
            System.out.println(ch + "=" + ((str.length() - s1.length())));
            str = s1;
            if (str.length() - s1.length() == 1)
                System.out.println(ch);
        }
    }
}
