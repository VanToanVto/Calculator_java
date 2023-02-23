/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.Quiz;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public User login(String user, String pass){
        String query= "select * from [user] where [user_name]= ? and password=?";
        try {
             conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs= ps.executeQuery();
            while (rs.next()) {                
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public boolean  chechkExit(String user){
        String query= "select * from [user] where [user_name]= ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs= ps.executeQuery();
            while (rs.next()) {                
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public void register(String user, String pass, int role, String date, String email){
        String query="Insert into [user] values(?,?,?,?,?)";
        try {
             conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, role);
            ps.setString(4, date);
            ps.setString(5, email);
            ps.executeUpdate();
 
        } catch (Exception e) {
        }
    }
    
      public void makeQuiz(String question, String option1, String option2, String option3, String option4,String answer,String date,int userId) {
        String query = "insert into quiz \n"
                + "values(N'"+question+"',N'"+option1+"',N'"+option2+"',N'"+option3+"',N'"+option4+"','"+answer+"','"+date+"',"+userId+")";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
        }
      }
      
          public List<Quiz> managerQuiz(int userId){
         List<Quiz> list= new ArrayList<>();
         String query="select * from quiz where user_id = ?";
          try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new Quiz(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
          return list;
     }
       public List<Quiz> getListQuiz(int numOfQuiz) {
        String query = "Select top "+numOfQuiz+" * from quiz order by newid()";
        List<Quiz> list=new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getString(8), 
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
       }
      
   

   
}
