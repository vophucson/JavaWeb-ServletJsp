<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="inner_pages">
	<div class="container">
		<div class="result-sorting-wrapper">
			<div class="result-sorting-by">
				<p>Các bài đã lưu</p>
			</div>
		</div>
		<div class="dealers_list_wrap">
			<c:forEach items="${list}" var="l">
				<div class="dealers_listing">
					<div class="row">
						<div class="col-sm-3 col-xs-4">
							<div class="dealer_logo">
								<img src="uploads/product/${l.image}" class="cover"
									alt="MDN Logo" width="300px" height="180px">
							</div>
						</div>
						<div class="col-sm-6 col-xs-8">
							<div class="dealer_info">
								<h5>
									<a href="productdetail?pid=${l.productId}">${l.brand.brandName}
										${l.pName}-${l.typeCar}</a>

								</h5>
								<div class="price_info">
									<p class="featured-price">
										<fmt:setLocale value="vi_VN" />
										<fmt:formatNumber value="${l.price}" type="currency" />
									</p>
									<div class="car-location">
										<span><i class="fa fa-map-marker" aria-hidden="true"></i>
											${l.localtion}</span>
									</div>
								</div>
								<ul>
									<li><i class="fa fa-road" aria-hidden="true"></i>${l.totalKm}
										km</li>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>năm
										${l.yearModel}</li>
								</ul>
								<p>Cửa hàng: ${l.dealer.dName}</p>
								<p>SĐT: ${l.dealer.dPhone}</p>
							</div>
						</div>
						<div class="col-sm-3 col-xs-12">
							<div class="view_profile">
								<a href="removec?pid=${l.productId}" class="btn btn-xs outline">Xóa
									thông tin</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>