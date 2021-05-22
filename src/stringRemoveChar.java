
import java.util.Scanner;

public class stringRemoveChar {
static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

    String str1= sc.nextLine();//Programming
    String dirtyString= sc.nextLine();//ra

       StringBuilder sb = new StringBuilder(str1);
        for(int i=0; i<dirtyString.length();i++)
        {
           int index= sb.indexOf(Character.toString(dirtyString.charAt(i)));
           while(index != -1)
           {
               sb.deleteCharAt(index);
               index=sb.indexOf(Character.toString(dirtyString.charAt(i)));
           }
        }
        System.out.println(sb);
        System.out.println(sb.reverse());

 /*      String newStr= null;
    for(int i=0; i<dirtyString.length();i++)
    {
        newStr= str1.replace(Character.toString(dirtyString.charAt(i)),"");
        str1 = newStr;

    }
    //////

        System.out.println(newStr);
*/


    }
}
