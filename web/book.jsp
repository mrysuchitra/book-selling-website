<%@page import="entity.NguoiDung"%>
<%@page import="entity.Anh"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="entity.QuyenSach"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop Item - Start Bootstrap Template</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            .z {}

            .z:hover {transform: scale(3);
                      position: fixed;
                      left: 200px;
                      top: 150px;
                      display: inline-block}
            </style>
        </head>

        <body>


            <!-- Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>
                <br>
                <!-- Page Content -->
                <div class="container mt-5">
                
                <div class="row mh-25">

                    <div class="col-sm-3">
                        <h1 class="my-4">Shop Name</h1>
                        <div class="list-group">
                        <c:forEach items="${theLoai}" var="cate">
                            <a href="/book-selling-web/category?category=${cate}" class="list-group-item">${cate}</a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-sm-9" >
                    <div class="row" >
                        <div class="col-sm-4 card">
                            <img class="card-img-top img-fluid" src="/book-selling-web/image?${book.getUrlAnh()}" alt="">
                            <div class="card-body">
                                <h3 class="card-title">${book.getTenSach()}</h3>
                                <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
                                3.5 stars
                            </div>
                                <form action="/book-selling-web/addProduct" method="get">
                                    <input type="hidden" name="maDauSach" value="${book.getMaDauSach()}">  
                                    <button class="btn btn-success form-control" type="submit">Sell one?</button>
                                </form>
                        </div>
                        <div class="col-sm-8">
                            <div class=" card card-outline-secondary" style="overflow-y: scroll; height: 500px">
                                <h5>Description</h5>
                                <p class="card-text">&nbsp &nbsp &nbsp &nbsp &nbsp ${book.getMoTa()}</p>
                                <div class="card-header">
                                    Product Reviews
                                </div>
                                <div class="card-body"  data-spy="scroll">
                                    <c:forEach items="${allReview}" var="review">
                                        <p>${review.getReview()}</p>
                                        <small class="text-muted">Posted by ${review.getNguoiDung().getTen()} on ${review.getNgayReview()}</small>
                                        <hr>            
                                    </c:forEach>
                                    
                                </div>
                            </div>
                            <div style="height:50px">
                                <form action=${requestScope['javax.servlet.forward.request_uri']} method="POST">
                                    <input class="form-control" type="text" id="inputReview" name="inputReview" placeholder="review...">
                                    <input type="hidden" name="bookId" value="${book.getMaDauSach()}" />
                                    <button type="submit" class="btn btn-success float-right">Leave a Review</button>
                                </form>
                            </div>
                        </div>    
                    </div>
                    <!--                        <div class="row card">
                    <c:forEach items="${allQuyenSach.getAnhCollection()}" var="anh">
                        <img class="card-img-side img-fluid" src="/book-selling-web/image?${anh.getTenAnh()}" alt="">

                        <small class="text-muted">Posted by ${review.getNguoiDung().getTen()} on ${review.getNgayReview()}</small>
                        <hr>            
                    </c:forEach>
                </div>-->
                </div>
            </div>

        </div>
        <br>
        <div class="container">
            <h3>Buy one</h3>
            <div class="" >
                <%
                    ArrayList<QuyenSach> allQuyenSach = (ArrayList<QuyenSach>) request.getAttribute("quyenSach");
                    try {
                        for (QuyenSach quyenSach : allQuyenSach) {
                            Iterator iterator = quyenSach.getAnhCollection().iterator();
                            String urlAnh;
                            String moTa = quyenSach.getTinhTrang();
                            String ngay = quyenSach.getNgayDang();
                            NguoiDung nguoiDang = quyenSach.getNguoiBan();
                            if (iterator.hasNext()) {
                                urlAnh = ((Anh) iterator.next()).getTenAnh();
                            } else {
                                urlAnh = "/image/sample.jpg";
                            }
                            String nguoiBan = quyenSach.getNguoiBan().getTen();
//                        out.print("<div class=\"card\"><div class=\"row\">");
//                        out.print("<img class=\"img-fluid z col-3\" width=\"100\" height=\"100\" style=\"hover: { transform: scale(1.5);}\" src=\"/book-selling-web/image?"+urlAnh+" \">");
//                        out.print(" <h class=\"col-sm-8\">"+ nguoiBan+"</h4>\n</div></div><br>");
//                        

                            out.print("<div class=\"card\"><div class=\"row\">"
                                    + "<img class=\"img-fluid z col-3\" width=\"100\" height=\"100\" style=\"hover: { transform: scale(1.2);}\" src=\"/book-selling-web/image?" + urlAnh + " \"> "
                                    + "<div class=\"container col-sm-9\">"
                                    + "<a href=\"/book-selling-web/user?tab=available\"><h5 class=\"row\">Seller:" + nguoiBan + "</h5></a>"
                                    + "<p class=\"row\">Condition: " + moTa + "</p>"
                                    + "<p class=\"position-relative\" style=\"left: 0px; bottom: 0px\">" + ngay + "</p>"
                                    + "<div class=\"float-right\"><button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#" + Integer.toString(quyenSach.getMaQuyenSach()) + "\">Get contact</button>"
                                    + "<div class=\"modal\" id=\"" + Integer.toString(quyenSach.getMaQuyenSach()) + "\"> <div class=\"modal-dialog\"><div class=\"modal-content\">"
                                    + "<div class=\"modal-header\"><h4 class=\"modal-title\">Seller info</h4><button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>"
                                    + "</div><div class=\"modal-body\">"
                                    + "<p> name: " + nguoiDang.getTen() + "</p>"
                                    + "<p> phone: " + nguoiDang.getSoDienThoai() + "</p>"
                                    + "<p> address: " + nguoiDang.getDiaChi() + "</p></div>"
                                    + "<div class=\"modal-footer\"> <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>"
                                    + "</div></div></div> </div></div></div></div></div><br>");
                        }
                    } catch (Exception ex) {
                    }
                %>

            </div>
        </div>

    </div>
    <!-- /.container -->


    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Bootstrap core JavaScript -->
    <!--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>-->


</body>

</html>
