package com.xianyu.view;

import com.xianyu.VO.ResultVO;
import com.xianyu.entity.UserLogin;
import com.xianyu.service.BalanceService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zack
 * on 2022/6/8 15:59
 */
public class ChargeView extends JFrame {
    private UserLogin userLogin;
    private double money;
    private JFrame frame;
    private JPanel editPanel;
    private JLabel text;
    private JEditorPane editor;
    private JPanel btnPanel;
    private JButton jButton;

    public ChargeView(UserLogin userLogin) {
        this.userLogin = userLogin;
        initView();
        addClick();
    }


    private void initView() {
        frame = new JFrame("充值");
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 400);
        frame.setResizable(false);

        editPanel = new JPanel(new FlowLayout());
        text = new JLabel("请输入充值金额");
        text.setFont(new Font(null,0,30));

        editor = new JEditorPane();
        editor.setPreferredSize(new Dimension(200,40));
        editor.setFont(new Font(null,0,30));
        editPanel.add(text);
        editPanel.add(editor);
        editPanel.setBorder(new EmptyBorder(40,20,40,20));

        btnPanel = new JPanel();
        jButton = new JButton("充值");
        jButton.setFont(new Font(null,0,30));
        btnPanel.add(jButton);
        frame.add(editPanel);
        frame.add(btnPanel);


    }

    private void addClick() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                money = Double.parseDouble(editor.getText());
                BalanceService balanceService = new BalanceService();
                System.out.println(money);
                System.out.println(userLogin.getUserId());
                ResultVO resultVO = balanceService.updateBalance(money, userLogin.getUserId());
                if (resultVO.getCode() == 200) {
                    JOptionPane.showMessageDialog(frame, resultVO.getMessage(), "充值", -1);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, resultVO.getMessage(), "充值错误", 0);
                    System.out.println(resultVO.toString());
                }
            }
        });
    }
}
