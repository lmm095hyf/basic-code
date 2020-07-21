package day20;

import javax.swing.*;
public class MyFrame extends JFrame implements Runnable
{
	JLabel lb;
	int x;
	public MyFrame(String s)
	{
		super(s);
		setBounds(100,150,400,300);
		setLayout(null);
		lb=new JLabel("Rose is beautiful!");
		x=0;
		lb.setBounds(x,50,200,100);
		add(lb);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void run()
	{
		while(true)
		{
			x++;
			x=x%getWidth();
			lb.setBounds(x,50,200,100);
			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException e) {}
		}
	}
	public static void main(String[] args)
	{
		MyFrame mf=new MyFrame("This is 胡鹰飞"+ new java.util.Date());
		Thread t=new Thread(mf);
		t.start();
	}
}