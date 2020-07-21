package cn.java.day20;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.Callable;

public class Demo {
    public static void main(String[] args) {
        //创建容器
        Cnotainer cnotainer = new Cnotainer();
        //创建测量身高的测量工具
        HeightMeasurer hm = new HeightMeasurer();
        //设置测量工具
        cnotainer.setMeasurer(hm);


        cnotainer.addObject(new Person("王一博", 1.80, 130,10000,7000,5300));
        cnotainer.addObject(new Person("肖战", 1.83, 140,20000,7561,5421));
        cnotainer.addObject(new Person("蓝忘机", 1.88, 135,25610,8461,2158));
        cnotainer.addObject(new Person("魏无羡", 1.86, 143,158425,15486,5464));



        cnotainer.measure();

        Object max = cnotainer.getMax();
        Object min = cnotainer.getMin();
        System.out.println("最高的身高是："+max);
        System.out.println("最矮的身高是："+min);

        Object obj=cnotainer.getMaxObject();
        Person person =(Person)obj;
        System.out.println("最高的身高是："+person.getName()+"身高："+max);
        obj=cnotainer.getMaxObject();
        person =(Person)obj;
        System.out.println("最矮的身高是："+person.getName()+"身高："+min);


        //目的：如果要测体重，BMI
        BmiMeasurer bm = new BmiMeasurer();
        cnotainer.setMeasurer(bm);
        cnotainer.measure();
        max = cnotainer.getMax();
        min = cnotainer.getMin();
        System.out.println("最胖的BMI是："+max);
        System.out.println("最瘦的BMI是："+min);
      obj=cnotainer.getMaxObject();
        person=(Person)obj;
        System.out.println("最胖的BMI是："+person.getName()+"BMI："+max);
        obj=cnotainer.getMinObject();
        person=(Person)obj;
        System.out.println("最瘦的BMI是："+person.getName()+"BMI："+min);

        //恩格尔系数
        EngelMeasurer e=new EngelMeasurer();
        cnotainer.setMeasurer(e);
        cnotainer.measure();
        max=cnotainer.getMax();
        min=cnotainer.getMin();
        System.out.println("最高的恩格尔是："+max);
        System.out.println("最低的恩格尔是："+min);
        obj=cnotainer.getMaxObject();

        person=(Person)obj;
        System.out.println("恩格尔系数最高的是："+person.getName()+" 恩格尔为:"+max);
       obj=cnotainer.getMinObject();
        person=(Person)obj;
        System.out.println("恩格尔系数最低的是："+person.getName()+" 恩格尔为:"+min);

    }
    }

