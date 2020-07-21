package cn.java.day25;

import java.util.Scanner;

public class Test05 {
    //开发BMI测量工具
    //从键盘上输入体重，身高，显示身体状态。
    /**
     * bmi=weight/（height*height）
     * 范围：
     * 偏瘦《18.5
     * 正常18.5《=24
     * 过重24《28
     * 肥胖》28
     * 过度肥胖大于32
     */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入您的体重：（kg）");
        double weight=sc.nextDouble();
        System.out.println("请输入你的身高：（m）");
         double height=sc.nextDouble();
        //计算bmi
        double bmi=weight/(height*height);
         String result="";
         //根据范围判断
        if (bmi<18.5){
            result="偏瘦";
        }else if(bmi<24){
            result  ="正常";
        }else if(bmi<28){
            result  ="过重";
        }else if(bmi<32){
            result  ="肥胖";
        }else{
            result="过度肥胖";
        }
        System.out.println("身高："+height+"m,体重："+
                weight+"kg，bmi="+bmi+"身体状况"+result);
    }

}
