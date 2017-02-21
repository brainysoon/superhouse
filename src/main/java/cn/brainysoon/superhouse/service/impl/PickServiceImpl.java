package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.dao.GoodsRepository;
import cn.brainysoon.superhouse.service.PickService;
import cn.brainysoon.superhouse.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by brainy on 17-2-18.
 */
@Service
public class PickServiceImpl implements PickService {

    private GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public int pickGoods(String _id, Integer position, Integer count) {

        if (CheckUtils.getInstance().isPickGoodsHasNull(_id, position, count)) {

            return -2;
        }


        //不用事务，直接逻辑来

        Goods goods = goodsRepository.findGoods(_id, position);

        if (goods.getCount() >= count) {

            goods.setCount(goods.getCount() - count);

            return goodsRepository.pickGoods(goods);

        } else {

            return -3;
        }
    }
}
