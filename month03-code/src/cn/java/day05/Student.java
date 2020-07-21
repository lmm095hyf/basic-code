package cn.java.day05;

import java.io.Serializable;

public class Student implements Serializable{

    private static final long serialVersionUID=1L;

    private String name;
    private String sn;
    private int chinese;
    private int math;
    private int physics;

    private Parents parent;

    public Student(Parents parent) {
        this.parent = parent;
    }

    public Parents getParent() {
        return parent;
    }

    public Student(String name, String sn, int chinese, int math, int physics) {
        this.name = name;
        this.sn = sn;
        this.chinese = chinese;
        this.math = math;
        this.physics = physics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }
    public String toString(){
        return "Student [name="+name+",sn="+sn+
                ",chinese="+chinese+",math="+math+
                ",physics"+physics+"]";
    }
}
