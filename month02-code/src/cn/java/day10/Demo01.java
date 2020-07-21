package cn.java.day10;

import java.util.Random;

/**
 * 内容： Java语法基础、OOP1内容：封装

 */
public class Demo01 {

    public static void main(String[] args) {

        /**
         * 	1、定义一个长度为50的整型数数组
         2、随机赋值60~100，表示数学考试的成绩
         3、请计算求出成绩的前三名（允许并列排名）

         取随机数
         Random r = new Random();
         r.nextInt(最大值);
         */
        //定义一个长度为50的数组
        int[] scores = new int[50];
        //随机取值
        Random r = new Random();
        //遍历数组
        for (int i = 0; i < scores.length; i++) {
            scores[i] = 60 + r.nextInt(41); // 60~100   60 + 40随机数
        }
        //冒泡排序,【从大到小】
        for (int i = 0; i< scores.length - 1;i ++) {
            for (int j = 0; j< scores.length - 1 -i ; j++) {
                //判斷大小
                if (scores[i] < scores[i + 1]) {
                    //交換值
                    int tmp = scores[i];
                    scores[i] = scores[i + 1];
                    scores[i + 1] = tmp;
                }

            }
        }

        // 增强for循环
        for (int s : scores) {
            System.out.println(s);
        }

        System.out.println("前三名（含并列）");
        // 记录当前名词的索引（下标）//并列情况的显示
        int curIndex = 0;
        for (int i = 0; i < 3; i++) {
            int curScore = scores[curIndex]; //0  =>  100;
            // j 从当前的名次索引处开始循环
            /*此处for循环分析，j为下标，若后面有数跟此时下标对应的数相等，
             * 则那个数的下标也跟此时下标相同
             * */
            for (int j = curIndex; j < scores.length; j++) {
                if(scores[j] == curScore) {
                    System.out.println(scores[j]);
                } else {
                    // 记录下一个名次的分数的起始索引（下标）
                    curIndex = j;
                    break;
                }
            }
        }

    }

}
