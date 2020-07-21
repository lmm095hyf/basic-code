package day10;

/**
 * 动物的类
 * @author lby
 *
 */
public class Animal {
	String name;//动物的名称
	int eye;//眼睛的个数
	int legs;//几条腿

	/**
	 * 输出动物吃的食物
	 * @param food 食物
	 */
	public void eat(String food,int i,char s){//String food这个叫方法的参数,方法的参数可以有多个，参数之间用,分隔
		System.out.println("此种动物的食物是：" + food);
	}

	/**
	 * 动物的移动方式
	 * @param moveType 移动方式
	 */
	public void move(String moveType){
		int i = 0;
		System.out.println("此种动物的移动方式是：" + moveType);
	}
}
