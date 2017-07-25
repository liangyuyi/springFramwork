package Utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期的格式化
 * Created by liangyuyi on 2017/7/4.
 */
public class DateUtils {
    /**
     * 返回中国当前的日期形式
     * @return
     */
    public static String ChinaDate(){
        Date date = new Date();
        DateFormat format = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        return "中国日期：" + format.format(date);
    }
}
