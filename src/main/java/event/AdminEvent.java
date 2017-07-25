package event;

import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import service.AdminService;

/**
 * Created by liangyuyi on 2017/7/13.
 */
public class AdminEvent {
    @Autowired
    private AdminService adminService;

    public void printAdmin(){
        Admin admin = adminService.getById("1");
        System.out.println(admin.getName());
    }
}
