package com.xianyu.view;

import com.xianyu.entity.Goods;
import com.xianyu.entity.Order;
import com.xianyu.entity.UserLogin;
import com.xianyu.service.OrderService;
import com.xianyu.service.PostService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Zack
 * on 2022/6/9 15:58
 */
public class MyPostView extends JFrame{
    private JFrame frame;
    private JList jList;
    private UserLogin userLogin;
    private List<Goods> list;
    public MyPostView(UserLogin userLogin){
        this.userLogin = userLogin;
        initView();
    }

    private void initView() {
        frame = new JFrame("我的发布");
        frame.setLayout(new BorderLayout());
        //窗口大小
        frame.setVisible(true);
        frame.setBounds(300, 200, 900, 1000);

        PostService postService = new PostService();
        list = postService.listPostGoods(userLogin.getUserId());
        HomeListMode homeListMode = new HomeListMode(list);
        jList = new JList(homeListMode);
        jList.setCellRenderer(new MyPostListCellRenderer());
        jList.setPreferredSize(new Dimension(800, 2000));
        JScrollPane jScrollPane = new JScrollPane(jList);
        //jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        frame.add(jScrollPane);
    }
}
