<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="user_profile inner_pages">
	<div class="container">
		<div class="row">
			<%@include file="leftbar.jsp"%>
			<div class="col-md-6 col-sm-8">
				<div class="profile_wrap">
					<h5 class="uppercase underline">Chỉnh sửa thông tin bài đăng</h5>
					<p class="text-danger text-center">${mess}</p>
					<form action="store-editpost" method="POST"
						enctype="multipart/form-data" accept-charset="UTF-8">
						<input type="hidden" value="${pid}" name="pid"> <input
							type="hidden" value="${detail.image}" name="oldimage">
						<div class="form-group">
							<label class="control-label">Tên xe</label> <input
								class="form-control white_bg" id="VehiclesTitle" type="text"
								name="productname" value="${detail.pName}"
								placeholder="Nhập tên xe">
						</div>
						<div class="form-group">
							<label class="control-label">Giá xe (Vnđ)</label> <input
								class="form-control white_bg" id="Price" type="text"
								name="price" value="${detail.price}" placeholder="Nhập giá xe">
						</div>
						<div class="form-group">
							<label class="control-label">Hình ảnh cũ</label>
							<div class="vehicle_images">
								<img src="uploads/product/${detail.image}" class="cover"
									alt="MDN Logo" width="390px" height="250px">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Chọn hình ảnh mới</label>
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
									<option value="${detail.brand.brandId}">${detail.brand.brandName}</option>
									<c:forEach items="${brand}" var="b">
										<c:if test="${b.brandId != detail.brand.brandId}">
											<option value="${b.brandId}">${b.brandName}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Tổng Km đã đi</label> <input
								class="form-control white_bg" id="year" type="text"
								name="totalkm" value="${detail.totalKm}"
								placeholder="Nhập tổng km đã đi">
						</div>
						<div class="form-group">
							<label class="control-label">Động cơ (Kw)</label> <input
								class="form-control white_bg" id="VehiclesTitle" type="text"
								name="engine" value="${detail.engine}"
								placeholder="Nhập mã lực của động cơ(Kw)">
						</div>
						<div class="form-group">
							<label class="control-label">Năm sản xuất</label> <input
								class="form-control white_bg" id="year" type="text"
								name="yearmodel" value="${detail.yearModel}"
								placeholder="Nhập năm sản xuất">
						</div>
						<div class="form-group">
							<label class="control-label">Loại nhiên liệu</label>
							<div class="select">
								<select class="form-control white_bg" name="fueltype">
									<c:if test="${detail.fuelType == 'Xăng'}">
										<option value="Xăng">Xăng</option>
										<option value="Diesel">Diesel</option>
										<option value="Hybird">Hybird</option>
										<option value="Điện">Điện</option>
										<option value="Pin nhiên liệu">Pin nhiên liệu</option>
									</c:if>
									<c:if test="${detail.fuelType == 'Diesel'}">
										<option value="Diesel">Diesel</option>
										<option value="Xăng">Xăng</option>
										<option value="Hybird">Hybird</option>
										<option value="Điện">Điện</option>
										<option value="Pin nhiên liệu">Pin nhiên liệu</option>
									</c:if>
									<c:if test="${detail.fuelType == 'Hybird'}">
										<option value="Hybird">Hybird</option>
										<option value="Xăng">Xăng</option>
										<option value="Diesel">Diesel</option>
										<option value="Điện">Điện</option>
										<option value="Pin nhiên liệu">Pin nhiên liệu</option>
									</c:if>
									<c:if test="${detail.fuelType == 'Điện'}">
										<option value="Điện">Điện</option>
										<option value="Xăng">Xăng</option>
										<option value="Diesel">Diesel</option>
										<option value="Hybird">Hybird</option>
										<option value="Pin nhiên liệu">Pin nhiên liệu</option>
									</c:if>
									<c:if test="${detail.fuelType == 'Pin nhiên liệu'}">
										<option value="Pin nhiên liệu">Pin nhiên liệu</option>
										<option value="Xăng">Xăng</option>
										<option value="Diesel">Diesel</option>
										<option value="Hybird">Hybird</option>
										<option value="Điện">Điện</option>
									</c:if>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Hộp số</label>
							<div class="select">
								<select class="form-control white_bg" name="transmission">
									<c:if test="${detail.transmission == 'Sàn'}">
										<option value="Sàn">Hộp số sàn</option>
										<option value="Tự động">Hộp số tự động</option>
										<option value="CVT">Hộp số CVT</option>
										<option value="DCT">Hộp số DCT</option>
									</c:if>
									<c:if test="${detail.transmission == 'Tự động'}">
										<option value="Tự động">Hộp số tự động</option>
										<option value="Sàn">Hộp số sàn</option>
										<option value="CVT">Hộp số CVT</option>
										<option value="DCT">Hộp số DCT</option>
									</c:if>
									<c:if test="${detail.transmission == 'CVT'}">
										<option value="CVT">Hộp số CVT</option>
										<option value="Sàn">Hộp số sàn</option>
										<option value="Tự động">Hộp số tự động</option>
										<option value="DCT">Hộp số DCT</option>
									</c:if>
									<c:if test="${detail.transmission == 'DCT'}">
										<option value="DCT">Hộp số DCT</option>
										<option value="Sàn">Hộp số sàn</option>
										<option value="Tự động">Hộp số tự động</option>
										<option value="CVT">Hộp số CVT</option>
									</c:if>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Chỗ ngồi</label>
							<div class="select">
								<select class="form-control white_bg" name="seats">
									<c:if test="${detail.seats == 2}">
										<option value="2">2</option>
										<option value="4">4</option>
										<option value="6">6</option>
										<option value="8">8</option>
									</c:if>
									<c:if test="${detail.seats == 4}">
										<option value="4">4</option>
										<option value="2">2</option>
										<option value="6">6</option>
										<option value="8">8</option>
									</c:if>
									<c:if test="${detail.seats == 6}">
										<option value="6">6</option>
										<option value="2">2</option>
										<option value="4">4</option>
										<option value="8">8</option>
									</c:if>
									<c:if test="${detail.seats == 8}">
										<option value="8">8</option>
										<option value="2">2</option>
										<option value="4">4</option>
										<option value="6">6</option>
									</c:if>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Khu vực</label>
							<div class="select">
								<select class="form-control white_bg" name="localtion">
									<c:if test="${detail.localtion =='Hồ Chí Minh'}">
										<option value="Hồ Chí Minh">Hồ Chí Minh</option>
										<option value="Hà Nội">Hà Nội</option>
										<option value="Đà Nẵng">Đà Nẵng</option>
									</c:if>
									<c:if test="${detail.localtion =='Hà Nội'}">
										<option value="Hà Nội">Hà Nội</option>
										<option value="Hồ Chí Minh">Hồ Chí Minh</option>
										<option value="Đà Nẵng">Đà Nẵng</option>
									</c:if>
									<c:if test="${detail.localtion =='Đà Nẵng'}">
										<option value="Đà Nẵng">Đà Nẵng</option>
										<option value="Hồ Chí Minh">Hồ Chí Minh</option>
										<option value="Hà Nội">Hà Nội</option>
									</c:if>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Chi tiết về xe</label>
							<textarea class="form-control white_bg" rows="6"
								placeholder="Nhập thông tin chi tiết về xe" name="description">${detail.des}</textarea>
						</div>
						<div class="form-group">
							<label class="control-label">Loại xe</label>
							<div class="vehicle_type">
								<div class="form-group radio col-md-6 accessories_list">
									<input type="radio" name="typecar" value="Mới" id="newcar"
										${detail.typeCar =="Mới"?"checked":""}> <label
										for="newcar">Xe mới</label>
								</div>
								<div class="form-group radio col-md-6 accessories_list">
									<input type="radio" name="typecar" value="Cũ" id="usedcar"
										${detail.typeCar =="Cũ"?"checked":""}> <label
										for="usedcar">Xe cũ</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn">
								Thay đổi <span class="angle_arrow"><i
									class="fa fa-angle-right" aria-hidden="true"></i></span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>