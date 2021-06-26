package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

    private static final ObjectMapper M = new ObjectMapper();

//    private static final MysqlDataSource DS = new MysqlDataSource();
//
//    static {
//        DS.setURL("jdbc:mysql://localhost:3306/image_system");
//        DS.setUser("root");
//        DS.setPassword("zhwsjj");
//        DS.setUseSSL(false);
//        DS.setCharacterEncoding("UTF-8");
//
//
//
//    }


    //单例模式创建数据库连接池,防止多线程时创建多个连接池
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://localhost:3306/image_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";
    public static DataSource getDataSource() {
        if (dataSource == null) {
            // 此处的 synchronized 其实就是给当前这一小块加锁.
            // synchronized 要么修饰一个方法, 要么得传个对象. 此处修饰整个方法显然不合适(粒度太大)
            synchronized (Util.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setUrl(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                    ((MysqlDataSource)dataSource).setUseSSL(false);
                    ((MysqlDataSource)dataSource).setCharacterEncoding("UTF-8");
                }
            }
        }
        return dataSource;
    }

    /**
     * 把java对象序列化为json字符串（Servlet响应输出的body需要json字符串）
     */
    public static String serialize(Object o){
        try {
            return M.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("序列化java对象失败："+o, e);
        }
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接获取失败", e);
        }
    }

    public static void close(Connection c, Statement s, ResultSet rs){
        try {
            if(rs != null) rs.close();
            if(s != null) s.close();
            if(c != null) c.close();
        } catch (SQLException e) {
            throw new RuntimeException("释放数据库资源失败", e);
        }
    }

    public static void close(Connection c, Statement s){

        close(c, s, null);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
