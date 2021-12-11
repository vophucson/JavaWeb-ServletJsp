<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="contact_us section-padding">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h3>NỘI DUNG LIÊN HỆ</h3>
				<div class="contact_form gray-bg">
					<form action="contact" method="post">
						<p class="text-danger text-center">${mess}</p>
						<div class="form-group">
							<label class="control-label">Họ và tên <span>*</span></label> <input
								type="text" class="form-control white_bg" id="fullname"
								name="name" placeholder="Nhập họ và tên">
						</div>
						<div class="form-group">
							<label class="control-label">Địa chỉ email <span>*</span></label>
							<input type="email" class="form-control white_bg"
								id="emailaddress" name="email" placeholder="Nhập địa chỉ email">
						</div>
						<div class="form-group">
							<label class="control-label">Số điện thoại <span>*</span></label>
							<input type="text" class="form-control white_bg" id="phonenumber"
								name="phone" placeholder="Nhập số điện thoại">
						</div>
						<div class="form-group">
							<label class="control-label">Tin nhắn <span>*</span></label>
							<textarea class="form-control white_bg" rows="4"
								placeholder="Nhập tin nhắn" name="content"></textarea>
						</div>
						<div class="form-group">
							<button class="btn" type="submit">
								Gửi tin nhắn <span class="angle_arrow"><i
									class="fa fa-angle-right" aria-hidden="true"></i></span>
							</button>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-6">
				<h3>Thông tin liên lạc</h3>
				<div class="contact_detail">
					<ul>
						<li>
							<div class="icon_wrap">
								<i class="fa fa-map-marker" aria-hidden="true"></i>
							</div>
							<div class="contact_info_m">${info.address}</div>
						</li>
						<li>
							<div class="icon_wrap">
								<i class="fa fa-phone" aria-hidden="true"></i>
							</div>
							<div class="contact_info_m">
								<a href="tel:61-1234-567-90">${info.phone}</a>
							</div>
						</li>
						<li>
							<div class="icon_wrap">
								<i class="fa fa-envelope-o" aria-hidden="true"></i>
							</div>
							<div class="contact_info_m">
								<a href="#">${info.email}</a>
							</div>
						</li>
					</ul>
					<div class="map_wrap">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.4843009459537!2d106.76973361488574!3d10.850721392271156!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752763f23816ab%3A0x282f711441b6916f!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBTxrAgcGjhuqFtIEvhu7kgdGh14bqtdCBUaMOgbmggcGjhu5EgSOG7kyBDaMOtIE1pbmg!5e0!3m2!1svi!2s!4v1634968720446!5m2!1svi!2s"
							width="600" height="450" style="border: 0;" allowfullscreen=""
							loading="lazy"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>