package day20;



public class Dog extends Animal{
    void cry(){
        System.out.println("汪汪汪~");
    }
    String getAnmialName(){
        System.out.println("This is a Dog");
        return "Dog";
    }
}
