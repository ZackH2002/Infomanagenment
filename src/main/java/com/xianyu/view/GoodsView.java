package com.xianyu.view;

import com.xianyu.VO.ResultVO;
import com.xianyu.entity.Collection;
import com.xianyu.entity.Goods;
import com.xianyu.entity.Order;
import com.xianyu.entity.UserLogin;
import com.xianyu.service.CollService;
import com.xianyu.service.GoodsService;
import com.xianyu.service.OrderService;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
    private UserLogin userLogin;
    private int pos;
    public GoodsView(Goods goods, UserLogin userLogin, int pos) throws IOException {
        this.goods = goods;
        this.userLogin = userLogin;
        this.pos = pos;
        initView();
        addClick();
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
        jLabel = new JLabel("", JLabel.CENTER);
        try {
            Image image = ImageIO.read(new File(goods.getUrl())).getScaledInstance(500, 500, Image.SCALE_DEFAULT);
            jLabel.setIcon(new ImageIcon(image));
            jLabel.setBorder(new EmptyBorder(10, 20, 20, 20));
        } catch (IOException e) {
            e.printStackTrace();
        }

        textJPanel = new JPanel();
        nameLabel = new JLabel();
        textJPanel.setLayout(new FlowLayout());
        String text = "<html>" + goods.getName() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "￥" + goods.getPrice() + " 库存：" + goods.getNum() + "<br/>" + goods.getContent() + "<html/>";
        nameLabel.setText(text);
        nameLabel.setFont(new Font(null, 0, 20));
        textJPanel.add(nameLabel);

        btnJPanel = new JPanel();
        buyBtn = new JButton("购买");
        collection = new JButton("收藏");
        btnJPanel.setLayout(new FlowLayout());
        btnJPanel.setBorder(new EmptyBorder(10, 20, 40, 20));
        btnJPanel.add(buyBtn);
        btnJPanel.add(collection);
        frame.add(jLabel, BorderLayout.NORTH);
        frame.add(textJPanel, BorderLayout.CENTER);
        frame.add(btnJPanel, BorderLayout.SOUTH);



    }

    private void addClick() {
        buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderService orderService = new OrderService();
                Order order = new Order();
                order.setGoodsId(goods.getGoodsId());
                order.setGoodsName(goods.getName());
                order.setUrl(goods.getUrl());
                order.setPrice(goods.getPrice());
                order.setSellerId(goods.getSellerId());
                order.setBuyerId(userLogin.getUserId());
                ResultVO resultVO = orderService.createOrder(order);
                if (resultVO.getCode() == 200) {
                    JOptionPane.showMessageDialog(frame, resultVO.getMessage(), "购买", -1);
                    GoodsService goodsService = new GoodsService();
                    List<Goods> goods = goodsService.listGoods();
                    frame.dispose();
                    Goods goods1 = goods.get(pos);
                    try {
                        new GoodsView(goods1,userLogin,pos);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, resultVO.getMessage(), "购买", 0);
                }
            }
        });

        collection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collection collection = new Collection();
                collection.setGoodsNum(goods.getNum());
                collection.setGoodsPrice(goods.getPrice());
                collection.setGoodsName(goods.getName());
                collection.setUrl(goods.getUrl());
                collection.setUserId(userLogin.getUserId());
                CollService collService = new CollService();
                ResultVO resultVO = collService.addFavorite(collection);
                if (resultVO.getCode() == 200){
                    JOptionPane.showMessageDialog(frame, resultVO.getMessage(), "收藏", -1);
                }else {
                    JOptionPane.showMessageDialog(frame, resultVO.getMessage(), "收藏", 0);
                }

            }
        });

    }

}
