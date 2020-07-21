package cn.java.day20;

public class BmiMeasurer implements IMeasurer{
    public double measure (Object obj){
        if(obj instanceof Person){
            Person person=(Person)obj;
            return person.getWeight()/ (person.getHeight()* person.getHeight());
        }else{
            return-1;
        }


    }

}
