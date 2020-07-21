package GUI.hyf.day01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Panel是一个空间，但是不能独立存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame=new Frame();
        //布局的概念
        Panel panel=new Panel();

        //设置布局
        frame.setLayout(null);
        //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(40,161,35));

        //panel设置坐标，相对于frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(252, 30, 19));

        //frame.add()
        frame.add(panel);
        frame.setVisible(true);

        //监听事件，监听窗口关闭事件System.exit()
        //适配器模式：
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
