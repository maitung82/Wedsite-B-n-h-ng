 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật đặt hàng chi tiết</title>
<link rel="stylesheet"
	href="/IT16308_Assignment/css/bootstrap.min.css">
</head>
<body>
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
	<div class="container">
		<div class="row">
			<div class="card">
				<div class="card-header">
					<h2 class="text-primary">QUẢN LÝ CHI TIẾT ĐẶT HÀNG</h2> 
				</div>
				<div class="col-md-12">
					<form:form
						action="/IT16308_Assignment/admin/orderDetails/update/${item.id}"
						modelAttribute="orderDetail" method="POST">
						<div class="form-input">
							<label class="form-label">Code Order :</label>
							<form:select path="order_id" class="form-select" value="${item.order_id.id }">
								<c:forEach items="${dsOrder }" var="order">
									<form:option value="${order.id }">${order.id }(${order.create_date }(${order.address })) </form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-input">
							<label class="form-label">Name product :</label>
							<form:select path="product_id" class="form-select" value="${item.product_id.name }" >
								<c:forEach items="${dsProduct }" var="product">
									<form:option value="${product.id }">${product.name }(${product.price }) </form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-input" >
							<label class="form-label" >Price :</label>
							<form:input path="price" value="${item.price }" class="form-control" disabled=""  />
							<form:errors path="price" class="text-danger"></form:errors>
						</div>
						<div class="form-input">
							<label class="form-label">Quantity :</label>
							<form:input path="quantity" value="${item.quantity }" class="form-control" />
							<form:errors path="quantity" class="text-danger"></form:errors>
						</div>
						<div class="form-input m-3">
							<button class="btn btn-primary">Update</button>
							<a class="btn btn-success" href="/IT16308_Assignment/admin/orderDetails/create">Tạo mới chi tiết</a>
						</div>
					</form:form>
				</div>
				<div class="col-md-12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Order Code</th>
								<th>Name product</th>
								<th>Price</th>
								<th>Quantity</th>
								<th colspan="2">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${data.content }" var="orderDetails">
								<tr>
									<td>${ orderDetails.id }</td>
									<td>${ orderDetails.order_id.id}</td>
									<td>${ orderDetails.product_id.name}</td>
									<td>
										${ orderDetails.price }
									</td>
									<td>${ orderDetails.quantity }</td>
									<td><a class="btn btn-primary"
										href="/IT16308_Assignment/admin/orderDetails/edit/${orderDetails.id }">Edit</a>
									</td>
									<td><button type="button" class="btn btn-danger"
											data-bs-toggle="modal" data-bs-target="#p${orderDetails.id}">Xóa</button>
										<!-- Modal -->
										<div class="modal fade" id="p${orderDetails.id }" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Bạn có
															chắc muốn xóa</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">Bạn có chắc chắn muốn xóa bé
														này không?</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">Hủy</button>
														<a class="btn btn-danger"
															href="/IT16308_Assignment/admin/orderDetails/delete/${ orderDetails.id }">Xóa</a>
													</div>
												</div>
											</div>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>


				</div>
			</div>
			<div class="card-footer">
				<div class="row">
					<div class="col-6 offset-5">
						<ul class="pagination">
							<li class="page-item"><a
								href="/IT16308_Assignment/admin/orderDetails/create"
								class="page-link"> First</a></li>
							<li class="page-item"><a
								href="/IT16308_Assignment/admin/orderDetails/create?page=${data.number - 1 } "
								class="page-link"> Previous</a></li>
							<li class="page-item"><a class="page-link" href="#">
									${data.number }</a></li>
							<li class="page-item"><a
								href="/IT16308_Assignment/admin/orderDetails/create?page=${data.number + 1 }"
								class="page-link"> Next </a></li>
							<li class="page-item"><a
								href="/IT16308_Assignment/admin/orderDetails/create?page=${data.totalPages - 1 }"
								class="page-link"> Last </a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
</div>

	<footer class="row col-md text-center p-3 bg-secondary"
			style="margin: 0;">
			<marquee behavior="" direction="">Mai Văn Tùng</marquee>
			<div class="row"></div>
		</footer>
	
	<script src="/IT16308_Assignment/js/bootstrap.min.js"></script>
	<script src="/IT16308_Assignment/js/jquery.min.js"></script>
	<script src="/IT16308_Assignment/js/popper.min.js"></script>
</body>
</html>