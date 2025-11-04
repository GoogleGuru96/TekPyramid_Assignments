package TrainingProgs2;

public class ScndLargstEleArry {
    public static void main(String[] args) {
        int[] arr= {10,80,20,70,30,60,40,50};
        int largest= arr[0];
        int scndLargest= Integer.MIN_VALUE;

        for(int i=1; i<arr.length;i++)
        {
          if(arr[i]>largest)
          {
              scndLargest= largest;
              largest= arr[i];
          }
          else if(arr[i]>scndLargest && arr[i]!= largest)
          {
              scndLargest= arr[i];
          }
        }
        System.out.println("The First Largest in Array:"+largest);
        System.out.println("The Second Largest in Array:"+scndLargest);
    }
}
