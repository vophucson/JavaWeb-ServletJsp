<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="hk-pg-wrapper">
	<!-- Breadcrumb -->
	<nav class="hk-breadcrumb" aria-label="breadcrumb">
		<ol class="breadcrumb breadcrumb-light bg-transparent">
			<li class="breadcrumb-item"><a href="#">Quản lý tài khoản</a></li>
			<li class="breadcrumb-item active" aria-current="page">Danh sách
				tài khoản</li>
		</ol>
	</nav>
	<!-- /Breadcrumb -->

	<!-- Container -->
	<div class="container">
		<!-- Title -->
		<div class="hk-pg-header">
			<h4 class="hk-pg-title">
				<span class="pg-title-icon"><span class="feather-icon"><i
						data-feather="archive"></i></span></span>Danh sách tài khoản
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
												<th>ID</th>
												<th>Họ và tên</th>
												<th>Email</th>
												<th>Mật khẩu</th>
												<th>Địa chỉ</th>
												<th>Số điện thoại</th>
												<th>Quyền Quản trị</th>
												<th>Quyền Bán Xe</th>
												<th>Chức năng</th>
											</tr>
										</thead>
										<tbody>


											<c:forEach items="${list}" var="u">
												<tr>
													<td>${u.userId}</td>
													<td>${u.userName}</td>
													<td>${u.email}</td>
													<td>${u.password}</td>
													<td>${u.phone}</td>
													<td>${u.address}</td>
													<td><c:if test="${u.isAdmin == 1}">Có</c:if> <c:if
															test="${u.isAdmin == 0}">Không</c:if><a
														href="admin-changeadmin?uid=${u.userId}" class="mr-25"
														data-toggle="tooltip" data-original-title="Đổi quyền">
															<i class="icon-pencil"></i>
													</a></td>

													<td><c:if test="${u.isDealer == 1}">Có</c:if> <c:if
															test="${u.isDealer == 0}">Không</c:if> <a
														href="admin-changedealer?uid=${u.userId}" class="mr-25"
														data-toggle="tooltip" data-original-title="Đổi quyền">
															<i class="icon-pencil"></i>
													</a></td>

													<td><a href="admin-deleteuser?uid=${u.userId}"
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
														href="admin-user?index=${tag - 1}"><i
															class="ion ion-ios-arrow-round-back"></i></a></li>
												</c:if>
												<c:forEach end="${endP}" begin="1" var="i">
													<li class="page-item ${tag==i?"active":""}"><a
														class="page-link" href="admin-user?index=${i}">${i}</a></li>
												</c:forEach>
												<c:if test="${tag < endP}">
													<li class="page-item"><a class="page-link"
														href="admin-user?index=${tag + 1}"><i
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


</div>