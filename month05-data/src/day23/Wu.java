package day23;

import java.util.Scanner;

public class Wu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入两个整数！！！");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        Wu w=new Wu();
        System.out.println(w.sum(num1,num2));
    }

    int sum(int a,int b){ return a+b; }
}
