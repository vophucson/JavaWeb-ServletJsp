<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="listing-detail">
	<div class="container">
		<div class="listing_detail_head row">
			<div class="col-md-9">
				<h2>${detail.brand.brandName} ${detail.pName}-${detail.typeCar}</h2>
				<div class="car-location">
					<span><i class="fa fa-map-marker" aria-hidden="true"></i>
						${detail.localtion}</span>
				</div>
			</div>
			<div class="col-md-3">
				<div class="price_info">
					<p>
						<fmt:setLocale value="vi_VN" />
						<fmt:formatNumber value="${detail.price}" type="currency" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-9">
				<div class="main_features">
					<ul>
						<li><i class="fa fa-tachometer" aria-hidden="true"></i>
							<h5>${detail.totalKm}</h5>
							<p>Tổng Km đã đi</p></li>
						<li><i class="fa fa-calendar" aria-hidden="true"></i>
							<h5>${detail.yearModel}</h5>
							<p>Năm sản xuất</p></li>
						<li><i class="fa fa-cogs" aria-hidden="true"></i>
							<h5>${detail.fuelType}</h5>
							<p>Loại nhiên liệu</p></li>
						<li><i class="fa fa-power-off" aria-hidden="true"></i>
							<h5>${detail.transmission}</h5>
							<p>Hộp số</p></li>
						<li><i class="fa fa-superpowers" aria-hidden="true"></i>
							<h5>${detail.engine}KW</h5>
							<p>Động cơ</p></li>
						<li><i class="fa fa-user-plus" aria-hidden="true"></i>
							<h5>${detail.seats}</h5>
							<p>Chỗ ngồi</p></li>
					</ul>
				</div>
				<div class="listing_more_info">
					<div class="listing_detail_wrap">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs gray-bg" role="tablist">
							<li role="presentation" class="active"><a
								href="#vehicle-overview " aria-controls="vehicle-overview"
								role="tab" data-toggle="tab">Mô tả </a></li>

							<!-- Tab panes -->

							<div class="tab-content">
								<!-- vehicle-overview -->
								<div role="tabpanel" class="tab-pane active"
									id="vehicle-overview">

									<p>${detail.des}.</p>
								</div>

								<!-- Technical-Specification -->

							</div>


							<!-- Accessories -->

						</ul>
					</div>

					<!--Vehicle-Video-->
					<div id="listing_images_slider" class="listing_images_slider">
						<div>
							<img src="uploads/product/${detail.image}" class="cover"
								alt="MDN Logo" width="850px" height="550px">
						</div>
					</div>

					<!--Comment-Form-->
					<!--/Comment-Form-->

				</div>

			</div>

			<!--Side-Bar-->
			<aside class="col-md-3">
				<div class="view_profile">
					<a href="add?pid=${detail.productId}" class="btn btn-xs outline">Lưu
						thông tin</a>
				</div>

				<div class="share_vehicle">
					<p>
						Chia sẻ: <a href="#"><i class="fa fa-facebook-square"
							aria-hidden="true"></i></a> <a href="#"><i
							class="fa fa-twitter-square" aria-hidden="true"></i></a> <a href="#"><i
							class="fa fa-linkedin-square" aria-hidden="true"></i></a> <a href="#"><i
							class="fa fa-google-plus-square" aria-hidden="true"></i></a>
					</p>
				</div>

				<div class="sidebar_widget">
					<div class="widget_heading">
						<h5>
							<i class="fa fa-address-card-o" aria-hidden="true"></i> Thông tin
							đại lý
						</h5>
					</div>
					<div class="dealer_detail">
						<img src="uploads/store/${detail.dealer.dImage}" class="cover"
							alt="MDN Logo" width="100px" height="100px">
						<p>
							<span>Tên:</span>${detail.dealer.dName}</p>
						<p>
							<span>Email:</span>${detail.dealer.dEmail}</p>
						<p>
							<span>SĐT:</span>${detail.dealer.dPhone}</p>
						<p>
							<span>Địa chỉ:</span>${detail.dealer.dAddress}</p>
						<a href="dealerdetail?dealerid=${detail.dealer.dealerId}&&index=1"
							class="btn btn-xs">Xem hồ sơ</a>
					</div>
				</div>
				<div class="sidebar_widget">
					<div class="widget_heading">
						<h5>
							<i class="fa fa-envelope" aria-hidden="true"></i> Gửi tin nhắn
							tới đại lý
						</h5>
					</div>
					<form action="sendmail" method="POST">
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Nhập họ và tên" name="subject">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="Email"
								name="to" value="${detail.dealer.dEmail}">
						</div>
						<div class="form-group">
							<textarea rows="4" class="form-control"
								placeholder="Nhập tin nhắn và cách thức liên hệ.Để đại lý liên hệ với bạn "
								name="content"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" value="Gửi tin nhắn" class="btn btn-block">
						</div>
					</form>
				</div>
			</aside>
			<!--/Side-Bar-->
		</div>

		<div class="space-20"></div>
		<div class="divider"></div>

		<!--Similar-Cars-->
		<div class="similar_cars">
			<h3>Những xe khác của ${detail.dealer.dName}</h3>
			<div class="row">
				<c:forEach items="${top4}" end="3" var="t">
					<div class="col-md-3 grid_listing">
						<div class="product-listing-m gray-bg">
							<div class="product-listing-img">
								<img src="uploads/product/${t.image}" class="cover"
									alt="MDN Logo" width="300px" height="180px">
								<div class="label_icon">${t.typeCar}</div>

							</div>
							<div class="product-listing-content">
								<h5>
									<a href="productdetail?pid=${t.productId}">${t.brand.brandName}
										${t.pName}</a>
								</h5>
								<p class="list-price">
									<fmt:setLocale value="vi_VN" />
									<fmt:formatNumber value="${t.price}" type="currency" />
								</p>
								<div class="car-location">
									<span><i class="fa fa-map-marker" aria-hidden="true"></i>
										${t.localtion}</span>
								</div>
								<ul class="features_list">
									<li><i class="fa fa-road" aria-hidden="true"></i>${t.totalKm}
										km</li>
									<li><i class="fa fa-tachometer" aria-hidden="true"></i>${t.transmission}</li>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>năm
										${t.yearModel}</li>
									<li><i class="fa fa-car" aria-hidden="true"></i>${t.fuelType}</li>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
		<!--/Similar-Cars-->

	</div>
</section>