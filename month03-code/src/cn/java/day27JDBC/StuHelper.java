package cn.java.day27JDBC;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
/*
 * 学生助手：生成学号，性别，专业，出生日期，入学日期，毕业状态
 */
public class StuHelper {
	
	public static Random random = new Random();
	public static Calendar cal = Calendar.getInstance();
	static String s1;
	
	//  生成学号
	public static int createSID() {
		return random.nextInt(100)+1;
	}
	
	//年龄
	public static int createAge() {
		int age = random.nextInt(8)+18;
		return age;
	}
	
	//性别
	public static String createSex() {
		int index = random.nextInt(2);
		if(index==0) {
			return "男";
		}else {
		return "女";
		}
	}
	//专业
	public static String createMajor() {
		int index = random.nextInt(5);
		if(index==0) {
			return "物联";
		}else if(index==1) {
			return "软件";
		}else if(index==2) {
			return "计科";
		}else if(index==3) {
			return "信息";
		}else {
			return "网络";
		}
	}
	
	//入学日期
	public static Timestamp createDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		int s = random.nextInt(9);
		int month =random.nextInt(9);
		int day=random.nextInt(23);
		cal.setTime(new java.util.Date() );//设置当前时间
		cal.add(Calendar.YEAR, -s);//改变时间
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DAY_OF_YEAR, day);
		java.util.Date s2=cal.getTime();//改变后的时间
		long time=s2.getTime();//获取改变时间后的毫秒值
		Timestamp d = new Timestamp(time);//获取SQL日期
		s1 = sdf.format(s2);
		return  d;
	}
	

	//出生日期
	public static Date createBirthday(java.util.Date d1) {
		int age = 18+random.nextInt(7);
		cal.setTime(d1);
		cal.add(Calendar.YEAR, -age);
		java.util.Date s = cal.getTime();
		long time = s.getTime();
		Date d = new Date(time);
		return d;
	}
	
	//毕业状态
	public static String creategraduationstatus() {

		Integer i = Integer.valueOf(s1.substring(0, 4));
		int s = i;
		if(s>=2012 && s<2016) { return "已毕业"; 
		}else if(s>=2016 && s<=2020) { 
			return "未毕业"; }
		return null;
		 
		
	}

	public static void main(String[] args) {
		StuHelper s = new StuHelper();
		System.out.println(s.createSex());
		System.out.println(s.createMajor());
		System.out.println(s.createAge());
		//System.out.println(s.createIseducated());
		System.out.println(s.createSID());
		System.out.println(s.createDate());
		System.out.println(s.createBirthday(s.createDate()));
	}
}
