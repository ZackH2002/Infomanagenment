package com.xianyu.service;

import com.xianyu.VO.ResultVO;
import com.xianyu.dao.BalanceDAO;
import com.xianyu.dao.impl.BalanceDAOImpl;

/**
 * @author hyc
 * @createTime 07 16:29
 * @description
 */
public class BalanceService {

    /**
     * 注入dao
     */
    BalanceDAO balanceDAO = new BalanceDAOImpl();

    /**
     * 根据用户id修改账户余额
     * @param balance 余额
     * @param userId 用户id
     * @return result
     */
    public ResultVO updateBalance(double balance, int userId) {
        ResultVO result = new ResultVO();
        if (balance <= 0) {
            return result.message("充值金额不合法!").code(400);
        }
        try {
            if (balanceDAO.addBalance(balance, userId) < 0) {
                return result.message("操作失败!").code(500);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result.message("充值成功!").code(200);
    }


}
