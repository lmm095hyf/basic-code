package day19;

/*
 * 定义一个点类，
 * 其中有两个成员变量分别是横坐标和纵坐标，
 * 定义构造方法，位移方法和展示方法，
 * 最后定义主方法。在主方法中，
 * 创建一个点对象，展示其当时位置，
 * 然后要它位移，再展示它的当时位置。
 * */

import java.util.Scanner;

public class Dot {
    static double x;
    static double y;

    public  Dot(double a,double b){
        x=a;
        y=b;
    }

    public static void Weiyi(){
        System.out.println("请输入位移后的距离");
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        x=x+a;
        y=y+b;
        System.out.println("横坐标为"+x+"纵坐标"+y);
    }

    public static void Zhanshi(){
        System.out.println("此时横坐标为"+x+"纵坐标"+y);
    }

    public static void main(String[] args) {
        Dot d=new Dot(5.1,4.3);
        System.out.println("横坐标为"+x+"纵坐标"+y);
        d.Weiyi();
        d.Zhanshi();
    }
}
