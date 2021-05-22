public class Decipher {
    public static void main(String[] args)
    {
        String ciphered = ".78E72T42U79Y42E69s3";//"K78A82R69K67A72*79T42E77O67L69w3";

        String strRemLast=ciphered.substring(0, ciphered.length()-1);
       // System.out.println(strRemLast);
        String strRemLastSpace= strRemLast+" ";
       // System.out.println(strRemLastSpace+"q");
        String remAsc = "";
        String ch="";
        String last ="";
       for(int i=0;!last.equals(" ");i++)
        {
            if(!Character.isDigit(strRemLastSpace.charAt(i)))
            {
                remAsc +=  String.valueOf(strRemLastSpace.charAt(i));
                if(strRemLastSpace.charAt(i+1) ==' ')
                    break;
                continue;
            }
           while(Character.isDigit(strRemLastSpace.charAt(i)) && ch.length()<=2)
           {
               ch += String.valueOf(strRemLastSpace.charAt(i));
               i++;
           }
           // System.out.println(i+" "+ch);
           char c;

           if(!ch.equals(""))
           {
               int asc = Integer.parseInt(ch);
               c= (char) asc;
               remAsc += String.valueOf(c);
           }
           last=String.valueOf(strRemLastSpace.charAt(i));
            ch="";
           // System.out.println(remAsc);
            i--;
        }

            String finalStr= remAsc.replace("*"," ");
            //System.out.println(finalStr);
        StringBuilder strb = new StringBuilder(finalStr);
        strb.reverse();
        String string =strb.toString();

        char[] charArr = string.toCharArray();
        for(int i=0; i<string.length();i++)
        {
            if(charArr[i]>='a' && charArr[i]<='z' )
                charArr[i]=(char)(charArr[i]-'a'+'A');

            else if(charArr[i]>='A' && charArr[i]<='Z' )
                charArr[i]=(char)(charArr[i]-'A'+'a');
        }

        String fstr= new String(charArr);
       // System.out.println(fstr);


    }
}
