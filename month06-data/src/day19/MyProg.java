package day19;

public class MyProg {
    static class TestPoint{
        private int x;
        private int y;
        public TestPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
        /**
         * 移动方法
         * @param reX x移动位置
         * @param reY y移动位置
         */
        public void remove(int reX,int reY){
            x=x+reX;
            y=y+reY;
        }
        /**
         * 展示方法
         */
        public  void show(){
            System.out.println("("+x+","+y+")");
        }

    }

    public static void main(String[] args) {
        TestPoint point =new TestPoint(1,2);
        point.show();
        point.remove(1, 3);
        point.show();
    }
}
