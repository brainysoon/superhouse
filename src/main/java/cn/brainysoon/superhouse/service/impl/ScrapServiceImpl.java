package cn.brainysoon.superhouse.service.impl;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.dao.GoodsRepository;
import cn.brainysoon.superhouse.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
@Service
public class ScrapServiceImpl implements ScrapService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public List<Goods> findGoodsScraped() {

        List<Goods> goodses = goodsRepository.findGoodsScraped();

        if (goodses == null) return null;

        /**
         * 找到过期的货物
         */
        List<Goods> scraps = new ArrayList<>();
        java.util.Date now = new java.util.Date();
        long nowDays = now.getYear() * (now.getMonth() + 1) * now.getDay();

        for (int i = 0; i < goodses.size(); i++) {

            Goods goods = goodses.get(i);

            Date date = goods.getDateproduced();
            long days = date.getYear() * (date.getMonth() + 1) * date.getDay();

            if ((days + goods.getUsefullife()) > nowDays) {

                scraps.add(goods);
            }
        }

        return scraps;
    }

    @Override
    public int scrapGoods(String[] _id) {

        int code = 0;

        //...删除
        for (int i = 0; i < _id.length; i++) {

            String[] str = _id[i].split("/");

            int status = goodsRepository.deleteGoodsByIdPosition(str[0], new Integer(str[1]));

            if (status > 0) {

                code++;
            }
        }

        return code;
    }
}
