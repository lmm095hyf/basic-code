package cn.java.day18;

public class SubComplay extends Complay {
    SubComplay(String name,int number){
        super(name,number);
    }
    public  void query(){
        for(Employer e:employers){
            e.show();
        }
    }
    public  void addSalary(int money,Checker checker){
        for(Employer e:employers){
            if(checker.condition(e)){
                e.salary+=money;
                e.show();
            }
        }
    }
    public boolean condition(Employer e){
        return e.sex==1;
    }
    public static void main(String[] args) {
        SubComplay sc=new SubComplay("百度",100);
        System.out.println("===========查询所有员工==============");
        sc.query();
        System.out.println("==========查询所有男员工===============");
        sc.addSalary(200,new ManChecker());
        System.out.println("========查询所有女员工，并且工资大于7000=================");
        sc.addSalary(100,new WomanChecker());

    }
    static class ManChecker implements Checker{
        public boolean condition(Employer e){
            return e.sex==1;
        }
    }
    static class WomanChecker implements Checker{
        public boolean condition(Employer e){
            return e.sex==0&& e.salary>7000;
        }
    }
}
interface Checker{
    boolean condition(Employer e);
}