

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi" class="h-100">

    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

        <!------ Include the above in your HEAD tag ---------->

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.min.css" type="text/css">
        <!-- Font awesome -->
        <link rel="stylesheet" href="../vendor/font-awesome/css/font-awesome.min.css" type="text/css">
        <!-- Custom css - Các file css do chúng ta tự viết -->
        <link rel="stylesheet" href="css/app.css" type="text/css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <!-- header -->
        <jsp:include page="Menu.jsp"/>

        <!-- end header -->

        <main role="main">
            <!-- Block content - Đục lỗ trên giao diện bố cục chung, đặt tên là `content` -->
            <div class="container mt-4">
                <div id="thongbao" class="alert alert-danger d-none face" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>

                <h1 class="text-center">Giỏ hàng</h1>
                <div class="row">
                    <div class="col col-md-12">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th >Image</th>
                                    <th >Name</th>
                                    <th >Price</th>                    
                                    <th >Quantity</th>
                                    <th >Total</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody id="datarow">
                                <c:set var="o" value="${sessionScope.cart}"/>
                                <c:forEach items="${o.items}" var="i">                                    <tr>
                                        <td ><img src="${i.product.image}" alt=""></a></td>
                                        <td >${i.product.name}</a></td>
                                        <td ><fmt:formatNumber pattern="##########" value="${i.product.price}"/></td>
                                <form action="updatequantity">
                                    <input type="hidden" name="product_id" value="${i.product.id}">
                                    <td ><input name="quantity" onchange="this.form.submit()" value="${i.quantity}" type="number"></td>
                                </form>
                                <td > <fmt:formatNumber pattern="##########" value="${i.product.price * i.quantity }"/></td>
                                <td><a href="deletecart?key=${i.product.id }">Xoa</a></td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <a href="LoadDB" class="btn btn-warning btn-md"><i class="fa fa-arrow-left"
                                                                           aria-hidden="true"></i>&nbsp;Quay
                            về trang chủ</a><br/>
                            <a href="checkout.jsp" class="btn btn-primary btn-md" value="Thanh toán"><i
                                aria-hidden="true" ></i>&nbsp;Thanh toán</a><br/>
                        
                    </div>
                </div>
            </div>
            <!-- End block content -->
        </main>

        <!--footer area start-->
        <jsp:include page="Footer.jsp"/>
        <!--footer area end-->
        <!-- end footer -->

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->






        <!-- JS
        ============================================ -->






    </body>

</html>