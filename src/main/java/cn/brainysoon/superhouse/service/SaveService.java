package cn.brainysoon.superhouse.service;

import java.sql.Date;

/**
 * Created by brainy on 17-2-18.
 */
public interface SaveService {

    /**
     * //存货物
     *
     * @param _id
     * @param goodsname
     * @param count
     * @param goodsclass
     * @param price
     * @param usefullife
     * @param dateproduced
     * @param position
     * @return 返回存货物的状态吗
     */
    int saveGoods(String _id, String goodsname, Integer count,
                  String goodsclass, Double price, Integer usefullife,
                  Date dateproduced, Integer position);
}
