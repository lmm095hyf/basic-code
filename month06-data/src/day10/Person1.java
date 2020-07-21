package day10;


public class Person1 {

	{
		//这就是代码块
		int i = 0;
	}
	//	public String name;
	public String name = "zhangsan";//public公有的，这样的类变量可以在类的外部使用，也可以在本类的方法使用
	private int age;//priavte私有的，可以在本类的方法使用，不能做类的外部使用
	//修饰符可以用来修饰变量，可以指明变是一个公有还是私有,私有的类变量不能通过对象.属性的方式调用
	//实例变量就是说在类实例化成对象之后才能使的

	public static String sex = "男";//static,意思是静态的，这样的变量不需要类实例话成对象就可以使用，
	//直接就可以通过类名.属性这样的方式直接调用,这样的变量叫做类变量

	public void showAge(){
		System.out.println(age);
	}

}
