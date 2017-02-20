package cn.brainysoon.superhouse.dao.mysql;

import cn.brainysoon.superhouse.bean.Log;
import cn.brainysoon.superhouse.dao.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by brainy on 17-2-20.
 */
@Repository
public class LogRepositoryImpl implements LogRepository, RowMapper<Log> {

    private static final String _ID = "_id";
    private static final String MANAGE_ID = "manage_id";
    private static final String OBJECT_ID = "object_id";
    private static final String LOG_DATE = "logdate";
    private static final String CONTENT = "content";

    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public int addLog(Log log) {

        try {

            return jdbcOperations.update(ADD_LOG,
                    log.get_id(),
                    log.getManage_id(),
                    log.getObject_id(),
                    log.getLogdate(),
                    log.getContent());
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {

        Log log = new Log();

        log.set_id(rs.getString(_ID));
        log.setManage_id(rs.getString(MANAGE_ID));
        log.setObject_id(rs.getString(OBJECT_ID));
        log.setLogdate(rs.getTimestamp(LOG_DATE));
        log.setContent(rs.getString(CONTENT));

        return log;
    }
}
