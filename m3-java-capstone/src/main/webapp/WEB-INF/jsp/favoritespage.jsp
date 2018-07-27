<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/site.css" />
<title>Favorites</title>
</head>
<body>
	<header>
		<img class="logo" alt="npgeek logo" src="img/logo.png">

	</header>
	<nav>
		<ul>
			<li><a href="/m3-java-capstone/homepage">Home</a></li>
			<li><a href="/m3-java-capstone/surveypage">Survey</a></li>
	</nav>
	<section id="main-content">
	<h1 id = "favHeader">Favorite Park Survey Results</h1>
		<c:forEach var="entry" items="${favoriteParks}">
			<div class="completeParkContainer">
				<div class = "imageContainer">
					<img class = "parkImgHP" src="img/parks/${entry.key.parkCode.toLowerCase()}.jpg" />
				</div>
				<div class="detailsContainerFavorites">
					<div>
						<h1>${entry.key.parkName}</h1>
					</div>
					<div class = "numVotes">${entry.value}</div>
				</div>
			</div>

		</c:forEach>


	</section>
</body>




</html>