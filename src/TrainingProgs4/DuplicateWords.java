package TrainingProgs4;

import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateWords {
    public static void main(String[] args) {
        String str="Google Guru he is a very good boy and he is very much active";
        String[] s1= str.split(" ");

        Map<String, Integer> map= new LinkedHashMap<>();

        for(int i=0;i<s1.length-1;i++)
        {

            map.put(s1[i],map.getOrDefault(s1[i],0)+1);
        }
        map.forEach((key,value)->{
            if(value>1)
            {
                System.out.println(key + " " + value);
            }
        });
    }
}
