package cn.java.day13;
/**
 * 班级
 * @author hy2005zyx
 *
 */
import java.util.Scanner;
public class Classes {
    Student stu1=new Student("王一博",23,"01");
    Student stu2=new Student("肖战",29,"02");
    Student stu3=new Student("蓝忘机",17,"03");
    Student stu4=new Student("魏无羡",18,"04");
    Student stu5=new Student("蓝湛",19,"05");
    Student stu6=new Student("魏婴",15,"06");
    Student stu7=new Student("林木木",16,"07");
    Student stu8=new Student("张杰",32,"08");
    Student stu9=new Student("何之洲",27,"09");
    Student stu10=new Student("沈熹",22,"10");
    Student stu11=new Student("堂堂",21,"11");
    Student stu12=new Student("王力宏",45,"12");
    Student stu13=new Student("许魏洲" ,33,"13");
    Student stu14=new Student("蒋婉盈",47,"14");
    Student stu15=new Student("哈尔滨",54,"15");
    Student stu16=new Student("西兰花",36,"16");
    Student stu17=new Student("张三",27,"17");
    Student stu18=new Student("李四",38,"18");
    Student stu19=new Student("王五",7,"19");
    Student stu20=new Student("习大大",53,"20");



    private Student[] students={stu1,stu2,stu3,stu4,stu5,stu6,
            stu7,stu8,stu9,stu10,stu11,stu12,stu13,stu14,stu15
            ,stu16,stu17,stu18,stu19,stu20};

    /**
     * 提供查找所有的学生信息的方法
     */
    public void query() {

    }

    /**
     * 提供根据姓名查找学生的方法，并将查出来的学生信息显示出来
     *  name
     */
    public void find() {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入查找的学生姓名");
         String name=sc.nextLine();

        for (int i = 0; i <students.length ; i++) {
            if(name.equals(students[i].name)){
                System.out.println("找到了：");
                System.out.println("学号："+students[i].sn+
                                "姓名："+name);
            }

        }
    }

    /**
     * 提供根据姓名查找学生并修改学生的年龄的方法.
     */
    public void edit() {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要修改年龄的学生姓名");
       String name=sc.nextLine();

        for (int i = 0; i <students.length ; i++) {
            if (name.equals(students[i].name)) {
                System.out.println("找到了：");
                System.out.println("学号：" + students[i].sn +
                        "姓名：" + name + "年龄：" + students[i].age);
                System.out.println("更改年龄为：");
                students[i].age = sc.nextInt();
            }
        }


    }
    public void show(){
        for (int i = 0; i <students.length ; i++) {
            System.out.println("学号：" + students[i].sn +
                    "姓名：" + students[i].name + "年龄：" +
                    students[i].age);

        }
        System.out.println(students.length);
    }

}
