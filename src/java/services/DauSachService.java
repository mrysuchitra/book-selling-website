/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.DauSach;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import sessionBean.DauSachDAO;
import utils.VNCharacterUtils;

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
            String sql = "Insert into DauSach (tenSach, namSuatBan, urlAnh, theLoai) " + "values  (N'"+dauSach.getTenSach()+"','"+dauSach.getNamSuatBan()+"','"+dauSach.getUrlAnh()+"',N'"+dauSach.getTheLoai()+"')";
            System.out.println(sql);
            sttm.execute(sql);
            return true;
        } catch (NamingException | SQLException ex) {
            System.out.print(ex);
        }
        return false;
    }
    
    public List<String> getTheLoai() {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/bookStore");
            Connection conn = ds.getConnection();
            Statement sttm = conn.createStatement();
            String sql = "select distinct theLoai from DauSach";
            ResultSet rs=sttm.executeQuery(sql);
            ArrayList<String> result = new ArrayList<String>();
            while(rs.next()){
                String theLoai=rs.getString("theLoai");
                //theLoai=VNCharacterUtils.removeAccent(theLoai);
                result.add(theLoai);
            }
            return result;
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return null;
    }
    
    public List<DauSach> getDauSachTheoTheLoai(String theLoai) {
        List<DauSach> allDauSach=this.database.findAll();
        List<DauSach> result=new ArrayList<DauSach>();
        for(DauSach dauSach: allDauSach){
            if (dauSach.getTheLoai().equals(theLoai)){
                result.add(dauSach);
            }
        }
        return result;
    }
    
    public DauSach getById(String id){
        DauSach found = this.database.find(Integer.parseInt(id));
        return found;
    }
    
    public List<DauSach> search(String query){
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/bookStore");
            Connection conn = ds.getConnection();
            Statement sttm = conn.createStatement();
            String sql = "SELECT * FROM DauSach WHERE dbo.non_unicode_convert(tenSach) LIKE  '%' +dbo.non_unicode_convert(N'"+query+"')+ '%'";
            //System.out.println(sql);
            ResultSet rs=sttm.executeQuery(sql);
            ArrayList<DauSach> result = new ArrayList<>();
            while(rs.next()){
                DauSach temp=new DauSach();
                temp.setMaDauSach(Integer.parseInt(rs.getString("maDauSach")));
                temp.setMoTa(rs.getString("moTa"));
                temp.setNamSuatBan(rs.getShort("namSuatBan"));
                temp.setTheLoai(rs.getString("theLoai"));
                temp.setTenSach(rs.getString("tenSach"));
                temp.setUrlAnh(rs.getString("urlAnh"));
                result.add(temp);
            }
            return result;
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return null;
    }
    
}
