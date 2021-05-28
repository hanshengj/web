package xpu.tool.db;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-04-03
 * Time: 13:39
 */
public class DBUtil {
    private static MysqlDataSource dataSource= null;


    public static Connection getConnection() throws SQLException {
        if(dataSource==null){
            dataSource=new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("zhwsjj");
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/mydb?charactionEncoding=utf-8&useSSL=true");
        }
        return (Connection) dataSource.getConnection();
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if(resultSet!=null) resultSet.close();
        if(preparedStatement!=null) preparedStatement.close();
        if(connection!=null) connection.close();
    }

}

