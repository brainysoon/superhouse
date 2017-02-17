package cn.brainysoon.superhouse.service;

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
}
