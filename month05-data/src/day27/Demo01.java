package day27;

import java.util.Scanner;

//4.将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
public class Demo01 {
    public static void main(String[] args) {

        System.out.println("请输入任意一个数！");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for (int i = 2; i <=n; i++) {
            while(n%i==0&&i!=n){
                n=n/i;
                System.out.printf(i+"*");
            }
            if(n==i){
                System.out.println(i);
            }
        }
    }

}

/**
 * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
 * 90=2*45
 * 45=3*15
 * 15=3*5
 * 质因数就是能够被该正整数整除的数（除它本身和1外）。
 */
//public class Demo01 {
//    public static void main(String[]args){
//        int n = 90;
//        Decompose(n);
//    }
//    //用于分解
//    private static void Decompose(int n){
//        System.out.print(n+"=");
//        for(int i=2;i<=n;i++){
//            while(n%i==0 && n!=i){
////                n=n/i;
////                System.out.print(i+"*");
////            }
//            if(n==i){
//                System.out.println(i);
//                break;
//            }
//
//        }
//    }
//}
