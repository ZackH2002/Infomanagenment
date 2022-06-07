package com.xianyu.dao;

/**
 * @author hyc
 */
public interface BalanceDAO {

    /**
     * 用户余额充值
     * @param balance 充值余额
     */
    void addBalance(String balance);


}
