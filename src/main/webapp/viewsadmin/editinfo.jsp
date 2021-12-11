<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="hk-pg-wrapper">
	<!-- Breadcrumb -->
	<nav class="hk-breadcrumb" aria-label="breadcrumb">
		<ol class="breadcrumb breadcrumb-light bg-transparent">
			<li class="breadcrumb-item"><a href="#">Quản lý thông tin</a></li>
			<li class="breadcrumb-item active" aria-current="page">chỉnh sửa
				thông tin</li>
		</ol>
	</nav>
	<!-- /Breadcrumb -->

	<!-- Container -->
	<div class="container">
		<!-- Title -->
		<div class="hk-pg-header">
			<h4 class="hk-pg-title">
				<span class="pg-title-icon"><span class="feather-icon"><i
						data-feather="align-left"></i></span></span>Chỉnh sửa thông tin website
			</h4>
		</div>
		<!-- /Title -->

		<!-- Row -->
		<div class="row">
			<div class="col-xl-10">

				<section class="hk-sec-wrapper">
					<div class="row">

						<div class="col-sm">
							<p class="text-danger">${mess}</p>
							<form action="admin-info" method="post">

								<div class="form-group row">
									<label for="inputEmail3" class="col-sm-2 col-form-label">Địa
										chỉ email</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputEmail3"
											placeholder="Nhập địa chỉ email" value="${info.email}"
											name="email">
									</div>
								</div>
								<div class="form-group row">
									<label for="inputEmail3" class="col-sm-2 col-form-label">Số
										điện thoại</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputEmail3"
											placeholder="Nhập  số điện thoại" value="${info.phone}"
											name="phone">
									</div>
								</div>
								<div class="form-group row">
									<label for="inputEmail3" class="col-sm-2 col-form-label">Địa
										chỉ</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputEmail3"
											placeholder="Nhập địa chỉ" value="${info.address}"
											name="address">
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