package day10;

public class Person2 {
	public String name;
	public int age;
	public int sex;//�Ա�0��1Ů
	
	public void study(){
		System.out.println("studying");
	}
	
	public void showAge(){
		System.out.println(age);
	}
	
	public int addAge(int i){
		age += i;
		return age;
	}
}
