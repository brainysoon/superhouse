package cn.brainysoon.superhouse.service;

/**
 * Created by brainy on 17-2-20.
 */
public interface LogService {

    String SAVE_GOODS_LOG = "保存货物";
    String PICK_GOODS_LOG = "提取货物";
    String SCRAP_GOODS_LOG = "报废货物";
    String ADD_STAFF = "添加员工";
    String STOP_STAFF = "停职员工";

    /**
     * @param manage_id
     * @param object_id
     * @return
     */
    int addLogByClass(String manage_id, String object_id, String LogClass);
}
