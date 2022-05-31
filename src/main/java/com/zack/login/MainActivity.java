package com.zack.login;

import javax.swing.*;
import javax.swing.text.PasswordView;
import java.awt.*;

/**
 * @author Zack
 * on 2022/5/31 19:35
 */
public class MainActivity {
    public static void main(String[] args) {
        JFrame frame=new JFrame("闲鱼");    //创建Frame窗口
        frame.setSize(600, 750);
        Font font_text1 = new Font("20", Font.TYPE1_FONT, 20);
        //黄色
        Color yellowColor = new Color(251, 209, 77);
        //透明色
        Color c_null = new Color(251, 209, 77, 0);
        JPanel jp=new JPanel();    //创建JPanel对象
        jp.setLayout(null);
        //设置黄色背景
        jp.setBackground(yellowColor);
        //设置图片
        ImageIcon imageIcon = new ImageIcon("src/main/java/com/zack/img/xianyu.png");
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        //图片大小和位置
        jLabel.setBounds(70, 0, 792, 192);
        jp.add(jLabel);

        //账号文字
        JLabel text_name = new JLabel();
        text_name.setText("账号");
        text_name.setBounds(200,270,600,20);
        text_name.setFont(font_text1);
        text_name.setBackground(c_null);
        jp.add(text_name);
        //账号输入框
        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setBounds(200,300,600,30);
        jEditorPane.setFont(font_text1);
        jp.add(jEditorPane);
        frame.add(jp);

        //密码文字
        JLabel text_password = new JLabel();
        text_password.setText("密码");
        text_password.setBounds(200,350,600,20);
        text_password.setFont(font_text1);
        text_password.setBackground(c_null);
        jp.add(text_password);

        //账号输入框
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setBounds(200,380,600,30);
        jPasswordField.setFont(font_text1);
        jp.add(jPasswordField);

        //登录按钮
        JButton Btn_login = new JButton();
        Btn_login.setBounds(400,500,200,50);
        Btn_login.setText("登录");
        Btn_login.setFont(font_text1);
        jp.add(Btn_login);

        frame.add(jp);

        //窗口大小
        frame.setBounds(300, 200, 1000, 700);
        frame.setVisible(true);
        //设置窗口大小不能改变
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
