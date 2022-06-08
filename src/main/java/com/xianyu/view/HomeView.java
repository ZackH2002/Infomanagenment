package com.xianyu.view;

import com.xianyu.VO.ResultVO;
import com.xianyu.entity.Goods;
import com.xianyu.entity.UserLogin;
import com.xianyu.service.GoodsService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author Zack
 * on 2022/6/2 19:27
 */
public class HomeView extends JFrame {
    private JFrame frame;
    /**
     * 顶层窗口
     */
    private JLabel imgLabel;
    private UserLogin userLogin;
    private JList jList;
    private JButton myButton;
    private JButton homeButton;
    private JButton postButton;
    private JPanel topJPanel;
    private List<Goods> list;
    private GoodsService goodsService;
    private ArrayList<Goods> goodsArrayList;

    public HomeView(UserLogin userLogin) {
        this.userLogin = userLogin;
        initView();
        click();
    }

    /**
     * 加载布局
     */
    private void initView() {
        topJPanel = new JPanel();
        topJPanel.setLayout(new FlowLayout());
        myButton = new JButton("我的");
        homeButton = new JButton("刷新");
        postButton = new JButton("发布");
        topJPanel.add(homeButton);
        topJPanel.add(postButton);
        topJPanel.add(myButton);
        // goodsArrayList = new ArrayList<Goods>();
        goodsService = new GoodsService();
        list = goodsService.listGoods();
//        Goods goods = new Goods();
//        goods.setName("iphone");
//        goods.setPrice(123.00);
//        goods.setContent("这是一个嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎");
//        goods.setUrl("C:\\Users\\Zack\\Pictures\\Saved Pictures\\123.png");
//        goodsArrayList.add(goods);
        HomeListMode homeListMode = new HomeListMode(list);
        jList = new JList(homeListMode);
        jList.setCellRenderer(new HomeListCellRenderer());
        jList.setPreferredSize(new Dimension(600, 1000));
        JScrollPane jScrollPane = new JScrollPane(jList);
        jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        int row = list.size() / 4 + 1;
        jList.setVisibleRowCount(row);
        //jScrollPane.setPreferredSize(new Dimension(600, 700));
        frame = new JFrame("首页");
        frame.setLayout(new BorderLayout());
        //窗口大小
        frame.setVisible(true);
        frame.setBounds(300, 200, 1000, 700);
        //设置窗口大小不能改变
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jScrollPane.setViewportView(jList);
        frame.add(topJPanel, BorderLayout.NORTH);
        frame.add(jScrollPane, BorderLayout.CENTER);

        //jScrollPane.add(jList);
        //frame.add(jScrollPane);
//        new FileChooser();
//        imgLabel = new JLabel();
//        imgLabel.setIcon(new ImageIcon("C:\\Users\\Zack\\Pictures\\专栏.png"));
//        frame.add(imgLabel);

    }

    private void click() {
        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int i = jList.getSelectedIndex();
                System.out.println(i);
                Goods goods = list.get(i);
                try {
                    new GoodsView(goods);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PostView(userLogin);
            }
        });
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyView(userLogin);
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list = goodsService.listGoods();
                HomeListMode homeListMode = new HomeListMode(list);
                jList.setModel(homeListMode);
                jList.revalidate();
                jList.repaint();
            }
        });
    }

}
