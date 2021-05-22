import java.util.Scanner;

public class RemoveDupesAndSum {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr =new int[n];
        int sum=0;
        for(int i=0;i<n;i++)
        {
           arr[i]=sc.nextInt();
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(max<arr[i])
                max=arr[i];

        }
        int[] count=new int[max+1];
        for(int i=0;i<n;i++)
            count[arr[i]]++;

        for(int i=0;i< count.length;i++)
        {
            if(count[i]>0)
                sum+=i;
        }
        System.out.println("Sum without dupes: "+sum);
    }
}
