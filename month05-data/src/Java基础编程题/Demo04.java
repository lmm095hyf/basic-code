package Java基础编程题;

import java.util.Scanner;
//4.将一个正整数分解质因数。
/**
 * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
 * 90=2*45
 * 45=3*15
 * 15=3*5
 * 质因数就是能够被该正整数整除的数（除它本身和1外）。
 */
public class Demo04 {
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


//参考答案

//public class Program4 {
//    public static void main(String[] args) {
//        int n=1;
//        while(true){
//            System.out.println("请输入您想分解的正整数（第"+n+"次查询）：");
//            Scanner in = new Scanner(System.in);
//            int positiveInt = in.nextInt();
//            if (positiveInt==0){
//                System.out.println("您已退出。");
//                break;}
//            decompose(positiveInt);
//            System.out.println();
//            n++;
//        }
//    }
//    //分解
//    private static void decompose(int positiveInt){
//        if (positiveInt==1){
//            System.out.println("无法分解。");}
//        else {
//            System.out.print(positiveInt+"=");
//            for (int i=2;i<positiveInt+1;i++){
//                while(positiveInt%i==0 && positiveInt!=i){
//                    positiveInt /=i;
//                    System.out.print(i+"*");
//                }
//                if (positiveInt==i){
//                    System.out.println(i);
//                    break;}
//            }
//        }
//    }
//}