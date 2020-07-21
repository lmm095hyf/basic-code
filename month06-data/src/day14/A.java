package day14;
//单行注释
//ctrl++放大   ctrl+-缩小
//粗体表示关键字
//console表示控制台
public class A {
    //String [] args  字符串数组  ==>args[0] 获取第一个元素
    //运行时传入的参数
    public static void main(String[] args) {
        //ctrl+s保存 eclipse 会自动的编译class文件
        //java A hyf  java A
        //判断是否有参数传入
        //程序的健壮性提升  软件工程
        if(args.length==0){
            System.out.println("hello world!");
        }else{
            System.out.println("hello"+args[0]);
        }
    }
}
