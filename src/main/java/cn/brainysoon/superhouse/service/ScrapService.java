package cn.brainysoon.superhouse.service;

import cn.brainysoon.superhouse.bean.Goods;

import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
public interface ScrapService {

    /**
     * @return 找到应该报废的货物
     */
    List<Goods> findGoodsScraped();

    /**
     * @param _id 包括_id 和 position
     * @return 返回状态吗
     */
    int scrapGoods(String[] _id);
}
