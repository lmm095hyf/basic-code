package cn.java.day20;

public class EngelMeasurer implements IMeasurer  {
    public double measure(Object obj){
        if(obj instanceof Person) {
            Person person = (Person) obj;
           return (person.getFoodexpenses() / person.getExpenses()) * 100;

        }else{
            return -1;
        }
        }
    }

