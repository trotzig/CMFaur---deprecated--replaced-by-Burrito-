<%@ tag isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="pageTitle" required="false" %>
<!DOCTYPE html>
<html>
	<head>
		<title><c:out value="${pageTitle}"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" media="screen" href="/main.css">
		
	</head>
	<body>
		<div class="body-wrapper">
			<div class="body">
				
				<div class="top-wrapper">
					<div class="top">
						<h1>Burrito CMF Demo</h1>
						<p>
							This demo displays a simple blog. Access the admin area here: <a href="/admin">/admin</a>. Login as <i>burrito_cmf@hmamail.com</i>, password <i>burrito</i>
						</p>
						<div class="clear-floats"></div>
					</div>
				</div>
				<div class="main-wrapper">
					<div class="main">
						<!-- The main content area -->
						<jsp:doBody/>
					</div>
				</div>
				<div class="clear-floats"></div>
				<div class="footer clear-floats">
					This is a demo of Burrito, a lightweight Content Management Framework | Created by henric.persson[at]gmail.com 				
				</div>
			</div>
		</div>
	</body>
</html>