package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()){
        Object data = "Some data, can be a String or a Javabean";
        request.setAttribute("data", data);
        request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
                //service check username and password
		if (username.equals("tien") && password.equals("1234")) {
			HttpSession session = request.getSession(false);
                        //save message in session
                        session.setAttribute("username", username);
                        session.setAttribute("name", name);
                        response.sendRedirect("");
		} else {
			response.sendRedirect("register?err=1");
		}
                
	}
}
