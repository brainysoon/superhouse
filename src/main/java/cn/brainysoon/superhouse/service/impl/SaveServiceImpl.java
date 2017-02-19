package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.dao.GoodsRepository;
import cn.brainysoon.superhouse.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by brainy on 17-2-18.
 */
public class SaveServiceImpl implements SaveService {

    GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public int saveGoods(String _id, String goodsname, Integer count, String goodsclass,
                         Double price, Integer usefullife, Date dateproduced, Integer position) {

        int saveCode = 0;

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