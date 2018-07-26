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
			
	
		</nav>
	<section id="main-content">
	<c:forEach var = "entry" items = "${favoriteParks}">
	<div>
		
			<div><img src = "img/parks/${entry.key.parkCode.toLowerCase()}.jpg"/></div>
			<div>${entry.key.parkName}</div>
			<div>${entry.value}</div>
	</div>
		</c:forEach>
	
	
	</section>
	</body>
	
	
	
	
	</html>