package com.hpe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.hpe.impl.UserImpl;
import com.hpe.po.LoginUser;
import com.hpe.po.Users;
import com.hpe.util.DBHelper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/*
 * 主要定义用户登录、用户注册、验证用户是否存在、用户信息维护（更新用户信息）、更改用户密码等方法
 */
public class UserDate implements UserImpl {
    
    public static int userId = 0;
    public static String USERNAME = null;

    // 登录
    @Override
    public boolean userLogin(String userName, String password) {
        // TODO Auto-generated method stub

        final String SQL = "select username,userpassword,userid from users where username = ? and userpassword = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        LoginUser user = new LoginUser();
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("userpassword"));
                USERNAME = user.getUserName();
                userId = rs.getInt("userid");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {
                rs.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (user.getUserName() == null) {

            return false;
        }
        return true;
    }

    // 注册
    @Override
    public boolean userRegister(Users user) {
        
        if (!checkUser(user.getUserName())) {

            final String SQL = "insert into users (username,userpassword,realname,tel,address,login_time)values(?,?,?,?,?,?)";
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                connection = DBHelper.getConnection();
                preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getUserPassword());
                preparedStatement.setString(3, user.getRealName());
                preparedStatement.setString(4, user.getTel());
                preparedStatement.setString(5, user.getAddress());
                preparedStatement.setString(6, sdf.format(user.getLogin_time()));
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            } finally {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return true;
        }
        
        System.err.println("注册用户名已经存在！请重新注册");
        return false;
    }

    // 验证用户存在
    @Override
    public boolean checkUser(String userName) {

        final String SQL = "select * from users where username = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String user = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = rs.getString("username");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {
                rs.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (user == null) {

            return false;
        }
      
        return true;
    }

    // 维护用户数据
    @Override
    public Boolean maintenanceUserDate(Users user) {

        final String SQL = "update users set realname = ?,tel = ?,address = ?,username = ? where userid = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getRealName());
            preparedStatement.setString(2, user.getTel());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getUserName());
            preparedStatement.setInt(5, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.err.println("信息更新成功！");
        return true;
    }

    // 修改密码
    @Override
    public boolean revisePassword(String newPassword, String oldPassword) {

        final String SQL = "update users set userpassword = ? where userpassword = ? and userid = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, oldPassword);
            preparedStatement.setInt(3, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return true;
    }

    //保存登录时间
    private Boolean saveLoginTime(String userName) {

        final String SQL = "update users set login_time = ? where username = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setString(1, dateFormat.format(date));
            preparedStatement.setString(2, userName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }

        return true;
    }
    //查询登陆时间
    
    public String loginTime(String userName) {
        
        final String SQL = "select login_time from users where username = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String time = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                time = rs.getString("login_time");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (!saveLoginTime(userName)) {
            System.err.println("登录时间记录出错！");
        }
        return time;   
    }

}
