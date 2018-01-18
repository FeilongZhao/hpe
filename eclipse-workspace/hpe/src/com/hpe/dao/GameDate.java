package com.hpe.dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.hpe.impl.GameImpl;
import com.hpe.po.Game;
import com.hpe.po.Ranking;
import com.hpe.util.DBHelper;
import com.mysql.jdbc.PreparedStatement;

/*
 * 主要定义游戏记录添加、游戏排名查询（读取数据库游戏记录数据进行排行）等方法；
 */
public class GameDate implements GameImpl {

    //添加游戏数据
    @Override
    public boolean addGameDate(Game game) {

        final String SQL = "insert into ranking(userid,integral,time)values(?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setInt(1, game.getUserId());
            preparedStatement.setInt(2, game.getIntegral());
            preparedStatement.setString(3, sdf.format(game.getTime()));
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
        return false;
    }

    //排名查询
    @Override
    public List<Ranking> getGameRanking(int userId) {
        // TODO Auto-generated method stub
        final String SQL = "SELECT users.username,ranking.integral,ranking.time FROM ranking INNER JOIN users on users.userid = ranking.userid "
                + "WHERE users.userid = ? ORDER BY ranking.integral DESC";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ranking ranking = null;
        List<Ranking> list = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<Ranking>();
            while (resultSet.next()) {
                ranking = new Ranking();
                ranking.setUserName(resultSet.getString("username"));
                ranking.setIntegral(resultSet.getInt("integral"));
                ranking.setTime(resultSet.getDate("time"));

                list.add(ranking);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
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
