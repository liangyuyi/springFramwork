package Robot;

import event.AdminEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liangyuyi on 2017/7/13.
 */
public class RobotMain {
    private final static String path = "applicationContext.xml";
    public static void main(String[] args) {
        //获取配置文件
       // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从配置文件中获取类，通过id号
//        AdminEvent obj = (AdminEvent) context.getBean("adminEvent");
//        obj.printAdmin();

        //从配置文件中获取类，直接写id对应的类名
        new ClassPathXmlApplicationContext(path).getBean(AdminEvent.class).printAdmin();
    }
}
