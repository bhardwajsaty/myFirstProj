package com.company;

import java.util.Scanner;

public class SortNumericalString {

    static final int MAX_NUM = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nstr = sc.next();
        int numbers[] =new int[MAX_NUM];
        char[] newStr= new char[nstr.length()];
        for(char x: nstr.toCharArray())
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
    }


}
