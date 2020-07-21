package cn.java.JDBC;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dome {
    /**
     * 3.	可根据产品编号来删除。
     * @param plumber
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void delete(int plumber) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orc";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            Statement stat = conn.createStatement();

            String sql = "DELETE FROM product WHERE productcode = " + plumber;
            System.out.println(sql);
            ResultSet rs = stat.executeQuery(sql);
        } finally {
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

    public void delete(int [] plumber) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orc";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            Statement stat = conn.createStatement();
            for (int i = 0 ;i < plumber.length; i++){
                String sql = "DELETE FROM product WHERE productcode = " + plumber[i];
                System.out.println(sql);
                ResultSet rs = stat.executeQuery(sql);
            }

        } finally {
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


    /**
     *  4.	可一次删除多条数据.
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Product> setProduct() throws ClassNotFoundException, SQLException {
        Connection conn = null;


        try {
            //1 加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2.获取连接

            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);

            //3.创建语句
            Statement stat = conn.createStatement();
            String sql = "select * from product where 1 = 1 ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet  rs = stat.executeQuery(sql);
            List<Product> ret = new ArrayList<>();

            while (rs.next()){
                Product p = new Product();

                p.setProductcode(rs.getInt("PRODUCTCODE"));
                p.setPname(rs.getString("PNAME"));
                p.setQuantity(rs.getInt("QUANTITY"));
                // System.out.println(empno +" " + empty +" " +job + " " + sal);
                ret.add(p);
            }

            for (Product e : ret) {
                System.out.println(e);
            }
            return ret;
        }finally {
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

    // 5.	可根据产品编号来修改产品名和数量.
    public  void  change(int productId, String productName) throws ClassNotFoundException {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orc";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            Statement stat = conn.createStatement();
            //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
            String sql = "update product set pname = ? where productcode = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(2, Integer.toString(productId));
            ps.setString(1,productName);
            ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
    // 5.	可根据产品编号来修改产品名和数量.
    public  void  change(int productId, String productName, int Quantity) throws ClassNotFoundException {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orc";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            Statement stat = conn.createStatement();
            //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
            String sql = "update product set quantity = ? , pname = ? where productcode = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(Quantity));
            ps.setString(2,productName);
            ps.setString(3,Integer.toString(productId));


            ResultSet rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public  void  change(int productId, int Quantity) throws ClassNotFoundException {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orc";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            Statement stat = conn.createStatement();
            //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
            String sql = "update product set quantity = ? where productcode = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(Quantity));
            ps.setString(2, Integer.toString(productId));
            ResultSet rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }


    public void main() throws SQLException, ClassNotFoundException {
        Dome d = new Dome();

//        d.delete(new int[]{1, 2});
        //d.change(1,"蔡徐坤");
        //d.change(1,"蔡徐坤",122);
        d.setProduct();

//        List<Product> list =
//        for (Product p : list ) {
//            System.out.println(p);
//        }
    }


}
