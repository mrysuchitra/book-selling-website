<%-- 
    Document   : home
    Created on : 23-Nov-2019, 22:23:09
    Author     : tien.nh173399
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>${theLoaiHienTai}</title>

  <!-- Bootstrap core CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">

</head>

<body>
  <!-- Navigation -->
  <jsp:include page="navigation.jsp"></jsp:include>

  <div class="container mt-5">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">${theLoaiHienTai}</h1>
        <div class="list-group">
        <c:forEach items="${theLoai}" var="cate">
            <a href="/book-selling-web/category?category=${cate}" class="list-group-item">${cate}</a>
        </c:forEach>
          
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

<!--        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>-->

        <div class="row">
            <c:forEach items="${allBook}" var="book">
                <a href="/book-selling-web/book?id=${book.getMaDauSach()}">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                      <a href="/book-selling-web/book?id=${book.getMaDauSach()}"><img class="card-img-top" src="/book-selling-web/image?${book.getUrlAnh()}" alt=""></a>
                      <div class="card-body">
                        <h4 class="card-title">
                          <a href="/book-selling-web/book?id=${book.getMaDauSach()}">${book.getTenSach()}</a>
                        </h4>
                        <p>${book.getTheLoai()}</p>
                        <p class="card-text">${book.getMoTa()}</p>
                      </div>
                      <div class="card-footer">
                        <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                      </div>
                    </div>
                  </div>
                </a>
            </c:forEach>

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <jsp:include page="footer.jsp"></jsp:include>
  
  <!-- Bootstrap core JavaScript -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

</body>

</html>

