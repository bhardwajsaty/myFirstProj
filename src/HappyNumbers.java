import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HappyNumbers {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc= new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        //System.out.println(a);
        //System.out.println(b);
        ChildOne co= new ChildOne();
        ChildTwo ct=new ChildTwo();
        String s1=   co.filter(a,b);
        String s2=   ct.filter(a,b);

        System.out.print(s1.trim());
        System.out.println();
        System.out.print(s2.trim());
       // System.out.println("is it good?");
    }
    public static class Parent
    {
        public int startElement;
        public int endElement;
        public String filter()
        {
            return null;
        }
    }
    public static class ChildOne extends Parent
    {
        public String filter(int a,int b)
        {
            this.startElement=a;
            this.endElement=b;

            int MAX_SIZE=1000000;
            ArrayList<Integer> primes = new ArrayList<>();
            boolean[] IsPrime=new boolean[MAX_SIZE];
            for(int i=2;i<MAX_SIZE;i++)
                IsPrime[i]=true;

            for(int p=2;p*p <MAX_SIZE;p++)
            {
                if(IsPrime[p])
                {
                    for(int i=p*p;i<MAX_SIZE;i+=p)
                        IsPrime[i]=false;
                }
            }

            for(int p=a;p<=b;p++)
            {
                if(IsPrime[p])
                    primes.add(p);
            }
            // System.out.println("Prime Numbers:");
            StringBuilder sb1 = new StringBuilder();

            for (Integer prime : primes) {
                sb1.append(prime);
                sb1.append(" ");
            }
            return sb1.toString();
            // System.out.println();
        }
    }
    public static class ChildTwo extends Parent
    {
        public String filter(int a,int b)
        {
            this.startElement=a;
            this.endElement=b;
            String s2 =sumbtwDigits(a,b);
            return s2;
        }
        public static int sumDigits(int n) {
            int sum = 0;
            int q = n;
            while (q > 0) {
                int r = q % 10;
                sum += r * r;
                q = q / 10;
            }
            return sum;
        }
        public static String sumbtwDigits(int n1,int n2)
        {
            ArrayList<Integer> happy = new ArrayList<Integer>();
            int s=0;
            for(int i=n1;i<=n2;i++)
            {
                int num=i;
                for(int j=0;j<10;j++) {
                    s=sumDigits(i);
                    if (s == 1|| s== 10 || s==13 || s==31){
                        // System.out.print(num+" ");
                        happy.add(num);
                        break;
                    } else if (s > 9)
                        i = s;
                    else break;
                }
                i=num;
            }

            StringBuilder sb2 = new StringBuilder();

            for (Integer integer : happy) {
                sb2.append(integer);
                sb2.append(" ");
            }
            return sb2.toString();
        }
    }
}