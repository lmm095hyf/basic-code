package cn.java.day01;

import java.util.HashSet;
import java.util.Set;

public class SetDemo01 {
    public static void main(String[] args) {
        Set<Person>set=new HashSet<>();

        set.add(new Person("肖战",29));
        set.add(new Person("王一博",23));
        set.add(new Person("wyb",23));
        set.add(new Person("xz",29));
        set.add(new Person("林木木",22));
/**
 * HashSet 判断对象是否相同基于 2 个方法
 * hashCode() 返回对象的哈希值
 * 		哈希函数计算的一个hash值
 *
 * equals()	  判断对象是否内容相同
 *
 * 1, hashCode 不同, 那么这个两个对象移动不同 ,不需要equals
 * 2, hashCode 相同, 那么两个个对象有可能内容一致
 * 3, 进行equals 比较
 *
 * Person 必须同时重写  equals 和 hashCode 方法
 *
 */
        for(Person p:set){
            System.out.println(p);
        }
    }
}
class Person{
    String name;
    Integer age;

    public Person (String name,Integer age){
        this.name=name;
        this.age=age;
    }
    public String toString(){
        return "Person[name"+name+",age="+age+"]";
    }
    public int hasCode(){
        final int prime=31;
        int retult=1;
        retult=prime*retult+((age==null)?0:age.hashCode());
        retult=prime*retult+((name==null)?0:age.hashCode());
        return retult;
    }
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        Person other=(Person)obj;
        if(age==null){
            if(other.age!=null)
                return false;
        }else if(!age.equals(other.age))
            return false;
        if(name==null){
            if(other.name!=null)
                return false;
        }else if(!name.equals(other.name))
            return false;
        return true;
    }
}