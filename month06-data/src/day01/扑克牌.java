package day01;

import java.util.Random;

public class 扑克牌 {
    public static void main(String[] args) {
        int[] pokers = new int[52];
        for (int i = 0; i < pokers.length; i++) {
            pokers[i] = i;
            System.out.println(pokers[i] + ",");
        }
        print(pokers);
        Random rd=new Random();
        for (int i = 0; i < pokers.length; i++) {
            int r=rd.nextInt(52);
            int teep=pokers[i];
            pokers[i]=pokers[r];
            pokers[r]=teep;
        }
        print(pokers);


        System.out.println("发牌");
        int [][]players=new int[4][13];
        for (int i = 0; i < pokers.length; i++) {

        }


    }

    public static void print(int [] pokers){
        System.out.println("打印扑克牌");
        String[] pNumber = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", ""};
        String[] pColors = {"黑桃", "红桃", "梅花", "方片"};


        for (int i = 0; i <pokers.length ; i++) {
            int number=pokers[i]%13;
            int color=pokers[i]/13;
            String pName=pColors[color]+pNumber[number];
            System.out.println(pName+",");
        }
    }
}
