<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="dealer_profile inner_pages">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-4">
				<div class="dealer_logo">
					<img src="uploads/store/${detail.dImage}" class="cover"
						alt="MDN Logo" width="222px" height="172px">
				</div>
			</div>
			<div class="col-md-6 col-sm-5 col-xs-8">
				<div class="dealer_info">
					<h4>${detail.dName}</h4>
					<p>${detail.dAddress}</p>
					<ul class="dealer_social_links">
						<li class="facebook-icon"><a href="#"><i
								class="fa fa-facebook-square" aria-hidden="true"></i></a></li>
						<li class="twitter-icon"><a href="#"><i
								class="fa fa-twitter-square" aria-hidden="true"></i></a></li>
						<li class="linkedin-icon"><a href="#"><i
								class="fa fa-linkedin-square" aria-hidden="true"></i></a></li>
						<li class="google-plus-icon"><a href="#"><i
								class="fa fa-google-plus-square" aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-3 col-sm-4 col-xs-12">
				<div class="dealer_contact_info gray-bg">
					<h6>
						<i class="fa fa-envelope" aria-hidden="true"></i> Địa chỉ Email
					</h6>
					<a href="mailto:contact@example.com">${detail.dEmail}</a>
				</div>
				<div class="dealer_contact_info gray-bg">
					<h6>
						<i class="fa fa-phone" aria-hidden="true"></i> Số điện thoại
					</h6>
					<a href="tel:61-1234-5678-09">${detail.dPhone}</a>
				</div>
			</div>
		</div>
		<div class="space-60"></div>
		<div class="row">
			<div class="col-md-9">
				<div class="dealer_more_info">
					<h5 class="gray-bg info_title">Giới thiệu về ${detail.dName}</h5>
					<p>${detail.dInfo}.</p>
					<div class="dealer_listings">
						<h6>Danh sách xe đang bán</h6>
						<div class="row">
							<c:forEach items="${listP}" var="p">
								<div class="col-md-4 grid_listing">
									<div class="product-listing-m gray-bg">
										<div class="product-listing-img">
											<img src="uploads/product/${p.image}" class="cover"
												alt="MDN Logo" width="300px" height="180px">
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
											<div class="car-location">
												<span><i class="fa fa-map-marker" aria-hidden="true"></i>
													${p.localtion}</span>
											</div>
											<ul class="features_list">
												<li><i class="fa fa-road" aria-hidden="true"></i>${p.totalKm}
													km</li>
												<li><i class="fa fa-tachometer" aria-hidden="true"></i>${p.transmission}</li>
												<li><i class="fa fa-calendar" aria-hidden="true"></i>năm
													${p.yearModel}</li>
												<li><i class="fa fa-car" aria-hidden="true"></i>${p.fuelType}</li>
											</ul>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="pagination">
							<ul>
								<c:forEach begin="1" end="${endP}" var="i">
									<a href="dealerdetail?dealerid=${detail.dealerId}&&index=${i}">
										<li class="${tag ==i?"current":""}">${i}</li>
									</a>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<aside class="col-md-3">
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
								name="to" value="${detail.dEmail}">
						</div>
						<div class="form-group">
							<textarea rows="4" class="form-control"
								placeholder="Nhập tin nhắn và cách thức liên hệ.Để cửa hàng liên hệ với bạn "
								name="content"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" value="Gửi tin nhắn" class="btn btn-block">
						</div>
					</form>
				</div>
			</aside>
		</div>
	</div>
</section>
</html>