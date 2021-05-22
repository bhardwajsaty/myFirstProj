import java.util.Scanner;

public class MaxProfitStock {

        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            int[] arr = new int[7];

            for(int i=0;i<7;i++)
                arr[i]= sc.nextInt();

            int reqSum = findMaxStockSum(arr);
            System.out.println("Sum max = "+reqSum);

        }
        public static int findMaxStockSum(int[] arr)
        {
            int maxSum=0;
            int sum =0;
            int firstVal=0;
            int next=0;
            for(int i=0;i<arr.length-1;i++)
            {
                firstVal=arr[i];
                int j =0;
                for(j=i+1;j<arr.length;j++)
                {
                    if(arr[j]>arr[i]) {
                        i++;
                        if(i!=arr.length-1)
                        continue;

                    }
                    else {
                        sum+=arr[i]-firstVal;
                        firstVal = arr[j];
                        System.out.println("FirstValue "+firstVal);
                        i++;
                    }
                    if(i!=arr.length-1) {
                        next = j;
                    }
                    else {
                        System.out.println("check val "+arr[i]+" "+firstVal);
                        sum+=arr[i]-firstVal;

                    }

                    if(sum>maxSum)
                        maxSum=sum;
                }
                i+=next-1;

            }
            return maxSum;
        }
    }

