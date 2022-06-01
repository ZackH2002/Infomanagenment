package com.zack.VO;

import java.util.Map;

/**
 * @author hyc
 * @createTime 01 19:56
 * @description
 */
public class ResultVO {

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据 使用Map封装
     */
    private Map<Object, Object> data;

    /**
     * 返回状态码
     */

    private int code;


    public ResultVO message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultVO code(int code) {
        this.setCode(code);
        return this;
    }

    public ResultVO data(Map<Object, Object> map) {
        this.setData(map);
        return this;
    }

    public ResultVO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", code=" + code +
                '}';
    }
}
