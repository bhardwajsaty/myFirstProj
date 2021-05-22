import java.util.Scanner;

public class SortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
    /*    char[] tempArr =  new char[s.length()];

        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                tempArr[i] = (char) (s.charAt(i) - 'A' + 'a');
            }
            else tempArr[i]= s.charAt(i);
        }
        s= new String(tempArr);*/
        s= s.toLowerCase();
        System.out.println(s);

        int[] characters = new int[256];
        for (char x : s.toCharArray())
        {
            characters[x-'a']++;
        }
        int k = 0;
        char[] newStr = new char[s.length()];
        for(int i=0;i<256;i++)
        {
            for(int j=0;j<characters[i];j++)
            {
                newStr[k++] =(char)(i+'a');
            }
        }

        String sortedStr = new String(newStr);
        System.out.println(sortedStr);

    }
}
