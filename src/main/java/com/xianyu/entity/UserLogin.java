package com.xianyu.entity;

/**
 * @author hyc
 * @createTime 01 20:32
 * @description 用户信息实体
 */
public class UserLogin {

    /**
     * 用户id 主键
     */
    private int userId;

    /**
     * 用户账户
     */
    private String account;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户账户余额
     */
    private String balance;

    @Override
    public String toString() {
        return "UserLogin{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", check='" + balance + '\'' +
                '}';
    }

    public UserLogin() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
