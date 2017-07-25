package Dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.ParameterizedType;

/**
 * Created by liangyuyi on 2017/7/5.
 */
//baseDao 这里就不用加@Repository，否则就报错了
public class BaseDao <T> extends JdbcDaoSupport {//这里使用泛型类，以便继承该类的类将其实体类传进来
    private Class<T> entityClass;
    private BeanPropertyRowMapper<T> mapper;//使用BeanPropertyRowMapper 数据库表字段和实体类自动对应

    public BaseDao(){
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        mapper = new BeanPropertyRowMapper<T>(entityClass);
    }

    /**
     * 设置数据源，数据源的id在application.xml
     * @param dataSource
     */
    @Resource(name = "dataSource")
    public void setJdbcTemplate(DataSource dataSource){
        super.setDataSource(dataSource);
    }

    /**
     * 查询单条数据
     * @param sql
     * @param args
     * @return
     */
    public T getUniqueObject(String sql, Object... args){
        T result = null;
        try{
            result = this.getJdbcTemplate().queryForObject(sql, mapper, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

