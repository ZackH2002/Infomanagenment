package com.xianyu.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zack
 * on 2022/6/6 16:16
 */
public class PartPanel extends JPanel {
    private Color color;
    public PartPanel(Color color) {
        super();
        this.color = color;
        setOpaque(true);
        int fieldWeight = getSize().width;
        int fieldHeight = getSize().height;
        setSize(fieldWeight + 5, fieldHeight + 5);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int fieldX = 0;
        int fieldY = 0;
        int fieldWeight = getSize().width;
        int fieldHeight = getSize().height;
        Graphics2D g2d = (Graphics2D) g;
        //Color bg = new Color(255, 230, 15);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillRoundRect(fieldX, fieldY, fieldWeight, fieldHeight, 30, 30);
        super.paintChildren(g);//可以正常显示该组件中添加的组件
    }
}

