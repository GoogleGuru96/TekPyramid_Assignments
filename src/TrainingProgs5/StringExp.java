package TrainingProgs5;

import java.util.Arrays;

public class StringExp {
    public static void main(String[] args) {
        String[] input={"apple", "banana", "cherrys", "dates"};
        String[] s=new String[4];
        for(int i=0; i<input.length;i++)
        {
            s[i]= input[i].substring(0,3);
        }
        System.out.println(Arrays.toString(s));
    }
}
