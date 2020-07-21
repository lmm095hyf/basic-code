package day23;

public class E {
    public static void main(String argv[]){
        int Board [][]=new int [10][10];
        int i;
        int j;
        System.out.println("========================================");
        for (j = 0; j < Board[0].length; j++) {
            System.out.print("\t" + j);
        }
        System.out.println();
        for (j = 0; j < Board[0].length; j++) {
            System.out.print("\t" + "*");
        }
        System.out.println();
        for (i = 0; i < Board.length; i++) {//循环行
            System.out.println(i + "*\t");
//            for (j = 0; j < Board[i].length; j++) {//循环列
//                if (Board[i][j] == 0) {
//                    System.out.print("\0"+"\t");
//                    continue;
//                    //System.out.print("\0\0\0");
//                }
  //              System.out.print(Board[i][j] + "\t");
            }
            System.out.println();
        }

    }

//}






