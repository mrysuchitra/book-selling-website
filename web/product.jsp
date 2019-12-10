<%-- 
    Document   : product
    Created on : Dec 8, 2019, 9:58:44 AM
    Author     : 1920
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import = "entity.QuyenSach"%>
        <div class="row">
            <c:forEach items="${quyenSach}" var="book">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                      <!--<a href="#"><img class="card-img-top" src="/book-selling-web/image?" alt=""></a>-->
                      <div class="card-body">
                        <h4 class="card-title">
                          <a href="#">${book.getTinhTrang()}</a>
                        </h4>
                        <!--<p></p>-->
                        <p class="card-text">Description..... tiến</p>
                      </div>
                    </div>
                  </div>
            </c:forEach>
                
    </body>
</html>
