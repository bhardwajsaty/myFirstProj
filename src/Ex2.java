import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr =new int[n];

        for(int i=0;i<n;i++)
        {
           arr[i]=sc.nextInt();
        }

        int[] revArr = new int[n];
        int k=0;
        for(int i=n-1;i>=0;i--)
        {
            revArr[k++]=arr[i];
        }

        int[] sum=new int[n];
        for(int i=0;i<n;i++)
        {
            sum[i]=revArr[i]+arr[i];
        }

        for(int num:sum)
        {
            System.out.println(num+" ");
        }
    }
}
