package Utils;

import java.nio.ByteBuffer;

/**
 * byte的一些用法
 * Created by liangyuyi on 2017/7/5.
 */
public class ByteUtil {
    /**
     * 字节缓冲byteBuffer的使用
     */
    public static void byte2byteBuffer(){
        String str = "abc";
        String str2 = "efg";
        byte [] bytes1 = str.getBytes();
        byte [] bytes2 = str2.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes1.length + bytes2.length);
        byteBuffer = byteBuffer.put(bytes1,0,bytes1.length);
        byteBuffer = byteBuffer.put(bytes2,0,bytes2.length);
        byte [] temp = byteBuffer.array();
        String t = new String(temp);
        byteBuffer.clear();
        String tt = new String(byteBuffer.array());
        System.out.println(t);
        System.out.println(tt);
    }

}
