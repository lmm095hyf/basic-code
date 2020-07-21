package cn.java.JDBC;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Dome d = new Dome();
        d.main();
    }

/**
 * 程序要求如下:
 * 1.	要求能对数据进行增，删，改，查的操作
 * 2.	在增加产品时，如果用户输入的产品名称相同则修改数量,否则为添加产品
 * 3.	可根据产品编号来删除。
 * 4.	可一次删除多条数据.
 * 5.	可根据产品编号来修改产品名和数量.
 * 6.	能分页显示数据
 */
}

