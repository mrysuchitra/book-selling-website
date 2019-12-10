/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.DauSach;
import entity.NguoiDung;
import entity.QuyenSach;
import java.util.List;
import sessionBean.DauSachDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import sessionBean.NguoiDungDAO;

/**
 *
 * @author tien.nh173399
 */
public class DauSachService {
    private DauSachDAO database;
    public DauSachService(){
        this.database=new DauSachDAO();
    }
    
    public List<DauSach> getAll(){
        return this.database.findAll();
    }
    
    public boolean create(DauSach dauSach) {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/bookStore");
            Connection conn = ds.getConnection();
            Statement sttm = conn.createStatement();
            String sql = "Insert into DauSach " + "values  (N'"+dauSach.getTenSach()+"','"+dauSach.getNamSuatBan()+"','"+dauSach.getUrlAnh()+"',N'"+dauSach.getTheLoai()+"')";
            sttm.execute(sql);
            return true;
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return false;
    }
    public ArrayList<QuyenSach> getQuyenSachByDauSach(int id, int quantity) {
        ArrayList<QuyenSach> listQuyenSach = new ArrayList<>();
        try {            
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/bookStore");
            Connection conn = ds.getConnection();
            String sql = "Select top " + quantity + " from QuyenSach where maDauSach = " + id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuyenSach quyenSach = new QuyenSach();
                quyenSach.setMaQuyenSach(rs.getInt("maQuyenSach"));
                quyenSach.setMaDauSach(new DauSachDAO().find(rs.getInt("maDauSach")));
                quyenSach.setNguoiBan(new NguoiDungDAO().find(rs.getString("nguoiBan")));
                quyenSach.setNgayDang(rs.getDate("ngayDang"));
                quyenSach.setTinhTrang(rs.getString("tinhTrang"));
                quyenSach.setConHang(rs.getBoolean("conHang"));

                listQuyenSach.add(quyenSach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listQuyenSach;
    }
}
