package TrainingProgs;

public class RightRot2 {
    public static void main(String[] args) {
        int[] arr= {10,30,50,70,90};
        int n= arr.length;
        int rotateBy= 2;

        int[] temp= new int[rotateBy];

        for(int i=0;i<rotateBy;i++)
        {
            temp[i]= arr[n-rotateBy+i];
        }
        for(int i=n-1;i>=rotateBy;i--)
        {
            arr[i] = arr[i-rotateBy];
        }
        for(int i=0;i<rotateBy;i++)
        {
            arr[i]= temp[i];
        }
        System.out.println("Array after rotated by 2");
        for(int i=0;i<n;i++)
        {
            int num= arr[i];
            System.out.print(num+" ");
        }
    }
}
