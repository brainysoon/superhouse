package cn.brainysoon.superhouse.utils;

import java.sql.Date;

/**
 * Created by brainy on 17-2-19.
 */
public class CheckUtils {

    private static CheckUtils checkUtils = new CheckUtils();

    private CheckUtils() {

    }

    public static CheckUtils getInstance() {

        return checkUtils;
    }

    /**
     * @param _id
     * @param goodsname
     * @param count
     * @param goodsclass
     * @param price
     * @param usefullife
     * @param dateproduced
     * @param position
     * @return
     */
    public boolean isGoodsHasNull(String _id, String goodsname, Integer count, String goodsclass,
                                  Double price, Integer usefullife, Date dateproduced, Integer position) {

        return (_id.equals("") || goodsclass.equals("") ||
                count.equals("") || goodsclass.equals("") ||
                price.equals("") || usefullife.equals("") ||
                dateproduced.equals("") || position.equals(""));
    }

    /**
     * @param _id
     * @param position
     * @param count
     * @return
     */
    public boolean isPickGoodsHasNull(String _id, Integer position, Integer count) {

        return (_id.equals("") || position.equals("") || count.equals(""));
    }

    /**
     * @param _id
     * @param staffname
     * @param password
     * @param birthday
     * @param issuper
     * @return
     */
    public boolean isStaffHasNull(String _id, String staffname, String password,
                                  Date birthday, Integer issuper) {

        return (_id.equals("") || staffname.equals("") || password.equals("") ||
                birthday == null || issuper.equals(""));
    }
}
