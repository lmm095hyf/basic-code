package cn.java.day16;
import java.util.Random;

public class Demo01 {
    public static void main(String[] args) {
        Animal a=new Cat();
        //instanceof 实例对象
        if(a instanceof Cat){
            System.out.println(" a 是一只猫");
        }else if(a instanceof Dog){
            System.out.println(" a 是一只狗");
        }else if(a instanceof Fish ){
            System.out.println(" a 是一条鱼");
        }
        //a 既是Cat，也是Animal
        System.out.println(a instanceof  Animal);

        long l=100;
        int i=(int)l;//显示转换（强制装换）
        //类型的转换，父类转子类==>大的基本类型转小的
        Cat c=(Cat)a;
        c.eat();
        //当前的转换一定会出现错误。猫不能转成狗
        //Dog d=(Dog)a;
        Demo01 d=new Demo01();
        d.showResult();



    }

    Animal[]animals=new Animal[100];
    public Demo01(){
        Random r=new Random();
        for (int i = 0; i < animals.length; i++) {
            Animal a=null;
            int j=r.nextInt(3);
            switch(j){
                case 0:
                    a=new Cat();
                    break;
                case 1:
                    a=new Dog();
                    break;
                case 2:
                    a=new Fish();
                    break;
            }
            animals[i]=a;
        }

    }
    public void showResult(){
        /*
        * 1、
        *
        *
        * */

        int c=0;
        int d=0;
        int f=0;
        for (int i = 0; i <animals.length ; i++) {
            if(animals[i] instanceof  Cat){
                c++;
                Cat cat=(Cat) animals[i];
                cat.eat();
            }else if(animals[i]instanceof Dog){
                d++;
                Dog dog=(Dog)animals[i];
                dog.play();
            }else if(animals[i]instanceof Fish){
                f++;
                Fish fish=(Fish)animals[i];
                fish.swimming();
            }
        }
        System.out.printf("一共有：%s只猫,%s只狗,%s条鱼",c,d,f);

    }

}
class Animal{

}
class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }
}
class Dog extends Animal{
    public void play(){
        System.out.println("狗在玩");
    }

}
class Fish extends Animal{
    public void swimming(){
        System.out.println("鱼游泳");
    }

}

