<%-- 
    Document   : addBook
    Created on : Dec 5, 2019, 3:59:46 PM
    Author     : 1920
--%>

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
        <form  action="<%=request.getContextPath()%>/addBook" method="POST" class=" mt-5">
            <div class="container">
            <div class="form-group">
              <label for="tenSach">Book's name</label>
              <input type="text" class="form-control" id="tenSach" placeholder="Nhập tên sách" name="tenSach">
            </div>
            <div class="form-group">
              <label for="namXuatBan">Public year</label>
              <input type="text" class="form-control" id="namXuatBan" placeholder="Năm xuất bản" name="namXuatBan">
            </div>
                <div class="form-label-group">
              <label for="address">Category</label>
                <select class="mdb-select md-form" id="address" name="theLoai">
                  <option value="Fiction">Fiction</option>
                  <option value="Drama">Drama</option>
                  <option value="Adventure">Adventure</option>
                  <option value="Horror">Horror</option>
                  <option value="Short Story">Short Story</option>
                  <option value="Humor">Humor</option>
                  <option value="Mystery">Mystery</option>
                  <option value="Romance">Romance</option>
                  <option value="Textbook">Textbook</option>
                  <option value="Self-help Book">Self-help Book</option>
                  <option value="Poetry">Poetry</option>
                  <option value="Short Story">Short Story</option>
                </select>
              </div>
            <div class="form-group">
              <label for="description">Description</label>
              <input type="text" class="form-control" id="description" placeholder="In English please..." name="description">
            </div>
            <button type="submit" class="btn btn-primary">Xác nhận</button>
            </div>
        </form>
            <div class="fixed-bottom">
        <jsp:include page="footer.jsp"></jsp:include>
            </div>
        <!-- Bootstrap core JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
