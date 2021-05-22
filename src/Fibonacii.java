import java.util.Arrays;
import java.util.Scanner;

public class Fibonacii {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int fibTerm = findFibTerm(n);
        System.out.println(n+"th Fibonacii term is: "+fibTerm);
    }
    public static int findFibTerm(int n)
    {
        if(n==1)
            return 0;
        else if(n==2)
            return 1;
        else
        {
            int t1 = findFibTerm(n-2);
            int t2= findFibTerm(n-1);
            return t1+t2;
        }
    }
}
