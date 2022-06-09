package com.xianyu.view;

import com.xianyu.entity.Collection;

import javax.swing.*;
import java.util.List;

/**
 * @author Zack
 * on 2022/6/9 16:03
 */
public class MyCollListMode extends AbstractListModel {
    List<com.xianyu.entity.Collection> collectionList;

    public MyCollListMode(List<Collection> collectionList){
        this.collectionList = collectionList;
    }
    @Override
    public int getSize() {
        return collectionList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return collectionList.get(index);
    }
}
