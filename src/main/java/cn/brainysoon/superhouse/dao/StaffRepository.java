package cn.brainysoon.superhouse.dao;

import cn.brainysoon.superhouse.bean.Staff;

import java.util.List;

/**
 * Created by brainy on 17-2-17.
 */
public interface StaffRepository {

    String QUERY_STAFF_BY_ID = "SELECT * FROM staff WHERE _id=?";
    String QUERY_ALL_STAFF = "SELECT * FROM staff";
    String ADD_STAFF = "INSERT INTO staff VALUES(?,?,?,?,?,?)";
    String DELETE_STAFF_BY_ID = "DELETE FROM staff WHERE _id=?";

    /**
     * 通过员工id查询员工
     */
    Staff findStaffById(String _id);

    /**
     * @return
     */
    List<Staff> queryAllStaff();

    /**
     * @param staff
     * @return
     */
    int addStaff(Staff staff);

    /**
     * @param _id
     * @return
     */
    int deleteStaffById(String _id);
}
