package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Log;
import cn.brainysoon.superhouse.dao.LogRepository;
import cn.brainysoon.superhouse.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by brainy on 17-2-20.
 */
@Service
public class LogServiceImpl implements LogService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    private LogRepository logRepository;

    @Autowired
    public void setLogRepository(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public int addLogByClass(String manage_id, String object_id, String LogClass) {

        Log log = new Log();

        //生成id
        log.set_id(sdf.format(new Date()) + ((int) (Math.random() * 1000)));
        log.setManage_id(manage_id);
        log.setObject_id(object_id);
        log.setLogdate(new Timestamp(System.currentTimeMillis()));
        log.setContent(LogClass);

        return logRepository.addLog(log);
    }
}
