package com.zack.service;

import com.zack.VO.ResultVO;
import com.zack.dao.impl.LoginDaoImpl;
import com.zack.entity.UserLogin;
import com.zack.utils.JDBCUtils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyc
 * @createTime 01 20:01
 * @description 用户登录逻辑
 */
public class LoginService {

    LoginDaoImpl loginDao = new LoginDaoImpl();

    public ResultVO login(String name, String password) {
        ResultVO result = new ResultVO();
        Map<Object, Object> data = new HashMap<>();
        // 判断用户名和密码是否为空
        if (name == null || password == null) {
            return result.message("用户名或者密码不能为空!").code(400);
        }
        // 查询用户是否存在
        UserLogin user = loginDao.queryUser(name, password);
        // 登录失败
        if (user == null) {
            System.out.println("登陆失败");
            return result.message("用户名或者密码错误!").code(400);
        }
        // 登录成功
        data.put("userInfo",user);
        System.out.println("登录成功");
        return result.message("登录成功!").code(200).data(data);
    }


}
