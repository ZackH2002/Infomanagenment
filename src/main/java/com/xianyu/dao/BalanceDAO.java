package com.xianyu.dao;

/**
 * @author hyc
 */
public interface BalanceDAO {

    /**
     * 用户余额充值
     * @param balance 充值余额
     * @param userId 用户id
     * @return int
     */
    int addBalance(double balance, int userId);


}
