package cn.java.JDBC;
import java.sql.*;
public class Demozuoyeti {
    public static void main(String[] args) {
        Demozuoyeti demo=new Demozuoyeti();
        demo.selectBySal();
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
            String sql = "select * from product ";

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
}