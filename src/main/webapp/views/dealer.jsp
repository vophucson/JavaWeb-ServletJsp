<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="inner_pages">
	<div class="container">
		<div class="result-sorting-wrapper">
			<div class="result-sorting-by">
				<p>Sắp xếp:</p>
				<form action="dealer" method="get" name="test">
					<div class="form-group select sorting-select">
						<input type="hidden" value="${tag}" name="index"> <select
							class="form-control" name="sort"
							onchange="javascript:document.test.submit();">
							<c:if test="${sort == 'no'}">
								<option value="no">Mặc định</option>
								<option value="lowtotop">Số xe(thấp đến cao)</option>
								<option value="toptolow">Số xe(cao xuống thấp)</option>
							</c:if>
							<c:if test="${sort == 'lowtotop'}">
								<option value="lowtotop">Số xe(thấp đến cao)</option>
								<option value="toptolow">Số xe(cao xuống thấp)</option>
								<option value="no">Mặc định</option>
							</c:if>
							<c:if test="${sort == 'toptolow'}">
								<option value="toptolow">Số xe(cao xuống thấp)</option>
								<option value="lowtotop">Số xe(thấp đến cao)</option>
								<option value="no">Mặc định</option>
							</c:if>
						</select>
					</div>
				</form>
			</div>
		</div>
		<div class="dealers_list_wrap">
			<c:forEach items="${listD}" var="d">
				<div class="dealers_listing">
					<div class="row">
						<div class="col-sm-3 col-xs-4">
							<div class="dealer_logo">
								<img src="uploads/store/${d.dImage}" class="cover"
									alt="MDN Logo" width="222px" height="172px">
							</div>
						</div>
						<div class="col-sm-6 col-xs-8">
							<div class="dealer_info">
								<h5>
									<a href="dealerdetail?dealerid=${d.dealerId}&&index=1">${d.dName}</a>
								</h5>
								<p>${d.dAddress}</p>
							</div>
						</div>
						<div class="col-sm-3 col-xs-12">
							<div class="view_profile">
								<a href="dealerdetail?dealerid=${d.dealerId}&&index=1"
									class="btn btn-xs outline">Xem hồ sơ</a>
								<p>(${d.countCar} xe)</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="pagination">
				<ul>
					<c:forEach begin="1" end="${endP}" var="i">
						<a href="dealer?index=${i}&&sort=${sort}">
							<li class="${tag ==i?"current":""}">${i}</li>
						</a>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</section>