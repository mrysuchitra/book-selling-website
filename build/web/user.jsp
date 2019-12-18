<%-- 
    Document   : addBook
    Created on : Dec 5, 2019, 3:59:46 PM
    Author     : 1920
--%>


<%@page import="entity.Anh"%>
<%@page import="entity.NguoiDung"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.QuyenSach"%>
<%@page import="entity.QuyenSach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!--
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Them Dau Sach</title>
        <meta name="viewport" content="width=device-width/2, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Add Book</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">

    </head>
    <body>
        <jsp:include page="navigation.jsp"></jsp:include>
            <br>
            <div class="container mt-5">
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link ${param.tab.equals("available")?"active":""}" href="/book-selling-web/user?tab=available">Available Books</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${param.tab.equals("sold")?"active":""}" href="/book-selling-web/user?tab=sold">Sold</a>
                </li>
            </ul>




            <div class="container">
                
                
                
                <%
                    ArrayList<QuyenSach> allQuyenSach = (ArrayList<QuyenSach>) request.getAttribute(request.getParameter("tab").toString());
                    try {
                        for (QuyenSach quyenSach : allQuyenSach) {
                            Iterator iterator = quyenSach.getAnhCollection().iterator();
                            String urlAnh;
                            if (iterator.hasNext()) {
                                urlAnh = ((Anh) iterator.next()).getTenAnh();
                            } else {
                                urlAnh = "/image/sample.jpg";
                            }
                            out.print(
                                    "<div class=\"card\"><div class=\"row\"><img class=\"img-fluid z col-3\" width=\"100\" height=\"100\" src=\"/book-selling-web/image?"
                                    +urlAnh
                                    +"\"><div class=\"container col-sm-9\"><p class=\"row\">Condition: "
                                    +quyenSach.getTinhTrang()
                                    + "</p><p class=\"position-relative\" style=\"left: 0px; bottom: 0px\">"
                                    +quyenSach.getNgayDang()
                                    +"</p><div class=\"float-right\">"
                            );
                            if(request.getParameter("tab").toString().equals("available")){
                                out.print(
                                    "<form action=\"/book-selling-web/user\" method=\"post\"> <input  type=\"hidden\"  name=\"maQuyenSach\" value=\""
                                    +quyenSach.getMaQuyenSach().toString()
                                    + "\"><button type=\"submit\" class=\"btn btn-primary\" >sold</button></form>"
                                );
                            }
                            out.print("</div></div></div> <br></div>");
                        }
                    } catch (Exception ex) {
                    }
                %>

            </div>





        </div>

        <div class="fixed-bottom">
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <!-- Bootstrap core JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
