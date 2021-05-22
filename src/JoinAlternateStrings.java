import java.util.Scanner;

public class JoinAlternateStrings {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str1= sc.nextLine();
        String str2=sc.nextLine();
        StringBuilder s1 = new StringBuilder(str1);
        StringBuilder s2 = new StringBuilder(str2);
        int max = s1.length()+s2.length();
       // System.out.println(max);
        int n=sc.nextInt();

        StringBuilder strFinal = new StringBuilder();
        while(strFinal.length() < max)
        {
            if(s1.length() != 0 )
            {
                if(s1.length()>n)
                {
                    strFinal.append(s1.substring(0,n));
                    s1.delete(0,n);
                    System.out.println(strFinal);
                }
                else
                {
                    strFinal.append(s1);
                    s1.delete(0,s1.length());
                    System.out.println(strFinal);
                }

            }

            if(s2.length() != 0 )
            {
                if(s2.length()>n)
                {
                    strFinal.append(s2.substring(0,n));
                    s2.delete(0,n);
                    System.out.println(strFinal);
                }
                else
                {
                    strFinal.append(s2);
                    s2.delete(0,s2.length());
                    System.out.println(strFinal);
                }

            }

        }

        System.out.println(strFinal);

    }
}
