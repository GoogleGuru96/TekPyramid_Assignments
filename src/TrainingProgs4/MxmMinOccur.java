package TrainingProgs4;

import com.sun.source.tree.WhileLoopTree;

//public class MxmMinOccur {
//    public static void main(String[] args) {
//        String s1= "GooogleGuru";
//        String s2= "";
//        int maxcnt= 0;
//        int mincnt= 1;
//        char ch1=' ';
//        char ch2=' ';
//
//
//        while(s1.length()>0)
//        {
//            char ch=s1.charAt(0);
//            s2=s1.replace(ch+"","");
//            boolean first= true;
//
//            int occ= s1.length()-s2.length();
//            if (first) {   // ✅ initialize min and max using the first character
//                maxcnt = occ;
//                mincnt = occ;
//                ch1 = ch;
//                ch2 = ch;
//                first = false;
//            }
//
//            if(occ>maxcnt)
//            {
//                maxcnt= occ;
//                ch1=ch;
//            }
//             if (occ<mincnt)
//            {
//               mincnt= occ;
//               ch2=ch;
//            }
//            s1= s2;
//        }
//        System.out.println("The maximum occured value:"+ch1 + " " +maxcnt);
//        System.out.println("The manimum occured value:"+ch2+" "+mincnt);
//    }
//}
public class MxmMinOccur {
    public static void main(String[] args) {
        String s1 = "GoogleGuru";
        String s2 = "";

        int maxcnt = 0, mincnt = 0;
        char ch1 = ' ', ch2 = ' ';

        boolean first = true;   // ✅ flag to handle the first character

        while (s1.length() > 0) {
            char ch = s1.charAt(0);
            s2 = s1.replace(ch + "", "");
            int occ = s1.length() - s2.length();

            if (first) {   // ✅ initialize min and max using the first character
                maxcnt = occ;
                mincnt = occ;
                ch1 = ch;
                ch2 = ch;
                first = false;
            }

            if (occ > maxcnt) {
                maxcnt = occ;
                ch1 = ch;
            }

            if (occ < mincnt) {
                mincnt = occ;
                ch2 = ch;
            }

            s1 = s2;
        }

        System.out.println("The maximum occurred value: " + ch1 + " = " + maxcnt);
        System.out.println("The minimum occurred value: " + ch2 + " = " + mincnt);
    }
}
