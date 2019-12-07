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
        <form  action="<%=request.getContextPath()%>/upload" method="POST" enctype="multipart/form-data">
            <div class="form-group">
              <label for="tenSach">Tên sách</label>
              <input type="text" class="form-control" id="tenSach" placeholder="Nhập tên sách" name="tenSach">
            </div>
            <div class="form-group">
              <label for="namXuatBan">Năm xuất bản</label>
              <input type="text" class="form-control" id="namXuatBan" placeholder="Năm xuất bản" name="namXuatBan">
            </div>
            <div class="form-group">
              <label for="theLoai">Thể loại</label>
              <input type="text" class="form-control" id="theLoai" placeholder="Thể loại" name="theLoai">
            </div>
            <div class="form-group">
              <label for="anhBia">Ảnh bìa</label>
              <input type="file" class="form-control" id="anhBia" name="anhBia">
            </div>
            <button type="submit" class="btn btn-primary">Xác nhận</button>
        </form>
 <!--       <form action="addBook" method="post">
			<table style="with: 50%">
				<tr>
					<td>Tên đầu sách</td>
					<td><input type="text" name="tenSach" /></td>
				</tr>
				<tr>
					<td>Năm xuất bản</td>
					<td><input type="date" name="namXuatBan" /></td>
				</tr>
				<tr>
					<td>Thể loại</td>
					<td><input type="text" name="theLoai" /></td>
				</tr>
				<tr>
					<td>Ảnh bìa</td>
					<td><input type="file" name="anhBia" /></td>
				</tr>

                        </table>
			<input type="Submit" value="Xác nhận" /></form> -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Bootstrap core JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
