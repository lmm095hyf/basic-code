package cn.java.day27;

public class Demo01 {
    public static void main(String[] args) {
        A d=new A ();
        System.out.println(d.toString());
        System.out.println( d);
        String s="看看是什么";
        s+=d;// 对象转字符串,  虚拟机会自动的调用 toString 方法
        System.out.println(s);

    }
    static class A {
        public String toString(){
            return "自定义的A类";
        }
    }
}
