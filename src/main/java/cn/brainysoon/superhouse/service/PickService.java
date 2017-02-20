package cn.brainysoon.superhouse.service;

/**
 * Created by brainy on 17-2-18.
 */
public interface PickService {

    /**
     * @param _id
     * @param position
     * @param count
     * @return 状态吗
     */
    int pickGoods(String _id, Integer position, Integer count);
}
