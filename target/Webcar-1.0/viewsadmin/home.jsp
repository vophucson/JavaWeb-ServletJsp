<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Main Content -->
<div class="hk-pg-wrapper">
	<!-- Container -->
	<div class="container mt-xl-50 mt-sm-30 mt-15">
		<!-- Title -->
		<div class="hk-pg-header align-items-top">
			<div>
				<h2 class="hk-pg-title font-weight-600 mb-10">Quản lý website
					Carforyou</h2>
			</div>
		</div>
		<!-- /Title -->
		<!-- Row -->
		<div class="row">
			<div class="col-xl-12">
				<div class="hk-row">
					<div class="col-lg-8">
						<div class="hk-row">
							<div class="col-lg-4">
								<div class="card card-sm">
									<div class="card-body pa-0">
										<div class="pa-15 mb-10">
											<span class="d-block font-14 font-weight-500 text-dark">Tổng
												bài đăng</span>
											<div
												class="d-flex align-items-center justify-content-between">
												<div class="display-5 font-weight-400 text-dark">${totalCar}</div>

											</div>
										</div>
										<div id="sparkline_1"></div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="card card-sm">
									<div class="card-body pa-0">
										<div class="pa-15 mb-10">
											<span class="d-block font-14 font-weight-500 text-dark">Số
												bài đã duyệt</span>
											<div
												class="d-flex align-items-center justify-content-between">
												<div class="display-5 font-weight-400 text-dark">${totalpassCar}</div>

											</div>
										</div>
										<div id="sparkline_2"></div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="card card-sm">
									<div class="card-body pa-0">
										<div class="pa-15 mb-10">
											<span class="d-block font-14 font-weight-500 text-dark">Số
												bài chưa duyệt</span>
											<div
												class="d-flex align-items-center justify-content-between">
												<div class="display-5 font-weight-400 text-dark">${totalnoPassCar}</div>

											</div>
										</div>
										<div id="sparkline_3"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="hk-row">
							<div class="col-lg-4">
								<div class="card card-sm">
									<div class="card-body pa-0">
										<div class="pa-15 mb-10">
											<span class="d-block font-14 font-weight-500 text-dark">Tổng
												số tài khoản</span>
											<div
												class="d-flex align-items-center justify-content-between">
												<div class="display-5 font-weight-400 text-dark">${totalUser}</div>

											</div>
										</div>
										<div id="sparkline_1"></div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="card card-sm">
									<div class="card-body pa-0">
										<div class="pa-15 mb-10">
											<span class="d-block font-14 font-weight-500 text-dark">Tổng
												số cửa hàng</span>
											<div
												class="d-flex align-items-center justify-content-between">
												<div class="display-5 font-weight-400 text-dark">${totalStore}</div>

											</div>
										</div>
										<div id="sparkline_2"></div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="card card-sm">
									<div class="card-body pa-0">
										<div class="pa-15 mb-10">
											<span class="d-block font-14 font-weight-500 text-dark">Tổng
												số thương hiệu</span>
											<div
												class="d-flex align-items-center justify-content-between">
												<div class="display-5 font-weight-400 text-dark">${totalBrand}</div>

											</div>
										</div>
										<div id="sparkline_3"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /Row -->
		</div>
		<!-- /Container -->
		<!-- Footer -->
		<!-- /Footer -->
	</div>
</div>
<!-- /Main Content -->

