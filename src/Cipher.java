import java.util.Scanner;

public class Cipher {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String normal = sc.nextLine();

        char[] charArr = normal.toCharArray();
        for(int i=0; i<normal.length();i++)
        {
            if(charArr[i]>='a' && charArr[i]<='z' )
                charArr[i]=(char)(charArr[i]-'a'+'A');

            else if(charArr[i]>='A' && charArr[i]<='Z' )
                charArr[i]=(char)(charArr[i]-'A'+'a');
        }
        String str = new String(charArr);
       // System.out.println("Array case Altered: "+str);

        StringBuilder strb = new StringBuilder(str);
        strb.reverse();

       // System.out.println("Array Reversed: "+strb.toString());

        for(int i=0; i<strb.length();i++)
        {
            if(strb.charAt(i)==' ')
                strb.setCharAt(i,'*');
        }

       // System.out.println("Space swapped with *: "+strb.toString());
        System.out.println(strb.length());
        String newStr= strb.toString();
        String finalStr= "";
        for(int i=0;i<newStr.length();i++)
        {
            if(i%2 == 0)
                finalStr=finalStr+ newStr.charAt(i);
            else {
                int ascode = newStr.charAt(i);
                //System.out.println(ascode);
                String asc = Integer.toString(ascode);
               // System.out.println(asc);
                finalStr += asc;
            }
        }
        //System.out.println("Even places to ASCII: "+finalStr);
        //String revString = new String(revArr);
        //char ch = normal.charAt(normal.length()-1);
        //boolean b = Character.isDigit(ch);
        //if(b)
        char ch ='3';
        finalStr += ch;
        System.out.println(finalStr);
    }
}

