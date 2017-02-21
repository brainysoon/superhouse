package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.dao.GoodsRepository;
import cn.brainysoon.superhouse.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
@Service
public class QueryServiceImpl implements QueryService {

    GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public List<Goods> queryGoodsByKey(String key) {

        return goodsRepository.findGoodsByKey(key);
    }
}
