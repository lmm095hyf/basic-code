package cn.java.JDBC;

import cn.java.day05.IOHelper;

import java.io.Closeable;
import java.sql.*;

/**
 * JDBC: java 数据库连接组件 ( 一系列 操作的数据的 接口和类 , 包 java.sql)
 * 1. 加载驱动	Class.forName("类路径")
 * 2. 获取连接 getConnection(url, user, password)
 * 3. 创建语句  createStatement()  prepareStatment(sql);
 * 4. 执行语句
 * 5. 关闭连接
 */
public class Demo02 {
    public void updateDept() throws ClassNotFoundException, SQLException {
        // 1.加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2.获取连接
        String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
        String user = "scott"; // 数据的用户
        String password = "a";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 3.创建语句
        Statement stat = conn.createStatement();

        // 4.执行语句
        String sql ="create table product ";
        int ret = stat.executeUpdate(sql);
        System.out.println("更新了" + ret + "条记录");

        // 5.关闭连接
        stat.close(); // 关闭语句对象
        conn.close(); // 关闭连接对象

    }
    public void selectBySal() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
            String user = "scott"; // 数据的用户
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            stat = conn.createStatement();
            String sql = "create table product";

            // 执行sql ResultSet 是查询的结果对象, 它也需要关闭
            rs = stat.executeQuery(sql); // 异常
            // rs.next() 判断结果集中是否还有数据, 返回 boolean 值
            while (rs.next()) {
                int empno = rs.getInt(1); // get数据类型 用于获取指定的字段值, 字段索引从 1 开始计数
                String ename = rs.getString(2);
                String job = rs.getString("JOB"); // oracle 字段名会自动转成大写
                double sal = rs.getDouble("SAL");
                System.out.printf("%s\t%s\t%s\t%s\t\n", empno, ename, job, sal);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭一定要在 finally 中
            IOHelper.close((Closeable) rs);
            IOHelper.close((Closeable) stat);
            IOHelper.close((Closeable) conn);
        }
    }
    public void selectByName(String name) {
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
            String user = "scott"; // 数据的用户
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from emp where ename = ?";
            System.out.println(sql);

            stat = conn.prepareStatement(sql);
            stat.setString(1,name);
            rs = stat.executeQuery();
            while (rs.next()) {
                int empno = rs.getInt(1); // get数据类型 用于获取指定的字段值, 字段索引从 1 开始计数
                String ename = rs.getString(2);
                String job = rs.getString("JOB"); // oracle 字段名会自动转成大写
                double sal = rs.getDouble("SAL");
                System.out.printf("%s\t%s\t%s\t%s\t\n", empno, ename, job, sal);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭一定要在 finally 中
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Demo01 d1 = new Demo01();

         d1.updateDept();
        // 注入攻击的
        d1.selectByName("abc' or '1'='1");
        d1.selectByName("SMITH");
        d1.selectByName("JONES");
    }

}
