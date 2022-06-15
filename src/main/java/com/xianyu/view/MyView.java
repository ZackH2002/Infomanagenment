package com.xianyu.view;

import com.xianyu.entity.UserLogin;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * @author 黄大航
 * on 2022/6/6 19:24
 */
public class MyView extends JFrame {
    private JFrame frame;
    private UserLogin userLogin;
    private PartPanel userPanel;
    private JLabel nameText;
    private JLabel iconLabel;
    private JPanel topPanel;
    private PartPanel balancePanel;
    private JPanel secondPanel;
    private JLabel balanceText;
    private JLabel balanceIcon;
    private PartPanel buyPanel;
    private JPanel thrPanel;
    private JLabel buyIcon;
    private JLabel likeIcon;
    private PartPanel postPanel;
    private JPanel lastPanel;
    private JLabel postIcon;
    private JLabel sellIcon;
    public MyView(UserLogin userLogin){
        this.userLogin = userLogin;
        initView();
        addClick();
    }



    private void initView() {
        Color yellowColor = new Color(255, 230, 15);
        frame = new JFrame("我的");
        frame.setLayout(new GridLayout(4,1,10,10));

        //窗口大小
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 700);

        //信息面板
        topPanel = new JPanel();
        userPanel = new PartPanel(yellowColor);
        userPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        nameText = new JLabel("昵称"+userLogin.getNickName());
        nameText.setFont(new Font(null,0,30));
        nameText.setBorder(new EmptyBorder(0,0,0,40));
        iconLabel = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/worker.png")).getScaledInstance(100,100,Image.SCALE_DEFAULT);
            iconLabel.setIcon(new ImageIcon(image));
            iconLabel.setBorder(new EmptyBorder(10, 80, 10, 60));
        } catch (IOException e) {
            e.printStackTrace();
        }
        userPanel.add(iconLabel);
        userPanel.add(nameText);
        topPanel.add(userPanel);
        topPanel.setBorder(new EmptyBorder(20,0,20,0));

        //余额面板
        secondPanel = new JPanel();
        balancePanel = new PartPanel(Color.white);
        balancePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        balanceIcon = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/wallet.png")).getScaledInstance(50,50,Image.SCALE_DEFAULT);
            balanceIcon.setIcon(new ImageIcon(image));
            balanceIcon.setBorder(new EmptyBorder(20, 80, 20, 60));
        } catch (IOException e) {
            e.printStackTrace();
        }
        balanceText = new JLabel(String.valueOf(userLogin.getBalance()));
        balancePanel.add(balanceIcon);
        balancePanel.add(balanceText);
        balanceText.setBorder(new EmptyBorder(20,80,20,80));
        balanceText.setFont(new Font(null,0,20));
        secondPanel.add(balancePanel);

        //购买到的面板
        thrPanel = new JPanel();
        buyPanel = new PartPanel(Color.white);
        buyPanel.setLayout(new FlowLayout());
        buyIcon = new JLabel("我买到的");
        likeIcon = new JLabel("收藏");
        try {
            Image imageBuy = ImageIO.read(new File("src/main/resources/img/buy.png")).getScaledInstance(50,50,Image.SCALE_DEFAULT);
            buyIcon.setIcon(new ImageIcon(imageBuy));
            buyIcon.setBorder(new EmptyBorder(20, 60, 20, 40));
            Image imageLike = ImageIO.read(new File("src/main/resources/img/likeWhite.png")).getScaledInstance(50,50,Image.SCALE_DEFAULT);
            likeIcon.setIcon(new ImageIcon(imageLike));
            likeIcon.setBorder(new EmptyBorder(20, 60, 20, 40));
            buyPanel.add(buyIcon);
            buyPanel.add(likeIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        thrPanel.add(buyPanel);

        //卖出的面板
        lastPanel = new JPanel();
        postPanel = new PartPanel(Color.white);
        postPanel.setLayout(new GridLayout(1,2,10,10));
        postIcon = new JLabel("我发布的");
        sellIcon = new JLabel("我卖出的");
        try {
            Image imagePost = ImageIO.read(new File("src/main/resources/img/postIcon.png")).getScaledInstance(50,50,Image.SCALE_DEFAULT);
            postIcon.setIcon(new ImageIcon(imagePost));
            postIcon.setBorder(new EmptyBorder(20, 60, 20, 40));
            Image imageLike = ImageIO.read(new File("src/main/resources/img/sell.png")).getScaledInstance(50,50,Image.SCALE_DEFAULT);
            sellIcon.setIcon(new ImageIcon(imageLike));
            sellIcon.setBorder(new EmptyBorder(20, 60, 20, 40));
            postPanel.add(postIcon);
            postPanel.add(sellIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lastPanel.add(postPanel);

        frame.add(topPanel);
        frame.add(secondPanel);
        frame.add(thrPanel);
        frame.add(lastPanel);
        frame.setResizable(false);
    }

    private void addClick() {
        secondPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new BalanceView(userLogin);
                frame.dispose();
            }
        });
        buyIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new OderView(userLogin);
            }
        });
        postIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new MyPostView(userLogin);
            }
        });
        likeIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new MyColl(userLogin);
            }
        });
        sellIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new MySellView(userLogin);
            }
        });
    }
}
