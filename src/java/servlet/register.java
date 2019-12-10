package servlet;

import entity.NguoiDung;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserService;
import sessionBean.NguoiDungDAO;

public class register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ten = request.getParameter("name");
        String diaChi = request.getParameter("address");
        String soDienThoai = request.getParameter("phoneNum");

        UserService userService = new UserService();
        NguoiDung nguoiDung = userService.findByUsername(username);

        if (nguoiDung != null) {
            response.sendRedirect("register?err=1");
        } else {
            nguoiDung = new NguoiDung(username, ten, password, diaChi, soDienThoai);
            userService.create(nguoiDung);
            System.out.println(nguoiDung.toString());
//                    NguoiDungDAO nguoiDungDAO=new NguoiDungDAO();
//                    nguoiDungDAO.create(nguoiDung);
            HttpSession session = request.getSession();
            //save message in session
            session.setAttribute("username", username);
            session.setAttribute("name", ten);
            response.sendRedirect("");
        }

    }
}
