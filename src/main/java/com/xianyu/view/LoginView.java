package com.xianyu.view;

import com.xianyu.VO.ResultVO;
import com.xianyu.entity.UserLogin;
import com.xianyu.service.LoginService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 黄大航
 * on 2022/5/31 16:28
 */
@SuppressWarnings("all")
public class LoginView extends JFrame {
    private JFrame frame;
    private JPanel jp;
    private JLabel imgLabel;
    /**
     * 图片
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
    private JPasswordField jPasswordField;

    /**
     * 密码输入框
     */
    private JButton btn_login;

    /**
     * 登录按钮
     */

    private JButton btn_registered;

    /**
     * 注册按钮
     */
    public LoginView() {
        inintView();
        addClick();
    }

    /**
     * 加载布局
     */
    private void inintView(){
        frame = new JFrame("闲鱼");    //创建Frame窗口
        frame.setSize(600, 750);
        Color blueColor = new Color(254, 177, 29);
        Font font_text = new Font("20", Font.TYPE1_FONT, 20);
        //黄色
        Color yellowColor = new Color(255, 230, 15);
        //透明色
        Color c_null = new Color(251, 209, 77, 0);
        jp = new JPanel();    //创建JPanel对象
        jp.setLayout(null);
        //设置黄色背景
        jp.setBackground(yellowColor);
        //设置图片
        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/xianyu.png");
        imgLabel = new JLabel();
        imgLabel.setIcon(imageIcon);
        //图片大小和位置
        imgLabel.setBounds(70, 0, 792, 192);
        jp.add(imgLabel);

        //账号文字
        text_name = new JLabel();
        text_name.setText("账号");
        text_name.setBounds(200, 270, 600, 20);
        text_name.setFont(font_text);
        text_name.setBackground(c_null);
        jp.add(text_name);
        //账号输入框
        jEditorPane = new JEditorPane();
        jEditorPane.setBounds(200, 300, 600, 30);
        jEditorPane.setFont(font_text);
        jp.add(jEditorPane);
        frame.add(jp);

        //密码文字
        text_password = new JLabel();
        text_password.setText("密码");
        text_password.setBounds(200, 350, 600, 20);
        text_password.setFont(font_text);
        text_password.setBackground(c_null);
        jp.add(text_password);

        //密码输入框
        jPasswordField = new JPasswordField(1);
        jPasswordField.setBounds(200, 380, 600, 30);
        jPasswordField.setFont(font_text);
        jp.add(jPasswordField);

        //登录按钮
        btn_login = new JButton();
        btn_login.setBounds(400, 500, 200, 50);
        btn_login.setText("登录");
        btn_login.setFont(font_text);
        btn_login.setForeground(Color.white);
        btn_login.setBackground(blueColor);
        btn_login.setBorder(null);
        jp.add(btn_login);

        //注册按钮
        btn_registered = new JButton();
        btn_registered.setBounds(400, 570, 200, 50);
        btn_registered.setText("注册");
        btn_registered.setFont(font_text);
        btn_registered.setForeground(Color.white);
        btn_registered.setBackground(blueColor);
        btn_registered.setBorder(null);
        jp.add(btn_registered);

        frame.add(jp);

        //窗口大小
        frame.setBounds(300, 200, 1000, 700);
        frame.setVisible(true);
        //设置窗口大小不能改变
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void addClick() {
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jEditorPane.getText();
                String password = jPasswordField.getText();
                LoginService loginService = new LoginService();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResultVO resultVO = loginService.login(name, password);
                        if (resultVO.getCode() == 400) {
                            JOptionPane.showMessageDialog(jp, resultVO.getMessage(), "登录错误", 0);
                        }else if(resultVO.getCode() == 200){
                            JOptionPane.showMessageDialog(jp,resultVO.getMessage(),"登录",-1);
                            UserLogin userLogin = (UserLogin) resultVO.getData().get("userInfo");
                            System.out.println(userLogin.toString());
                            new HomeView(userLogin);
                            frame.dispose();
                        }
                    }
                }).start();

            }
        });
        btn_registered.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterView();
            }
        });
    }
}
