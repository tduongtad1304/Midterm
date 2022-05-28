package com.example.midterm.dao;

import com.example.midterm.dbcontext.DBUtil;
import com.example.midterm.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ly Quynh Tran
 */
public class UserDao {

    public boolean login(User user) {
        DBUtil db = DBUtil.getInstance();
        String sql = "Select * from user_table where userName=? "
                + "and password=?";

        System.out.println("1");

        Connection con = null;

        System.out.println("2");
        try {
            con = db.getConnection();

            System.out.println("3");

            // Student insert CODE here
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.getUserName().trim());
            statement.setString(2, user.getPassword().trim());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                System.out.println("Success");
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DBUtil.closeConnection(con);
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean registerUser(User user) {
        DBUtil db = DBUtil.getInstance();
        String sql = "INSERT INTO user_table (firstName, lastName, email, userName, password) \n"
                + "VALUES (?, ?, ?, ?, ?)";// Student insert CODE here

        Connection con = null;
        try {
            con = db.getConnection();

            // Student insert CODE here
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.getFirstName().trim());
            statement.setString(2, user.getLastName().trim());
            statement.setString(3, user.getEmail().trim());
            statement.setString(4, user.getUserName().trim());
            statement.setString(5, user.getPassword().trim());
            int rs = statement.executeUpdate();
            if (rs==1) {
                // Student insert CODE here
                System.out.println("Success");
                return true;
            }

        } catch (Exception ex) {
            System.out.print(ex);
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DBUtil.closeConnection(con);
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}

