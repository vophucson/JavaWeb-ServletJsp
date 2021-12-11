
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="hk-pg-wrapper">
	<!-- Breadcrumb -->
	<nav class="hk-breadcrumb" aria-label="breadcrumb">
		<ol class="breadcrumb breadcrumb-light bg-transparent">
			<li class="breadcrumb-item"><a href="#">Quản lý bài đăng</a></li>
			<li class="breadcrumb-item active" aria-current="page">Danh sách
				bài đăng chưa duyệt</li>
		</ol>
	</nav>
	<!-- /Breadcrumb -->

	<!-- Container -->
	<div class="container">
		<!-- Title -->
		<div class="hk-pg-header">
			<h4 class="hk-pg-title">
				<span class="pg-title-icon"><span class="feather-icon"><i
						data-feather="archive"></i></span></span>Danh sách bài đăng chưa duyệt
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
												<th>Kiểm tra bài đăng</th>
												<th>Cửa hàng đăng bài</th>
												<th>Tình Trạng</th>

												<th>Chức năng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="l">
												<tr>
													<td>${l.productId}</td>
													<td>
														<h6>
															<a href="productdetail?pid=${l.productId}"
																target="_blank">${l.brand.brandName}-${l.pName}</a>
														</h6>
													</td>
													<td>${l.dealer.dName}</td>
													<td>Chưa Duyệt <a
														href="admin-changenopass?pid=${l.productId}" class="mr-25"
														data-toggle="tooltip" data-original-title="Duyệt bài đăng">
															<i class="icon-pencil"></i>
													</a>
													</td>
													<td><a
														href="admin-deletepostnopass?pid=${l.productId}"
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
														href="admin-postcarnopass?index=${tag - 1}"><i
															class="ion ion-ios-arrow-round-back"></i></a></li>
												</c:if>
												<c:forEach end="${endP}" begin="1" var="i">
													<li class="page-item ${tag==i?"active":""}"><a
														class="page-link" href="admin-postcarnopass?index=${i}">${i}</a></li>
												</c:forEach>
												<c:if test="${tag < endP}">
													<li class="page-item"><a class="page-link"
														href="admin-postcarnopass?index=${tag + 1}"><i
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