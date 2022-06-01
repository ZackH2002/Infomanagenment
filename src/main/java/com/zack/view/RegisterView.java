package com.zack.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zack
 * on 2022/6/1 19:59
 */
public class RegisterView extends JFrame {
    private JFrame frame;
    private JPanel jp;
    public RegisterView(){
        frame = new JFrame("注册");    //创建Frame窗口
        frame.setSize(600, 750);
        frame.setBounds(1200, 200, 500, 700);
        frame.setVisible(true);
        Font font_text = new Font("20", Font.TYPE1_FONT, 20);
        //黄色
        Color yellowColor = new Color(251, 209, 77);
        //透明色
        Color c_null = new Color(251, 209, 77, 0);
        jp = new JPanel();    //创建JPanel对象
        jp.setLayout(null);
        //设置黄色背景
        jp.setBackground(yellowColor);
        frame.add(jp);
    }
}
