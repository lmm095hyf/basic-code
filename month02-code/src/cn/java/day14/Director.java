package cn.java.day14;
public class Director extends Employee{
    private float transportAllowance;

    /**
     * 自动生成的代码 (请忽略)
     */
    public Director(String name, float basic, String address) {
        super(name, basic, address);
        // TODO Auto-generated constructor stub
        this.transportAllowance=transportAllowance;
    }
    public void show(){
        super.show();
        System.out.println("津贴："+transportAllowance);
    }
}