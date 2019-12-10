/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DauSach;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DauSachService;
import java.net.URLDecoder; 

/**
 *
 * @author tien.nh173399
 */
public class category extends HttpServlet {

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

            String url=URLDecoder.decode(request.getQueryString(),"UTF-8");
            String theLoaiHienTai=url=url.substring(url.indexOf('=')+1,url.length());
            System.out.println(theLoaiHienTai);
            DauSachService dauSachService = new DauSachService();
            List<DauSach> all = dauSachService.getDauSachTheoTheLoai(theLoaiHienTai);
            List<String> theLoai = dauSachService.getTheLoai();
            request.setAttribute("theLoai", theLoai);
            request.setAttribute("allBook", all);
            request.setAttribute("theLoaiHienTai", theLoaiHienTai);   
            System.out.println(request.getAttribute("theLoaiHienTai"));         
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");
            request.getRequestDispatcher("/category.jsp").forward(request, response);
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
        processRequest(request, response);
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
