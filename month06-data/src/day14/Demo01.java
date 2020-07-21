package day14;

public class Demo01 {
    public static void main(String[] args) {
        //判断闰年
        //1.能被400整除一定是闰年
        //2.能被4整除，但是不能被100整除
        //闰年的定义：非整百年份是，整百年份时，是400是4的倍数，的倍数，所以100用来判断是否为整百年份

        int year=1996;

        if(year % 40==0||year % 100 !=0 && year%4 == 0){
            System.out.println("是闰年");
        }else{
            System.out.println("不是闰年");
        }

    }
}
