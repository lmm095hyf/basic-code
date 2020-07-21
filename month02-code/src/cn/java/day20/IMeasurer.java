package cn.java.day20;

/*
 * 测量工具
 * */

public interface IMeasurer {
    /*
    * 用来测量某个对象的属性值，并返回
    * 思考：如果要测量少或体重实现类要走怎么写
    * */
    double measure(Object obj);
}
