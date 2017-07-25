package Utils;

import java.io.File;

/**
 * Created by liangyuyi on 2017/7/9.
 */
public class FileUtils {
    /**
     * 输出文件的参数
     * @param path
     */
    public static void fileProperties(String path){
        File file = new File(path);
        System.out.println("file name:" + file.getName());
        System.out.println("file length:" + file.length());//单位为字节
        System.out.println("file path:" + file.getPath());
    }

    public static void main(String[] args) {
        String url = "G:\\download\\01.doc";
        fileProperties(url);
    }
}
