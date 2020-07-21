package cn.java.day13;
public class Student extends Person{

    String sn;
    String name;
    int age;
    public Student(String name,int  age,String sn){
        super(name,age);
        this.sn=sn;
    }

}
