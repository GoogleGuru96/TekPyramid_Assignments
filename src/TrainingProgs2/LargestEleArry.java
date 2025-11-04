package TrainingProgs2;

public class LargestEleArry {
    public static void main(String[] args) {
        int[] arr= {10,80,20,70,30,60,40,50};
        int largest= arr[0];

        for (int i=1;i<arr.length;i++)
        {
            if(arr[i]>largest)
            {
                largest= arr[i];
            }
        }
        System.out.println("The Largest Element in the Array:"+largest);
    }
}
