import java.util.Scanner;

public class Ex3 {
    public static  void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int day = sc.nextInt();
        String bin = Integer.toBinaryString(day);
        System.out.println(bin);

        int count =0;
        for(char x: bin.toCharArray())
        {
            if(x=='1')
                count++;
        }

        System.out.println("No of coins: "+count);
        System.out.println("Values of "+count+" coins: ");
        StringBuilder sb = new StringBuilder(bin);
        sb.reverse();
        for(int i=0;i<sb.length();i++)
        {
            if(sb.charAt(i)=='1')
                System.out.print((int)(Math.pow(2,i))+" ");
        }
    }
}
