/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskHandling;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLDecoder;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author 1920
 */
public class fileUploadHandler extends HttpServlet {
    private final String UPLOAD_DIRECTORY_BOOK = "D:\\App_Data\\NetBean\\book-selling-web\\web\\image";
    private final String UPLOAD_DIRECTORY_PRODUCT = UPLOAD_DIRECTORY_BOOK;

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
            out.println("<title>Servlet fileUploadHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fileUploadHandler at " + request.getContextPath() + "</h1>");
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
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name="";
                        Cookie[] cookies = request.getCookies();
                        
                        for (int i = 0; i < cookies.length; i++) {
                            String temp=cookies[i].getName().toString();
                            if (temp.equals("tenSach") || temp.equals("name") ){
                              name=cookies[i].getValue();
                              Cookie cookie=new Cookie(cookies[i].getName(),"");
                              cookie.setMaxAge(0);
                              response.addCookie(cookie);
                              break;
                          }
                        }
                        name=name+".jpg";
                        //Object name = request.getAttribute("fileName2");
                        //if(request.getAttribute("uploadObject").equals("DauSach")){
                            System.out.print(UPLOAD_DIRECTORY_BOOK + File.separator + name);
                            item.write( new File(UPLOAD_DIRECTORY_BOOK + File.separator + name));
                        //}
                        //else if(request.getAttribute("uploadObject").equals("QuyenSach")){
                        //    item.write( new File(UPLOAD_DIRECTORY_PRODUCT + File.separator + name));
                        //}
                    }
                }
            
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                System.out.println(ex);
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
     
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(request.getContextPath()+"/home");
        //dispatcher.forward(request, response);
        response.sendRedirect("/book-selling-web");
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
