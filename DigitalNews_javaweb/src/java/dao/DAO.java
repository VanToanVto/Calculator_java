/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Digital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Digital getTop1Title() {
        try {
            String query = "select * from DigitalNews where timePost=(\n"
                    + "select max(timePost) from DigitalNews)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital digital = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                return digital;

            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * lay danh sach ten bai moi nhat ko co ten bai dang hien thi
     *
     * @param id
     * @return
     */
    public List<Digital> getTop5(int id) {
        try {
            String query = "select top 5 * from DigitalNews where id not in(select id=? from DigitalNews) \n"
                    + "order by timePost desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            List<Digital> list = new ArrayList<>();
            while (rs.next()) {
                Digital digital = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                list.add(digital);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * lay danh sach ten 5 bai moi nhat ko co ten bai moi nhat
     *
     * @return
     */
    public List<Digital> getLisTop5Articles() {
        try {
            String query = "select top 5 * from DigitalNews where timePost not in(select max(timePost) from DigitalNews) \n"
                    + "order by timePost desc;";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Digital> list = new ArrayList<>();
            while (rs.next()) {
                Digital digital = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                list.add(digital);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * lay du lieu bai duoc chon qua id
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Digital getOne(int id) throws Exception {
        try {
            String query = "select * from DigitalNews where id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                return d;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * tim kiem theo ten bai
     *
     * @param txt
     * @param pageIndex
     * @return
     * @throws Exception
     */
    public List<Digital> search(String txt, int pageIndex) throws Exception {
        try {
            List<Digital> list = new ArrayList<>();
            String query = "select * from\n"
                    + "(select ROW_NUMBER() over (order by id asc) as r, * \n"
                    + "from DigitalNews where title like ?) as x\n"
                    + "where r between ?*3-2  and ?*3";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageIndex);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"),
                        rs.getDate("timePost"),
                        rs.getString("shortdes"));
                list.add(d);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * dem so luong bai theo da search theo ten
     *
     * @param txt
     * @return
     * @throws Exception
     */
    public int count(String txt) throws Exception {
        try {
            String query = "select count(*) from DigitalNews \n"
                    + "where title like ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
        }
        return 0;
    }
    
    

//    public String hightLight(String title, String txt) {
//        String replaceText = "<span class=\"highLight\">" + txt + "</span>";
//        title = title.replaceAll(txt, replaceText);
//        return title;
//    }
//
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        Digital d = dao.getTop1();
//        System.out.println(d);
//        int count = dao.countResult("d");
//        System.out.println(count);
//
//    }
}
