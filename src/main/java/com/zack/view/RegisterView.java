package com.zack.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zack
 * on 2022/6/1 19:59
 */
public class RegisterView extends JFrame {
    private JFrame frame;
    private JLabel head;
    private JLabel text_nickName;
    /**
     * 昵称提示
     */
    private JEditorPane edit_nickName;
    /**
     * 昵称输入框
     */
    private JLabel text_name;
    /**
     * 账号提示
     */
    private JEditorPane jEditorPane;

    /**
     * 账号输入框
     */
    private JLabel text_password;

    /**
     * 密码提示文字
     */
    private JEditorPane jPasswordField;

    /**
     * 密码输入框
     */
    private JButton btn_register;

    /**
     * 注册按钮
     */
    public RegisterView() {
        Font font_text = new Font("20", Font.TYPE1_FONT, 20);
        //黄色
        Color yellowColor = new Color(251, 209, 77);
        Color blueColor = new Color(77, 119, 251);
        //透明色
        Color c_null = new Color(251, 209, 77, 0);
        //创建Frame窗口
        frame = new JFrame("注册");
        frame.setSize(600, 750);
        frame.setBounds(1200, 200, 500, 700);
        frame.setVisible(true);
        //frame.setLayout(new GridLayout(3,1,10,5));
        //创建头像面板
        JPanel jPanel=new JPanel();
        jPanel.setBackground(yellowColor);
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,20));
        //设置图片
        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/headicon.png");
        head = new JLabel();
        head.setIcon(imageIcon);
        jPanel.add(head);
        //昵称文字
        text_nickName = new JLabel();
        text_nickName.setText("昵称");
        text_nickName.setBounds(200, 270, 800, 20);
        text_nickName.setFont(font_text);
        text_nickName.setBackground(c_null);
        jPanel.add(text_nickName);
        //昵称输入框
        edit_nickName = new JEditorPane();
        edit_nickName.setBounds(200, 300, 400, 30);
        edit_nickName.setFont(font_text);
        jPanel.add(edit_nickName);
        //账号文字区域
        //账号文字
        text_name = new JLabel();
        text_name.setText("账号");
        text_name.setBounds(200, 270, 800, 20);
        text_name.setFont(font_text);
        text_name.setBackground(c_null);
        jPanel.add(text_name);
        //账号输入框
        jEditorPane = new JEditorPane();
        jEditorPane.setBounds(200, 300, 400, 30);
        jEditorPane.setFont(font_text);
        jPanel.add(jEditorPane);
        //密码文字
        text_password = new JLabel();
        text_password.setText("密码");
        text_password.setBounds(200, 350, 800, 20);
        text_password.setFont(font_text);
        text_password.setBackground(c_null);
        jPanel.add(text_password);

        //密码输入框
        jPasswordField = new JEditorPane();
        jPasswordField.setBounds(200, 480, 400, 30);
        jPasswordField.setFont(font_text);
        jPanel.add(jPasswordField);

        btn_register = new JButton();
        btn_register.setBounds(400, 570, 200, 50);
        btn_register.setText("注册");
        btn_register.setFont(font_text);
        btn_register.setForeground(Color.white);
        btn_register.setBackground(blueColor);
        jPanel.add(btn_register);
        //添加面板到容器
        frame.add(jPanel);
        //frame.add(edit_jPanel);
        addClick();

    }
    private void addClick(){
        btn_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jEditorPane.getText();
                String password = jPasswordField.getText();
                String nikeName = edit_nickName.getText();
            }
        });

    }
}
