package com.zack.view;

import com.zack.entity.Goods;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Zack
 * on 2022/6/6 14:26
 */
public class GoodsView extends JFrame {
    private JFrame frame;
    private Goods goods;
    private JLabel jLabel;
    private JLabel nameLabel;
    private JPanel textJPanel;
    private JPanel btnJPanel;
    private JButton buyBtn;
    private JButton collection;
    public GoodsView(Goods goods) throws IOException {
        this.goods = goods;
        initView();
    }

    private void initView() throws IOException {
        frame = new JFrame(goods.getName());
        //frame.setSize(600, 750);
        //窗口大小
        frame.setBounds(500, 200, 1000, 800);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        //设置窗口大小不能改变
        frame.setResizable(false);
        jLabel = new JLabel("",JLabel.CENTER);
        try {
            Image image = ImageIO.read(new File(goods.getUrl())).getScaledInstance(500,500,Image.SCALE_DEFAULT);
            jLabel.setIcon(new ImageIcon(image));
            jLabel.setBorder(new EmptyBorder(10, 20, 20, 20));
        } catch (IOException e) {
            e.printStackTrace();
        }

        textJPanel = new JPanel();
        nameLabel = new JLabel();
        textJPanel.setLayout(new FlowLayout());
        String text = "<html>"+goods.getName()+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"￥"+goods.getPrice()+"<br/>"+goods.getContent()+"<html/>";
        nameLabel.setText(text);
        nameLabel.setFont(new Font(null,0,20));
        textJPanel.add(nameLabel);

        btnJPanel = new JPanel();
        buyBtn = new JButton("购买");
        collection = new JButton("收藏");
        btnJPanel.setLayout(new FlowLayout());
        btnJPanel.setBorder(new EmptyBorder(10, 20, 40, 20));
        btnJPanel.add(buyBtn);
        btnJPanel.add(collection);
        frame.add(jLabel,BorderLayout.NORTH);
        frame.add(textJPanel,BorderLayout.CENTER);
        frame.add(btnJPanel,BorderLayout.SOUTH);
    }
}
