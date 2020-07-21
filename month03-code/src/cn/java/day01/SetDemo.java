package cn.java.day01;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("肖战");
        set.add("肖战");
        set.add("肖战");
        set.add("王一博");
        set.add("xz");
        set.add("肖战");
        set.add("wyb");
        set.add("林木木");
        for (String person  :set) {
            System.out.println(person+";");

        }

        System.out.println();

        //HashSet是无序的，但是LinkedHashSet是有序的

        set=new LinkedHashSet<>();
        set.add("肖战");
        set.add("肖战");
        set.add("肖战");
        set.add("肖战");
        set.add("王一博");
        set.add("xz");
        set.add("wyb");
        set.add("林木木");

        for (String person  :set) {
            System.out.println(person+";");

        }

    }
}
