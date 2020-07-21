package cn.java.day15;

import org.omg.Messaging.SyncScopeHelper;

import java.sql.SQLOutput;

public class Parent {
    String name="王一博";
    String like;
    public void showName(){
        System.out.println(this.name);

    }
    public void show技能(){

    }

    public static void main(String[]args){
        Child c=new Child();
        c.showName();

        Parent p=new Child();
        p.showName();

        System.out.println("===========================");

        Child c1=new Child();
        Parent p1=c1;
        System.out.println( c1==p1 );

        p1.name="忘羡";
        p1.like="魔道祖师";
        c1.edu="夜猎";

        System.out.println(c1.name);
        System.out.println(c1.like);
        System.out.println( c1.edu);
        System.out.println("============================");
        System.out.println(p1.name);
        System.out.println(c1.like);

        System.out.println("========方法测试1==========");
        p1.showName();
        System.out.println("========方法测试==========");
        c1.showName();

        System.out.println("========属性测试1==========");
        System.out.println(p1.name);
        System.out.println(c1.name);

    }

}
class Child extends Parent{
    String name="肖战";
    String edu;
    public void showName(){
        super.showName();
        System.out.println(this.name);
    }
}