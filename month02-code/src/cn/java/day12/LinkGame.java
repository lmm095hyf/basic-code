package cn.java.day12;
import java.util.Random;
import java.util.Scanner;

public class LinkGame {

    /**
     * 开始游戏 ===》 ==> 初始化界面 ==》 展示界面   ==》
     * 用户输入  ==》判断是否连通  ==》判断是否结束 ====》结束游戏
     *
     * 练习：让用户输入 2个坐标值  4个数字
     *
     * 作业：
     * 	1、优化用户输入的界面
     * 	2、游戏结束的判断（棋盘全是 0 ）
     * 	3、尝试实现 一个折角的连接
     */

    // 常量 ===》 不变的量         final 终结
    private static  int SIZE=10;

    private Random random = new Random();

    private int[][] board = new int[SIZE][SIZE];

    Scanner scanner = new Scanner(System.in);

    /**
     * 开始游戏
     */
    public void start() {
        init();

        while(true) {
            showBoard(board);
            System.out.println("请输入4个坐标：");
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            boolean result = check(x1,y1,x2,y2);
            if(result == true) {
                // 连通成功，成功消去2个图形（数字置零）
                board[y1][x1] = 0;
                board[y2][x2] = 0;
            }
        }
    }
    /**
     * 展示界面
     */
        private static void showBoard(int Board[][]) {
            int i,j;
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
                System.out.print(i + "*\t");
                for (j = 0; j < Board[i].length; j++) {//循环列
                    if (Board[i][j] == 0) {
                        System.out.print("\0"+"\t");
                        continue;
                        //System.out.print("\0\0\0");
                    }
                    System.out.print(Board[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("========================================");
        }


    /**
     * 初始化界面
     */
    public void init() {
        // 构建测试棋盘数据
		/*for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				board[y][x] = 5;
			}
		}*/

        // 计算循环的次数
        int count = SIZE * SIZE / 2;
        for (int i = 0; i < count; i++) {
            // 计算2个点的编号（一维数组）
            int p1 = i * 2;
            int p2 = p1 + 1;
            // 计算2个点在二维数组中的坐标
            int y1 = p1 / SIZE;
            int x1 = p1 % SIZE;
            int y2 = p2 / SIZE;
            int x2 = p2 % SIZE;
            // 取随机值
            int rInt = 1 + random.nextInt(9);
            // 同时给两个点赋值
            board[y1][x1] = rInt;
            board[y2][x2] = rInt;
        }

        // 打乱棋盘  for +  alt + /
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                int newX = random.nextInt(SIZE);
                int newY = random.nextInt(SIZE);
                // 交换值
                int tmp = board[y][x];
                board[y][x] = board[newY][newX];
                board[newY][newX] = tmp;
            }
        }

    }

    /**
     * 测试直线的连通，如果两个点数字相同，并且中间连接的道路上全是 0， 或者两者紧贴在一起，那么则是连通的
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public boolean check(int x1, int y1, int x2, int y2) {

        // 注释快捷键  ctrl + shift + /    去掉  + \
		/*System.out.println("第一个点的值："+board[y1][x1]);
		System.out.println("第二个点的值："+board[y2][x2]);*/

        // 判断2个图形（数字）是否一致
        if(board[y1][x1] != board[y2][x2]) {
            return false;
        }

        // 判断是否平行
        if (y1 == y2) {
            // 判断是否是紧贴在一起的元素
            if (x1 == x2 + 1 || x1 == x2 - 1) {
                return true;
            }

            /**
             * i += (x1 < x2 ? 1 : -1)   循环变量根据 x1 和 x2 的坐标来 加减
             */
            for (   int i = x1    ;    i == x2   ;    i += (x1 < x2 ? 1 : -1)    ) {
                // 如果 不等于 0 表示当前位置有一个 图形, 直接返回 false
                if(  board[y1][i] != 0  ) {
                    return false;
                }
            }
            return true;
        }

        // 判断是否垂直
        if (x1 == x2) {
            if (y1 == y2 + 1 || y1 == y2 - 1) {
                return true;
            }
            for (   int i = y1    ;    i == y2   ;    i += (y1 < y2 ? 1 : -1)    ) {
                // 如果 不等于 0 表示当前位置有一个 图形, 直接返回 false
                if(  board[i][x1] != 0  ) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

}