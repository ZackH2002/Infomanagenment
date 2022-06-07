package com.xianyu.view;

import com.xianyu.entity.UserLogin;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Zack
 * on 2022/6/7 10:24
 */
public class BalanceView extends JFrame {
    private JFrame frame;
    private JLabel balanceIcon;
    private PartPanel balancePanel;
    private JPanel topPanel;
    private JLabel balanceText;
    private JPanel btnPanel;
    private JButton chargeBtn;
    private UserLogin userLogin;

    public BalanceView(UserLogin userLogin) {
        this.userLogin = userLogin;
        initView();
        addClick();
    }

    private void initView() {
        Color yellowColor = new Color(255, 230, 15);
        Color blueColor = new Color(254, 177, 29);
        frame = new JFrame("余额");
        frame.setLayout(new GridLayout(3, 1, 10, 10));

        //窗口大小
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 700);
        frame.setResizable(false);

        topPanel = new JPanel();
        balancePanel = new PartPanel(yellowColor);
        balancePanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        balanceIcon = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/walletIcon.png")).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            balanceIcon.setIcon(new ImageIcon(image));
            balanceIcon.setBorder(new EmptyBorder(10, 80, 10, 60));
        } catch (IOException e) {
            e.printStackTrace();
        }
        balancePanel.setBorder(new EmptyBorder(10, 80, 10, 80));
        balancePanel.add(balanceIcon);
        topPanel.add(balancePanel);

        balanceText = new JLabel("￥22222", JLabel.CENTER);
        balanceText.setFont(new Font(null, Font.BOLD, 40));

        btnPanel = new JPanel();
        chargeBtn = new JButton("充值");
        chargeBtn.setBackground(blueColor);
        chargeBtn.setPreferredSize(new Dimension(250, 40));
        chargeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnPanel.add(chargeBtn);

        frame.add(topPanel);
        frame.add(balanceText);
        frame.add(btnPanel);
    }

    private void addClick() {
    }
}
