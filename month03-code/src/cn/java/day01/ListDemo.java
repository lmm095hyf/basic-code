package cn.java.day01;
/**
 * List 集合
 * 有序集合（也称为序列 ）。
 */
import java.util.*;
import java.util.ArrayList;

public class ListDemo {
    public static void main(String[] args) {
        /**
         * 所有的集合类都是 泛型 类  java 1.5 推出的新特性
         * 泛型: 用于指定某个类只能处理的对象的类型
         */
        // 创建list集合, 引用转型

        List<String>list=new ArrayList<>();

        list.add("肖战");
        list.add("王一博");
        list.add("何之洲");
        list.add("魏无羡");
        list.add("蓝忘机");

        String ws=(String)list.get(0);
        System.out.println(ws);
        System.out.println(list.size());
        list.add(0,"林木木");
        System.out.println(list.get(0));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)+";");
        }
        System.out.println();

        for (String person :list) {
            System.out.println(person+";");

        }
        System.out.println();
        for(Iterator<String>it=list.iterator();it.hasNext();) {
            String person = it.next();
            System.out.println(person + ";");
        }
        System.out.println();
        Iterator<String>it=list.iterator();

        for( ;it.hasNext(); ){
            String person=it.next();
            System.out.println(person+";");
        }
        System.out.println();
        while(it.hasNext()){
            String person=it.next();
            System.out.println(person+";");
        }
    }



}
