package cn.java.day27JDBC;
import	java.util.Scanner;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dome {
    String url = "jdbc:oracle:thin:@39.107.46.233:1521:orcl";
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
            //String url = "jdbc:oracle:thin:@39.107.46.233:1521:orc";
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

    /**
     * 一次删除多条数据.
     * @param plumber
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void delete(int [] plumber) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //String url = "jdbc:oracle:thin:@39.107.46.233:1521:orc";
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
     *  x显示所有数据
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

            //String url = "jdbc:oracle:thin:@39.107.46.233:1521:orc";
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


    /**
     * 产品编号来修改产品名
     * @param productId 产品编号
     * @param productName 产品名
     * @throws ClassNotFoundException
     */
    public  void  change(int productId, String productName) throws ClassNotFoundException {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
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
     * 可根据产品编号来修改产品名和数量.
     * @param productId 产品编号
     * @param productName 产品名
     * @param Quantity 数量
     * @throws ClassNotFoundException
     */
    public  void  change(int productId, String productName, int Quantity) throws ClassNotFoundException {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //String url = "jdbc:oracle:thin:@39.107.46.233:1521:orcl";
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
     * 可根据产品编号来修改和数量.
     * @param productId 产品编号
     * @param Quantity 数量
     * @throws ClassNotFoundException
     */
    public  void  change(int productId, int Quantity) throws ClassNotFoundException {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
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
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2.获取连接
        }catch (ClassNotFoundException e) {
            RuntimeException re = new RuntimeException(" ", e);
        }
    }

    public Connection get() {
        String url = "jdbc:oracle:thin:@39.107.46.233:1521:orcl";
        String user = "scott";
        String password = "a";

        try{
            return DriverManager.getConnection(url, user, password);
        }catch (SQLException se){
            throw new RuntimeException("  ",se);
        }
    }

    /**
     * 根据编号精确查找,能查看所有的数据.
     * @param productId
     */
    public  void find (int productId){
        Connection conn = get();

        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            String sql = "select *  from product where productcode = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, String.valueOf(productId));
            rs = ps.executeQuery();
            while (rs.next()) {
                int porductcode = rs.getInt("PRODUCTCODE");
                String name = rs.getString("PNAME");
                int quentity = rs.getInt("QUANTITY");
                System.out.printf("产品编号：%s\t产品名称：%s\t产品数量：%s\t\n",porductcode, name, quentity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
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
     * 能根据产品名模糊查找，
     * @param productName 产品名
     */
    public void find(String productName){
        Connection conn = get();
        ResultSet rs = null;
        try {
            String sql = "select *  from product where pname like ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, productName);
            rs = ps.executeQuery();

            while (rs.next()) {
                int porductcode = rs.getInt("PRODUCTCODE");
                String name = rs.getString("PNAME");
                int quentity = rs.getInt("QUANTITY");
                System.out.printf("产品编号：%s\t产品名称：%s\t产品数量：%s\t\n",porductcode, name, quentity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
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
    public void insertdate(int productcode, String pname, int quentity) {
        Connection conn = get();
        PreparedStatement stat = null;
        try {

            String sql = "insert into product values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(productcode));
            ps.setString(2,pname);
            ps.setString(3, String.valueOf(quentity));
            ResultSet rs = ps.executeQuery();

        }catch (SQLException e) {
            e.printStackTrace();
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
     * * 分页查询 select * from( select rownum as rn,productcode,pname,quantity from
     *  (select * from porduct) where rownum<=5) where rn>=1;
     * @param max
     * @param min
     */
    public void selectdate(int max, int min) {
        Connection conn = get();

        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            String sql = "select * from(\r\n" + "select rownum as rn,productcode,pname,quantity\r\n"
                    + "from (select * from product)\r\n" + "where rownum<=?)\r\n" + "where rn>=? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, String.valueOf(max));
            ps.setString(2, String.valueOf(min));
            rs = ps.executeQuery();

            while (rs.next()) {
                int rn = rs.getInt("RN");
                int porductcode = rs.getInt("PRODUCTCODE");
                String name = rs.getString("PNAME");
                int quentity = rs.getInt("QUANTITY");
                System.out.printf("RN:%s\t产品编号：%s\t产品名称：%s\t产品数量：%s\t\n", rn, porductcode, name, quentity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Dome d = new Dome();
        d.menu();
    }

    public void menu() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Dome d = new Dome();
        while (true) {
            System.out.println("\n" +
                    "1.\t查看所有的数据\n" +
                    "2.\t添加产品\n" +
                    "3.\t根据产品编号来删除数据。\n" +
                    "4.\t删除多条数据.\n" +
                    "5.\t根据产品编号来修改产品名和数量.\n" +
                    "6.\t根据产品编号来修改产品名或数量\n"+
                    "7.\t分页显示数据\n" +
                    "8.\t根据产品名模糊查找\n" +
                    "9.\t根据编号精确查找," );

            int a = sc.nextInt();
            switch (a) {
                case 1:
                    d.setProduct();
                    break;
                case 2:
                    System.out.println("请输入产品编号");
                    int i = sc.nextInt();
                    System.out.println("请输入产品名");
                    String s = sc.next();
                    System.out.println("请输入产品数量：");
                    int quantity = sc.nextInt();
                    d.insertdate(i,s,quantity);
                    System.out.println("添加成功！");
                    break;
                case 3:
                    System.out.println("输入你要删除的编号：");
                    d.delete(sc.nextInt());
                    System.out.println("删除结果：");
                    d.setProduct();
                    break;
                case 4:
                    System.out.println("需要删除几条数据？");
                    int b = sc.nextInt();
                    int[] X = new int[b] ;
                    for ( i = 0; i < X.length; i++) {
                        X[i] = sc.nextInt();
                    }
                     d.delete(X);
                    break;
                case 5:
                    System.out.println("请输入需要修改的产品编号");
                    int num = sc.nextInt();
                    System.out.println("修改产品名称为：");
                    String pname = sc.next();
                    System.out.println("修改产品数量为：");
                     quantity = sc.nextInt();
                    d.change(num,pname,quantity);
                    break;
                case 6:
                    System.out.println("请输入需要修改的产品编号");
                    num = sc.nextInt();
                    System.out.println("请选择相应选项：\n" +
                            "1.\t修改产品名称：\n+" +
                            "2.修改产品数量\t");
                    int aa = sc.nextInt();
                    if (aa == 1){
                        System.out.println("修改产品名称为：");
                        d.change(num,sc.next());
                    }else if (aa == 2){
                        System.out.println("修改产品数量为：");
                        d.change(num,sc.nextInt());
                    }else {
                        System.out.println("输入错误！！");
                        break;
                    }
                    System.out.println("修改成功：");
                    d.setProduct();
                    break;
                case 7:
                    System.out.println("请输入分页的最小编号");
                    int a1 = sc.nextInt();
                    System.out.println("请输入分页的最大编号");
                    int a2 = sc.nextInt();
                    d.selectdate(a2, a1);
                    break;
                case 8:
                    System.out.println("请输入需要查找的产品名 输入格式 小%（小米） 或 %果（苹果）");
                    String name = sc.next();
                    d.find(name);
                    break;
                case 9:
                    System.out.println("请输入需要查找的产品编号: ");
                    int aaa = sc.nextInt();
                    find(aaa);
                    break;
                default:
                    System.out.println("输入错误! 请重新输入。");
                    break;

            }
        }
    }
}
