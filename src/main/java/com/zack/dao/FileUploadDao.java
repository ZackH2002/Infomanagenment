package com.zack.dao;

/**
 * @author hyc
 */
public interface FileUploadDao {

    /**
     * 插入图片路径
     * @param url 图片url
     * @return 是否插入成功
     */
    int uploadFile(String url);


}
