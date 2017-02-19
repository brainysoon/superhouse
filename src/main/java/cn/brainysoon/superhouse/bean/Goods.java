package cn.brainysoon.superhouse.bean;

import java.sql.Date;

/**
 * Created by brainy on 17-2-18.
 */
public class Goods {

    private String _id;
    private String goodsname;
    private Integer count;
    private String goodsclass;
    private Double price;
    private Integer usefullife;
    private Date dateproduced;
    private Integer position;
    public String get_id() {
        return _id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public Integer getCount() {
        return count;
    }

    public String getGoodsclass() {
        return goodsclass;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getUsefullife() {
        return usefullife;
    }

    public Date getDateproduced() {
        return dateproduced;
    }

    public Integer getPosition() {
        return position;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setGoodsclass(String goodsclass) {
        this.goodsclass = goodsclass;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUsefullife(Integer usefullife) {
        this.usefullife = usefullife;
    }

    public void setDateproduced(Date dateproduced) {
        this.dateproduced = dateproduced;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
