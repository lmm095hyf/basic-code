package cn.java.day20;

public class EG implements IMeasurer{

    public double measure(Object obj) {
        if(obj instanceof Person) {
            Person p=(Person)obj;
            return (p.getFoodexpenses()/p.getExpenses());
        }
        return 0;
    }

}