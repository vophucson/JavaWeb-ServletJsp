<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="hk-pg-wrapper">
	<!-- Breadcrumb -->
	<nav class="hk-breadcrumb" aria-label="breadcrumb">
		<ol class="breadcrumb breadcrumb-light bg-transparent">
			<li class="breadcrumb-item"><a href="#">Quản lý thương hiệu</a></li>
			<li class="breadcrumb-item active" aria-current="page">Danh sách
				thương hiệu</li>
		</ol>
	</nav>
	<!-- /Breadcrumb -->

	<!-- Container -->
	<div class="container">
		<!-- Title -->
		<div class="hk-pg-header">
			<h4 class="hk-pg-title">
				<span class="pg-title-icon"><span class="feather-icon"><i
						data-feather="archive"></i></span></span>Danh sách thương hiệu
			</h4>
		</div>
		<!-- /Title -->

		<!-- Row -->
		<div class="row">
			<div class="col-xl-12">
				<section class="hk-sec-wrapper">
					<h5 class="hk-sec-title">
						<button type="button" class="btn btn-outline-danger"
							data-toggle="modal" data-target="#exampleModalForms">Thêm</button>

					</h5>
					<p class="text-danger">${mess}</p>
					<div class="row">
						<div class="col-sm">
							<div class="table-wrap">
								<div class="table-responsive">
									<table class="table table-hover table-bordered mb-0">
										<thead>
											<tr>
												<th>ID</th>
												<th>Tên thương hiệu</th>
												<th>Hỉnh ảnh Logo</th>
												<th>Chức Năng</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${list}" var="b">
												<tr>
													<td>${b.brandId}</td>
													<td>${b.brandName}</td>
													<td>
														<div>
															<img src="uploads/brand/${b.icon}" class="cover"
																alt="MDN Logo" width="100px" height="60px">
														</div>
													</td>
													<td><a href="admin-editbrand?bid=${b.brandId}"
														class="mr-25" data-toggle="tooltip"
														data-original-title="Chỉnh sửa"> <i
															class="icon-pencil"></i>
													</a> <a href="admin-deletebrand?bid=${b.brandId}"
														data-toggle="tooltip" data-original-title="Xóa"> <i
															class="icon-trash txt-danger"></i>
													</a></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
									<div
										class="col-sm row align-items-center justify-content-center">
										<nav class="pagination-wrap d-inline-block mr-40 mt-30"
											aria-label="Page navigation example">
											<ul class="pagination custom-pagination pagination-filled">
												<c:if test="${tag > 1}">
													<li class="page-item"><a class="page-link"
														href="admin-brand?index=${tag - 1}"><i
															class="ion ion-ios-arrow-round-back"></i></a></li>
												</c:if>
												<c:forEach end="${endP}" begin="1" var="i">
													<li class="page-item ${tag==i?"active":""}"><a
														class="page-link" href="admin-brand?index=${i}">${i}</a></li>
												</c:forEach>
												<c:if test="${tag < endP}">
													<li class="page-item"><a class="page-link"
														href="admin-brand?index=${tag + 1}"><i
															class="ion ion-ios-arrow-round-forward"></i></a></li>
												</c:if>
											</ul>
										</nav>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

			</div>
		</div>
		<!-- /Row -->

	</div>
	<!-- /Container -->
	<div class="modal fade" id="exampleModalForms" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalForms" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Thêm sản phẩm</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>

				</div>
				<div class="modal-body">
					<form action="admin-createbrand" method="POST"
						enctype="multipart/form-data" accept-charset="UTF-8">
						<div class="form-group">
							<label for="exampleDropdownFormEmail1">Tên thương hiệu</label> <input
								type="text" class="form-control"
								placeholder="Nhập tên thương hiệu" name="name">

						</div>
						<div class="from-group">
							<div class="fileinput fileinput-new input-group"
								data-provides="fileinput">
								<div class="input-group-prepend">
									<span class="input-group-text">Logo</span>
								</div>
								<div class="form-control text-truncate" data-trigger="fileinput">
									<i class="glyphicon glyphicon-file fileinput-exists"></i> <span
										class="fileinput-filename"></span>
								</div>
								<span class="input-group-append"> <span
									class=" btn btn-danger btn-file"><span
										class="fileinput-new">Chọn hình</span><span
										class="fileinput-exists">Thay đổi</span> <input type="file"
										name="icon"> </span>
								</span> <a href="#" class="btn btn-secondary fileinput-exists"
									data-dismiss="fileinput">Xóa</a>
							</div>
						</div>
						<div>&nbsp</div>
						<button type="submit" class="btn btn-danger">Xác nhận</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>