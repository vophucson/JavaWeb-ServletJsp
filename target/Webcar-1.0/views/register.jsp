<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header">

			<h3 class="modal-title">Đăng ký</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<div class="signup_wrap">
					<div class="col-md-6 col-sm-6">
						<p class="text-danger text-center">${mess}</p>
						<form action="register" method="post">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Họ và tên"
									name="name">
							</div>
							<div class="form-group">
								<input type="email" class="form-control"
									placeholder="Địa chỉ email" name="email">
							</div>
							<div class="form-group">
								<input type="password" class="form-control"
									placeholder="Mật khẩu" name="pass">
							</div>
							<div class="form-group">
								<input type="password" class="form-control"
									placeholder="Nhập lại mật khẩu" name="repass">
							</div>
							<div class="form-group">
								<input type="submit" value="Đăng ký" class="btn btn-block">
							</div>
						</form>
					</div>
					<div class="col-md-6 col-sm-6">
						<h6 class="gray_text">Đăng nhập cách khác</h6>
						<a href="#" class="btn btn-block facebook-btn"><i
							class="fa fa-facebook-square" aria-hidden="true"></i> Đăng nhập
							với Facebook</a> <a href="#" class="btn btn-block twitter-btn"><i
							class="fa fa-twitter-square" aria-hidden="true"></i> Đăng nhập
							với Twitter</a> <a href="#" class="btn btn-block googleplus-btn"><i
							class="fa fa-google-plus-square" aria-hidden="true"></i> Đăng
							nhập với Google+</a>
					</div>
					<div class="mid_divider"></div>
				</div>
			</div>
		</div>
		<div class="modal-footer text-center">
			<p>
				Bạn đã có tài khoản? <a href="login">Đăng nhập ở đây</a>
			</p>
		</div>
	</div>
</div>