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


}
