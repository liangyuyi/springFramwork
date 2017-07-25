package service;

import Dao.AdminDao;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liangyuyi on 2017/7/6.
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    /**
     * 根据id号获取数据
     * @param id
     * @return
     */
    public Admin getById(String id){
        return adminDao.getById(id);
    }
}
