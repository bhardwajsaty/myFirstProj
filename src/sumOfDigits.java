import java.util.Scanner;

public class sumOfDigits {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = findSumOfDigits(n);
        System.out.println(sum);

    }

    public static int findSumOfDigits(int n)
    {
        int q= n;
        int sum=0;
        int r;
        while(q>0)
        {
            r=q%10;
            sum+=r;
            q=q/10;
        }
        return sum;
    }
}

