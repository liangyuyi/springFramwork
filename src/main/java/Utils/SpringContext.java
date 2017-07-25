package Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Created by chenzj on 2017/3/9.
 */
public class SpringContext implements ApplicationContextAware {

    /**
     * 私有spring应用上下文
     */
    public static ApplicationContext applicationContext;

    /**
     * 实现了ApplicationContextAware 接口，必须实现该方法；
     * 通过传递applicationContext参数初始化成员变量applicationContext
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
        System.out.println("注入spring上下文成功");
    }

    /**
     * 根据名称从spring中获取某实例
     * @param name
     * @return
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 根据beanclass从spring中获取某实例
     * @param clz
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<?> clz) throws BeansException {
        return (T)applicationContext.getBean(clz);
    }

    /**
     * 从spring容器中获取某个类的所有bean，bean名为key，bean实例为value
     * @param clz
     * @return
     */
    public static Map<String, Object> getBeanOfType(Class<?> clz) {
        return (Map<String, Object>) applicationContext.getBeansOfType(clz);
    }

    /**
     * 从spring容器中获取到对应的实体对象
     * @param annotationClass
     * @return
     */
    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationClass) {
        return applicationContext.getBeansWithAnnotation(annotationClass);
    }

}
