<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">

    </head>
    <body>
        <jsp:include page="navigation.jsp"></jsp:include>
        <div class="container mt-5">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Login</h5>
            <form class="form-signin" action="<%=request.getContextPath()%>/login" method="POST">
              <div class="form-label-group">
                <label for="inputUsername">Username</label>
                <input id="inputUsername" name="username"class="form-control" placeholder="Username" required autofocus>
              </div>

              <div class="form-label-group">
                <label for="inputPassword">Password</label>
                <input class="form-control" type="password" id="inputPassword" name="password"class="form-control" placeholder="Password" required>
              </div>

              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
              </div>
                <%
                String err = request.getParameter("err");
                if ("1".equals(err)) {
                        out.print("<h5 style=\"color: red;\">wrong email or password</h5>");
                }else if("2".equals(err)){
                    out.print("<h5 style=\"color: red;\">Please login first!</h5>");
                }
                %>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Login</button>
            
            </form>
                           <hr class="my-4">
              <h5 class="text-center">haven't have account?</h5>
              <a href="<%=request.getContextPath()%>/register"><button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button></a>
   
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
