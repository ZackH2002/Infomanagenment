package com.xianyu.view;

import com.xianyu.VO.ResultVO;
import com.xianyu.entity.Goods;
import com.xianyu.entity.UserLogin;
import com.xianyu.service.GoodsService;

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

/**
 * @author Zack
 * on 2022/6/6 15:54
 */
public class PostView extends JFrame {
    private JFrame frame;
    private UserLogin userLogin;
    private JLabel imgLabel;
    private PartPanel imgPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JLabel goodsImg;
    private JPanel choosePanel;
    private JPanel namePanel;
    private JLabel nameText;
    private JLabel nameImg;
    private JEditorPane nameEdit;
    private JButton chooseBtn;
    private String imgUrl;
    private JPanel pricePanel;
    private JEditorPane numEdit;
    private JPanel numPanel;
    private JPanel contentPanel;
    private JTextArea contentEdit;
    private JLabel contentImg;
    private JLabel contentText;
    private JEditorPane priceEdit;
    private JButton postBtn;
    private JPanel btnPanel;

    public PostView(UserLogin userLogin) {
        this.userLogin = userLogin;
        imgUrl = null;
        initView();
        addClick();
    }

    private void addClick() {
        chooseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                imgUrl = fileChooser.filePath();
                frame.dispose();
                initView();
                addClick();

                //System.out.println(imgUrl);
            }
        });
        postBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Goods goods = new Goods();
                String name = nameEdit.getText();
                int price = Integer.parseInt(priceEdit.getText());
                String content = contentEdit.getText();
                int num = Integer.parseInt(numEdit.getText());
                goods.setName(name);
                goods.setPrice(price);
                goods.setUrl(imgUrl);
                goods.setNum(num);
                goods.setSellerId(userLogin.getUserId());
                goods.setContent(content);
                GoodsService goodsService = new GoodsService();
                ResultVO resultVO = goodsService.addGoods(goods);
                if (resultVO.getCode() == 200) {
                    JOptionPane.showMessageDialog(frame,resultVO.getMessage(),"发布",-1);
                    frame.dispose();
                }
            }
        });

    }

    private void initView() {

        Color yellowColor = new Color(255, 230, 15);
        frame = new JFrame("发布");
        frame.setLayout(new BorderLayout());
        //窗口大小
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 900);

        //顶部背景图片
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        imgPanel = new PartPanel(yellowColor);
        //imgPanel.setBorder(new EmptyBorder(10, 40, 20, 40));
        imgLabel = new JLabel("", JLabel.CENTER);
        //imgPanel.setBackground(yellowColor);
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/post.png")).getScaledInstance(60, 60, Image.SCALE_DEFAULT);
            imgLabel.setIcon(new ImageIcon(image));
            imgLabel.setBorder(new EmptyBorder(0, 40, 0, 40));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Label label = new Label();
        leftPanel = new JPanel();
        leftPanel.add(label);
        rightPanel = new JPanel();
        rightPanel.add(label);
        imgPanel.add(imgLabel);
        //topPanel.add(leftPanel,BorderLayout.WEST);
        topPanel.add(imgPanel, BorderLayout.CENTER);
        topPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        // topPanel.add(rightPanel,BorderLayout.EAST);

        //中心部分
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 1));

        //选择图片部分
        choosePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        if (imgUrl != null) {
            System.out.println(imgUrl);
            //String newUrl = imgUrl.replaceAll("/", "//");
            goodsImg = new JLabel();
            try {
                Image image = ImageIO.read(new File(imgUrl)).getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                goodsImg.setIcon(new ImageIcon(image));
                goodsImg.setBorder(new EmptyBorder(0, 40, 0, 40));
                System.out.println(imgUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            choosePanel.add(goodsImg);
        }
        chooseBtn = new JButton("选择图片");
        choosePanel.add(chooseBtn);
        //Label label2 = new Label("2");
        //Label label3 = new Label("3");
        //Label label4 = new Label("4");

        //名称部分
        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        nameImg = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/code.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            nameImg.setIcon(new ImageIcon(image));
            //priceLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nameText = new JLabel("名称");
        nameText.setFont(new Font(null, 0, 20));
        nameEdit = new JEditorPane();
        nameEdit.setFont(new Font(null, 0, 20));
        nameEdit.setPreferredSize(new Dimension(300, 30));
        namePanel.add(nameImg);
        namePanel.add(nameText);
        namePanel.add(nameEdit);

        //价格部分
        pricePanel = new JPanel();
        pricePanel.setLayout(new FlowLayout());
        JLabel priceLabel = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/consumption.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            priceLabel.setIcon(new ImageIcon(image));
            //priceLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel priceText = new JLabel("价格");
        priceText.setFont(new Font(null, 0, 20));
        priceEdit = new JEditorPane();
        priceEdit.setFont(new Font(null, 0, 20));
        priceEdit.setPreferredSize(new Dimension(300, 30));
        pricePanel.add(priceLabel);
        pricePanel.add(priceText);
        pricePanel.add(priceEdit);

        //库存部分
        numPanel = new JPanel();
        numPanel.setLayout(new FlowLayout());
        JLabel numLabel = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/packaging.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            numLabel.setIcon(new ImageIcon(image));
            //priceLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel numText = new JLabel("库存");
        numText.setFont(new Font(null, 0, 20));
        numEdit = new JEditorPane();
        numEdit.setFont(new Font(null, 0, 20));
        numEdit.setPreferredSize(new Dimension(300, 30));
        numPanel.add(numLabel);
        numPanel.add(numText);
        numPanel.add(numEdit);

        //商品描述
        //名称部分
        contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        contentImg = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/editor.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            contentImg.setIcon(new ImageIcon(image));
            //priceLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentText = new JLabel("商品描述");
        contentText.setFont(new Font(null, 0, 20));
        contentEdit = new JTextArea();
        contentEdit.setFont(new Font(null, 0, 20));
        contentEdit.setPreferredSize(new Dimension(300, 60));
        contentPanel.add(contentImg);
        contentPanel.add(contentText);
        contentPanel.add(contentEdit);

        centerPanel.add(choosePanel);
        centerPanel.add(namePanel);
        centerPanel.add(pricePanel);
        centerPanel.add(numPanel);
        centerPanel.add(contentPanel);
        //centerPanel.add(label2);
        //centerPanel.add(label3);
        //centerPanel.add(label4);
        btnPanel = new JPanel();
        btnPanel.setLayout(new BorderLayout());
        postBtn = new JButton("发布");
        btnPanel.setBorder(new EmptyBorder(20, 40, 60, 40));
        btnPanel.add(postBtn, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(postBtn, BorderLayout.SOUTH);
        frame.setResizable(false);
    }
}
