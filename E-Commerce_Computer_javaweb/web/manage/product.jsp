<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <title>Visitors an Admin Panel Category Bootstrap Responsive Website Template | Responsive_table :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
          Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- bootstrap-css -->
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <!-- //bootstrap-css -->
    <!-- Custom CSS -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <link href="css/style-responsive.css" rel="stylesheet"/>
    <!-- font CSS -->
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="css/font.css" type="text/css"/>
    <link href="css/font-awesome.css" rel="stylesheet"> 
    <!-- //font-awesome icons -->
    <script src="js/jquery2.0.3.min.js"></script>
</head>
<body>
    <section id="container">
        <!--header start-->
        <jsp:include page="../manage/header.jsp"/>
        <!--header end-->
        <!--sidebar start-->
        <jsp:include page="../manage/leftmenu.jsp"/>
        <!--sidebar end-->
        <!--main content start-->
        <section id="main-content">
            <section class="wrapper">
                <div class="table-agile-info">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Basic table
                        </div>
                        <div>
                            <table class="table" ui-jq="footable" ui-options='{
                                   "paging": {
                                   "enabled": true
                                   },
                                   "filtering": {
                                   "enabled": true
                                   },
                                   "sorting": {
                                   "enabled": true
                                   }}'>
                                <thead>
                                    <tr>
                                        <th data-breakpoints="xs">ID</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Giá</th>
                                        <th>Giá khuyến mãi</th>
                                        <th data-breakpoints="xs sm md" data-title="DOB">Cấu hình</th>
                                        <th data-breakpoints="xs sm md" data-title="DOB">Mô tả</th>
                                        <th data-breakpoints="xs sm md" data-title="DOB">Số lượng</th>
                                        <th data-breakpoints="xs sm md" data-title="DOB">Danh mục sản phẩm</th>
                                        <th data-breakpoints="xs sm md" data-title="DOB">Hãng sản xuất</th>
                                        <th data-breakpoints="xs sm md" data-title="DOB">Đường dẫn hình ảnh</th>
                                        <th data-breakpoints="xs sm md" data-title="DOB">Hành động</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr data-expanded="true">
                                        <td>1</td>
                                        <td>CPU Intel Core i5 10300H | GPU Geforce GTX 1650 MaxQ | Màn hình 15.6" FullHD (1920 x 1080). 144Hz, IPS Panel | Hệ điều hành Windows 10 64Bit Home | RAM DDR4 8GB (1 x 8GB) 2666MHz; 2 slots, up to 32GB | Ổ cứng SSD 512GB SSD NVMe M.2 PCIe Gen 3 x 4 | Ổ cứng HDD 1 slot HDD 2.5'</td>
                                        <td>CPU Intel Core i5 10300H | GPU Geforce GTX 1650 MaxQ | Màn hình 15.6" FullHD (1920 x 1080). 144Hz, IPS Panel | Hệ điều hành Windows 10 64Bit Home | RAM DDR4 8GB (1 x 8GB) 2666MHz; 2 slots, up to 32GB | Ổ cứng SSD 512GB SSD NVMe M.2 PCIe Gen 3 x 4 | Ổ cứng HDD 1 slot HDD 2.5'</td>
                                        <td>CPU Intel Core i5 10300H | GPU Geforce GTX 1650 MaxQ | Màn hình 15.6" FullHD (1920 x 1080). 144Hz, IPS Panel | Hệ điều hành Windows 10 64Bit Home | RAM DDR4 8GB (1 x 8GB) 2666MHz; 2 slots, up to 32GB | Ổ cứng SSD 512GB SSD NVMe M.2 PCIe Gen 3 x 4 | Ổ cứng HDD 1 slot HDD 2.5'</td>
                                        <td>July 25th 1960</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Elodia</td>
                                        <td>Weisz</td>
                                        <td>Wallpaperer Helper</td>

                                        <td>March 30th 1982</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>Raeann</td>
                                        <td>Haner</td>
                                        <td>Internal Medicine Nurse Practitioner</td>

                                        <td>February 26th 1966</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>Junie</td>
                                        <td>Landa</td>
                                        <td>Offbearer</td>

                                        <td>March 29th 1966</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>Solomon</td>
                                        <td>Bittinger</td>
                                        <td>Roller Skater</td>

                                        <td>September 22nd 1964</td>
                                    </tr>
                                    <tr>
                                        <td>6</td>
                                        <td>Bar</td>
                                        <td>Lewis</td>
                                        <td>Clown</td>

                                        <td>August 4th 1991</td>
                                    </tr>
                                    <tr>
                                        <td>7</td>
                                        <td>Usha</td>
                                        <td>Leak</td>
                                        <td>Ships Electronic Warfare Officer</td>

                                        <td>November 20th 1979</td>
                                    </tr>
                                    <tr>
                                        <td>8</td>
                                        <td>Lorriane</td>
                                        <td>Cooke</td>
                                        <td>Technical Services Librarian</td>

                                        <td>April 7th 1969</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-sm-7 text-right text-center-xs">                
                    <ul class="pagination pagination-sm m-t-none m-b-none">
                        <li><a href=""><i class="fa fa-chevron-left"></i></a></li>
                        <li><a href="">1</a></li>
                        <li><a href="">2</a></li>
                        <li><a href="">3</a></li>
                        <li><a href="">4</a></li>
                        <li><a href=""><i class="fa fa-chevron-right"></i></a></li>
                    </ul>
                </div>
            </section>
            <!-- footer -->
            <div class="footer">
                <div class="wthree-copyright">
                    <p>© 2017 Visitors. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
                </div>
            </div>
            <!-- / footer -->
        </section>

        <!--main content end-->
    </section>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="js/scripts.js"></script>
    <script src="js/jquery.slimscroll.js"></script>
    <script src="js/jquery.nicescroll.js"></script>
    <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
    <script src="js/jquery.scrollTo.js"></script>
</body>
</html>
