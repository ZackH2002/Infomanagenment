package com.zack.service;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.zack.VO.ResultVO;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyc
 * @createTime 02 20:07
 * @description
 */
@SuppressWarnings("all")
public class PicUpload {

    /**
     * 图片上传的本地路径
     */
    private static final String UPLOAD_PATH = "D:\\picture\\";


    public ResultVO upload(File file) {
        Map<Object, Object> map = new HashMap<>();
        ResultVO result = new ResultVO();
        // 获取原文件名字
        String originName = file.getName();
        // 获取文件后缀名
        String suffix = originName.substring(originName.lastIndexOf(".") + 1);
        // 判断文件是否合法
        if (!"jpg".equals(suffix) && !"png".equals(suffix)) {
            return result.message("仅支持.jpg和.png类型的图片!").code(400);
        }
        // 将文件url存入数据库

        return result.message("操作成功!").code(200).data(map);
    }

}
