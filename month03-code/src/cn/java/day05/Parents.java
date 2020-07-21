package cn.java.day05;

import java.io.Serializable;

/**
 * 	扩展需求:
 * 1, 创建一个 Parent 家长 类:   姓名,  电话, 年龄,  取值随机
 * 2.为每个学生添加一个家长的成员变量, 并赋值一个家长对象
 * 3.查API,实现文件数据的追加
 * 4.追加的学生信息的学号, 要递增
 */

public class Parents implements Serializable {
    private static final long serialVersionUID=1L;

    private String name;
    private int number;
    private int age;

    public Parents(String name, int number, int age) {
        this.name = name;
        this.number = number;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
