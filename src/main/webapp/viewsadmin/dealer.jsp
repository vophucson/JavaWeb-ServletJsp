<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="hk-pg-wrapper">
	<!-- Breadcrumb -->
	<nav class="hk-breadcrumb" aria-label="breadcrumb">
		<ol class="breadcrumb breadcrumb-light bg-transparent">
			<li class="breadcrumb-item"><a href="#">Quản lý đại lý</a></li>
			<li class="breadcrumb-item active" aria-current="page">Danh sách
				đại lý</li>
		</ol>
	</nav>
	<!-- /Breadcrumb -->

	<!-- Container -->
	<div class="container">
		<!-- Title -->
		<div class="hk-pg-header">
			<h4 class="hk-pg-title">
				<span class="pg-title-icon"><span class="feather-icon"><i
						data-feather="archive"></i></span></span>Danh sách Đại lý
			</h4>
		</div>
		<!-- /Title -->

		<!-- Row -->
		<div class="row">
			<div class="col-xl-12">
				<section class="hk-sec-wrapper">
					<div class="row">
						<div class="col-sm">
							<div class="table-wrap">
								<div class="table-responsive">
									<table class="table table-hover table-bordered mb-0">
										<thead>
											<tr>
												<th>Kiểm tra cửa hàng</th>
												<th>Tài khoản sở hữu</th>
												<th>Tình Trạng</th>
												<th>Chức năng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="d">
												<tr>

													<td>
														<h6>
															<a href="dealerdetail?dealerid=${d.dealerId}&&index=1"
																target="_blank">${d.dName}</a>
														</h6>
													</td>
													<td>ID: ${d.dealerId}<br> Email: ${d.userEmail} <br>
														Họ và tên: ${d.userName} <br> SĐT: ${d.userPhone}
													</td>
													<td><c:if test="${d.isPass == 1}">Đã Duyệt</c:if> <c:if
															test="${d.isPass == 0}">Chưa Duyệt</c:if><a
														href="admin-changestore?did=${d.dealerId}" class="mr-25"
														data-toggle="tooltip" data-original-title="Duyệt cửa hàng">
															<i class="icon-pencil"></i>
													</a></td>



													<td><a href="admin-deletedealer?did=${d.dealerId}"
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
														href="admin-dealer?index=${tag - 1}"><i
															class="ion ion-ios-arrow-round-back"></i></a></li>
												</c:if>
												<c:forEach end="${endP}" begin="1" var="i">
													<li class="page-item ${tag==i?"active":""}"><a
														class="page-link" href="admin-dealer?index=${i}">${i}</a></li>
												</c:forEach>
												<c:if test="${tag < endP}">
													<li class="page-item"><a class="page-link"
														href="admin-dealer?index=${tag + 1}"><i
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
	<div class="modal fade" id="ModalFormsAdmin" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalForms" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Duyệt cửa hàng</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>

				</div>
				<div class="modal-body">
					<form>
						<div class="row">
							<label class="col-form-label col-sm-2 pt-0">Thay đổi</label>
							<div class="col-sm-10">
								<div class="custom-control custom-radio mb-5">
									<input id="option_1" name="optionHorizontal"
										class="custom-control-input" checked="" type="radio">
									<label class="custom-control-label" for="option_1">Duyệt</label>
								</div>
								<div class="custom-control custom-radio mb-5">
									<input id="option_2" name="optionHorizontal"
										class="custom-control-input" type="radio"> <label
										class="custom-control-label" for="option_2">Không
										Duyệt</label>
								</div>

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