<%-- 
    Document   : addProduct
    Created on : Dec 11, 2019, 9:08:24 AM
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

        <title>Add Product</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">

    </head>
    <body>
        <jsp:include page="navigation.jsp"></jsp:include>
        <form  action="<%=request.getContextPath()%>/addProduct" method="POST" >
            <div class="container">
                <div class="form-label-group">
                    <label for="address">Tình trạng sản phẩm</label>
                    <select class="mdb-select md-form" id="tinhTrang" name="tinhTrang">
                        <option value="Mới">Mới</option>
                        <option value="Như mới">Như mới</option>
                        <option value="Tốt">Tốt</option>
                        <option value="Khá">Khá</option>
                        <option value="Cũ">Cũ</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Xác nhận</button>
            </div>
        </form>
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Bootstrap core JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
