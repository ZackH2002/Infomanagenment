package com.xianyu.view;

/**
 * @author 黄大航
 * on 2022/6/6 10:39
 */

import com.xianyu.entity.Goods;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ListModel列表模型，用于获取列表中每个单元格的值以及列表的长度，
 */
public class HomeListMode extends AbstractListModel {

    List<Goods> gArrayList;

    public HomeListMode(List<Goods> gArrayList) {
        this.gArrayList = gArrayList;
    }

    @Override
    public int getSize() {
        return gArrayList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return gArrayList.get(index);
    }
}
