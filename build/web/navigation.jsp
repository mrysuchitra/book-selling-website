<%-- 
    Document   : header
    Created on : 23-Nov-2019, 23:44:19
    Author     : tien.nh173399
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>navigation</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand col-lg-3" href="/book-selling-web/">Book Store</a>
                <form class="col-lg-5 middle" action="/book-selling-web/search" method="get">
                    <div class="row">
                    <input class="form-control middle col-lg-9" type="text" name="query" placeholder="book name...">
                    <button class="btn btn-outline-success my-2 my-sm-0 col-lg-3" type="submit">Search</button>
                    </div>
                </form>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/book-selling-web">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/book-selling-web/addBook">Add book</a>
                        </li>
                        <%
                            if (session.getAttribute("username")!=null){
                                out.println("<li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">"+session.getAttribute("name")+"</a></li>");
                                out.println("<li class=\"nav-item\"> <a class=\"nav-link\" href=\"/book-selling-web/logout\">Logout</a></li>");
                            }
                            else{
                                out.println("<li class=\"nav-item\"> <a class=\"nav-link\" href=\"/book-selling-web/login\">Login</a></li>");
                                out.println("<li class=\"nav-item\"> <a class=\"nav-link\" href=\"/book-selling-web/register\">Register</a></li>");                               
                            }
                        %>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>

