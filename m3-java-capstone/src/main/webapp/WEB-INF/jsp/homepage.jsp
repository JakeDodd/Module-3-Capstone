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
		</ul>

	</nav>
<section id="main-content">
	<div>
	<c:forEach var = "park" items = "${parkList}">
		<div class = completeParkContainer>
			<div class = "imageContainer">
			<a href= "/m3-java-capstone/detailpage?parkcode=${park.parkCode}"><img src = "img/parks/${park.parkCode.toLowerCase()}.jpg"/></a>
			</div>
			<div class = "detailsContainer">
			<div><h2>${park.parkName}</h2></div>
			<div>${park.description}</div>
			</div>
		</div>
	</c:forEach>
	</div>
	

</section>
</body>




</html>