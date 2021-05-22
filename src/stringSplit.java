import java.util.Scanner;

public class stringSplit {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.split("[^a-zA-Z]");
        System.out.println(words.length);
        for(String word: words)
            System.out.println(word);
    }
}
