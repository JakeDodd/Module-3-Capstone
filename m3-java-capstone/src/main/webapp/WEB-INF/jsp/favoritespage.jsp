<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "css/site.css"/>
	<title>Favorites</title>
	</head>
	<body>
		<header>
			<img alt="npgeek logo" src="img/logo.png">
		
		</header>
		<nav>
			<ul>
				<li><a href="/m3-java-capstone/homepage">Home</a></li>
				<li><a href="/m3-java-capstone/surveypage">Survey</a></li>
			</ul>
	
		</nav>
	<section id="main-content">
	<div>
		<c:forEach var = "park" items = "${favoriteParks}">
			<div><img src = "img/parks/${park.key.parkCode.toLowerCase()}.jpg"/></div>
			<div>${park.key.parkName}</div>
			<div>${park.value}</div>
		</c:forEach>
	</div>
	
	
	</section>
	</body>
	
	
	
	
	</html>