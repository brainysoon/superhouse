package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Staff;
import cn.brainysoon.superhouse.dao.StaffRepository;
import cn.brainysoon.superhouse.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
