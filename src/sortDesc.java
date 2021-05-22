import java.util.Arrays;


public class sortDesc {
    public static void main(String[] args)
    {
        int[] arr = {123,324,6,70,1000,0};
        int[] sortArr = getSortedArray(arr);
        System.out.println(Arrays.toString(sortArr));
    }
    public static int[] getSortedArray(int[] arr)
    {
        int[] newArr = new int[arr.length];
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int k=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            newArr[k++]=arr[i];
        }
        return newArr;
    }
}
