package cn.brainysoon.superhouse.dao.mysql;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.dao.GoodsRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
public class GoodsRepositoryImpl implements GoodsRepository, RowMapper<Goods> {

    private static final String _ID = "_id";
    private static final String GOODS_NAME = "goodsname";
    private static final String COUNT = "count";
    private static final String GOODS_CLASS = "goodsclass";
    private static final String USEFUL_LIFE = "usefullife";
    private static final String DATE_PRODUCED = "dateproduced";
    private static final String POSITION = "position";

    private JdbcOperations jdbcOperations;

    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {

        Goods goods = new Goods();

        goods.set_id(rs.getString(_ID));
        goods.setGoodsname(rs.getString(GOODS_NAME));
        goods.setCount(rs.getInt(COUNT));
        goods.setGoodsclass(rs.getString(GOODS_CLASS));
        goods.setUsefullife(rs.getInt(USEFUL_LIFE));
        goods.setDateproduced(rs.getDate(DATE_PRODUCED));
        goods.setPosition(rs.getInt(POSITION));

        return goods;
    }

    @Override
    public int saveGoods(Goods goods) {
        return jdbcOperations.update(SAVE_GOODS,
                goods.get_id(),
                goods.getGoodsname(),
                goods.getCount(),
                goods.getGoodsclass(),
                goods.getPrice(),
                goods.getUsefullife(),
                goods.getDateproduced(),
                goods.getPosition());
    }

    @Override
    public List<Goods> findGoodsById(String id) {


        return null;
    }

    @Override
    public List<Goods> findGoodsByGoodsName(String goodsname) {
        return null;
    }

    @Override
    public List<Goods> findGoodsByGoodsClass(String goodsclass) {
        return null;
    }
}
