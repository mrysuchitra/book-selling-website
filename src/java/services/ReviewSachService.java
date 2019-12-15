/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.ReviewSach;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import sessionBean.ReviewSachDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author tien.nh173399
 */
public class ReviewSachService {
    private ReviewSachDAO reviewDB;
    
    public ReviewSachService(){
        this.reviewDB= new ReviewSachDAO();
    }
    
    public List<ReviewSach> getReview(String id){
        List<ReviewSach> all = this.reviewDB.findAll();
        List<ReviewSach> result=new ArrayList<ReviewSach>();
        for (ReviewSach review: all){
            if (Integer.toString(review.getDauSach().getMaDauSach()).equals(id)){
                result.add(review);
            }
        }
        return result;
    }
    
     public boolean create(ReviewSach review) {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/bookStore");
            Connection conn = ds.getConnection();
            Statement sttm = conn.createStatement();
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String sql = "Insert into reviewSach " + "values  ("+Integer.toString(review.getReviewSachPK().getMaDauSach())+",'"+review.getReviewSachPK().getNguoiReview()+"',"+review.getSoSao()+",N'"+review.getReview()+"','"+review.getNgayReview()+"')";
            //System.out.println(sql);
            sttm.execute(sql);
            return true;
        } catch (Exception ex) {
            try {
                InitialContext initContext = new InitialContext();
                DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/bookStore");
                Connection conn = ds.getConnection();
                Statement sttm = conn.createStatement();
                String sql="update reviewSach set review=N'"+review.getReview()+"', soSao="+review.getSoSao()+", ngayReview='"+review.getNgayReview()+"' where maDauSach="+Integer.toString(review.getReviewSachPK().getMaDauSach())+" and nguoiReview='"+review.getReviewSachPK().getNguoiReview()+"'";
                //System.out.println(sql);
                sttm.executeUpdate(sql);
                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        return false;
    }
}
