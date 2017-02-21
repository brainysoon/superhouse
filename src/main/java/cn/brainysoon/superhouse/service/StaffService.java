package cn.brainysoon.superhouse.service;

import cn.brainysoon.superhouse.bean.Staff;

import java.sql.Date;
import java.util.List;

/**
 * Created by brainy on 17-2-17.
 */
public interface StaffService {

    /**
     * @param _id      员工号 用户登录
     * @param password 员工密码
     * @return 返回状态码
     */
    int handleLogin(String _id, String password);

    /**
     * @param _id 通过id得到Staff
     * @return Staff 实体
     */
    Staff getStaffById(String _id);

    /**
     * @return
     */
    List<Staff> queryAllStaffs(Staff staff);

    /**
     * @param _id
     * @param staffname
     * @param password
     * @param birthdy
     * @param issuper
     * @return
     */
    int addStaff(String _id, String staffname, String password,
                 Date birthdy, Integer issuper);

    /**
     * @param _id
     * @return
     */
    int stopStaffs(String[] _id);
}
