package com.company;
import java.util.Scanner;

public class Solution {

    static final int MAX_NUM = 256;
    public static void frequency(int n) {
        //your code here
        int count[]= new int[MAX_NUM];
        String str1 = String.valueOf(n);
        char[] chArr = str1.toCharArray();
        int numbers[] =new int[MAX_NUM];
        char[] newStr= new char[str1.length()];
        for(char x: chArr)
        {
            numbers[x - '0']++;
        }
        int k=0;
        for(int i=0; i<MAX_NUM;i++)
        {
            for(int j=0; j<numbers[i]; j++)
            {
                newStr[k++]=(char)(i+'0');
            }

        }
        String sortedString = new String(newStr);
        System.out.println("Sorted String: "+sortedString);


        int len =sortedString.length();
        for(int i=0;i<len;i++)
            count[sortedString.charAt(i)]++;

        char ch[] = new char[sortedString.length()];
        for(int i=0; i<len; i++)
        {
            ch[i]= sortedString.charAt(i);
            int find =0;
            for(int j=0; j<=i;j++)
            {
                if(sortedString.charAt(i) == ch[j])
                    find++;

            }
            if(find == 1)
                System.out.println(sortedString.charAt(i)+": "+count[sortedString.charAt(i)]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        frequency(n);
    }
}
