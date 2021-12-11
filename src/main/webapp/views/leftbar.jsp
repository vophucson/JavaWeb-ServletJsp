<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="col-md-3 col-sm-3">
	<div class="profile_nav">
		<ul>
			<li class="${tag == 1?"active":""}"><a href="profile-setting">Cài
					đặt tài khoản</a></li>
			<c:if test="${sessionScope.user.isDealer == 1}">
				<li class="${tag == 2?"active":""}"><a href="store-setting">Cài
						đặt gian hàng</a></li>
				<li class="${tag == 3?"active":""}"><a
					href="store-listcar?index=1">Danh sách bài đăng</a></li>
				<li class="${tag == 4?"active":""}"><a href="store-postcar">Đăng
						bán xe</a></li>
			</c:if>
			<li><a href="logout">Đăng xuất</a></li>
		</ul>
	</div>
</div>