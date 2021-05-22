import java.math.BigDecimal;
import java.text.DecimalFormat;

public class decimalFormat {
    public static void main(String[] args)
    {
        String pattern = "###.##";
        BigDecimal bd = new BigDecimal(123456789.1689);

        DecimalFormat numberFormat = new DecimalFormat(pattern);

        System.out.println(bd);

        //pattern ###.###
        System.out.println(numberFormat.format(bd));

        //pattern ###.#
        numberFormat.applyPattern("###.#");
        System.out.println(numberFormat.format(bd));

        //pattern ###,###.##
        numberFormat.applyPattern("###,###.##");
        System.out.println(numberFormat.format(bd));

        //pattern 000.###
        numberFormat.applyPattern("000.##");
        System.out.println(numberFormat.format(bd));

    }
}
