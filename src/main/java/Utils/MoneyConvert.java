package Utils;

import java.text.DecimalFormat;

/**
 * 货币金额大写格式
 * Created by liangyuyi on 2017/7/4.
 */
public class MoneyConvert {
    private static String [] STR_UNIT = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
    private static String [] STR_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒","捌","玖"};

    /**
     * 将数字转成大写形式，目前只能转小数点前面的数
     * @param d
     * @return
     */
    public static String convert(double d){
        //小数格式
        DecimalFormat df = new DecimalFormat("#0.###");
        //格式化double数字
        String strNum = df.format(d);
        if(strNum.contains(".")){
            String num = strNum.substring(0,strNum.indexOf("."));
            //整数部分大于12不能转换
            if(num.length()>12){
                System.out.println("数字太大，不能完成转换");
                return "";
            }
        }
        String point = "";
        if(strNum.contains(".")){
            point="元";
        }
        else{
            point = "元整";
        }
        String result = getInteger(strNum) + point;//TODO 有待扩展，小数部分算法还没写
        return result;
    }

    /**
     * 将整数部分转成小写
     * @param num
     * @return
     */
    public static String getInteger(String num){
        if(num.contains(".")){
            num = num.substring(0, num.indexOf("."));
        }
        num = new StringBuffer(num).reverse().toString();//反转字符串

        StringBuffer temp = new StringBuffer();
        for(int i = 0; i<num.length(); i++){
            temp.append(STR_UNIT[i]);
            temp.append(STR_NUMBER[num.charAt(i) - 48]);
        }

        num = temp.reverse().toString();//将字符串反转回来
        //替换字符串
        num = StringMethodUtils.strReplace(num, "零拾", "零");
        num = StringMethodUtils.strReplace(num, "零佰", "零");
        num = StringMethodUtils.strReplace(num, "零仟", "零");
        num = StringMethodUtils.strReplace(num, "零万", "万");
        num = StringMethodUtils.strReplace(num, "零亿", "亿");
        num = StringMethodUtils.strReplace(num, "零零", "零");
        num = StringMethodUtils.strReplace(num, "亿万", "亿");
        //如果字符串以零结尾，将零去掉
        if(num.lastIndexOf("零") == num.length() - 1){
            num = num.substring(0, num.length() - 1);
        }
        return num;
    }
}
