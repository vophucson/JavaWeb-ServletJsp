<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="default-header">
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2">
				<div class="logo">
					<a href="home"><img src="templates/assets/images/logo.png"
						alt="image" /></a>
				</div>
			</div>
			<div class="col-sm-9 col-md-10">
				<div class="header_info">
					<div class="header_widgets">
						<div class="circle_icon">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</div>
						<p class="uppercase_text">Gửi email cho chúng tôi :</p>
						<a href="mailto:info@example.com">${info.email}</a>
					</div>
					<div class="header_widgets">
						<div class="circle_icon">
							<i class="fa fa-phone" aria-hidden="true"></i>
						</div>
						<p class="uppercase_text">Số điện thoại hỗ trợ:</p>
						<a href="tel:61-1234-5678-09">${info.phone}</a>
					</div>
					<div class="social-follow">
						<ul>
							<li><a href="#"><i class="fa fa-facebook-square"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter-square"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-linkedin-square"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus-square"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram"
									aria-hidden="true"></i></a></li>
						</ul>
					</div>
					<c:if test="${sessionScope.user == null}">
						<div class="login_btn">
							<a href="login" class="btn btn-xs uppercase">Đăng
								nhập / Đăng ký</a>
						</div>
					</c:if>
					<c:if test="${sessionScope.user != null}">
					<div class="login_btn" style="width:185px;"></div>
			</c:if>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Navigation -->
<nav id="navigation_bar" class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button id="menu_slide" data-target="#navigation"
				aria-expanded="false" data-toggle="collapse"
				class="navbar-toggle collapsed" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="header_wrap">
			<c:if test="${sessionScope.user != null}">
				<div class="user_login">
					<ul>
						<li class="dropdown"><a href="#" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"><i
								class="fa fa-user-circle" aria-hidden="true"></i>
								${sessionScope.user.userName}
								 <i class="fa fa-angle-down"
								aria-hidden="true"></i></a>
							<ul class="dropdown-menu">
								<li class="${tag == 1?"active":""}"><a
									href="profile-setting">Cài đặt tài khoản</a></li>
								<c:if test="${sessionScope.user.isDealer == 1}">
									<li class="${tag == 2?"active":""}"><a
										href="store-setting">Cài đặt gian hàng</a></li>
									<li class="${tag == 3?"active":""}"><a
										href="store-listcar?index=1">Danh sách bài đăng</a></li>
									<li class="${tag == 4?"active":""}"><a
										href="store-postcar">Đăng bán xe</a></li>
								</c:if>
								<li><a href="logout">Đăng xuất</a></li>
							</ul></li>
					</ul>
				</div>
				
			</c:if>
			<div class="header_search">
				<div id="search_toggle">
					<i class="fa fa-search" aria-hidden="true"></i>
				</div>
				<form action="product" method="get" id="header-search-form">
					<input type="text" placeholder="Tìm kiếm theo tên xe"
						class="form-control" name="pname"> <input type="hidden"
						name="type" value="searchname"> <input type="hidden"
						name="sort" value="no"> <input type="hidden" name="index"
						value="1">
					<button type="submit">
						<i class="fa fa-search" aria-hidden="true"></i>
					</button>
				</form>
			</div>
		</div>
		<div class="collapse navbar-collapse" id="navigation">
			<ul class="nav navbar-nav">
				<li><a href="home" aria-haspopup="true" aria-expanded="false">Trang
						chủ</a></li>
				<li><a href="contact">Liên hệ</a></li>
				<li class="dropdown"><a href="#" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Thương hiệu</a>
					<ul class="dropdown-menu">
						<c:forEach items="${brand}" var="o">
							<li><a
								href="product?type=brand&&sort=no&&index=1&&bid=${o.brandId}">${o.brandName}</a></li>
						</c:forEach>
					</ul></li>
				<li><a href="dealer?index=1&&sort=no" aria-haspopup="true"
					aria-expanded="false">Đại lý ô tô</a></li>
				<li><a href="save" aria-haspopup="true" aria-expanded="false">Các
						bài đã lưu</a></li>
						
			</ul>
		</div>
	</div>
</nav>

