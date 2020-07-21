package cn.java.day15;


import sun.management.jmxremote.SingleEntryRegistry;

/*
 * 春晚
 *
 * 练习题
 *1 请加入魔术和杂技
 * 2 扩展子类的方法和属性，让每一个节目都有不同的内容
 *
 * */
public class SpringParty {
    //界面单
    private Program[] programs=new Program[100];
    //最后一个节目的编号
    private int index=0;
    /*
     * 开始表演
     * */
    public void start(){
        for(Program p:programs){
            if(p!=null){
                p.show();
            }else{
                System.out.println("难忘今宵。。。");
                break;

            }
        }
    }
    /*
     * 添加节目
     *
     * 方法重载（多态：静态多态）
     */
    public void addProgram(Program p){
        programs[index]=p;
        index++;
    }

    public static void main(String[] args) {
        SpringParty sp=new SpringParty();
        sp.addProgram(new Singe("黄河大合唱"));
        sp.addProgram(new Magic("瞬间移动"));
        sp.addProgram(new Dance("千手观音"));
        sp.addProgram(new Acrobatism("高空杂技"));
        sp.addProgram(new Singe("两只老虎"));
        sp.addProgram(new Dance("踢踏舞"));
        sp.start();
    }
}
//唱歌
class Program{
    String name;
    public void show(){
        System.out.println(name+":");
    }
}
class Singe extends Program {
    Singe(String name) {
        this.name = name;
    }

    public void show() {
        super.show();
        if ("两只老虎".equals(name)){
            System.out.println("两只老虎两只老虎跑得快跑得快！！！");
        }else if ("黄河大合唱".equals(name)){
            System.out.println("这曲黄河大合唱真好听！");
        }else if ("难忘今宵".equals(name)){
            System.out.println("难忘今宵！难忘今宵~~~~");
        }

    }
}
class Dance extends Program{
        Dance(String name){
            this.name=name;
        }
    
        public void  show(){
            super.show();
            if ("踢踏舞".equals(name)){
                System.out.println("这个踢踏舞真好看！");
            }else if ("千手观音".equals(name)){
                System.out.println("哇，好整齐的千手观音啊！好棒！");
            }
    }
}
class Magic extends Program{
    Magic(String name){
        this.name=name;
    }

    public void  show(){
        super.show();
        System.out.println("这个魔术非常精彩" );
    }
}
class Acrobatism extends Program{
    Acrobatism(String name){
        this.name=name;
    }

    public void  show(){
        super.show();
        System.out.println("这个杂技非常精彩" );
    }
}
