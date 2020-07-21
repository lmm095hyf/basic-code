package cn.java.day16;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public abstract class Demo02 {
    abstract void test();

    public void test1(){
        Person p=new Teacher();
        p.work();

        p=new Programer();
        p.work();

    }
}

abstract  class Person{
    String name;
    abstract  void work();
    //abstract  void play();

}
class Teacher extends Person{
    void work(){
        System.out.println("老师教书");
    }
}
abstract  class  Worker extends Person {
}
class Programer extends Person{
        void work(){
        System.out.println("程序员写代码");
    }
}

