<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="user_profile inner_pages">
	<div class="container">
		<div class="row">
			<%@include file="leftbar.jsp"%>
			<div class="col-md-6 col-sm-8">
				<div class="profile_wrap">
					<h5 class="uppercase underline">Tạo hoặc Chỉnh sử thông tin
						gian hàng</h5>
					<c:if test="${dInfo != null}">
						<p class="text-danger text-center">Bạn đã có gian hàng vui lòng
							nhập thông tin muốn thay đổi</p>
					</c:if>
					<c:if test="${dInfo == null}">
						<p class="text-danger text-center">Bạn chưa có gian hàng vui
							lòng nhập thông tin để tạo</p>
					</c:if>
					<form action="store-setting" method="POST"
						enctype="multipart/form-data" accept-charset="UTF-8">
						<p class="text-danger">${mess}</p>
						<c:if test="${dInfo.dImage != null}">
							<div class="form-group">
								<label class="control-label">Ảnh đại diện cũ</label>
								<div class="vehicle_images">
									<img src="uploads/store/${dInfo.dImage}" class="cover"
										alt="MDN Logo" width="222px" height="172px">
								</div>
							</div>
						</c:if>
						<div class="form-group">
							<label class="control-label">Cập nhật ảnh đại diện</label>
							<div class="vehicle_images">
								<div class="upload_more_img">
									<input name="upload" type="file">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Tên gian hàng</label> <input
								class="form-control white_bg" id="VehiclesTitle" type="text"
								placeholder="Nhập tên cửa hàng" value="${dInfo.dName}"
								name="dname">
						</div>
						<div class="form-group">
							<label class="control-label">Địa chỉ email</label> <input
								class="form-control white_bg" id="VehiclesTitle" type="text"
								placeholder="Nhập tên email cửa hàng" value="${dInfo.dEmail}"
								name="demail">
						</div>
						<div class="form-group">
							<label class="control-label">Số điện thoại</label> <input
								class="form-control white_bg" id="VehiclesTitle" type="text"
								placeholder="Nhập tên số điện thoại cửa hàng"
								value="${dInfo.dPhone}" name="dphone">
						</div>
						<div class="form-group">
							<label class="control-label">Giới thiệu gian hàng</label>
							<textarea class="form-control white_bg" rows="4"
								placeholder="Nhập giới thiệu cửa hàng" name="dinfo">${dInfo.dInfo}</textarea>
						</div>
						<div class="form-group">
							<label class="control-label">Địa chỉ</label>
							<textarea class="form-control white_bg" rows="2"
								placeholder="Nhập địa chỉ cửa hàng" name="address">${dInfo.dAddress}</textarea>
						</div>
						<div class="form-group">
							<button type="submit" class="btn">
								Cập nhật <span class="angle_arrow"><i
									class="fa fa-angle-right" aria-hidden="true"></i></span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>