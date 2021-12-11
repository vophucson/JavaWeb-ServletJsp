<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="user_profile inner_pages">
	<div class="container">
		<div class="row">
			<%@include file="leftbar.jsp"%>
			<div class="col-md-6 col-sm-8">
				<div class="profile_wrap">
					<h5 class="uppercase underline">Xem và chỉnh sửa thông tin tài
						khoản</h5>
					<form action="editprofile" " method="post">
						<input type="hidden" value="${user.userId}" name="userid">
						<div class="form-group">
							<label class="control-label">Họ và tên</label> <input
								class="form-control white_bg" id="fullname" type="text"
								placeholder="Nhập họ và tên" value="${user.userName}"
								name="name">
						</div>
						<div class="form-group">
							<label class="control-label">Số điện thoại</label> <input
								class="form-control white_bg" id="phone-number" type="text"
								placeholder="Nhập số điện thoại" value="${user.phone}"
								name="phone">
						</div>
						<div class="form-group">

							<label class="control-label">Địa chỉ</label> <input
								class="form-control white_bg" id="fullname" type="text"
								placeholder="Nhập địa chỉ" value="${user.address}"
								name="address">
						</div>
						<div class="form-group">
							<button type="submit" class="btn">
								Lưu thay đổi <span class="angle_arrow"><i
									class="fa fa-angle-right" aria-hidden="true"></i></span>
							</button>
						</div>
					</form>

					<div class="gray-bg field-title">
						<h6>Thay đổi mật khẩu</h6>
					</div>
					<form action="profile-setting" method="post">
						<p class="text-danger text-center">${mess}</p>
						<div class="form-group">
							<label class="control-label">Mật khẩu cũ</label> <input
								class="form-control white_bg" id="password" type="password"
								name="oldpass">
						</div>
						<div class="form-group">
							<label class="control-label">Mật khẩu mới</label> <input
								class="form-control white_bg" id="password" type="password"
								name="newpass">
						</div>
						<div class="form-group">
							<label class="control-label">Nhập lại mật khẩu</label> <input
								class="form-control white_bg" id="c-password" type="password"
								name="confrim">
						</div>
						<div class="form-group">
							<button type="submit" class="btn">
								Thay đổi mật khẩu <span class="angle_arrow"><i
									class="fa fa-angle-right" aria-hidden="true"></i></span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>