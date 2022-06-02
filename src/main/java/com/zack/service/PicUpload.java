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
     * 图片上传的服务器路径
     */
    private static final String UPLOAD_PATH = "http://47.108.166.59/80:";

    public ResultVO upload(File file) {
        Map<Object, Object> map = new HashMap<>();
        ResultVO result = new ResultVO();
        // 获取原文件名字
        String originName = file.getName();
        // 生成新文件名字 用uuid防止重复
        String uuid = IdUtil.simpleUUID();
        // 获取文件后缀名
        String suffix = originName.substring(originName.lastIndexOf(".") + 1);

        if (!"jpg".equals(suffix) && !"png".equals(suffix)) {
            return result.message("仅支持.jpg和.png类型的图片!").code(400);
        }
        // 最终的文件名字
        String fileName = uuid + suffix;
        // 文件最终的储存路径
        String filePath = UPLOAD_PATH + fileName;
        File newFile = new File(filePath);
        // 判断文件是否已经存在
        if (!newFile.getParentFile().exists()) {

            // 创建文件
            if (!newFile.mkdirs()) {
                return result.message("操作失败!").code(500);
            }
        }
        map.put("url",filePath);
        return result.message("操作成功!").code(200).data(map);
    }

}
