<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<link rel = "stylesheet" href = "css/site.css"/>
<title>Home Page</title>

</head>
<body>
	<header>
		<img class = "logo" alt="npgeek logo" src="img/logo.png">
		
	</header>
	<nav>
		<ul>
			<li><a href="/m3-java-capstone/homepage">Home</a></li>
			<li><a href="/m3-java-capstone/surveypage">Survey</a></li>
			<li><label for = "tempUnit">Temp Unit: F</label>
			<input type = "radio" name = "tempUnit" value = "F">
			<label for = "tempUnit">C</label>
			<input type = "radio" name = "tempUnit" value = "C"><li>
		</ul>

	</nav>
<section id="main-content">

	<h1>You are on the homepage</h1>
	<div>
	<c:forEach var = "park" items = "${parkList}">
	
		<div>
		<a href= "/m3-java-capstone/detailpage?parkcode=${park.parkCode}"><img src = "img/parks/${park.parkCode.toLowerCase()}.jpg"/></a>
		</div>
		<div>
		<div>${park.parkName}</div>
		<div>${park.description}</div>
		</div>
	</c:forEach>
	</div>

</section>
</body>




</html>