package com.xianyu.view;

import com.xianyu.entity.Goods;
import com.xianyu.entity.Order;
import com.xianyu.service.OrderService;

import javax.swing.*;
import java.util.List;

/**
 * @author Zack
 * on 2022/6/9 15:23
 */
public class OrderListMode extends AbstractListModel {
    List<Order> ordersArrayList;

    public OrderListMode(List<Order> ordersArrayList) {
        this.ordersArrayList = ordersArrayList;
    }

    @Override
    public int getSize() {
        return ordersArrayList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ordersArrayList.get(index);
    }
}
