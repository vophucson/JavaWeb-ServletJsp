<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>Car for you</title>
<meta name="description"
	content="A responsive bootstrap 4 admin dashboard template by hencework" />

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<!-- Morris Charts CSS -->
<link
	href="<c:url value="/templates/admin/vendors/morris.js/morris.css"/>"
	rel="stylesheet" type="text/css" />

<!-- Toastr CSS -->
<link
	href="<c:url value="/templates/admin/vendors/jquery-toast-plugin/dist/jquery.toast.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- Toggles CSS -->
<link
	href="<c:url value="/templates/admin/vendors/jquery-toggles/css/toggles.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/templates/admin/vendors/jquery-toggles/css/themes/toggles-light.css"/>"
	rel="stylesheet" type="text/css">

<!-- Custom CSS -->
<link href="<c:url value="/templates/admin/dist/css/style.css"/>"
	rel="stylesheet" type="text/css">

</head>

<body>
	<!-- HK Wrapper toppp -->
	<%@ include file="/common/admin/top.jsp"%>
	<!-- /Top Navbar -->

	<!-- Main Content -->
	<dec:body />
	<!-- /HK Wrapper -->
	<script
		src="<c:url value="/templates/admin/vendors/jquery/dist/jquery.min.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<c:url value="/templates/admin/vendors/popper.js/dist/umd/popper.min.js"/>"></script>
	<script
		src="<c:url value="/templates/admin/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>

	<!-- Slimscroll JavaScript -->
	<script
		src="<c:url value="/templates/admin/dist/js/jquery.slimscroll.js"/>"></script>

	<!-- Fancy Dropdown JS -->
	<script
		src="<c:url value="/templates/admin/dist/js/dropdown-bootstrap-extended.js"/>"></script>

	<!-- FeatherIcons JavaScript -->
	<script src="<c:url value="/templates/admin/dist/js/feather.min.js"/>"></script>

	<!-- Toggles JavaScript -->
	<script
		src="<c:url value="/templates/admin/vendors/jquery-toggles/toggles.min.js"/>"></script>
	<script src="<c:url value="/templates/admin/dist/js/toggle-data.js"/>"></script>

	<!-- Counter Animation JavaScript -->
	<script
		src="<c:url value="/templates/admin/vendors/waypoints/lib/jquery.waypoints.min.js"/>"></script>
	<script
		src="<c:url value="/templates/admin/vendors/jquery.counterup/jquery.counterup.min.js"/>"></script>

	<!-- Easy pie chart JS -->
	<script
		src="<c:url value="/templates/admin/vendors/easy-pie-chart/dist/jquery.easypiechart.min.js"/>"></script>

	<!-- Sparkline JavaScript -->

	<!-- Morris Charts JavaScript -->
	<script
		src="<c:url value="/templates/admin/vendors/raphael/raphael.min.js"/>"></script>
	<script
		src="<c:url value="/templates/admin/vendors/morris.js/morris.min.js"/>"></script>

	<!-- EChartJS JavaScript -->
	<script
		src="<c:url value="/templates/admin/vendors/echarts/dist/echarts-en.min.js"/>"></script>

	<!-- Peity JavaScript -->
	<script
		src="<c:url value="/templates/admin/vendors/peity/jquery.peity.min.js"/>"></script>

	<!-- Toastr JS -->
	<script
		src="<c:url value="/templates/admin/vendors/jquery-toast-plugin/dist/jquery.toast.min.js"/>"></script>
	<script src="<c:url value="/templates/admin/dist/js/init.js"/>"></script>
	<script
		src="<c:url value="/templates/admin/vendors/jasny-bootstrap/dist/js/jasny-bootstrap.min.js"/>"></script>


</body>

</html>