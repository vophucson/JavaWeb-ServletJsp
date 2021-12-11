<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="hk-pg-wrapper">
	<!-- Breadcrumb -->
	<nav class="hk-breadcrumb" aria-label="breadcrumb">
		<ol class="breadcrumb breadcrumb-light bg-transparent">
			<li class="breadcrumb-item"><a href="#">Quản lý thương hiệu</a></li>
			<li class="breadcrumb-item" aria-current="page"><a
				href="admin-brand?index=1">Danh sách thương hiệu</a></li>
			<li class="breadcrumb-item active" aria-current="page">chỉnh sửa
				thương hiệu</li>
		</ol>
		<!-- /Breadcrumb -->
	</nav>
	<!-- Container -->
	<div class="container">
		<!-- Title -->
		<div class="hk-pg-header">
			<h4 class="hk-pg-title">
				<span class="pg-title-icon"><span class="feather-icon"><i
						data-feather="align-left"></i></span></span>Chỉnh sửa thương hiệu
			</h4>
		</div>
		<!-- /Title -->

		<!-- Row -->
		<div class="row">
			<div class="col-xl-10">
				<p class="text-danger">${mess}</p>
				<section class="hk-sec-wrapper">

					<div class="row">

						<div class="col-sm">
							<form action="admin-editbrand" method="POST"
								enctype="multipart/form-data" accept-charset="UTF-8">
								<input type="hidden" value="${brand.brandId}" name="bid">
								<input type="hidden" value="${brand.icon}" name="oldicon">
								<div class="form-group row">
									<label for="inputEmail3" class="col-sm-2 col-form-label">Tên
										thương hiệu</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" id="inputEmail3"
											placeholder="Nhập tên thương hiệu" value="${brand.brandName}"
											name="name">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-form-label col-sm-2 pt-0">Logo cũ</label>
									<div class="col-sm-6">

										<div>
											<img src="uploads/brand/${brand.icon}" class="cover"
												alt="MDN Logo" width="100px" height="60px">
										</div>


									</div>
								</div>
								<div class="form-group row">
									<label class="col-form-label col-sm-2 pt-0">Chọn Logo
										mới</label>
									<div class="col-sm-7">
										<div class="fileinput fileinput-new input-group"
											data-provides="fileinput">
											<div class="input-group-prepend">
												<span class="input-group-text">Logo</span>
											</div>
											<div class="form-control text-truncate"
												data-trigger="fileinput">
												<i class="glyphicon glyphicon-file fileinput-exists"></i> <span
													class="fileinput-filename"></span>
											</div>
											<span class="input-group-append"> <span
												class=" btn btn-danger btn-file"><span
													class="fileinput-new">Chọn hình</span><span
													class="fileinput-exists">Thay đổi</span> <input type="file"
													name="icon"> </span> <a href="#"
												class="btn btn-secondary fileinput-exists"
												data-dismiss="fileinput">Xóa</a>

											</span>
										</div>
									</div>
								</div>


								<div class="form-group row mb-0 text-center">
									<div class="col-sm-10">
										<button type="submit" class="btn btn-danger">Xác nhận</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</section>
			</div>
		</div>
		<!-- /Row -->
	</div>
	<!-- /Container -->

	<!-- Footer -->

	<!-- /Footer -->

</div>