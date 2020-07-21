package cn.java.day28zuoye.jdbc1;

import java.util.Date;

public class Demo1 {
    public static void main(String[] args) {


        for(int i=0;i<1000;i++) {
            //d=Sexhelp.createsex();
            //dd=Majorhelp.createmajor();
            //System.out.println(d+"=="+dd);
            //a=Agehelp.createDate();
            //d=Agehelp.createDate();
            //int i1=Agehelp.creategraduationstatus();
            //System.out.println(d+"====="+i1);
            Date d=new Date();
            d=Demo2.createDate();
            //String s=Agehelp.creategraduationstatus();
            System.out.println(d);

        }
    }

}
