package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap core CSS -->\r\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom styles for this template -->\r\n");
      out.write("        <link href=\"css/shop-homepage.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navigation.jsp", out, false);
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">\r\n");
      out.write("        <div class=\"card card-signin my-5\">\r\n");
      out.write("          <div class=\"card-body\">\r\n");
      out.write("            <h5 class=\"card-title text-center\">Sign In</h5>\r\n");
      out.write("            <form class=\"form-signin\" action=\"");
      out.print(request.getContextPath());
      out.write("/login\" method=\"POST\">\r\n");
      out.write("              <div class=\"form-label-group\">\r\n");
      out.write("                <label for=\"inputUsername\">Email address</label>\r\n");
      out.write("                <input id=\"inputUsername\" name=\"username\"class=\"form-control\" placeholder=\"Username\" required autofocus>\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("              <div class=\"form-label-group\">\r\n");
      out.write("                <label for=\"inputPassword\">Password</label>\r\n");
      out.write("                <input type=\"password\" id=\"inputPassword\" name=\"password\"class=\"form-control\" placeholder=\"Password\" required>\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("              <div class=\"custom-control custom-checkbox mb-3\">\r\n");
      out.write("                <input type=\"checkbox\" class=\"custom-control-input\" id=\"customCheck1\">\r\n");
      out.write("                <label class=\"custom-control-label\" for=\"customCheck1\">Remember password</label>\r\n");
      out.write("              </div>\r\n");
      out.write("                ");

                String err = request.getParameter("err");
                if ("1".equals(err)) {
                        out.print("<h5 style=\"color: red;\">wrong email or password</h5>");
                }
                
      out.write("\r\n");
      out.write("              <button class=\"btn btn-lg btn-primary btn-block text-uppercase\" type=\"submit\">Login</button>\r\n");
      out.write("            \r\n");
      out.write("            </form>\r\n");
      out.write("                           <hr class=\"my-4\">\r\n");
      out.write("              <h5 class=\"text-center\">haven't have account?</h5>\r\n");
      out.write("              <a href=\"");
      out.print(request.getContextPath());
      out.write("/register\"><button class=\"btn btn-lg btn-primary btn-block text-uppercase\" type=\"submit\">Register</button></a>\r\n");
      out.write("   \r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Bootstrap core JavaScript -->\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
