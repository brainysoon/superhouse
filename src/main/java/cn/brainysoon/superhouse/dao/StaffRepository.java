package cn.brainysoon.superhouse.dao;

import cn.brainysoon.superhouse.bean.Staff;

/**
 * Created by brainy on 17-2-17.
 */
public interface StaffRepository {

    String QUERY_STAFF_BY_ID = "SELECT * FROM staff WHERE _id=?";

    /**
     * 通过员工id查询员工
     */
    Staff findStaffById(String _id);
}
