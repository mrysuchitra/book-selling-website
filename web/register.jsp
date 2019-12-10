<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Register</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">

    </head>
    <body>
        <jsp:include page="navigation.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h5 class="card-title text-center">Sign In</h5>
                                <form class="form-signin" action="<%=request.getContextPath()%>/register" method="POST"
                                  oninput='password2.setCustomValidity(password2.value != password.value ? "Passwords do not match." : "")'>
                                <div class="form-label-group">
                                    <label for="inputUsername">Email address</label>
                                    <input id="inputUsername" name="username"class="form-control" placeholder="Username" required autofocus>
                                </div>

                                <div class="form-label-group">
                                    <label for="inputPassword1">Password</label>
                                    <input type="password" id="inputPassword1" name="password"class="form-control" placeholder="Password" required>
                                </div>
                                <div class="form-label-group">
                                    <label for="inputPassword2">Password</label>
                                    <input type="password" id="inputPassword2" name="password2"class="form-control" placeholder="Password" required>
                                </div>
                                <div class="form-label-group">
                                    <label for="name">Name</label>
                                    <input id="name" name="name"class="form-control" placeholder="Name" required autofocus>
                                </div>
                                <div class="form-label-group">
                                    <label for="address">Chọn thành phố bạn đang sống</label>
                                    <select class="mdb-select md-form" id="address" name="address">
                                        <option value="Hà Nội">Hà Nội</option>
                                        <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                                        <option value="Đà Nẵng">Đà Nẵng</option>
                                    </select>
                                </div>
                                <div class="form-label-group">
                                    <label for="phone">Email address</label>
                                    <input id="phone" name="phoneNum"class="form-control" placeholder="0987654321" required autofocus>
                                </div>


                                <%
                                    String err = request.getParameter("err");
                                    if ("1".equals(err)) {
                                        out.print("<h5 style=\"color: red;\">Something went wrong, please try again!</h5>");
                                    }
                                %>
                                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>

                            </form>
                            <hr class="my-4">
                            <h5 class="text-center">Already have account?</h5>
                            <a href="<%=request.getContextPath()%>/login"><button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">login</button></a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Bootstrap core JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
