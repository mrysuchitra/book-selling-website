/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DauSachService;
import entity.DauSach;
import java.util.List;

/**
 *
 * @author tien.nh173399
 */
public class home extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
//        Object data = request.getQueryString();
//        request.setAttribute("data", data);
        DauSachService dauSachService=new DauSachService();
        List<DauSach> all= dauSachService.getAll();
        List<String> theLoai=dauSachService.getTheLoai();
        request.setAttribute("allBook", all);
        request.setAttribute("theLoai", theLoai);        
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }

}
