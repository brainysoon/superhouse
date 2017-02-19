package cn.brainysoon.superhouse.dao;

import cn.brainysoon.superhouse.bean.Goods;

import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
public interface GoodsRepository {

    String SAVE_GOODS = "INSERT INTO goods VALUES(?,?,?,?,?,?,?,?)";
    String QUERY_GOODS_BY_ID = "SELCET * FROM ";

    /**
     * //保存货物
     *
     * @param goods
     * @return 保存的状态吗
     */
    int saveGoods(Goods goods);

    /**
     * @param id 查找关键字
     * @return 返回查找到的集合
     */
    List<Goods> findGoodsById(String id);

    /**
     * @param goodsname 查找关键字
     * @return 返回货物集合
     */
    List<Goods> findGoodsByGoodsName(String goodsname);

    /**
     * @param goodsclass 查找关键字
     * @return 返回查找到的货物集合
     */
    List<Goods> findGoodsByGoodsClass(String goodsclass);
}