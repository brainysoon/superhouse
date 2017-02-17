package cn.brainysoon.superhouse.dao.mysql;

import cn.brainysoon.superhouse.bean.Staff;
import cn.brainysoon.superhouse.dao.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by brainy on 17-2-17.
 */
@Repository
public class StaffRepositoryImpl implements StaffRepository, RowMapper<Staff> {

    //数据库
    private static final String _ID = "_id";
    private static final String STAFF_NAME = "staffname";
    private static final String PASSWORD = "password";
    private static final String BIRTHDAY = "birthday";
    private static final String DATEIN = "datein";
    private static final String ISSUPER = "issuper";

    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Staff findStaffById(String _id) {

        Staff staff = null;

        try {

            staff = jdbcOperations.queryForObject(QUERY_STAFF_BY_ID, new String[]{_id}, this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return staff;
    }

    @Override
    public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {

        Staff staff = new Staff();

        staff.set_id(rs.getString(_ID));
        staff.setStaffname(rs.getString(STAFF_NAME));
        staff.setPassword(rs.getString(PASSWORD));
        staff.setBirthday(rs.getDate(BIRTHDAY));
        staff.setDatein(rs.getDate(DATEIN));
        staff.setIssuper(rs.getInt(ISSUPER));

        return staff;
    }
}
