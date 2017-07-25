package Utils;

import java.io.*;
import java.util.Properties;

/**
 * 读取配置文件的工具类，properties文件
 */
public class PropertiesUtils {

    //读取配置文件
    public static Properties loadProperties(File properties) {
        Properties prop = new Properties();
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(properties));
            prop.load(bis);
            bis.close();
        } catch (IOException e) {
        }
        return prop;
    }

    public static void saveProperties(File properties, Properties prop) {
        try {
            if (!properties.exists()) {
                properties.createNewFile();
            }
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(properties));
            prop.store(bos, "");
            bos.close();
        } catch (IOException e) {
        }
    }
}
