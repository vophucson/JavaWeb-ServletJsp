<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="user_profile inner_pages">
	<div class="row">
		<%@include file="leftbar.jsp"%>
		<div class="col-md-6 col-sm-8">
			<div class="profile_wrap">
				<h5 class="uppercase underline">
					DANH SÁCH BÀI ĐĂNG<span>(${count} bài)</span>
				</h5>
				<div class="my_vehicles_list">
					<ul class="vehicle_listing">
						<c:forEach items="${list}" var="l">
							<li class="${l.isPass == 0?"deactive_vehicle":""}">
								<div class="vehicle_img">
									<img src="uploads/product/${l.image}" class="cover"
										alt="MDN Logo" width="150x" height="120px">
								</div>
								<div class="vehicle_title">
									<h6>
										<a href="productdetail?pid=${l.productId}">${l.brand.brandName}
											${l.pName}</a>
									</h6>
								</div>
								<div class="vehicle_status">
									<a href="#" class="btn outline btn-xs ${l.isPass == 1?"active-btn":""}">
										<c:if test="${l.isPass == 1}">Đã duyệt</c:if> <c:if
											test="${l.isPass == 0}">Chưa duyệt</c:if>
									</a>
									<div class="clearfix"></div>
									<a href="store-editpost?pid=${l.productId}"><i
										class="fa fa-pencil-square-o" aria-hidden="true"
										title="Chỉnh sửa"></i></a> <a
										href="store-deletepost?pid=${l.productId}"><i
										class="fa fa-trash" aria-hidden="true" title="Xóa bài đăng"></i></a>
								</div>
							</li>
						</c:forEach>

					</ul>
					<div class="pagination">
						<ul>
							<c:forEach begin="1" end="${endP}" var="i">
								<a href="store-listcar?index=${i}">
									<li class="${tagindex ==i?"current":""}">${i}</li>
								</a>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>