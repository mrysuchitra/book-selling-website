package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserService;
import entity.NguoiDung;

public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()){
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
                
                UserService userService=new UserService();
                NguoiDung nguoiDung= userService.findByUsername(username);
		
                if (nguoiDung==null || !nguoiDung.getPwd().equals(password)) {
                    response.sendRedirect("login?err=1");
			
		} else {
                    HttpSession session = request.getSession();
                    //save message in session
                    session.setAttribute("username", username);
                    session.setAttribute("name", nguoiDung.getTen());
                    response.sendRedirect("");
			
		}
	}
}
