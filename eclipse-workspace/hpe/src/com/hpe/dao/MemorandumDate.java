package com.hpe.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hpe.impl.MemorandumImpl;
import com.hpe.po.Memorandum;
import com.hpe.util.DBHelper;
import com.mysql.jdbc.EscapeTokenizer;
import com.mysql.jdbc.PreparedStatement;

/*
 * 主要定义个人备忘录的增删改查（根据用户id查询、根据备忘录ID查询）方法
 */
public class MemorandumDate implements MemorandumImpl {

    // 添加备忘录
    @Override
    public Boolean addMemorandum(Memorandum memorandum) {
        // TODO Auto-generated method stub

        final String SQL = "insert into memorandum(memorandum_title,time,content,userid)values(?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setString(1, memorandum.getMemorandum_title());
            preparedStatement.setString(2, sdf.format(memorandum.getTime()));
            preparedStatement.setString(3, memorandum.getContent());
            preparedStatement.setInt(4, memorandum.getUserId());
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

    // 删除
    @Override
    public boolean deleteMemorandum(int userId, int memorandum_id) {

        final String SQL = "delete from memorandum where userid = ? and memorandum_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, memorandum_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
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
        }
        return true;
    }

    // 更新
    @Override
    public boolean updateMemorandum(int userId, int memorandum_id, Map<String, String> content) {
        final String SQL = "update memorandum set memorandum_title = ? ,content = ? where userid = ? and memorandum_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setString(1, content.get("标题"));
            preparedStatement.setString(2, content.get("内容"));
            preparedStatement.setInt(3, userId);
            preparedStatement.setInt(4, memorandum_id);
            preparedStatement.execute();
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
        return false;
    }

    // 查看所有
    @Override
    public List<Memorandum> getMemorandum(int userId) {
        // TODO Auto-generated method stub

        final String SQL = "select * from memorandum where userid = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Memorandum memorandum = null;
        List<Memorandum> list = null;

        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            list = new ArrayList<Memorandum>();
            while (rs.next()) {
                memorandum = new Memorandum();
                memorandum.setMemorandum_id(rs.getInt("memorandum_id"));
                memorandum.setMemorandum_title(rs.getString("memorandum_title"));
                memorandum.setContent(rs.getString("content"));
                memorandum.setTime(rs.getDate("time"));
                memorandum.setUserId(rs.getInt("userid"));
                list.add(memorandum);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return list;
    }

}
