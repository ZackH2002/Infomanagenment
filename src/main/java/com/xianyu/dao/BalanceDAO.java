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

    /**
     * 通过id获取用户余额
     * @param userId 用户id
      * @return 用户余额
     */
    int getBalanceById(int userId);

    /**
     * 减少用户余额
     * @param balance 减少的余额
     * @param userId 用户id
     */
    void deleteBalanceById(double balance, int userId);


}
