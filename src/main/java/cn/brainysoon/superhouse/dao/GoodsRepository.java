package cn.brainysoon.superhouse.dao;

import cn.brainysoon.superhouse.bean.Goods;

import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
public interface GoodsRepository {

    String SAVE_GOODS = "INSERT INTO goods VALUES(?,?,?,?,?,?,?,?)";
    String FIND_GOODS = "SELECT * FROM goods WHERE _id=? AND position=?";
    String PICK_GOODS = "UPDATE goods SET count=? WHERE _id=? AND position=?";
    String FIND_GOODS_BY_KEY = "SELECT * FROM goods WHERE _id LIKE ? OR goodsname LIKE" +
            " ? OR goodsclass LIKE ?";
    String FIND_GOODS_BY_NULL_KEY = "SELECT * FROM goods";
    String FIND_GOODS_SHOULD_SCRAPED = "SELECT * FROM goods";
    String DELETE_GOODS_BY_ID_POSITION = "DELETE FROM goods WHERE _id=? AND position=?";

    /**
     * //保存货物
     *
     * @param goods
     * @return 保存的状态吗
     */
    int saveGoods(Goods goods);

    /**
     * @param _id
     * @param position
     * @return
     */
    Goods findGoods(String _id, Integer position);

    /**
     * @param goods
     * @return
     */
    int pickGoods(Goods goods);

    /**
     * @param key
     * @return
     */
    List<Goods> findGoodsByKey(String key);


    /**
     * @return
     */
    List<Goods> findGoodsScraped();

    /**
     * @param _id
     * @param position
     * @return
     */
    int deleteGoodsByIdPosition(String _id, Integer position);
}