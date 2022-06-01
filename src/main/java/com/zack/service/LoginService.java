package com.zack.service;

import com.zack.VO.ResultVO;

/**
 * @author hyc
 * @createTime 01 20:01
 * @description
 */
public class LoginService {


    public ResultVO login(String name, String password) {
        ResultVO result = new ResultVO();
        if (name == null || password == null) {
            return result.message("用户名或者密码不能为空!").code(400);
        }


        return result;
    }


}
