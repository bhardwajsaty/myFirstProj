package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashmap {
    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        Map<Integer,String> keyValuePair= new HashMap<>();
        int n= sc.nextInt();
        for(int i=0;i<n;i++) {
            int num=0;
            String str =null;
            if(sc.hasNextInt())
            num = sc.nextInt();

            str = sc.nextLine();

            keyValuePair.put(num, str);

        }
        //System.out.println(keyValuePair);
        int findKey = sc.nextInt();
        if(keyValuePair.containsKey(findKey))
        {
            String st = keyValuePair.get(findKey).toString().trim();
            System.out.println(st);
        }
        else System.out.println("-1");
    }
}
