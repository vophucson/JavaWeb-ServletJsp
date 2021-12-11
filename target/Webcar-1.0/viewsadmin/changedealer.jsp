<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="hk-pg-wrapper">
	<!-- Breadcrumb -->
	<nav class="hk-breadcrumb" aria-label="breadcrumb">
		<ol class="breadcrumb breadcrumb-light bg-transparent">
			<li class="breadcrumb-item"><a href="#">Quản lý tài khoản</a></li>
			<li class="breadcrumb-item" aria-current="page"><a
				href="admin-user?index=1">Danh sách tài khoản</a></li>
			<li class="breadcrumb-item active" aria-current="page">Thay đổi
				quyền bán xe</li>
		</ol>
		<!-- /Breadcrumb -->
	</nav>
	<!-- Container -->
	<div class="container">
		<!-- Title -->
		<div class="hk-pg-header">
			<h4 class="hk-pg-title">
				<span class="pg-title-icon"><span class="feather-icon"><i
						data-feather="align-left"></i></span></span>Chỉnh sửa quyền tài khoản
			</h4>
		</div>
		<!-- /Title -->

		<!-- Row -->
		<div class="row">
			<div class="col-xl-10">
				<section class="hk-sec-wrapper">

					<div class="row">

						<div class="col-sm">
							<form action="admin-changedealer" method="POST">
								<input type="hidden" value="${uid}" name="uid">
								<div class="row">
									<label class="col-form-label col-sm-2 pt-0">Quyền bán
										xe</label>

									<div class="col-sm-10">
										<div class="custom-control custom-radio mb-5">
											<input id="option_1" name="role" value="1"
												class="custom-control-input" type="radio"> <label
												class="custom-control-label" for="option_1">Có</label>
										</div>
										<div class="custom-control custom-radio mb-5">
											<input id="option_2" name="role" value="0"
												class="custom-control-input" type="radio"> <label
												class="custom-control-label" for="option_2">Không</label>
										</div>

									</div>
								</div>

								<div>&nbsp</div>
								<div class="form-group row mb-0 text-center">
									<div class="col-sm-10">
										<button type="submit" class="btn btn-danger">Xác nhận</button>
									</div>
								</div>
								>

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