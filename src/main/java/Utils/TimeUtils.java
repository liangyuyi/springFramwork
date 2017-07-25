package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by liangyuyi on 2017/7/9.
 */
public class TimeUtils {
    /**
     * 将数字格式化为长度为2的字符串
     * @param number
     * @return
     */
    private static String format(int number){
        return number<10? "0"+number : ""+number;
    }
    /**
     * 获取当前时间：格式为xx:xx:xx
     */
    public static String getTime(){
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        return format(hour) + ":" + format(minute) + ":" + format(second);
    }

    /**
     * 获取规定的时间格式
     */
    public static void getTimeOfFormat(){
        String [] patternExample = {"yyyy-MM-dd","MM-dd-yyyy","a h:m:s","z H:m:s"};
        for(int i =0; i<patternExample.length;i++){
            SimpleDateFormat formatter = new SimpleDateFormat(patternExample[i]);
            System.out.println(formatter.format(new Date()));
        }
    }

    public static void getTimeLong(){
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = sdf.parse("2017-06-08 00:00:00.0");
            System.out.println(date1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       getTimeLong();
    }
}
