package day24;

public class 爱心 {
    public static void main(String[] args) {



        for(int i = 0; i < 3; i++) {//爱心的上半部分左部分
            
            for(int j = 6; j > 2 * i; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j < 6 + 4 * i; j++) {
                System.out.print("*");
            }

            for(int q = 6; q > 3 * i  ; q--) {//爱心的上半部分右部分
                System.out.print(" ");
            }
            for(int w = 0; w < 6 + 4 * i; w++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 0; i < 9; i++) {//开始打印心的最下半部分
            for(int q = 0; q < i * 2; q++) {
                System.out.print(" ");
            }
            for(int j = 31; j > 4 * i -1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
