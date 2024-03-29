package com.xianyu.view;

import com.xianyu.entity.Goods;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Zack
 * on 2022/6/9 15:56
 */
public class MyPostListCellRenderer extends JLabel implements ListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Goods goods = (Goods) value;
        //设置JLabel文字
        String text = "<html>"+goods.getName()+" 库存："+goods.getNum()+"<br/>"+"￥"+goods.getPrice()+"<html/>";
        setText(text);
        setFont(new Font(null,0,18));
        setVerticalTextPosition(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setHorizontalAlignment(JLabel.LEADING);
        //设置图片
        try {
            Image image = ImageIO.read(new File(goods.getUrl())).getScaledInstance(200,200,Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(image));
            setIconTextGap(30);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setBorder(new EmptyBorder(10, 20, 10, 20));
        return this;
    }
}
