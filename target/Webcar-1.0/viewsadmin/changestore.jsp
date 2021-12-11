<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="hk-pg-wrapper">
	<!-- Breadcrumb -->
	<nav class="hk-breadcrumb" aria-label="breadcrumb">
		<ol class="breadcrumb breadcrumb-light bg-transparent">
			<li class="breadcrumb-item"><a href="#">Quản lý cửa hàng</a></li>
			<li class="breadcrumb-item" aria-current="page"><a
				href="admin-dealer?index=1">Danh sách cửa hàng</a></li>
			<li class="breadcrumb-item active" aria-current="page">Duyệt cửa
				hàng</li>
		</ol>
		<!-- /Breadcrumb -->
	</nav>
	<!-- Container -->
	<div class="container">
		<!-- Title -->
		<div class="hk-pg-header">
			<h4 class="hk-pg-title">
				<span class="pg-title-icon"><span class="feather-icon"><i
						data-feather="align-left"></i></span></span>Chỉnh sửa tình trạng cửa hàng
			</h4>
		</div>
		<!-- /Title -->

		<!-- Row -->
		<div class="row">
			<div class="col-xl-10">
				<section class="hk-sec-wrapper">

					<div class="row">

						<div class="col-sm">
							<form action="admin-changestore" method="POST">
								<input type="hidden" value="${deadlerid}" name="did">
								<div class="row">
									<label class="col-form-label col-sm-2 pt-0">Tình trạng</label>

									<div class="col-sm-10">
										<div class="custom-control custom-radio mb-5">
											<input id="option_1" name="pass" value="1"
												class="custom-control-input" type="radio"> <label
												class="custom-control-label" for="option_1">Duyệt</label>
										</div>
										<div class="custom-control custom-radio mb-5">
											<input id="option_2" name="pass" value="0"
												class="custom-control-input" type="radio"> <label
												class="custom-control-label" for="option_2">Không
												Duyệt</label>
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