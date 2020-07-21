package day28;

public class Xi{
    static {
        //静态块
        System.out.println("我是最先被执行的静态块");
    }
    public static void main(String[] args){
        AAA a=new AAA();
        System.out.println("我在了解静态块！");
    }


}

class AAA{
    static {
        //静态块
        System.out.println("我是AAA中的静态块");
    }
}