package com.zack.dao;

import com.zack.entity.UserLogin;

/**
 * @author HP
 */
public interface LoginDao {

    /**
     * 查询用户是否存在
     * @param account 用户账户
     * @param userPwd 用户秘密
     * @return 用户实体
     */
    UserLogin queryUser(String account, String userPwd);

    /**
     * 插入用户
     * @param account 用户账户
     * @param userPwd 用户密码
     * @param nickName 用户昵称
     * @return 插入是否成功 大于0 - 成功
     */
    int insertUser(String account, String userPwd, String nickName);

    /**
     * 通过账号查找用户
     * @param account 用户账户
     * @return 是否存在用户
     */
    boolean findUserByAccount(String account);

}
