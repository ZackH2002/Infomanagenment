package com.zack.view;

import com.zack.entity.UserLogin;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton chooseBtn;
    private String imgUrl;
    private JPanel pricePanel;
    private JEditorPane numEdit;
    private JPanel numPanel;
    private JPanel contentPanel;
    private JEditorPane priceEdit;

    public PostView(UserLogin userLogin){
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

                //System.out.println(imgUrl);
            }
        });
    }

    private void initView() {

        Color yellowColor = new Color(255, 230, 15);
        frame = new JFrame("发布");
        frame.setLayout(new BorderLayout());
        //窗口大小
        frame.setVisible(true);
        frame.setBounds(500, 200, 500, 700);
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        imgPanel = new PartPanel();
        //imgPanel.setBorder(new EmptyBorder(10, 40, 20, 40));
        imgLabel = new JLabel("",JLabel.CENTER);
        //imgPanel.setBackground(yellowColor);
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/post.png")).getScaledInstance(60,60,Image.SCALE_DEFAULT);
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
        topPanel.add(leftPanel,BorderLayout.WEST);
        topPanel.add(imgPanel,BorderLayout.CENTER);
        topPanel.add(rightPanel,BorderLayout.EAST);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5,1));
        choosePanel = new JPanel(new FlowLayout());
        if(imgUrl!=null){
            System.out.println(imgUrl);
            //String newUrl = imgUrl.replaceAll("/", "//");
            goodsImg = new JLabel();
            try {
                Image image = ImageIO.read(new File(imgUrl)).getScaledInstance(150,150,Image.SCALE_DEFAULT);
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

        pricePanel = new JPanel();
        pricePanel.setLayout(new FlowLayout());
        JLabel priceLabel = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/consumption.png")).getScaledInstance(40,40,Image.SCALE_DEFAULT);
            priceLabel.setIcon(new ImageIcon(image));
            //priceLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel priceText = new JLabel("价格");
        priceText.setFont(new Font(null,0,20));
        priceEdit = new JEditorPane();
        priceEdit.setFont(new Font(null,0,20));
        priceEdit.setPreferredSize(new Dimension(300,30));
        pricePanel.add(priceLabel);
        pricePanel.add(priceText);
        pricePanel.add(priceEdit);

        numPanel = new JPanel();
        numPanel.setLayout(new FlowLayout());
        JLabel numLabel = new JLabel();
        try {
            Image image = ImageIO.read(new File("src/main/resources/img/packaging.png")).getScaledInstance(40,40,Image.SCALE_DEFAULT);
            numLabel.setIcon(new ImageIcon(image));
            //priceLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel numText = new JLabel("库存");
        numText.setFont(new Font(null,0,20));
        numEdit = new JEditorPane();
        numEdit.setFont(new Font(null,0,20));
        numEdit.setPreferredSize(new Dimension(300,30));
        numPanel.add(numLabel);
        numPanel.add(numText);
        numPanel.add(numEdit);

        centerPanel.add(choosePanel);
        centerPanel.add(pricePanel);
        centerPanel.add(numPanel);
        //centerPanel.add(label2);
        //centerPanel.add(label3);
        //centerPanel.add(label4);

        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(centerPanel,BorderLayout.CENTER);
        frame.setResizable(false);
    }
}
