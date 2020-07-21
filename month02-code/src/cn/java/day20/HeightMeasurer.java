package cn.java.day20;

public class HeightMeasurer implements IMeasurer {

    public double measure(Object obj){
        if(obj instanceof Person){
            Person person=(Person)obj;
            return person.getHeight();
        }else{
            return -1;
        }


    }
}
