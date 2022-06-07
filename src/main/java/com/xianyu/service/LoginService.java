package com.xianyu.service;

import com.xianyu.VO.ResultVO;
import com.xianyu.dao.LoginDao;
import com.xianyu.dao.impl.LoginDaoImpl;
import com.xianyu.entity.UserLogin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyc
 * @createTime 01 20:01
 * @description 用户登录注册逻辑
 */
public class LoginService {

    /**
     * 注入loginDao
     */
    LoginDao loginDao = new LoginDaoImpl();

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

    public ResultVO regis(String account, String userPwd, String nickName) {
        ResultVO result = new ResultVO();
        // 判空
        if (account == null || userPwd == null) {
            return result.message("用户名或密码不能为空!").code(400);
        }
        // 判断账户是否被注册过
        if (loginDao.findUserByAccount(account)) {
            return result.message("该账户已存在!").code(400);
        }

        int i = loginDao.insertUser(account, userPwd, nickName);
        // 注册失败
        if (i < 0) {
            return result.message("操作失败!").code(500);
        }

        return result.message("注册成功!").code(200);
    }



}
