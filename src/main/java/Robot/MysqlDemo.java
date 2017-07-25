package Robot;

import java.sql.*;

/**
 * 基本的连接数据库方法：参考：http://www.cnblogs.com/hushaojun/p/5523622.html
 * Created by liangyuyi on 2017/7/19.
 */
public class MysqlDemo {
    public static void main(String[] args) {
        Connection connection = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
        String url = "jdbc:mysql://112.74.56.89:3306/liangyuyi?"
                + "user=root&password=fouronefive415&useUnicode=true&characterEncoding=UTF8";
        try{
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            //连接数据库
            connection = DriverManager.getConnection(url);

            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = connection.createStatement();
            //sql语句
            sql = "select * from admin where id = '1'";
            ResultSet reset = stmt.executeQuery(sql);
            while (reset.next()){
                System.out.println(reset.getString(2));
            }

            connection.close();
        }catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
