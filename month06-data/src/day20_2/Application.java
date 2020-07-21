package day20_2;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        圆 y1=new 圆();
        圆 y2=new 圆();
        正方形 z1=new 正方形();
        正方形 z2=new 正方形();

        y1.周长(4);
        y1.面积(4);
        y2.周长(6);
        y2.面积(6);

        z1.周长(3);
        z1.面积(3);
        z2.周长(5);
        z2.面积(5);

        System.out.println("软件1802宋雨修"+new Date());
        System.out.println(y1.面积(4)+y2.面积(6)+ z1.面积(3)+ z2.面积(5));
    }
}
