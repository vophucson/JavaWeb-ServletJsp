<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="hk-wrapper hk-alt-nav hk-icon-nav">

	<!-- Top Navbar -->
	<nav
		class="navbar navbar-expand-xl navbar-light fixed-top hk-navbar hk-navbar-alt">
		<a class="navbar-toggle-btn nav-link-hover navbar-toggler"
			href="javascript:void(0);" data-toggle="collapse"
			data-target="#navbarCollapseAlt" aria-controls="navbarCollapseAlt"
			aria-expanded="false" aria-label="Toggle navigation"><span
			class="feather-icon"><i data-feather="menu"></i></span></a> <a
			class="navbar-brand text-red" href="admin-home"> Carforyou </a>
		<div class="collapse navbar-collapse" id="navbarCollapseAlt">
			<ul class="navbar-nav">
				<li><a class="nav-link" href="admin-home" role="button"
					aria-haspopup="true" aria-expanded="false"> Trang chính </a></li>
				<li class="nav-item dropdown show-on-hover"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Quản lý thương hiệu </a>
					<div class="dropdown-menu" data-dropdown-in="fadeIn"
						data-dropdown-out="fadeOut">
						<a class="dropdown-item" href="admin-brand?index=1">Danh sách thương
							hiệu</a>

					</div></li>
				<li class="nav-item dropdown show-on-hover"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Quản lý tài khoản </a>
					<div class="dropdown-menu" data-dropdown-in="fadeIn"
						data-dropdown-out="fadeOut">
						<a class="dropdown-item" href="admin-user?index=1">Danh sách tài khoản
						</a>

					</div></li>
				<li class="nav-item dropdown show-on-hover"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Quản lý đại lý </a>
					<div class="dropdown-menu" data-dropdown-in="fadeIn"
						data-dropdown-out="fadeOut">
						<a class="dropdown-item" href="admin-dealer?index=1">Danh sách đại lý </a>

					</div></li>
				<li class="nav-item dropdown show-on-hover"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Quản lý bài đăng </a>
					<div class="dropdown-menu" data-dropdown-in="fadeIn"
						data-dropdown-out="fadeOut">
						<a class="dropdown-item" href="admin-postcarpass?index=1">Danh sách đã
							duyệt </a> <a class="dropdown-item" href="admin-postcarnopass?index=1">Danh
							sách chưa duyệt </a>
					</div></li>
				<li class="nav-item dropdown show-on-hover"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Quản lý thông tin </a>
					<div class="dropdown-menu" data-dropdown-in="fadeIn"
						data-dropdown-out="fadeOut">
						<a class="dropdown-item" href="admin-info">Chỉnh sửa thông tin
						</a>

					</div></li>

			</ul>
		</div>
		<ul class="navbar-nav hk-navbar-content">
			<li class="nav-item"><a id="settings_toggle_btn"
				class="nav-link nav-link-hover" href="javascript:void(0);"><span
					class="feather-icon"><i data-feather="settings"></i></span></a></li>

			<li class="nav-item dropdown dropdown-authentication"><a
				class="nav-link dropdown-toggle no-caret" href="#" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<div class="media">
						<div class="media-body">
							<span>${sessionScope.user.userName}<i
								class="zmdi zmdi-chevron-down"></i></span>
						</div>
					</div>

			</a>
				<div class="dropdown-menu dropdown-menu-right"
					data-dropdown-in="flipInX" data-dropdown-out="flipOutX">


					<div class="sub-dropdown-menu show-on-hover">
						<a href="#" class="dropdown-toggle dropdown-item no-caret"><i
							class="zmdi zmdi-check text-success"></i>Online</a>
					</div>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="logout"><i
						class="dropdown-icon zmdi zmdi-power"></i><span>Đăng xuất</span></a>
				</div></li>
		</ul>
	</nav>
</div>