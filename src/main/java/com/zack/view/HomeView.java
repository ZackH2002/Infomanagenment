package com.zack.view;

import com.zack.entity.UserLogin;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zack
 * on 2022/6/2 19:27
 */
public class HomeView extends JFrame {
    private JFrame frame;
    /**
     * 顶层窗口
     */
    private UserLogin userLogin;
    public HomeView(UserLogin userLogin){
        this.userLogin = userLogin;
        initView();
    }

    /**
     * 加载布局
     */
    private void initView() {
        frame = new JFrame("首页");
        frame.setSize(600, 750);
        //窗口大小
        frame.setBounds(300, 200, 1000, 700);
        frame.setVisible(true);
        //设置窗口大小不能改变
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
