<%-- 
    Document   : home
    Created on : Jun 10, 2022, 4:01:47 PM
    Author     : vuman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="js/home.js"></script>
    <title>EightShoes</title>
    <link href="images/icon.png" rel="icon">
    <script src="https://kit.fontawesome.com/72eb2ee2e2.js" crossorigin="anonymous"></script>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/header.js"></script>
    </head>
    
    <body>
        <header>
            <div class="top-header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6"></div>
                        <div class="col-md-6 col-sm-12">
                            Hotline: <a href="tel: 123456789" style="font-weight: bold">0123456789</a> | <a href=""><i
                                    class="fa-solid fa-lock"></i> Đăng ký</a> | <a href=""><i class="fa-solid fa-user"></i>
                                Đăng
                                nhập</a>
                        </div>
                    </div>
                </div>
            </div>


            <div class="mid-header">
                <div class="mid1-header container">
                    <div class="row">
                        <div class="col-sm-3"></div>
                        <div class="col-sm-6">
                            <a href="">
                                <img class="logo" src="images/logo.png">
                            </a>
                        </div>
                        <div class="col-sm-3 text-right">
                            <a title="Danh sách yêu thích" href="">
                                <i class="fa-solid fa-heart"></i>
                            </a>
                            <i class="fa-solid fa-cart-shopping"></i>
                        </div>
                    </div>
                </div>
                <div class="mid2-header">
                    <div class="popup-box">
                        <div class="popup-box__stage">
                            <div class="popup-box__item">Email hỗ trợ : linhtinh@gmail.com</div>
                            <div class="popup-box__item">Miễn phí vận chuyển toàn quốc</div>
                            <div class="popup-box__item">Đăng ký hoặc gọi 0123456789 để cập nhật chương trình khuyến mãi
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="bottom-header">
                <div class="container">
                    <div class="row">
                        <div class="menu">
                            <nav><a href="">CONVERSE</a></nav>
                            <nav><a href="">VANS</a></nav>
                            <nav><a href="">PUMA</a></nav>
                            <nav><a href="">ADIDAS</a></nav>
                            <nav><a href="">NIKE</a></nav>
                            <nav><a href="">BITIS</a></nav>
                            <nav><a style="color: red" href="">KHUYẾN MÃI</a></nav>
                            <nav><a href="">CỬA HÀNG</a></nav>
                        </div>
                        <div class="search">
                            <input name="search" class="sb-search-input" placeholder="Tìm kiếm" type="text" value="">
                            <button type="button"><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="top-page ">
            <div class="slide">
                <a class="banner" href=""><img src="images/banner/Chuck-70-banner.jpg" alt="This is Chuck taylor 70s banner"></a>
                <a class="banner" href=""><img src="images/banner/vans-banner.jpg" alt="This is Vans banner"></a>
                <a class="banner" href=""><img src="images/banner/adidas-banner.jpg" alt="This is Addidas banner"></a>
                <a class="banner" href=""><img src="images/banner/nike-banner.jpeg" alt="This is Nike banner"></a>
            </div>
        </div>

        <div class="content">
            <div class="brand-logo container">
                <div class="row">
                    <div class="col-sm-2">
                        <a href=""><img src="images/logo/converse-logo.jpg" alt="Converse-logo"></a>
                    </div>
                    <div class="col-sm-2">
                        <a href=""><img src="images/logo/vans-logo.jpg" alt="Vans-logo"></a>
                    </div>
                    <div class="col-sm-2">
                        <a href=""><img src="images/logo/puma-logo.jpg" alt="Puma-logo"></a>
                    </div>
                    <div class="col-sm-2">
                        <a href=""><img src="images/logo/adidas-logo.png" alt="Adidas-logo"></a>
                    </div>
                    <div class="col-sm-2">
                        <a href=""><img src="images/logo/nike-logo.jpg" alt="Nike-logo"></a>
                    </div>
                    <div class="col-sm-2">
                        <a href=""><img src="images/logo/bitis-logo.png" alt="Bitis-logo"></a>
                    </div>
                </div>
            </div>

            <div class="small-list container">
                <div class="small--list">
                    <img src="images/banner2/converse-banner2.jpg" alt="Converse-banner">
                </div>
                <div class="small-vans-list">
                    <img src="images/banner2/vans-banner2.jpg" alt="vans-banner">
                </div>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <span>GIỚI THIỆU</span>
                        <ul>
                            <a href=""><li>Về Eight Shoes</li></a>
                            <a href=""><li>Cửa hàng</li></a>
                            <a href=""><li>Khuyến mãi</li></a>
                        </ul>
                    </div>
                    <div class="col-sm-4">
                        <span>Thông tin</span>
                        <ul>
                            <a href=""><li>Chính sách và quy định chung</li></a>
                            <a href=""><li>Chính sách vận chuyển và giao nhận</li></a>
                            <a href=""><li>Chính sách bảo hành - đổi/trả</li></a>
                            <a href=""><li>Chính sách bảo mật</li></a>
                        </ul>
                    </div>
                    <div class="col-sm-4">
                        <span>Hỗ trợ</span>
                        <ul>
                            <a href=""><li>Hỗ trợ trực tuyến</li></a>
                            <a href=""><li>Kiểm tra đơn hàng</li></a>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>          
    </body>
</html>
