package Java基础编程题;
//5.利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
public class Demo05 {
    static int [] arr={59,65,25,24,84,91,46,58,48,19,47,98,16,48,71,62,60,49,31,95,100,61};

    public static void main(String[] args){
        int a=0;
        int b=0;
        int c=0;
        for (int i = 0; i <arr.length ; i++) {

            if(arr[i]>=90){
                System.out.println("第"+(i+1)+"位同学的成绩等级为"+"A");
                ++a;
            }else if(arr[i]>=60&&arr[i]<=89) {
                System.out.println("第" + (i + 1) + "位同学的成绩等级为" + "B");
                ++b;
            }else {
                System.out.println("第" + (i + 1) + "位同学的成绩等级为" + "C");
                ++c;
            }
        }
        System.out.println("这个班上的成绩为A等级有"+a+"人，B为"+b+"人，C为"+c);
    }

}


//参考答案
///**
// * 利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，
// * 60-89分之间的用B表示，60分以下的用C表示。
// */
//public class Program5 {
//    public static void main(String[] args) {
//        System.out.println("请输入你的成绩：");
//        Scanner in = new Scanner(System.in);
//        int score = in.nextInt();
//        grade(score);
//    }
//    public static void grade(int score){
//        if (score>100 || score<0)
//            System.out.println("输入无效。");
//        else {
//            String str = (score>=90)?"分，属于A等":((score>60)?"分，属于B等":"分，属于C等");
//            System.out.println(score+str);
//        }
//    }
//}