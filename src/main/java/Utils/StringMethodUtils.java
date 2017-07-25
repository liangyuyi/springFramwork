package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串的一些函数的使用实例
 * Created by liangyuyi on 2017/7/4.
 */
public class StringMethodUtils {
    /**
     * 将字符串反转，其中字符串中包含汉字也可以反转
     * @param str
     * @return
     */
    public static String strReverse(String str){
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * 替换字符串中的一些字符串
     * @param originStr
     * @param searchStr
     * @param replaceStr
     * @return
     */
    public static String strReplace(String originStr, String searchStr, String replaceStr){
        originStr = originStr.replace(searchStr, replaceStr);
        return originStr;
    }

    /**
     * 将字符串中的大写转成小写
     * @param string
     * @return
     */
    public static String upperLetter(String string){
        return string.toUpperCase();
    }

    /**
     * 将字符串中的小写转成大写
     * @param string
     * @return
     */
    public static String lowerLetter(String string){
        return string.toLowerCase();
    }

    /**
     * System.getProperty("line.separator")表示换行符,功能和"\n"是一致的,但是此种写法屏蔽了 Windows和Linux的区别
     */
    public static void separator() {
        System.out.println(System.getProperty("line.separator"));
        System.out.println(System.getProperty("line.separator").length());
    }

    /**
     * 根据身份证得到生日
     * @param id
     */
    public static void idToDate(String id){
        if(id.length() == 18){
            System.out.println("yes");
            System.out.println(id.substring(6,14));
            System.out.println(id.substring(12,14));
            String birh = id.substring(6,10) + "-" + id.substring(10,12) + "-" + id.substring(12,14);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date birthday = sdf.parse(birh);
                System.out.println(birthday.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        idToDate("440882199512153153");
    }
}
