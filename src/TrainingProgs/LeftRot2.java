package TrainingProgs;

public class LeftRot2 {
    public static void main(String[] args) {
        int[] arr= {10,30,50,70,90};
        int n= arr.length;
        int rotateBy= 2;

        int[] temp=new int[rotateBy];
        for(int i=0;i<rotateBy;i++)
        {
            temp[i]= arr[i];
        }
        for(int i=0;i<n-rotateBy;i++)
        {
            arr[i]= arr[i+rotateBy];
        }
        for(int i=0;i<rotateBy;i++)
        {
            arr[n-rotateBy+i]=temp[i];
        }
        System.out.println("Array after left rotated by 2");
        for(int num:arr)
        {
            System.out.println(num+" ");
        }
    }
}
