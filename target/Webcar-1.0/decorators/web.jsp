<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<title>CarForYou</title>
<!--Bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/templates/assets/css/bootstrap.min.css" />"
	type="text/css">
<!--Custome Style -->
<link rel="stylesheet"
	href="<c:url value="/templates/assets/css/style.css"/>" type="text/css">
<!--OWL Carousel slider-->
<link rel="stylesheet"
	href="<c:url value="/templates/assets/css/owl.carousel.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/templates/assets/css/owl.transitions.css" />"
	type="text/css">
<!--slick-slider -->
<link href="<c:url value="/templates/assets/css/slick.css"/>"
	rel="stylesheet">
<!--bootstrap-slider -->
<link
	href="<c:url value="/templates/assets/css/bootstrap-slider.min.css"/>"
	rel="stylesheet">
<!--FontAwesome Font Style -->
<link
	href="<c:url value="/templates/assets/css/font-awesome.min.css" />"
	rel="stylesheet">

<!-- Custom Colors -->
<link rel="stylesheet"
	href="<c:url value="/templates/assets/colors/red.css"/>">


<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value="/templates/assets/images/favicon-icon/apple-touch-icon-144-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value="/templates/assets/images/favicon-icon/apple-touch-icon-114-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value="/templates/assets/images/favicon-icon/apple-touch-icon-72-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed"
	href="<c:url value="/templates/assets/images/favicon-icon/apple-touch-icon-57-precomposed.png" />">
<link rel="shortcut icon"
	href="<c:url value="/templates/assets/images/favicon-icon/favicon.png" />">
<!-- Google-Font-->
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900"
	rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>

	<!--Header-->
	<header>
		<%@ include file="/common/web/header.jsp"%>
		<!-- Navigation end -->

	</header>
	<!-- /Header -->

	<!-- Banners -->
	<!-- /Banners -->

	<!-- Filter-Form -->
	<!-- /Filter-Form -->

	<!-- About -->
	<!-- Content -->
	<dec:body />
	<!-- /About -->

	<!-- Resent Cat-->

	<!-- /Resent Cat -->


	<!--Featured Car-->

	<!-- /Featured Car-->
	<!--Brands-->
	<section class="brand-section gray-bg">
		<div class="container">
			<div class="brand-hadding">
				<h5>Thương hiệu</h5>
			</div>
			<div class="brand-logo-list">
				<div id="popular_brands">
					<c:forEach items="${brand}" var="b">
						<div>

							<a href="product?type=brand&&sort=no&&index=1&&bid=${b.brandId}"><img
								src="uploads/brand/${b.icon}" class="cover" alt="MDN Logo"
								width="100px" height="60px"></a>

						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<!-- /Brands-->

	<!--Footer -->
	<footer>
		<%@ include file="/common/web/footer.jsp"%>
	</footer>
	<!-- /Footer-->

	<!--Back to top-->
	<div id="back-top" class="back-top">
		<a href="#top"><i class="fa fa-angle-up" aria-hidden="true"></i> </a>
	</div>
	<!--/Back to top-->

	<!--Login-Form -->

	<!--/Login-Form -->

	<!--Register-Form -->
	<!--/Register-Form -->

	<!--Forgot-password-Form -->
	<!--/Forgot-password-Form -->

	<!-- Scripts -->
	<script src="<c:url value="/templates/assets/js/jquery.min.js" />"></script>
	<script src="<c:url value="/templates/assets/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/templates/assets/js/interface.js" />"></script>
	<!--bootstrap-slider-JS-->
	<script
		src="<c:url value="/templates/assets/js/bootstrap-slider.min.js" />"></script>
	<!--Slider-JS-->
	<script src="<c:url value="/templates/assets/js/slick.min.js" />"></script>
	<script src="<c:url value="/templates/assets/js/owl.carousel.min.js"/>"></script>

</body>

</html>