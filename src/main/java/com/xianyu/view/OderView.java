package com.xianyu.view;

import com.xianyu.VO.ResultVO;
import com.xianyu.entity.Goods;
import com.xianyu.entity.Order;
import com.xianyu.entity.UserLogin;
import com.xianyu.service.OrderService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Zack
 * on 2022/6/9 15:19
 */
public class OderView extends JFrame {
    private JFrame frame;
    private JList jList;
    private UserLogin userLogin;
    private List<Order> list;
    public OderView(UserLogin userLogin){
        this.userLogin = userLogin;
        initView();
    }

    private void initView() {
        frame = new JFrame("我的订单");
        frame.setLayout(new BorderLayout());
        //窗口大小
        frame.setVisible(true);
        frame.setBounds(300, 200, 900, 1000);

        OrderService orderService = new OrderService();
        list = orderService.listOrdersById(userLogin.getUserId());
        OrderListMode orderListMode = new OrderListMode(this.list);
        jList = new JList(orderListMode);
        jList.setCellRenderer(new OrderListCellRenderer());
        jList.setPreferredSize(new Dimension(800, 2000));
        JScrollPane jScrollPane = new JScrollPane(jList);
        //jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        frame.add(jScrollPane);
    }

}
