<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="user_profile inner_pages">
	<div class="container">
		<div class="row">
			<%@include file="leftbar.jsp"%>
			<div class="col-md-6 col-sm-8">
				<div class="profile_wrap">
					<h5 class="uppercase underline">Đăng bài mới</h5>
					<c:choose>
						<c:when test="${dinfo.isPass == 0}">
							<p class="text-danger text-center">Cửa hàng bạn chưa được
								duyệt. Nên chưa có quyền đăng bài</p>
						</c:when>
						<c:otherwise>
							<p class="text-danger text-center">${mess}</p>
							<form action="store-postcar" " method="POST"
								enctype="multipart/form-data" accept-charset="UTF-8">
								<div class="form-group">
									<label class="control-label">Tên xe</label> <input
										class="form-control white_bg" id="VehiclesTitle" type="text"
										name="productname" placeholder="Nhập tên xe">
								</div>
								<div class="form-group">
									<label class="control-label">Giá xe (Vnđ)</label> <input
										class="form-control white_bg" id="Price" type="text"
										name="price" placeholder="Nhập giá xe">
								</div>
								<div class="form-group">
									<label class="control-label">Chọn hình ảnh</label>
									<div class="vehicle_images">
										<div class="upload_more_img">
											<input name="imagelink" type="file">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label">Thương hiệu</label>
									<div class="select">
										<select class="form-control white_bg" name="brandid">
											<option value="0">Chọn thương hiệu</option>
											<c:forEach items="${brand}" var="b">
												<option value="${b.brandId}">${b.brandName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label">Tổng Km đã đi</label> <input
										class="form-control white_bg" id="year" type="text"
										name="totalkm" placeholder="Nhập tổng km đã đi">
								</div>
								<div class="form-group">
									<label class="control-label">Động cơ (Kw)</label> <input
										class="form-control white_bg" id="VehiclesTitle" type="text"
										name="engine" placeholder="Nhập mã lực của động cơ(Kw)">
								</div>
								<div class="form-group">
									<label class="control-label">Năm sản xuất</label> <input
										class="form-control white_bg" id="year" type="text"
										name="yearmodel" placeholder="Nhập năm sản xuất">
								</div>
								<div class="form-group">
									<label class="control-label">Loại nhiên liệu</label>
									<div class="select">
										<select class="form-control white_bg" name="fueltype">
											<option value="0">Chọn loại nhiên liệu</option>
											<option value="Xăng">Xăng</option>
											<option value="Diesel">Diesel</option>
											<option value="Hybird">Hybird</option>
											<option value="Điện">Điện</option>
											<option value="Pin nhiên liệu">Pin nhiên liệu</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label">Hộp số</label>
									<div class="select">
										<select class="form-control white_bg" name="transmission">
											<option value="0">Chọn hộp số</option>
											<option value="Sàn">Hộp số sàn</option>
											<option value="Tự động">Hộp số tự động</option>
											<option value="CVT">Hộp số CVT</option>
											<option value="DCT">Hộp số DCT</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label">Chỗ ngồi</label>
									<div class="select">
										<select class="form-control white_bg" name="seats">
											<option value="0">Chọn chỗ ngồi</option>
											<option value="2">2</option>
											<option value="4">4</option>
											<option value="6">6</option>
											<option value="8">8</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label">Khu vực</label>
									<div class="select">
										<select class="form-control white_bg" name="localtion">
											<option value="0">Chọn khu vực</option>
											<option value="Hồ Chí Minh">Hồ Chí Minh</option>
											<option value="Hà Nội">Hà Nội</option>
											<option value="Đà Nẵng">Đà Nẵng</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label">Chi tiết về xe</label>
									<textarea class="form-control white_bg" rows="6"
										placeholder="Nhập thông tin chi tiết về xe" name="description"></textarea>
								</div>
								<div class="form-group">
									<label class="control-label">Loại xe</label>
									<div class="vehicle_type">
										<div class="form-group radio col-md-6 accessories_list">
											<input type="radio" name="typecar" value="Mới" id="newcar">
											<label for="newcar">Xe mới</label>
										</div>
										<div class="form-group radio col-md-6 accessories_list">
											<input type="radio" name="typecar" value="Cũ" id="usedcar">
											<label for="usedcar">Xe cũ</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn">
										Đăng bài <span class="angle_arrow"><i
											class="fa fa-angle-right" aria-hidden="true"></i></span>
									</button>
								</div>
							</form>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</section>