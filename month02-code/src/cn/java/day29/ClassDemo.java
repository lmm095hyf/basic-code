package cn.java.day29;

public class ClassDemo {
    public static void main(String[] args)
            throws NoSuchMethodException,
            NoSuchFieldException,
            IllegalAccessException,
            InstantiationException {

        /**
         * 	获取类对象的方法
         * 		1, 使用 class 关键字
         * 		2,Class.forName("类完全限定名") 静态方法
         * 			类完全限定名 = 包名 + 类名
         * 		3,使用 getClass 对象成员方法
         */
        System.out.println(A.class);
        try{
            System.out.println(Class.forName("cn.java.day29.A"));
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Object o=new A();
        System.out.println(o.getClass());
        Class cls=o.getClass();

        /**
         * 类的构成元素:  方法, 属性, 构造方法, 块,  内部类
         * 	类对象可以动态的获取这些元素对象
         *
         * Unhandled exception type NoSuchMethodException
         */
        System.out.println(cls.getMethod("hashCode"));
        System.out.println(cls.getField("name"));
        A aa=(A)cls.newInstance();
        System.out.println(aa);
        System.out.println(o);
    }
}
     class A{
    public String name;
}
