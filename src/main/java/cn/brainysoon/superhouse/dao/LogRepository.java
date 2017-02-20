package cn.brainysoon.superhouse.dao;

import cn.brainysoon.superhouse.bean.Log;

/**
 * Created by brainy on 17-2-20.
 */
public interface LogRepository {

    String ADD_LOG = "INSERT INTO log VALUES(?,?,?,?,?)";

    /**
     * @param log
     * @return
     */
    int addLog(Log log);
}
