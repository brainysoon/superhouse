package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.dao.GoodsRepository;
import cn.brainysoon.superhouse.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
public class QueryServiceImpl implements QueryService {

    GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public List<Goods> queryGoodsByKey(String key, String keyclass) {

        if (keyclass.equals("_id")) {


        } else if (keyclass.equals("goodsname")) {

        } else {

        }

        return null;
    }
}
