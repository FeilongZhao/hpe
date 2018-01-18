package com.hpe.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hpe.impl.AccountImpl;
import com.hpe.po.Account;
import com.hpe.util.DBHelper;

/*
 * 主要定义余额查询、存钱、转账、账户验证、当月的收入、当月的支出方法；
 */
public class AccountDate implements AccountImpl {

    // 查询余额
    @Override
    public Account getAccountMoney(int userId) {

        Account account = new Account();
        final String SQL = "select users.userid,account.accountid,account.account_money "
                + "from account INNER JOIN users on users.userid = account.userid WHERE users.userid = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                account.setUserid(rs.getString("userid"));
                account.setAccountId(rs.getInt("accountid"));
                account.setAccountMoney(rs.getBigDecimal("account_money"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return account;
    }

    // 存钱
    @Override
    public Boolean saveMoney(int userId,BigDecimal money) {

        final String SQL = "UPDATE account SET account_money = account_money + ? WHERE userid = ?";
        // final String SQL1 = "insert into
        // account_log(accountid,transfer_account,type,log_time,money)values(?,?,?,?,?)
        // ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setBigDecimal(1, money);
            preparedStatement.setInt(2, userId);
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
        
        saveAccountLog(getAccountId(userId), getAccountId(userId), "转入", money);

        return true;

    }

    // 转账
    @Override
    public Boolean ransferAccounts(int accountId, int myId, BigDecimal money) {
        final String SQL1 = "UPDATE account SET account_money = account_money + ? WHERE accountid = ?";
        final String SQL2 = "UPDATE account SET account_money = account_money - ? WHERE accountid = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        if (checkAccount(accountId)) {
            if (getAccountMoney(myId).getAccountMoney().compareTo(money) >= 0) {
                try {
                    // 加
                    connection = DBHelper.getConnection();
                    preparedStatement = (PreparedStatement) connection.prepareStatement(SQL1);
                    preparedStatement.setBigDecimal(1, money);
                    preparedStatement.setInt(2, accountId);
                    preparedStatement.executeUpdate();
                    saveAccountLog(accountId, getAccountId(myId), "转入", money);

                    // 减
                    preparedStatement = (PreparedStatement) connection.prepareStatement(SQL2);
                    preparedStatement.setBigDecimal(1, money);
                    preparedStatement.setInt(2, getAccountId(myId));
                    preparedStatement.executeUpdate();
                    saveAccountLog(getAccountId(myId), accountId, "转出", money);

                } catch (SQLException e) {
                    System.out.println("输入不合法!");
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
            } else {
                System.out.println("余额不足");
            }
        } else {
            System.out.println("账户不存在");
        }

        return false;

    }

    // 验证账户
    @Override
    public boolean checkAccount(int accountId) {

        final String SQL = "SELECT users.username FROM users "
                + "INNER JOIN account on users.userid = account.accountid WHERE accountid = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String userName = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setInt(1, accountId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                userName = rs.getString("username");
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
        if (userName == null) {
            return false;
        }

        return true;
    }

    // 当月收入
    @Override
    public BigDecimal income(int myId) {

        final String SQL = "SELECT SUM(money) AS sum FROM account_log WHERE type ='转入'AND accountid = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        BigDecimal money = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setInt(1, getAccountId(myId));
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
                money = rs.getBigDecimal("sum");
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
        
        return money;
    }

    // 当月支出
    @Override
    public BigDecimal pay(int myId) {
        final String SQL = "SELECT SUM(money) AS sum FROM account_log WHERE type ='转出'AND accountid = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        BigDecimal money = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setInt(1, getAccountId(myId));
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
                money = rs.getBigDecimal("sum");
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
        
        return money;
    }

    // 根据用户id查询账户id
    private int getAccountId(int userId) {

        int accountId = 0;

        final String SQL = "SELECT account.accountid FROM account "
                + "INNER JOIN users on users.userid = account.userid WHERE users.userid = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                accountId = rs.getInt("accountid");
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

        return accountId;
    }

    //添加日志
    public Boolean saveAccountLog(int accountId, int transfer_account, String type, BigDecimal money) {

        final String SQL1 = "insert into account_log(accountid,transfer_account,type,log_time,money)values(?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            connection = DBHelper.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL1);
            preparedStatement.setInt(1, accountId);
            preparedStatement.setInt(2, transfer_account);
            preparedStatement.setString(3, type);
            preparedStatement.setString(4, sdf.format(date));
            preparedStatement.setBigDecimal(5, money);
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
}
