package cn.java.day20;
public class Person {
    //定义  姓名身高 体重属性
   private String name;
   private double height;
   private double weight;

   private double income;
   private double expenses;
   private double foodexpenses;

    public Person(String name, double height, double weight,double income, double expenses, double foodexpenses) {

        this.name=name;
        this.height=height;
        this.weight=weight;
        this.income=income;
        this.expenses=expenses;
        this.foodexpenses=foodexpenses;
    }
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getFoodexpenses() {
        return foodexpenses;
    }

    public void setFoodexpenses(double foodexpenses) {
        this.foodexpenses = foodexpenses;
    }


    /*
   * 属性方法：设值方法setXXX，取值方法getXXX
   * 为什么一定要熟悉方法？
   **/
    public String getName()
    {
       return name;

    }
    public void setName(String name) {
        if(name==null){
            System.out.println("请输入用户名：");
            return;
        }
        this.name = name;
    }

    public double getHeight() {

        return height;
    }

    public void setHeight(double height) {

        this.height = height;
    }

    public double getWeight()
    {

        return weight;
    }

    public void setWeight(double weight) {

        this.weight = weight;
    }
}
