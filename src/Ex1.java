
/*
Program to remove dupes from any array
 */
import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
        {
           arr[i]=sc.nextInt();
        }

        int max=Integer.MIN_VALUE;

        for(int val: arr)
        {
            if(val>max)
                max=val;
        }

        int[] count = new int[max+1];

        for(int i=0;i<n;i++)
            count[arr[i]]++;

        int p=0;
        int q=0;
        for(int i=0;i< count.length;i++)
        {
            if(count[i]>1) {
                p += count[i];
                q++;
            }
        }
        //System.out.println(p);
        int[] newArr = new int[n-p+q];
        int k=0;
        for(int i=0;i< count.length;i++)
            if(count[i]>0)
            newArr[k++]=i;

            for(int val:newArr)
                System.out.println(val);


    }
}
