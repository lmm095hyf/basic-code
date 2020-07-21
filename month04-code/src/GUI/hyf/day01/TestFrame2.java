package GUI.hyf.day01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame2 {
    //展示多个窗口
    public static void main(String[] args) {
        MyFrame myframe1=new MyFrame(100,100,200,200,Color.blue);
        MyFrame myframe2=new MyFrame(300,100,200,200,Color.yellow);
        MyFrame myframe3=new MyFrame(100,300,200,200,Color.red);
        MyFrame myframe4=new MyFrame(300,300,200,200,Color.MAGENTA);
        myframe1.addWindowListener(new WindowAdapter() {
            //窗口点击关闭的时候需要做的事情
            @Override
            public void windowClosing(WindowEvent e){
                //结束程序
                System.exit(0);
            }
        });
        myframe2.addWindowListener(new WindowAdapter() {
            //窗口点击关闭的时候需要做的事情
            @Override
            public void windowClosing(WindowEvent e){
                //结束程序
                System.exit(0);
            }
        });
        myframe3.addWindowListener(new WindowAdapter() {
            //窗口点击关闭的时候需要做的事情
            @Override
            public void windowClosing(WindowEvent e){
                //结束程序
                System.exit(0);
            }
        });
        myframe4.addWindowListener(new WindowAdapter() {
            //窗口点击关闭的时候需要做的事情
            @Override
            public void windowClosing(WindowEvent e){
                //结束程序
                System.exit(0);
            }
        });
    }

}
class MyFrame extends Frame{
    static int id=0;//可能存在多个窗口，我们需要一个计数器

    public MyFrame(int x,int y,int w,int h,Color color){
        super("MyFrame+"+(++id));
        setBackground(color);
        setBounds(x,y,w,h);
        setVisible(true);

    }

}