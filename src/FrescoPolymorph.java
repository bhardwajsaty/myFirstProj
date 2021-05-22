import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FrescoPolymorph {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        ChildOne co= new ChildOne();
        co.filter(140,166);

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
        public void filter(int a,int b)
        {
           this.startElement=a;
            this.endElement=b;

            int MAX_SIZE=1000000;
            ArrayList<Integer> primes = new ArrayList<>();
            boolean[] IsPrime=new boolean[MAX_SIZE];
            for(int i=0;i<MAX_SIZE;i++)
                IsPrime[i]=true;

            for(int p=2;p*p <MAX_SIZE;p++)
            {
                if(IsPrime[p])
                {
                    for(int i=p*p;i<MAX_SIZE;i+=p)
                        IsPrime[i]=false;
                }
            }

            for(int p=2;p<MAX_SIZE;p++)
            {
                if(IsPrime[p])
                    primes.add(p);
            }
           // System.out.println("Prime Numbers:");
            for(int i=0;primes.get(i)<=b;i++)
            {
                if(primes.get(i)>=a)
                    System.out.print(primes.get(i)+" ");

            }
        }
    }
}
