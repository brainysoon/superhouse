package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Staff;
import cn.brainysoon.superhouse.dao.StaffRepository;
import cn.brainysoon.superhouse.service.StaffService;
import cn.brainysoon.superhouse.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by brainy on 17-2-17.
 */
@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;

    @Autowired
    public void setStaffRepository(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public int handleLogin(String _id, String password) {

        //简单校验
        if (_id.equals("") || password.equals("")) {

            return -2;
        }

        Staff staff = null;

        staff = staffRepository.findStaffById(_id);

        //登录业务逻辑
        if (staff == null) {

            return -1;
        }

        if (staff.getPassword().equals(password)) {

            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Staff getStaffById(String _id) {

        return staffRepository.findStaffById(_id);
    }

    @Override
    public List<Staff> queryAllStaffs(Staff staff) {

        List<Staff> staffs = staffRepository.queryAllStaff();

        if (staffs == null) {
            return null;
        }

        for (int i = 0; i < staffs.size(); i++) {

            if (staffs.get(i).get_id().equals(staff.get_id())) {

                staffs.remove(i);
            }
        }

        return staffs;
    }

    @Override
    public int addStaff(String _id, String staffname, String password, Date birthdy, Integer issuper) {

        if (CheckUtils.getInstance().isStaffHasNull(_id, staffname, password, birthdy, issuper)) {

            return -3;
        }

        //封装实体
        Staff staff = new Staff();

        staff.set_id(_id);
        staff.setStaffname(staffname);
        staff.setPassword(password);
        staff.setBirthday(birthdy);
        staff.setDatein(new Date(System.currentTimeMillis()));
        staff.setIssuper(issuper);

        return staffRepository.addStaff(staff);
    }

    @Override
    public int stopStaffs(String[] _id) {

        int staffCode = 0;

        for (int i = 0; i < _id.length; i++) {


            int code = staffRepository.deleteStaffById(_id[i]);

            if (code > 0) {

                staffCode++;
            }
        }

        return staffCode;
    }
}
