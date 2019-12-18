/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Anh;
import entity.DauSach;
import entity.QuyenSach;
import entity.ReviewSach;
import entity.ReviewSachPK;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.DauSachService;
import services.QuyenSachService;
import services.ReviewSachService;

/**
 *
 * @author tien.nh173399
 */
public class book extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DauSachService dauSachService = new DauSachService();
            QuyenSachService quyenSachService = new QuyenSachService();
            ReviewSachService reviewSachService = new ReviewSachService();

            String url = URLDecoder.decode(request.getQueryString(), "UTF-8");
            String id = url = url.substring(url.indexOf('=') + 1, url.length());
            List<String> theLoai = dauSachService.getTheLoai();
            request.setAttribute("theLoai", theLoai);

            DauSach dauSach = dauSachService.getById(id);
            request.setAttribute("book", dauSach);

            List<QuyenSach> allQuyenSach = quyenSachService.getQuyenSach(Integer.toString(dauSach.getMaDauSach()));
            List<QuyenSach> temp= new ArrayList<>();
            for (QuyenSach q: allQuyenSach){
                if(q.getConHang()){
                    temp.add(q);
                }
            }         
            request.setAttribute("quyenSach", temp);

            List<ReviewSach> allReview = reviewSachService.getReview(Integer.toString(dauSach.getMaDauSach()));
            request.setAttribute("allReview", allReview);
            

            request.getRequestDispatcher("/book.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login?err=2");
        } else {

            String inputReview = request.getParameter("inputReview");
            String maDauSach = request.getParameter("bookId");
            //System.out.println(inputReview);
            ReviewSachService reviewSachService = new ReviewSachService();
            ReviewSachPK reviewPk = new ReviewSachPK(Integer.parseInt(maDauSach), session.getAttribute("username").toString());
            Date date=new Date();
            ReviewSach review = new ReviewSach(reviewPk, 5, inputReview, date);
            reviewSachService.create(review);
            response.sendRedirect("book?id="+maDauSach);       
        }
    }
}
