package day20;

public class Cat extends Animal{
    void cry(){
        System.out.println("喵喵喵~");
    }
    String getAnmialName(){
        System.out.println("This is a Cat");
        return "Cat";
    }
}
