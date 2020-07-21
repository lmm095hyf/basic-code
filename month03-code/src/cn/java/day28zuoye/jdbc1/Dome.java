package cn.java.day28zuoye.jdbc1;
import cn.java.day22.NameRandom;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
/**
 * 作业：实现学生查询功能
 * 要求:
 * 1. 建立学生表( student ),字段设计至少包含:
 * ①	学号(主键)
 * ②	姓名
 * ③	性别
 * ④	专业名
 * ⑤	出生日期(年月日)
 * ⑥	入学时间(年月日时分秒)
 * ⑦	毕业状态
 * 2. 随机添加1000个学生记录
 * ①	学号: 从1开始编号
 * ②	姓名: 随机
 * ③	性别: 随机: 男,女
 * ④	专业: 随机
 * ⑤	出生日期: 随机, 要求年龄 18~25岁
 * ⑥	入学时间: 随机, 2012~2020的随机时间
 * ⑦	毕业状态: 2015之前入学的都是”已毕业”, 之后的是”未毕业”
 * 3. 返回的结果使用实体类封装
 * 4. 请完成以下方法:
 * ①	findStudent(Student stu) 实现组合条件查询
 * ②	findByBirthday( Date begin, Date end ) 实现根据学生生日字段, 用时间区间查询
 * ③	findByRegTime(int year) 查询指定年份入学的学生
 * ④	finish(int sn)	毕业,更新指定学生毕业状态, 但请判断学生必须学满3年, sn是学号
 */
public class Dome {

    public static void main(String[] args) {
        Dome d = new Dome();
        List<Map < String, Object>> Map1 = d.cha("select * from studentSys");
        for (Map<String, Object> map : Map1){
            System.out.println(map);
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

    public List<Map<String, Object>> cha(String sql, Object... objects) {
        Connection conn = get();
        try {
            System.out.println("sql: " + sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("参数：" + Arrays.toString(objects));
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1,objects[i]);
            }
            ResultSet rs = ps.executeQuery();
            //获取结果集元数据对象 元数据 ： 描述数据的数
            ResultSetMetaData rsmd = rs.getMetaData();
            List < Map<String, Object>> ret = new ArrayList<Map<String, Object> >();
            while (rs.next()){
                Map<String, Object> row = new LinkedHashMap<String, Object>();
                for (int i = 0; i < rsmd.getColumnCount();i++ ){
                    String columnName = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(columnName);
                    row.put(columnName, columnValue);
                }
                ret.add(row);
            }
            return  ret;
        }catch (SQLException se){
            throw  new RuntimeException("执行失败", se);
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

    public void  randomStu() {
        Random random = new Random();
        //insert into studentSys values('100003', '张二', '男', 18, '计算机专业',to_date('1996-06-06'，'yyyy-mm-dd'),
        // to_date('1996-06-06 17:20:30'，'yyyy-mm-dd hh24:mi:ss'),0 );

        Connection conn = get();
        try {
            String sql = "insert into studentSys values(?, ?, ?, ?, ?, ?, ?, ?  )";
            System.out.println("sql: " + sql);
            for (int i = 1; i <= 1000; i++) {

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, Integer.toString(i));
                ps.setString(2, NameRandom.randName());
                int sex = random.nextInt(2);
                String sex1 = " ";
                if (sex == 0) {
                    sex1 = "女";
                } else {
                    sex1 = "男";
                }
                Date date = randomDate1("1994-1-1", "2001-12-31");
                java.sql.Date date1= new java.sql.Date(date.getTime());

                Date date2 =  randomDate2("2012-1-1 00:00:00", "2020-12-31 24:59:59");
                java.sql.Date date3= new java.sql.Date(date2.getTime());
                        //(java.sql.Date) randomDate("2019-01-01","2019-01-31");
                ps.setString(3, sex1);//性别
                ps.setString(4, Integer.toString(random.nextInt(8)+18));//年龄
                ps.setString(5, "XXX学院");//专业
                ps.setDate(6, date1);
                ps.setDate(7, date3);
                ps.setString(8,Integer.toString(random.nextInt(2)));
                ps.executeQuery();
            }

        } catch (SQLException | ParseException se) {
            se.printStackTrace();
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




    public static Date randomDate1(String beginDate,String  endDate ) throws ParseException {

        //时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //定义开始时间
        Date start = format.parse(beginDate);
        //定义结束时间
        Date end = format.parse(endDate);
        if(start.getTime() >= end.getTime()){
            return null;
        }
        long date = random(start.getTime(),end.getTime());
        return new Date(date);
    }

    public static Date randomDate2(String beginDate,String  endDate ) throws ParseException {

        //时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //定义开始时间
        Date start = format.parse(beginDate);
        //定义结束时间
        Date end = format.parse(endDate);
        if(start.getTime() >= end.getTime()){
            return null;
        }
        long date = random(start.getTime(),end.getTime());
        return new Date(date);
    }
    private static long random(long begin,long end){

        long rtn = begin + (long)(Math.random() * (end - begin));
        //如果返回的是开始时间和结束时间，通过递归调用本函数查找随机值
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }
}
