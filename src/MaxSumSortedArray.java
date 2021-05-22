import java.util.Scanner;

public class MaxSumSortedArray {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i]= sc.nextInt();

        int reqSum = findReqSum(arr);
        System.out.println("Sum max = "+reqSum);

    }
    public static int findReqSum(int[] arr)
    {
        int maxSum=0;
        int sum =0;
      for(int i=0;i<arr.length-1;i++)
      {
          sum=arr[i];
          for(int j=i+1;j<arr.length;j++)
          {
              if(arr[j]>arr[i]) {
                  sum += arr[j];
                  i++;
              }
              if(sum>maxSum)
                  maxSum=sum;
          }

      }
      return maxSum;
    }
}
