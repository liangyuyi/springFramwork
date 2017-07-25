package Utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 将数字转成货币格式
 * Created by liangyuyi on 2017/7/4.
 */
public class FormatNumber {
    /**
     * 中国货币
     * @param number
     * @return
     */
    public static String ChinaFormat(double number){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        return "Locate CHINA:" + format.format(number);
    }

    /**
     * 美国的货币形式
     * @param number
     * @return
     */
    public static String UsaFormat(double number){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return "Locate US:" + format.format(number);
    }
}
