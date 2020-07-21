package GUI.hyf.day01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//第一个GUI界面
public class TestFrame {
    public static void main(String[] args) {
        //Frame JDK 看源码
        Frame frame =new Frame("我的第一个Java图像界面窗口");

        //需要设置可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(400,400);

        //设置背景颜色 Color
        frame.setBackground(new Color(13, 185, 127));

        //弹出的初始位置
        frame.setLocation(200,200);

        //设置大小固定
        frame.setResizable(false);

        frame.addWindowListener(new WindowAdapter() {
            //窗口点击关闭的时候需要做的事情
            @Override
            public void windowClosing(WindowEvent e){
                //结束程序
                System.exit(0);
            }
        });
    }

}
