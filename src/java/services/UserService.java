/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import sessionBean.NguoiDungDAO;
import entity.NguoiDung;
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
public class UserService {
    private NguoiDungDAO database;
    
    public UserService(){
        this.database=new NguoiDungDAO();
    }
    
    public NguoiDung findByUsername(String username){
        List<NguoiDung> all=this.database.findAll();
        int size=all.size();
        for (int i=0; i<size; i++){
            if (all.get(i).getUsername().equals(username)){
                return all.get(i);
            }
        }
        return null;
    }
    
    public int isValid(String username, String password){
        //return -1 if username is not found
        //return 0 if wrong pw
        //return 1 if valid
        NguoiDung nguoiDung=this.findByUsername(username);
        if (nguoiDung==null){
            return -1;
        }else{
            if (nguoiDung.getPwd().equals(password)){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    
//    public void create(NguoiDung nguoiDung){
//        try{
//           this.database.create(nguoiDung);
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//    }
    public boolean create(NguoiDung nguoiDung) {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/bookStore");
            Connection conn = ds.getConnection();
            Statement sttm = conn.createStatement();
            String sql = "Insert into NguoiDung " + "values  ('"+nguoiDung.getUsername()+"','"+nguoiDung.getTen()+"','"+nguoiDung.getPwd()+"',N'"+nguoiDung.getDiaChi()+"','"+nguoiDung.getSoDienThoai()+"')";
            sttm.execute(sql);
            return true;
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return false;
    }
}

