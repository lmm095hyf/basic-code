package cn.java.day20;

import java.util.Objects;

public class WeightMeasurer implements IMeasurer {

    public double measure(Object obj){
        if(obj instanceof Person){
            Person person=(Person)obj;
            return person.getWeight();
        }else{
            return -1;
        }


    }
}