<%-- 
    Document   : addProductImage
    Created on : Dec 11, 2019, 9:47:15 AM
    Author     : 1920
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add product image</title>
        
        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="navigation.jsp"></jsp:include>
            <%
                 
                  response.addCookie(new Cookie("name",request.getAttribute("name").toString()));
              %>
              <br>
              <form  class = " mt-5" action="<%=request.getContextPath()%>/upload" method="POST" enctype="multipart/form-data" >
            <div class="container">
            <div class="form-group">
              <label for="anhBia">Ảnh</label>
              <input type="file" class="form-control" id="anh" name="anh">
            </div>
            <button type="submit" class="btn btn-primary">Xác nhận</button>
            </div>
        </form>
        <div class="fixed-bottom">
        <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <%-- <% request.setAttribute("uploadObject", "QuyenSach"); %> --%>
        <!-- Bootstrap core JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
