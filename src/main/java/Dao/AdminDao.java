package Dao;

import entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by liangyuyi on 2017/7/6.
 */
@Repository
public class AdminDao extends BaseDao<Admin> {
    /**
     * 根据id号获取用户信息
     * @param id
     * @return
     */
    public Admin getById(String id){
        String sql = "select * from admin where id = ?";
        return super.getUniqueObject(sql,id);
    }
}
