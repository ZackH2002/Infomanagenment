package com.xianyu.view;

import com.xianyu.entity.Collection;
import com.xianyu.entity.Goods;
import com.xianyu.entity.UserLogin;
import com.xianyu.service.CollService;
import com.xianyu.service.PostService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Zack
 * on 2022/6/9 16:10
 */
public class MyColl extends JFrame{
    private JFrame frame;
    private JList jList;
    private UserLogin userLogin;
    private List<Collection> list;
    public MyColl(UserLogin userLogin){
        this.userLogin = userLogin;
        initView();
    }

    private void initView() {
        frame = new JFrame("我的收藏");
        frame.setLayout(new BorderLayout());
        //窗口大小
        frame.setVisible(true);
        frame.setBounds(300, 200, 900, 1000);

        CollService collService = new CollService();
        list = collService.listColl(userLogin.getUserId());
        MyCollListMode myCollListMode = new MyCollListMode(list);
        jList = new JList(myCollListMode);
        jList.setCellRenderer(new MyCollListCellRenderer());
        jList.setPreferredSize(new Dimension(800, 2000));
        JScrollPane jScrollPane = new JScrollPane(jList);
        //jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        frame.add(jScrollPane);
    }
}
