/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.QuyenSach;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DauSachService;

/**
 *
 * @author 1920
 */
public class product extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet product</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet product at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        //int id = Integer.parseInt(request.getParameter("id"));
//        int page = 1;
//        int recordsPerPage = 5;
//        if(request.getParameter("page")) != null)
//            page = Integer.parseInt(request.getParameter("page"));
//        DauSachService dao = new DauSachService();
//        List<QuyenSach> list = dao.getQuyenSachByDauSach((page-1)*recordsPerPage, recordsPerPage);
//        int noOfRecords = dao.getSoLuongSachByDauSach();
//        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
//        request.setAttribute("quyenSachList", list);
//        request.setAttribute("noOfPages", noOfPages);
//        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/product.jsp");
        view.forward(request, response);
        
        
//        ArrayList<QuyenSach> list = new DauSachService().getQuyenSachByDauSach(0, 5);
//        request.setAttribute("quyenSach", list);
//        
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("utf-8");
//        request.getRequestDispatcher("/product.jsp").forward(request, response);
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
