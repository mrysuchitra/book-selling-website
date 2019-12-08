/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.DauSach;
import java.util.List;
import sessionBean.DauSachDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
}
