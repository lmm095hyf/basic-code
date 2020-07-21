package day01;

public class Demo01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("*");
        }
        System.out.println("======使用*打出一个矩形（矩阵）=======");


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
