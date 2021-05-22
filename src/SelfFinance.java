
//import java.util.regex;
//import java.math.*;
import java.text.DecimalFormat;

public class SelfFinance{

    public static String result(String allMarks) {
        String[] getAllMarks= allMarks.split("\\|");

        String allSubjectMarks = getAllMarks[0];
        String sportsMarks = getAllMarks[1];
        String[] indvSubMarks = allSubjectMarks.split(",");

        String[][] subMarksAndCred =new String[indvSubMarks.length][2];
        String[] subMarks = new String[indvSubMarks.length+1];
        String[] credPoints = new String[indvSubMarks.length+1];
        for(int i=0;i<indvSubMarks.length;i++){
            subMarksAndCred[i]=indvSubMarks[i].split(" ");
            subMarks[i]= subMarksAndCred[i][0];
            credPoints[i] = subMarksAndCred[i][1];
        }

        String[] indvSportsMarks = sportsMarks.split(",");
        if(indvSportsMarks[0].equals("1"))
        {
            subMarks[indvSubMarks.length]=indvSportsMarks[1];
            credPoints[indvSubMarks.length]=indvSportsMarks[2];
        }

        int maxCred = 0;
        for(int i=0;i<credPoints.length;i++)
        {
            if(credPoints[i]!= null)
                maxCred+=5;
        }

        double[] gradePoint = new double[subMarks.length];
        for(int i=0;i<subMarks.length;i++)
        {
            if(subMarks[i] != null){
                int val = Integer.parseInt(subMarks[i]);
                if(val>=75 && val<= 100)
                {
                    double gp=9+(1/25.0)*(val-75);
                    DecimalFormat df =new DecimalFormat("#.#");
                    //df.setRoundingMode(RoundingMode.CEILING);
                    gradePoint[i]=Double.parseDouble(df.format(gp));

                }
                else if(val>=60 && val<= 74)
                {
                    double gp=8+(1/14.0)*(val-60);
                    DecimalFormat df =new DecimalFormat("#.#");
                    // df.setRoundingMode(RoundingMode.CEILING);
                    gradePoint[i]=Double.parseDouble(df.format(gp));

                }
                else if(val>=50 && val<= 59)
                {
                    double gp=7+(1/9.0)*(val-50);
                    DecimalFormat df =new DecimalFormat("#.#");
                    //df.setRoundingMode(RoundingMode.CEILING);
                    gradePoint[i]=Double.parseDouble(df.format(gp));

                }
                else if(val>=40 && val<= 49)
                {
                    double gp=6+(1/9.0)*(val-40);
                    DecimalFormat df =new DecimalFormat("#.#");
                    //df.setRoundingMode(RoundingMode.CEILING);
                    gradePoint[i]=Double.parseDouble(df.format(gp));
                }
                else gradePoint[i]=0;
            }
        }
        double cgpa =0;
        for(int i=0;i<subMarks.length;i++)
        {
            if(credPoints[i]!=null){
                int cp = Integer.parseInt(credPoints[i]);
                cgpa+=gradePoint[i] * cp/maxCred;
            }
        }
        DecimalFormat df1 =new DecimalFormat("#.00");
        //df1.setRoundingMode(RoundingMode.CEILING);
        String CGPA = df1.format(cgpa);
        return CGPA;
    }
    public static void main(String[] args)
    {
        String allMarks="100 5,100 2,46 5|1,100,5";
        String actual=result(allMarks);
        System.out.println(actual);
        // int expected=1714193;
        System.out.println(actual.hashCode());
    }

}