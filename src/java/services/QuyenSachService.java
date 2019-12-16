/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import sessionBean.AnhDAO;
import sessionBean.QuyenSachDAO;
import entity.Anh;
import entity.QuyenSach;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author tien.nh173399
 */
public class QuyenSachService {
    private QuyenSachDAO quyenSachDB;
    private AnhDAO anhDB;
    
    public QuyenSachService(){
        this.quyenSachDB=new QuyenSachDAO();
        this.anhDB = new AnhDAO();
    }
    
    public List<QuyenSach> getQuyenSach(String maDauSach){
        List<QuyenSach> result=new ArrayList<QuyenSach>();
        List<QuyenSach> allQuyenSach = quyenSachDB.findAll();
        for (QuyenSach quyenSach: allQuyenSach){
            if (Integer.toString(quyenSach.getMaDauSach().getMaDauSach()).equals(maDauSach)){
                result.add(quyenSach);
            }
        }
        return result;
    }
    
    public String getUrlAnh (String id){
        List<Anh> allAnh= anhDB.findAll();
        for (Anh anh: allAnh){
            if (anh.getMaQuyenSach().equals(id)){
                return "/image/"+anh.getTenAnh();
            }
        }
        return null;
    }
    
     public boolean create(QuyenSach quyenSach){
         try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/bookStore");
            Connection conn = ds.getConnection();
            Statement sttm = conn.createStatement();
           
            String date = quyenSach.getNgayDang();

            //String sql = "Insert into QuyenSach " + "values  ('"+quyenSach.getMaDauSach().getMaDauSach()+"','"+quyenSach.getNguoiBan().getUsername()+"','"+quyenSach.getNgayDang()+"',N'"+quyenSach.getTinhTrang()+"','"+quyenSach.getConHang()+"')";
            String sql = "Insert into QuyenSach (madauSach, nguoiBan, ngaydang, tinhtrang, conhang)" + "values  ("+quyenSach.getMaDauSach().getMaDauSach().toString()+",'"+quyenSach.getNguoiBan().getUsername()+"','"+date+"',N'"+quyenSach.getTinhTrang()+"','"+quyenSach.getConHang()+"')";
            System.out.println(sql);
            sttm.execute(sql);
            sql="select * from QuyenSach where NgayDang='"+date +"'";
            ResultSet rs=sttm.executeQuery(sql);
            while(rs.next()){
                sql = "insert into anh values ('/image/"+quyenSach.getMaDauSach().getMaDauSach().toString()+"-"+quyenSach.getNguoiBan().getUsername()+".jpg',"+Integer.toString(rs.getInt("maQuyenSach"))+")";
                System.out.println(sql);
                sttm.execute(sql);
                break;
            }
            
                
            
            return true;
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return false;
     }
}
