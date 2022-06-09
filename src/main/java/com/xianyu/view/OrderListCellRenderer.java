package com.xianyu.view;

import com.xianyu.entity.Goods;
import com.xianyu.entity.Order;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Zack
 * on 2022/6/9 15:26
 */
public class OrderListCellRenderer extends JLabel implements ListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Order order = (Order) value;
        //设置JLabel文字
        String text = "<html>"+"订单编号："+order.getOrderId()+"<br/>"+order.getGoodsName()+" "+order.getOrderTime()+"<br/>"+"￥"+order.getPrice()+"<html/>";
        setText(text);
        setFont(new Font(null,0,18));
        setVerticalTextPosition(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setHorizontalAlignment(JLabel.LEADING);
        //设置图片
        try {
            Image image = ImageIO.read(new File(order.getUrl())).getScaledInstance(200,200,Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(image));
            setIconTextGap(30);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setBorder(new EmptyBorder(10, 20, 10, 20));
        return this;
    }
}
