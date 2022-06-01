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
    private JLabel head;
    public RegisterView() {
        Font font_text = new Font("20", Font.TYPE1_FONT, 20);
        //黄色
        Color yellowColor = new Color(251, 209, 77);
        //透明色
        Color c_null = new Color(251, 209, 77, 0);
        //创建GridBagLayout布局管理器
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        //创建Frame窗口
        frame = new JFrame("注册");
        frame.setSize(600, 750);
        frame.setBounds(1200, 200, 500, 700);
        frame.setVisible(true);
        frame.setLayout(gridBagLayout);
        frame.setBackground(yellowColor);
        //组件填充显示区域
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.0;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        //设置图片
        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/head.png");
        head = new JLabel();
        head.setIcon(imageIcon);

    }
}
