import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb=new StringBuilder();

        int q=n;
        int x,y;
        while(q>0)
        {
           x=q%2;
           sb.append(x);
           y=q/2;
           q=y;
        }
        System.out.println("Binary form of n is: "+sb.reverse());
         int bin = Integer.parseInt(sb.reverse().toString());
    }
}
