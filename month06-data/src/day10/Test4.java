package day10;

public class Test4 {
//	static int t = 0;
	public static void main(String[] args){
//		System.out.println(t);
//		//ʵ����Person�࣬Ҳ���Ǵ���Person����
////		int i = 0;
////		String s = "";
//		Person person = new Person();//����һ��Person���͵ı�����������person��ʵ����Person�ಢ�Ҹ�person��ֵ����ֵ��ֵ���ǵ�ǰ��ʵ��
//		//new Person()����ʵ����Person��
//		person.name = "����";//��person�����name���Ը�ֵ
//		person.showName();//����ķ����ĵ���
//		int i = person.getAge();//�з���ֵ�ķ������ڵ���֮��ͻ���һ��ֵ�����ֵ���Ƿ�����return���ǲ���
//		System.out.println(i);
//		
//		person.age = 11;//��person�����age���Ը�ֵ
//		int a = person.getAge();
//		System.out.println(a);
		
//		//ʵ����һ��Animal�Ķ���
//		Animal ani = new Animal();
//		
//		ani.eat("����");
//		
//		ani.move("��");
		
		//δ�����ܻ�ѧϰ���Ӹ��ӵ��࣬���ǻ�����ഴ�����󣬲���ʹ�ö���
		//���ڶ����ʹ��������������ط�,��������ı����������෽��
		
//		Person1 p = new Person1();
////		p.name;
////		p.age
//		Person1.sex
		//��һ����ͨ����ʵ���������Ķ�����Զ����ÿ�������Ƕ�������������
//		Person p1 = new Person();
//		Person p2 = new Person();
//		p1.name = "zhangsan";
//		p2.name = "lisi";
//		p1.showName();
//		p2.showName();
		
//		Student stu = new Student();
//		stu.name = "С��";
//		stu.age = 12;
//		stu.course = "���ġ���ѧ��Ӣ���ѧ";
//		stu.interest = "���򡢽��衢����";
//		stu.showInfo();
		
//		Test4 t4 = new Test4();
//		int area = t4.getArea(2, 3);
//		System.out.println(area);
		
//		Student s = new Student();
//		s.showInfo();
//		new Student().showInfo();
//		
//		Person2 p = new Person2();
//		p.name = "lucy";
//		p.age = 11;
//		p.sex = 1;
//		p.study();
//		
//		int a = p.addAge(2);
//		System.out.println("a:" + a + "  p.age:" + p.age);
		
//		double area = new Circle().area(2);
//		System.out.println("�뾶Ϊ2��Բ������ǣ�" + area);
		
		Test4 t4 = new Test4();
//		t4.mOL(2);
//		t4.mOL(2, 3);
//		t4.mOL("���ط���mOL");
		t4.max(0, 1);
		t4.max(0.2, 1.5);
		t4.max(9.1, 2, 4.5);
		
	}
	
	public int getArea(int x, int y){
		return x * y;
	}
	//�����ͬ���Ƶķ����������һ�����й��棬��ô��Щͬ������һ���ǲ����ĸ������߲������������Ͳ�һ��
	//������ͬ�������ͽ�������
	public int add(int x, int y){
		return x + y;
	}
	
//	public int add(int m, int n){
//		
//	}
	public double add(int x, double y){
		return x + y;
	}
	
	public int add(int x, int y, int z){
		return x + y + z;
	}
	
	public void mOL(int i){
		System.out.println(i * i * i);
	}
	
	public void mOL(int x, int y){
		System.out.println(x * y);
	}
	
	public void mOL(String s){
		System.out.println(s);
	}
	
	public void max(int x, int y){
		if(x > y){
			System.out.println("���ֵ�ǣ�" + x);
		}else{
			System.out.println("���ֵ�ǣ�" + y);
		}
	}
	
	public void max(double x, double y){
		double res = 0;
		if(x > y){
			res = x;
		}else{
			res = y;
		}
		System.out.println("���ֵ�ǣ�" + res);
	}
	
	public void max(double a, double b, double c){
		double res = 0;
		
		if(a > b){
			if(a > c){
				res = a;
			}else{
				res = c;
			}
		}else{
			if(b > c){
				res = b;
			}else{
				res = c;
			}
		}
		System.out.println("���ֵ�ǣ�" + res);
	}
}
