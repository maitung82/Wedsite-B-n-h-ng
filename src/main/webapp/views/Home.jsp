<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<link rel="stylesheet" href="/IT16308_Assignment/css/bootstrap.min.css">
<body>
	<div class="container-fluid">
		<header class="row">
			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img
							src="
                   https://3.bp.blogspot.com/-pIummBi6N3M/UeOYg7UCyKI/AAAAAAAAACk/vl5vyv3IuO0/s1600/dienthoaididong_02.jpg"
							class="d-block w-100" alt="..." height="200px">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</header>
		<nav class="navbar navbar-expand-lg c shadow navbar-light bg-white">
			<div class="container-fluid">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="/IT16308_Assignment/admin/getHome">Trang chủ</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle active" id="homeDropdownMenuLink"
						href="#" data-bs-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Danh mục</a>
						<div class="dropdown-menu" aria-labelledby="homeDropdownMenuLink">
							<a class="dropdown-item"
								href="/IT16308_Assignment/admin/accounts/create">Quản lý
								người dùng</a> <a class="dropdown-item"
								href="/IT16308_Assignment/admin/categories/create">Quản lý
								danh mục </a> <a class="dropdown-item"
								href="/IT16308_Assignment/admin/products/create">Quản lý sản
								phẩm</a> <a class="dropdown-item"
								href="/IT16308_Assignment/admin/orders/create">Quản lý đặt
								hàng</a> <a class="dropdown-item"
								href="/IT16308_Assignment/admin/orderDetails/create">Quản lý
								đặt hàng chi tiết</a> <a class="dropdown-item" href="">Đổi mật
								khẩu</a>
						</div></li>
				</ul>
				<button class="navbar-toggler navbar-toggler-right" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
					aria-controls="navbarCollapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fa fa-bars"></i>
				</button>
				<!-- Navbar Collapse -->
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<form class="form-inline mt-4 mb-2 d-sm-none" action="#"
						id="searchcollapsed">
						<div class="input-label-absolute input-label-absolute-left w-100">
							<label class="label-absolute" for="searchcollapsed_search"><i
								class="fa fa-search"></i><span class="sr-only">What are
									you looking for?</span></label> <input
								class="form-control form-control-sm border-0 shadow-0 bg-gray-200"
								id="searchcollapsed_search" placeholder="Search"
								aria-label="Search" type="search">
						</div>
					</form>
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link" href="#">Đăng
								xuất</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="row m-0">

			<article class="col-md-9 ">

                <div class="row mt-3">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header text-center">
                                <span>Vertu</span>
                            </div>
                            <img src="https://th.bing.com/th/id/R.99ba0399530cc416aa209367e487765e?rik=ybA7TuadlfFNQg&pid=ImgRaw&r=0"
                                class="card-img-top" alt="..." style="width: 100%; height: 300px">
                            <div class="card-footer text-center">
                                <span>85600$</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header text-center">
                                <span>Iphone 12</span>
                            </div>
                            <img src="https://hc.com.vn/i/ecommerce/media/GS.006097_FEATURE_71005.jpg"
                                class="card-img-top" alt="..." style="width: 100%; height: 300px">

                            <div class="card-footer text-center">
                                <span>699$</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header text-center">
                                <span>Nokia 8800 vàng hồng gold da nâu</span>
                            </div>
                            <img src="https://muadonghocu.vn/wp-content/uploads/2020/07/nokia-8800-vang-hong-gold-da-nau-c072f7d1-7987-4324-b85e-77bb0e8cdde5-1024x1024.jpg"
                                class="card-img-top" alt="..." style="width: 100%; height: 300px">

                            <div class="card-footer text-center">
                                <span>1200$</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header text-center">
                                <span>Đồng hồ hublot</span>
                            </div>
                            <img src="https://th.bing.com/th/id/OIP.y2Lm3CX3QmqqD4UxOASK3QHaFc?pid=ImgDet&rs=1"
                                class="card-img-top" alt="..." style="width: 100%; height: 300px">
                            <div class="card-footer text-center">
                                <span>15000$</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header text-center">
                                <span>Ipad</span>
                            </div>
                            <img src="https://noteboox.de/media/image/product/84556/lg/apple-ipad-pro-mu102fd-a-tablet~8.jpg"
                                class="card-img-top" alt="..." style="width: 100%; height: 300px">

                            <div class="card-footer text-center">
                                <span>999$</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header text-center">
                                <span>Macbook Retina</span>
                            </div>
                            <img src="https://static.swappa.com/media/listing/LRHB24663/BqgLICvU.jpg"
                                class="card-img-top" alt="..." style="width: 100%; height: 300px">

                            <div class="card-footer text-center">
                                <span>888$</span>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </article>


			
			 <aside class="col-md-3 bg-light">
               
                <div class="card mt-3">
                    <div class="card-header">
                        <span class="fas fa-align-justify"></span> Danh Mục
                    </div>
                    <ul class="list-group list-group-flush" style="list-style: none;">
                        <li class="list-group-item"><a>Iphone</a><span
							data-bs-toggle="tooltip" data-bs-placement="top" title="Giảm 90%"
							class="badge bg-danger">30%</span></li>
                        <li><a href="#" class="list-group-item">Nokia</a></li>
                        <li><a href="#" class="list-group-item">MacBook</a></li>
                        <li><a href="#" class="list-group-item">Ipad</a></li>
                        <li><a href="#" class="list-group-item">Đồng Hồ</a></li>
                         <li><a href="#" class="list-group-item">Vertu</a></li>
                    </ul>
                </div>
            </aside>
		</div>
		<footer class="row col-md text-center p-3 bg-secondary"
			style="margin: 0;">
			<marquee behavior="" direction="">Mai Văn Tùng</marquee>
			<div class="row"></div>
		</footer>
	</div>
</body>
<script src="/IT16308_Assignment/js/bootstrap.min.js"></script>
<script src="/IT16308_Assignment/js/jquery.min.js"></script>
<script src="/IT16308_Assignment/js/popper.min.js"></script>
</html>