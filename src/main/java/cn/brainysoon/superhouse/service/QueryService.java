package cn.brainysoon.superhouse.service;

import cn.brainysoon.superhouse.bean.Goods;

import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
public interface QueryService {

    /**
     * @param key 通过关键字查找商品
     * @return 返回查找到的商品名称
     */
    List<Goods> queryGoodsByKey(String key);
}
