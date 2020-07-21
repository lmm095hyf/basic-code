package day01;

import java.util.Random;

public class Demo02 {
    public static void main(String[] args) {
        Random rd=new Random();

        System.out.println("===随机赋值===");
        int arr[]=new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=rd.nextInt(101);
        }
        System.out.println();


        for (int a:arr){
            System.out.print(a+",");
        }

    }



}
