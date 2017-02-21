package cn.brainysoon.superhouse.dao.mysql;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.dao.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
@Repository
public class GoodsRepositoryImpl implements GoodsRepository, RowMapper<Goods> {

    private static final String _ID = "_id";
    private static final String GOODS_NAME = "goodsname";
    private static final String COUNT = "count";
    private static final String GOODS_CLASS = "goodsclass";
    private static final String USEFUL_LIFE = "usefullife";
    private static final String DATE_PRODUCED = "dateproduced";
    private static final String POSITION = "position";
    private static final String PRICE = "price";

    private JdbcOperations jdbcOperations;

    @Autowired
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
        goods.setPrice(rs.getDouble(PRICE));

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
    public Goods findGoods(String _id, Integer position) {

        try {

            return jdbcOperations.queryForObject(FIND_GOODS, new String[]{_id, position.toString()}, this);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public int pickGoods(Goods goods) {

        try {

            return jdbcOperations.update(PICK_GOODS,
                    goods.getCount().toString(),
                    goods.get_id(),
                    goods.getPosition().toString()
            );

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Goods> findGoodsByKey(String key) {

        try {

            //查询所有货物
            if (key.equals("")) {

                return jdbcOperations.query(FIND_GOODS_BY_NULL_KEY, this);
            }

            return jdbcOperations.query(FIND_GOODS_BY_KEY,
                    new String[]{key, key, key}, this);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Goods> findGoodsScraped() {

        try {

            return jdbcOperations.query(FIND_GOODS_SHOULD_SCRAPED, this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public int deleteGoodsByIdPosition(String _id, Integer position) {

        try {

            return jdbcOperations.update(DELETE_GOODS_BY_ID_POSITION, _id,
                    position.toString());
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return -1;
    }
}
