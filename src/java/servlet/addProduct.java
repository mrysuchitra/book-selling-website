/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DauSach;
import entity.NguoiDung;
import entity.QuyenSach;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DauSachService;
import services.QuyenSachService;
import services.UserService;

/**
 *
 * @author 1920
 */
public class addProduct extends HttpServlet {

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
            if(request.getSession().getAttribute("username")==null){
                response.sendRedirect("login?err=2");
                return;
            }
            String url=URLDecoder.decode(request.getQueryString(),"UTF-8");
            String id=url=url.substring(url.indexOf('=')+1,url.length());
            request.setAttribute("maDauSach", id);
            request.getRequestDispatcher("/addProduct.jsp").forward(request, response);
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
        //processRequest(request, response);
        String tinhTrang = request.getParameter("tinhTrang");
        Date date = new Date();
        if(request.getSession().getAttribute("username")==null){
            response.sendRedirect("login?err=2");
        }
        
        UserService userService=new UserService();
        NguoiDung nguoiBan = userService.findByUsername(request.getSession().getAttribute("username").toString());
        DauSachService dauSachService=new DauSachService();
        DauSach dauSach = dauSachService.getById(request.getParameter("maDauSach").toString());
         
        
        QuyenSach quyenSach = new QuyenSach();
        quyenSach.setConHang(true);
        quyenSach.setNgayDang(date);
        quyenSach.setTinhTrang(tinhTrang);
        quyenSach.setMaDauSach(dauSach);
        quyenSach.setNguoiBan(nguoiBan);
        
        (new QuyenSachService()).create(quyenSach);
        
        request.setAttribute("name",dauSach.getMaDauSach().toString()+"-"+nguoiBan.getUsername());
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("/addProductImage.jsp").forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
