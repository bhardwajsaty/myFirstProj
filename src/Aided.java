import java.util.*;
import java.math.*;
import java.text.DecimalFormat;
public class Aided {

    public static String result(String allMarks) {
        String[] getAllMarks= allMarks.split("\\|");

        String allSubjectMarks = getAllMarks[0];
        String nccMarks = getAllMarks[1];
        String sportsMarks = getAllMarks[2];
        String[] indvSubMarks = allSubjectMarks.split(",");

        String[][] subMarksAndCred =new String[indvSubMarks.length][2];
        String[] subMarks = new String[indvSubMarks.length+2];
        String[] credPoints = new String[indvSubMarks.length+2];
        for(int i=0;i<indvSubMarks.length;i++){
            subMarksAndCred[i]=indvSubMarks[i].split(" ");
            subMarks[i]= subMarksAndCred[i][0];
            credPoints[i] = subMarksAndCred[i][1];
        }

        String[] indvNcc = nccMarks.split("[,]",0);
//System.out.println(indvNcc[0]);
        if(indvNcc[0].equals("1"))
        {
            //System.out.println("Yes");
            subMarks[indvSubMarks.length]=indvNcc[1];
            credPoints[indvSubMarks.length]=indvNcc[2];
        }

        String[] indvSportsMarks = sportsMarks.split("[,]",0);
        if(indvSportsMarks[0].equals("1"))
        {
            subMarks[indvSubMarks.length+1]=indvSportsMarks[1];
            credPoints[indvSubMarks.length+1]=indvSportsMarks[2];
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
            // System.out.println(subMarks[i]);
            if(subMarks[i] != null){
                int val = Integer.parseInt(subMarks[i]);
                if(val>=75 && val<= 100)
                {
                    System.out.println("Val: "+val);
                    double gp=9+(1/25.0)*(val-75);
                    DecimalFormat df =new DecimalFormat("#.#");
                   //  df.setRoundingMode(RoundingMode.CEILING);
                    gradePoint[i]=Double.parseDouble(df.format(gp));
                    System.out.println("gradepint["+i+"]= "+gradePoint[i]);
                }
                else if(val>=60 && val<= 74)
                {
                    System.out.println("Val: "+val);
                    double gp=8+(1/14.0)*(val-60);
                    DecimalFormat df =new DecimalFormat("#.#");
                    // df.setRoundingMode(RoundingMode.CEILING);
                    gradePoint[i]=Double.parseDouble(df.format(gp));
                    System.out.println("gradepint["+i+"]= "+gradePoint[i]);
                }
                else if(val>=50 && val<= 59)
                {
                    System.out.println("Val: "+val);
                    double gp=7+(1/9.0)*(val-50);
                    DecimalFormat df =new DecimalFormat("#.#");
                   // df.setRoundingMode(RoundingMode.CEILING);
                    gradePoint[i]=Double.parseDouble(df.format(gp));
                    System.out.println("gradepint["+i+"]= "+gradePoint[i]);
                }
                else if(val>=40 && val<= 49)
                {
                    System.out.println("Val: "+val);
                    double gp=6+(1/9.0)*(val-40);
                    DecimalFormat df =new DecimalFormat("#.#");
                    //df.setRoundingMode(RoundingMode.CEILING);
                    gradePoint[i]=Double.parseDouble(df.format(gp));
                    System.out.println("gradepint["+i+"]= "+gradePoint[i]);
                }
                else {System.out.println("Val: "+val);gradePoint[i]=0;System.out.println("gradepint["+i+"]= "+gradePoint[i]);}
            }
        }

        double cgpa =0;
        BigDecimal d = new BigDecimal(cgpa);
        BigDecimal c= new BigDecimal(maxCred);

        for(int i=0;i<subMarks.length;i++)
        {
            if(credPoints[i]!=null){
                //int cp = Integer.parseInt(credPoints[i]);
                BigDecimal a= new BigDecimal(credPoints[i]);
                BigDecimal b= BigDecimal.valueOf(gradePoint[i]);
                //d=d.add(b).multiply(b).multiply(a).divide(c);
               // cgpa+=gradePoint[i] * (double)cp/maxCred;
                a=a.multiply(b);
                a=a.divide(c);
                d=a.add(d);

                cgpa=d.doubleValue();
                System.out.println(cgpa);
            }
        }
        DecimalFormat df1 =new DecimalFormat("#.##");
 //df1.setRoundingMode(RoundingMode.CEILING);
        String CGPA = df1.format(cgpa);
        return CGPA;

    }
    public static void main(String[] args)
    {
        String allMarks="67 4,34 2,54 5,100 2|1,100,5|0,100,5";
        String actual=result(allMarks);
        System.out.println(actual);
       // int expected=1714193;
        System.out.println(actual.hashCode());
    }

}

