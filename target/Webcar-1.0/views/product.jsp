<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="listing-page">
	<div class="container">
		<div class="row">
			<div class="col-md-9 col-md-push-3">
				<div class="result-sorting-wrapper">
					<div class="result-sorting-by">
						<p>Sắp xếp:</p>
						<form action="product" method="get" name="test">
							<div class="form-group select sorting-select">
								<input type="hidden" value="${type}" name="type"> <input
									type="hidden" value="${tag}" name="index"> <input
									type="hidden" value="${pname}" name="pname"> <input
									type="hidden" value="${bid}" name="bid"> <select
									class="form-control" name="sort"
									onchange="javascript:document.test.submit();">
									<c:if test="${sort == 'no'}">
										<option value="no">Mặc định</option>
										<option value="lowtotop">Giá (thấp đến cao)</option>
										<option value="toptolow">Giá (cao xuống thấp)</option>
									</c:if>
									<c:if test="${sort == 'lowtotop'}">
										<option value="lowtotop">Giá (thấp đến cao)</option>
										<option value="toptolow">Giá (cao xuống thấp)</option>
										<option value="no">Mặc định</option>
									</c:if>
									<c:if test="${sort == 'toptolow'}">
										<option value="toptolow">Giá (cao xuống thấp)</option>
										<option value="lowtotop">Giá (thấp đến cao)</option>
										<option value="no">Mặc định</option>
									</c:if>
								</select>
							</div>
						</form>
					</div>
				</div>
				<c:forEach items="${listP}" var="p">
					<div class="product-listing-m gray-bg">
						<div class="product-listing-img">
							<img src="uploads/product/${p.image}" class="cover"
								alt="MDN Logo" width="390px" height="250px">
							<div class="label_icon">${p.typeCar}</div>
						</div>
						<div class="product-listing-content">
							<h5>
								<a href="productdetail?pid=${p.productId}">${p.brand.brandName}
									${p.pName}</a>
							</h5>
							<p class="list-price">
								<fmt:setLocale value="vi_VN" />
								<fmt:formatNumber value="${p.price}" type="currency" />
							</p>
							<ul>
								<li><i class="fa fa-road" aria-hidden="true"></i>${p.totalKm}
									km</li>
								<li><i class="fa fa-tachometer" aria-hidden="true"></i>${p.transmission}</li>
								<li><i class="fa fa-user" aria-hidden="true"></i>${p.seats}
									chỗ</li>
								<li><i class="fa fa-calendar" aria-hidden="true"></i>năm
									${p.yearModel}</li>
								<li><i class="fa fa-car" aria-hidden="true"></i>${p.fuelType}</li>
								<li><i class="fa fa-superpowers" aria-hidden="true"></i>${p.engine}
									kW</li>
							</ul>
							<a href="productdetail?pid=${p.productId}" class="btn">Chi
								Tiết <span class="angle_arrow"><i
									class="fa fa-angle-right" aria-hidden="true"></i></span>
							</a>
							<div class="car-location">
								<span><i class="fa fa-map-marker" aria-hidden="true"></i>
									${p.localtion}</span>
							</div>
						</div>
					</div>
				</c:forEach>

				<div class="pagination">
					<ul>
						<c:forEach begin="1" end="${endP}" var="i">
							<a
								href="product?type=${type}&&sort=${sort}&&index=${i}&&pname=${pname}&&bid=${bid}">
								<li class="${tag ==i?"current":""}">${i}</li>
							</a>
						</c:forEach>
					</ul>
				</div>
			</div>

			<!--Side-Bar-->
			<aside class="col-md-3 col-md-pull-9">
				<div class="sidebar_widget">
					<div class="widget_heading">
						<h5>
							<i class="fa fa-car" aria-hidden="true"></i> Những xe tốt nhất
						</h5>
					</div>
					<c:forEach items="${special}" var="s">
						<div class="recent_addedcars">
							<ul>
								<li class="gray-bg">
									<div class="recent_post_img">
										<img src="uploads/product/${s.image}" class="cover"
											alt="MDN Logo" width="80px" height="80px">
									</div>
									<div class="recent_post_title">
										<a href="productdetail?pid=${s.productId}">${s.brand.brandName}
											${s.pName}</a>
										<p class="widget_price"">
											<fmt:setLocale value="vi_VN" />
											<fmt:formatNumber value="${s.price}" type="currency" />
										</p>
									</div>
								</li>

							</ul>
						</div>
					</c:forEach>
				</div>
			</aside>
			<!--/Side-Bar-->
		</div>
	</div>
</section>