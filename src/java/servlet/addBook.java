/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DauSach;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import services.DauSachService;
import sessionBean.DauSachDAO;
import taskHandling.fileUploadHandler;

/**
 *
 * @author 1920
 */
public class addBook extends HttpServlet {

    
    private final String UPLOAD_DIRECTORY = "E:\\BTL_CNPM_image";/**
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
            out.println("<title>Servlet addBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addBook at " + request.getContextPath() + "</h1>");
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
        HttpServletRequest requestTmp = request;
//        if(ServletFileUpload.isMultipartContent(request)){
//            try {
//                List<FileItem> multiparts = new ServletFileUpload(
//                                         new DiskFileItemFactory()).parseRequest(request);
//               
//                for(FileItem item : multiparts){
//                    if(!item.isFormField()){
//                        String name = new File(item.getName()).getName();
//                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
//                    }
//                }
//            
//               //File uploaded successfully
//               request.setAttribute("message", "File Uploaded Successfully");
//            } catch (Exception ex) {
//               request.setAttribute("message", "File Upload Failed due to " + ex);
//            }          
//          
//        }else{
//            request.setAttribute("message",
//                                 "Sorry this Servlet only handles file upload request");
//        }
        
        String tenSach = requestTmp.getParameter("tenSach");
        System.out.println("Đây là" +tenSach);
        String ok = request.getParameter("namXuatBan");
        if (ok == null) {System.out.println("Looxi null");}
        short namXuatBan = Short.parseShort((String)request.getParameter("namXuatBan"));
        String theLoai = request.getParameter("theLoai");
        String anhBia = request.getParameter("anhBia");
        
        DauSach dauSach = new DauSach();
        dauSach.setTenSach(tenSach);
        dauSach.setNamSuatBan(namXuatBan);
        dauSach.setTheLoai(theLoai);
        dauSach.setUrlAnh(anhBia);
        
        new DauSachService().create(dauSach);
        System.out.println("i was called");
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
