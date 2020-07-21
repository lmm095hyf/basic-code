package cn.java.day16;
import cn.java.day16.Demo03;
public class InterfaceTest {
    public static void main(String[] args) {
        //demo03 d=new demo03();
        Demo03 d=null;
        d.fun1();
        d.fun2();
        d.fun3();

    }
}
class A implements Demo03{
    public void fun1(){

    }
    public void fun2(){

    }
    public void fun3(){

    }
}
class B implements  Demo03,Demo04,Demo05{
    public void fun4(){

    }
    public void fun1(){

    }
    public void fun2(){

    }
    public void fun3(){

    }
}
class C{

}
class D extends C implements Demo04,Demo05{
    public  void  fun4(){

    }

}
interface Demo04{
    void fun4();
}
interface Demo05{

}



