public class AddRandomWebsite {
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder(8);
        String alphaString = "abcdefghijklmnopqrstuvwxyz";

        for(int i=0;i<8;i++)
        {
            int index= (int)(alphaString.length() * Math.random());
            sb.append(alphaString.charAt(index));
        }
        String webAddress = "www."+ sb +".com";
        System.out.println(webAddress);
    }
}
