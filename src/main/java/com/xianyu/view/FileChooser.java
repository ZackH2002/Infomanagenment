package com.xianyu.view;

import com.xianyu.VO.ResultVO;
//import com.xianyu.service.PicUpload;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author Zack
 * on 2022/6/2 20:57
 */
public class FileChooser extends JFrame implements ActionListener {
    JButton open = null;
    private String filePath;

    public FileChooser() {
        //open=new JButton("open");
        //this.add(open);
        this.setBounds(400, 200, 100, 100);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //open.addActionListener(this);
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        if (file.isDirectory()) {
            System.out.println("文件夹:" + file.getAbsolutePath());
        } else if (file.isFile()) {
            File file1 = jfc.getSelectedFile();
//            PicUpload picUpload = new PicUpload();
//            ResultVO result = picUpload.upload(file1);
//            System.out.println(result.getCode());
//            System.out.println(result.getData().get("url"));
            filePath = file.getAbsolutePath();
            System.out.println("文件:" + file.getAbsolutePath());
        }
        System.out.println(jfc.getSelectedFile().getName());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public String filePath() {
        return filePath;
    }
}
