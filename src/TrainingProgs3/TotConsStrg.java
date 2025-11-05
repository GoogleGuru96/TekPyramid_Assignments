package TrainingProgs3;

public class TotConsStrg {
    public static void main(String[] args) {
        String str= "Google Guru";
        int count=0;
        str= str.toLowerCase();

        for(int i=0;i<str.length();i++)
        {
           char ch=str.charAt(i);
           if(!(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch==' '))
           {
               count++;
           }
        }
        System.out.println("Total number of Consonants:"+count);
    }
}
