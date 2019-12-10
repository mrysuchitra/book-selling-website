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
import java.util.List;
import java.util.ArrayList;
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
    
    
}
