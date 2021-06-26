package org.example.dao;

import org.example.model.Image;
import org.example.model.User;
import org.example.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-06-24
 * Time: 9:36
 */
public class UserDao {

    public static User findUser(String name) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = Util.getConnection();
            String sql = "select * from user where name=?";
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            User user = null;
            while (rs.next()){
                user = new User();
//                user.setName(rs.getString(name));
//                image.setImageId(rs.getInt("image_id"));
//                image.setImageName(rs.getString("image_name"));
//                image.setContentType(rs.getString("content_type"));
//                image.setMd5(rs.getString("md5"));
//                image.setPath(rs.getString("path"));
            }
            return user;
        }catch (SQLException e){
            throw new RuntimeException("查询用户出错", e);
        }finally {
            Util.close(c, ps, rs);
        }
    }


    public static User findUser(String name,String password) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = Util.getConnection();
            String sql = "select * from user where name=? and password=?";
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            User user = null;
            while (rs.next()){
                user = new User();
            }
            return user;
        }catch (SQLException e){
            throw new RuntimeException("查询用户出错", e);
        }finally {
            Util.close(c, ps, rs);
        }
    }

    public static boolean  addUser(String name,String password) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = Util.getConnection();
            String sql = " insert into user (name,password)values (?,?);";
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);

            boolean isOk = ps.executeUpdate() > 0 ? true : false;

            return isOk;
        }catch (SQLException e){
            throw new RuntimeException("添加用户出错", e);
        }finally {
            Util.close(c, ps, rs);
        }
    }
}
