
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Filter-Form -->
<!-- /Filter-Form -->

<!-- About -->
<section class="about-us-section section-padding">
	<div class="container">
		<div class="section-header text-center">
			<h2>
				Chào mừng tới với<span> CarForYou</span>
			</h2>
			<p>Bạn sẽ tìm được những chiếc xe mà bạn mơ ước với mức giá hợp
				lý nhất.</p>
		</div>
		<div class="row">
			<div class="col-lg-6 col-sm-6">
				<div class="looking-car">
					<div class="looking-cat-image">
						<img src="templates/assets/images/car1.png" alt="Image" />
					</div>
					<div class="looking-car-content">
						<h3>
							Xem<span> Xe cũ?</span>
						</h3>
						<p>Những chiếc xe đã qua sử dụng nhưng còn rất mới.</p>
						<a href="product?type=used&&sort=no&&index=1" class="btn">Xem
							danh sách<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
						</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-sm-6">
				<div class="looking-car">
					<div class="looking-cat-image">
						<img src="templates/assets/images/car2.png" alt="Image" />
					</div>
					<div class="looking-car-content">
						<h3>
							Xem <span>Xe mới?</span>
						</h3>
						<p>Những chiếc xe mới chưa lăn bánh với giá hợp lý.</p>
						<a href="product?type=new&&sort=no&&index=1" class="btn">Xem
							danh sách<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /About -->

<!-- Resent Cat-->
<section class="section-padding gray-bg">
	<div class="container">
		<div class="section-header text-center">
			<h2>
				Tìm kiếm Xe<span> hợp lý cho bạn</span>
			</h2>
			<p>The best or nothing.</p>
		</div>
		<div class="row">

			<!-- Nav tabs -->
			<div class="recent-tab">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#resentnewcar"
						role="tab" data-toggle="tab">Xe mới</a></li>
					<li role="presentation"><a href="#resentusecar" role="tab"
						data-toggle="tab">Xe cũ</a></li>
				</ul>
			</div>
			<!-- Recently Listed New Cars -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="resentnewcar">
					<c:forEach items="${top6new}" var="t">
						<div class="col-list-3">
							<div class="recent-car-list">
								<div class="car-info-box">
									<img src="uploads/product/${t.image}" class="cover"
										alt="MDN Logo" width="355px" height="250px">
									<ul>
										<li><i class="fa fa-road" aria-hidden="true"></i>${t.totalKm}
											km</li>
										<li><i class="fa fa-calendar" aria-hidden="true"></i>năm
											${t.yearModel}</li>
										<li><i class="fa fa-map-marker" aria-hidden="true"></i>${t.localtion}</li>
									</ul>
								</div>
								<div class="featured-car-content">
									<h6>
										<a href="productdetail?pid=${t.productId}">${t.brand.brandName}
											${t.pName}</a>
									</h6>
									<div class="price_info">
										<p class="featured-price">
											<fmt:setLocale value="vi_VN" />
											<fmt:formatNumber value="${t.price}" type="currency" />
										</p>
										<div class="car-location">
											<span><i class="fa fa-map-marker" aria-hidden="true"></i>
												${t.localtion}</span>
										</div>

									</div>
									<div class="inventory_info_m">
										<div class="row">
											<p>Cửa hàng: ${t.dealer.dName}.</p>
											<p>SĐT: ${t.dealer.dPhone}.</p>
											<div class="view_profile">
												<a href="add?pid=${t.productId}" class="btn btn-xs outline">Lưu
													thông tin</a>
											</div>
										</div>

									</div>

								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<!-- Recently Listed Used Cars -->
				<div role="tabpanel" class="tab-pane" id="resentusecar">
					<c:forEach items="${top6used}" var="t">
						<div class="col-list-3">
							<div class="recent-car-list">
								<div class="car-info-box">
									<img src="uploads/product/${t.image}" class="cover"
										alt="MDN Logo" width="355px" height="250px">
									<ul>
										<li><i class="fa fa-road" aria-hidden="true"></i>${t.totalKm}
											km</li>
										<li><i class="fa fa-calendar" aria-hidden="true"></i>năm
											${t.yearModel}</li>
										<li><i class="fa fa-map-marker" aria-hidden="true"></i>${t.localtion}</li>
									</ul>
								</div>
								<div class="featured-car-content">
									<h6>
										<a href="productdetail?pid=${t.productId}">${t.brand.brandName}
											${t.pName}</a>
									</h6>
									<div class="price_info">
										<p class="featured-price">
											<fmt:setLocale value="vi_VN" />
											<fmt:formatNumber value="${t.price}" type="currency" />
										</p>
										<div class="car-location">
											<span><i class="fa fa-map-marker" aria-hidden="true"></i>
												${t.localtion}</span>
										</div>
									</div>
									<div class="inventory_info_m">
										<div class="row">
											<p>Cửa hàng: ${t.dealer.dName}.</p>
											<p>SĐT: ${t.dealer.dPhone}.</p>
											<div class="view_profile">
												<a href="add?pid=${t.productId}" class="btn btn-xs outline">Lưu
													thông tin</a>
											</div>
										</div>

									</div>
								</div>

							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Resent Cat -->


<!--Featured Car-->
<section class="section-padding">
	<div class="container">
		<div class="section-header text-center">
			<h2>
				Những chiếc xe<span> Tốt nhất</span>
			</h2>
			<p>The best car for Car for you .</p>
		</div>
		<div class="row">
			<c:forEach items="${special}" var="s">
				<div class="col-list-3">
					<div class="featured-car-list">
						<div class="featured-car-img">
							<img src="uploads/product/${s.image}" class="cover"
								alt="MDN Logo" width="355px" height="250px">
							<div class="label_icon">${s.typeCar}</div>
						</div>
						<div class="featured-car-content">
							<h6>
								<a href="productdetail?pid=${s.productId}">${s.brand.brandName}
									${s.pName}</a>
							</h6>
							<div class="price_info">
								<p class="featured-price">
									<fmt:setLocale value="vi_VN" />
									<fmt:formatNumber value="${s.price}" type="currency" />
								</p>
								<div class="car-location">
									<span><i class="fa fa-map-marker" aria-hidden="true"></i>
										${s.localtion}</span>
								</div>
							</div>
							<ul>
								<li><i class="fa fa-road" aria-hidden="true"></i>${s.totalKm}
									km</li>
								<li><i class="fa fa-tachometer" aria-hidden="true"></i>${s.transmission}</li>
								<li><i class="fa fa-calendar" aria-hidden="true"></i>năm
									${s.yearModel}</li>
								<li><i class="fa fa-car" aria-hidden="true"></i>${s.fuelType}</li>
								<li><i class="fa fa-user" aria-hidden="true"></i>${s.seats}
									chỗ</li>
								<li><i class="fa fa-superpowers" aria-hidden="true"></i>${s.engine}
									kW</li>
							</ul>
						</div>
						<div class="inventory_info_m">

							<p>Cửa hàng: ${s.dealer.dName}.</p>
							<p>SĐT: ${s.dealer.dPhone}.</p>
							<div class="view_profile">
								<a href="add?pid=${s.productId}" class="btn btn-xs outline">Lưu
									thông tin</a>
							</div>


						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- /Featured Car-->
<!--Brands-->
<!-- /Brands-->

<!--Footer -->
<!-- /Footer-->

<!--Back to top-->
<!--/Back to top-->

<!--Login-Form -->
<!--/Login-Form -->

<!--Register-Form -->
<!--/Register-Form -->

<!--Forgot-password-Form -->
<!--/Forgot-password-Form -->
