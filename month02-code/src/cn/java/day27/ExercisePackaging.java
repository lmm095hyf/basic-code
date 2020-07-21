package cn.java.day27;

import java.util.concurrent.Callable;

/**
 * 常用 Integer 方法汇总练习
 * 请根据每行注释的描述，执行指定的方法，并输出结果
 * 
 * 请参考API: http://www.matools.com/api/java8
 */
public class ExercisePackaging {
	
	/**
	 * Integer 类练习
	 * 注意：
	 * 		其他数值类型的包装类（Long、Double...）也具有相同或类似方法，
	 * 		请童鞋们自行验证。
	 */
	public static void main(String[] args) {
		ExercisePackaging e=new ExercisePackaging();
		e.testInteger();
		e.testCharacter();

	}
	public void testInteger() {
		
		/**
		 * 构造方法
		 */
		// 请使用 int值 99 作为参数，创建一个 Integer 变量 number1 
		System.out.println(" number1 :");
		Integer number01=new Integer(99);
		System.out.println(number01);
		// 请使用 字符串 "88" 作为参数，创建一个 Integer 变量 number2
		System.out.println("number2 :");
		Integer number02=new Integer("88");
		System.out.println(number02);
		Integer a=1;
		int b=a;

		/**
		 * 实例方法（对象方法）
		 */
		Integer var = 100;
		System.out.println("测试对象 var = " + var);
		// 执行 ???Value() 方法将 i 转换成 byte 类型
		System.out.println("方法将 i 转换成 byte 类型:");
		byte v1=var.byteValue();
		System.out.println(v1);
		// 执行 ???Value() 方法将 i 转换成 short 类型
		System.out.println("方法将 i 转换成 short 类型:");
		short v2=var.shortValue();
		System.out.println(v2);
		// 执行 ???Value() 方法将 i 转换成 int 类型
		System.out.println("方法将 i 转换成 int 类型:");
		int v3=var.intValue();
		System.out.println(v3);
		// 执行 ???Value() 方法将 i 转换成 long 类型
		System.out.println("方法将 i 转换成 long 类型:");
		long v4=var.longValue();
		System.out.println(v4);
		// 执行 ???Value() 方法将 i 转换成 float 类型
		System.out.println("方法将 i 转换成 float 类型:");
		float v5=var.floatValue();
		System.out.println(v5);
		// 执行 ???Value() 方法将 i 转换成 double 类型
		System.out.println("方法将 i 转换成 double 类型:");
		double v6=var.doubleValue();
		System.out.println(v6);
		// 执行 ???To(Integer anotherInteger) 数字比较两个 Integer对象
		System.out.println("数字比较两个 Integer对象：");
		Integer i1=34;
		Integer i2=43;
		System.out.println(i1.compareTo(i2));

		/**
		 * 静态属性和方法
		 */
		// 请输出 Integer 类型的最大值
		System.out.println("输出 Integer 类型的最大值:");
		System.out.println(Integer.MAX_VALUE);
		// 请输出 Integer 类型的最小值
		System.out.println("输出 Integer 类型的最小值:");
		System.out.println(Integer.MIN_VALUE);
		// 执行 ???Int(String s)，将字符串参数解析为带符号的十进制整数
		System.out.println("将字符串参数解析为带符号的十进制整数:");
		System.out.println(Integer.parseInt("999"));
		// 执行 ???(int x, int y)，数字比较两个 Integer对象
		System.out.println("数字比较两个 Integer对象:");
		Integer e1=35;
		Integer e2=45;
		System.out.println(e1.compareTo(e2));
		// 执行 ???(int a, int b)，返回两个 int的较大值
		System.out.println("返回两个 int的较大值:");
		System.out.println(Integer.max(23,34));
		// 执行 ???(int a, int b)，返回两个 int的较小值
		System.out.println("返回两个 int的较小值:");
		System.out.println(Integer.min(13,34));
		// 执行 ???(int a, int b)，根据+运算符将两个整数相加
		System.out.println("根据+运算符将两个整数相加:");
		System.out.println(Integer.sum(85,105));
		// 执行 to???String(int i)，在基数2中返回整数参数的字符串表示形式为无符号整数（转成2进制）
		System.out.println("在基数2中返回整数参数的字符串表示形式为无符号整数（转成2进制）:");
		System.out.println(Integer.toBinaryString(1220));
		// 执行 to???String(int i)，返回整数参数的字符串表示形式，作为16位中的无符号整数（转成16进制）
		System.out.println("返回整数参数的字符串表示形式，作为16位中的无符号整数（转成16进制）:");
		System.out.println(Integer.toHexString(15));
		// 执行 to???String(int i)，在基数8中返回整数参数的字符串表示形式为无符号整数（转成8进制）
		System.out.println("在基数8中返回整数参数的字符串表示形式为无符号整数（转成8进制）:");
		System.out.println(Integer.toOctalString(45));
		// 执行 ???Of(int i)，返回一个 Integer指定的 int值的 Integer实例（int 转 Integer）
		System.out.println("int 转 Integer:");
		System.out.println(Integer.valueOf(343));
		// 执行 ???Of(String s)，返回一个 Integer对象，保存指定的值为 String（String 转 Integer）
		System.out.println("String 转 Integer：");
		System.out.println(Integer.valueOf("345213"));
	}
	
	/**
	 * Character 练习
	 */
	public void testCharacter() {
		/**
		 * 构造方法
		 */

		System.out.println("===================================");
		System.out.println("Character 练习:");
		System.out.println("===================================");
		// 请用构造方法创建一个 Character 对象
		System.out.println("创建一个 Character 对象:");
		Character ch = new Character('1');
		System.out.println(ch);

		/**
		 * 静态属性
		 */
		 // 请输出 char 的最大值
		System.out.println("请输出 char 的最大值:");
		System.out.println(Character.MAX_RADIX);
		 // 请输出 char 的最小值
		System.out.println("请输出 char 的最小值:");
		System.out.println(Character.MIN_RADIX);
		/**
		 * 实例方法
		 */
		// 执行 ???Value() 返回此 Character对象的值
		System.out.println("返回此 Character对象的值:");
		Character ch1=new Character('q');
		System.out.println(ch1.charValue());
		// 执行 ???To(Character anotherCharacter) 数字比较两个 Character对象。
		Character c='d';
		System.out.println(c.compareTo('c'));
		/**
		 * 静态方法
		 */
		// 执行 is???(char ch) 确定指定的字符是否是数字
		System.out.println(Character.isDigit('a'));
		System.out.println(Character.isDigit('6'));

		// 执行 is???(char ch) 确定指定的字符是否是一个字母。
		System.out.println(Character.isLetter('a'));
		System.out.println(Character.isLetter('6'));
		// 执行 is???(char ch) 确定指定的字符是否是小写字符。
		System.out.println("确定指定的字符是否是小写字符。");
		char chq='a';
		char chq2='A';
		System.out.println(Character.isLowerCase(chq));
		System.out.println(Character.isLowerCase(chq2));
		// 执行 is???(char ch) 确定指定的字符是否为大写字符。
		char chq3='a';
		char chq4='A';
		System.out.println("确定指定的字符是否为大写字符。");
		System.out.println(Character.isUpperCase(chq3));
		System.out.println(Character.isUpperCase(chq4));

		// 执行 is???(char ch) 确定指定的字符是否是Unicode空格字符。
		System.out.println("确定指定的字符是否是Unicode空格字符。");
		System.out.println(Character.isSpaceChar(' '));
		// 执行 to???(char ch) 使用UnicodeData文件中的案例映射信息将字符参数转换为大写。
		System.out.println("将字符参数转换为大写。");
		System.out.println(Character.toUpperCase('a'));
		// 执行 to???(char ch) 使用UnicodeData文件中的大小写映射信息将字符参数转换为小写。
		System.out.println("将字符参数转换为小写。");
		System.out.println(Character.toLowerCase('A'));
		// 执行 ???Of(char c)  返回一个 表示指定的 char值的 Character实例。
		System.out.println("表示指定的 char值的 Character实例。");
		System.out.println(Character.valueOf('a'));
	}

	/**
	 * Boolean 练习
	 */
	public void testBoolean() {
		/**
		 * 构造方法
		 */
		// 使用 boolean值 创建 Boolean对象
		Boolean bool=new Boolean(true);
		// 使用 String值 创建 Boolean对象
		Boolean bool1=new Boolean("abc");
		/**
		 * 静态属性
		 */
		// 请在控制台输出 Boolean对象对应于原始值 false 。
		//public static final Boolean FALSE
		// 请在控制台输出 Boolean对象对应于原始值 true 。
		//public static final Boolean TRUE
		/**
		 * 实例方法
		 */
		// 执行 ???Value() 将此 Boolean对象的值作为布尔基元返回。
		System.out.println("将此 Boolean对象的值作为布尔基元返回。");
		System.out.println(bool.booleanValue());
		// 执行 ???To(Boolean b) 将此 Boolean实例与另一个实例进行比较。
		System.out.println("将此 Boolean实例与另一个实例进行比较。");
		System.out.println(bool.compareTo(bool1));
		/**
		 * 静态方法
		 */
		// 执行 ???(boolean x, boolean y) 比较两个 boolean值。
		System.out.println("比较两个 boolean值。");
		System.out.println(Boolean.compare(true,false));
		// 执行 get???(String name) 返回 true当且仅当由参数命名的系统属性存在且等于字符串 "true" 。
		System.out.println("返回 true当且仅当由参数命名的系统属性存在且等于字符串 \"true\" 。");
		System.out.println(Boolean.getBoolean("a"));
		// 执行 logical???(boolean a, boolean b) 返回将逻辑AND运算符应用于指定的 boolean操作数的结果。
		System.out.println(Boolean.logicalAnd(true,true));
		// 执行 logical???(boolean a, boolean b) 返回将逻辑OR运算符应用于指定的 boolean操作数的结果。
		System.out.println(Boolean.logicalOr(true,true));
		// 执行 ???Boolean(String s) 将字符串参数解析为布尔值。
		System.out.println(Boolean.parseBoolean("0!=0"));
		// 执行 ???Of(boolean b) 返回一个 Boolean指定的 boolean值的 Boolean实例。
		System.out.println(Boolean.valueOf(true));
		// 执行 ???Of(String s) 返回一个 Boolean ，其值由指定的字符串表示。
		System.out.println(Boolean.valueOf("1=0"));
	}

}
