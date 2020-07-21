package day20;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Simulator simulator=new Simulator();
        simulator.playSound(new Dog());
        simulator.playSound(new Cat());
        System.out.println("软件1802 宋雨修"+new Date());
    }
}
