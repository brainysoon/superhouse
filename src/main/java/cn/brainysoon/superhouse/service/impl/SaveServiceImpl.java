package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.dao.GoodsRepository;
import cn.brainysoon.superhouse.service.SaveService;
import cn.brainysoon.superhouse.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * Created by brainy on 17-2-18.
 */
@Service
public class SaveServiceImpl implements SaveService {

    private GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public int saveGoods(String _id, String goodsname, Integer count, String goodsclass,
                         Double price, Integer usefullife, Date dateproduced, Integer position) {

        int saveCode = 0;

        //判断字段是否有空
        if (CheckUtils.getInstance().isGoodsHasNull(_id, goodsname, count, goodsclass,
                price, usefullife, dateproduced, position)) {

            return -3;
        }

        //创建实体类
        Goods goods = new Goods();
        goods.set_id(_id);
        goods.setGoodsname(goodsname);
        goods.setCount(count);
        goods.setGoodsclass(goodsclass);
        goods.setPrice(price);
        goods.setUsefullife(usefullife);
        goods.setDateproduced(dateproduced);
        goods.setPosition(position);

        try {

            //尝试存到数据库
            saveCode = goodsRepository.saveGoods(goods);

        } catch (Exception ex) {
            ex.printStackTrace();
            saveCode = -2;
        }

        return saveCode;
    }
}