import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNo {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int n1= sc.nextInt();
        int n2= sc.nextInt();

        isPrime(n);

        findN1toN2Prime(n1,n2);
    }
    public static void isPrime(int n)
    {
        int count =0;
        for(int i=2; i<n/2 ; i++)
        {
           if(n%i ==0)
               count++;
        }
        if(count>0)
            System.out.println(n+" is Not Prime");
        else System.out.println(n+" is Prime");
    }

    public static void findN1toN2Prime(int n1,int n2)
    {
        int MAX_SIZE =1000000;
        ArrayList<Integer> primes = new ArrayList<Integer>();

        boolean[] ifPrime = new boolean[MAX_SIZE];

        for(int p=0;p<MAX_SIZE;p++)
        {
            ifPrime[p]=true;
        }

        for(int p=2;p*p< MAX_SIZE;p++)
        {
            if(ifPrime[p]==true)
            {
               for(int i=p*p;i<MAX_SIZE;i+=p)
               {
                   ifPrime[i]=false;
               }
            }
        }

        for(int p=n1;p<= n2;p++)
        {
            if(ifPrime[p]==true)
                primes.add(p);
        }

       // int Item = primes.get(n-1);
        //System.out.println(n+"th Prime is: "+Item);

        System.out.println("Primes between n1 and n2: ");
        for(int i=0;i<primes.size();i++)
           System.out.print(primes.get(i)+" ");

          //  System.out.print(primes.get(i)+" ");


    }
}

