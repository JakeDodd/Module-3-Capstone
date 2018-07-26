<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel = "stylesheet" href = "css/site.css"/>
	<title>detailPage</title>
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
	<div> <img src = "img/parks/${park.parkCode.toLowerCase()}.jpg"></div>
	<div>${park.parkName}</div>
	<div>
		<div>${park.state}</div>
		<div>${park.acreage} acres</div>
		<div>${park.elevation} elevation</div>
		<div>${park.milesOfTrail} miles of trail</div>
		<div>${park.numberOfCampsites} number of campsites</div>
		<div>${park.climate} climate</div>
		<div>${park.yearFounded} founded in</div>
		<div>${park.annualVisitors} Annual Visitors</div>
		<div>${park.inspirationalQuote}</div>
		<div>${park.quoteSource}</div>
		<div>${park.description}</div>
		<div>$ ${park.entryFee} entry fee</div>
		<div>${park.numberOfAnimalSpecies}</div>
	</div>
	<div>
		<c:forEach var = "day" items = "${fiveDayForecast}">
			<div class = "dailyWeather">
			<c:set var = "tempAdvisoryHighLow" value = " "/>
			<c:choose>
				<c:when test = "${day.highTemp > 75}">
					<c:set var = "tempAdvisoryHighLow" value = "Bring an extra gallon of water"/>
				</c:when>
				<c:when test = "${day.lowTemp < 20}">
					<c:set var = "tempAdvisoryHighLow" value = "Frigid temperatures expected, be sure to minimize exposed skin and time outdoors"/>
				</c:when>
			</c:choose>
			<c:set var = "tempAdvisoryRange" value = ""/>
			<c:choose>
				<c:when test = "${day.highTemp - day.lowTemp > 20}">
					<c:set var = "tempAdvisoryRange" value = "Wear breathable layers"/>
				</c:when>
			</c:choose>
			
			<c:set var = "forecastAdvisory" value = ""/>
			
				<c:choose>
				<c:when test = "${day.forecast  == 'snow'}">
					<c:set var = "forecastAdvisory" value = "Pack snowshoes" />
				</c:when>
				<c:when test = "${day.forecast  == 'rain'}">
					<c:set var = "forecastAdvisory" value = "Pack rain gear and wear waterproof shoes" />
				</c:when>
				<c:when test = "${day.forecast  == 'thunderstorms'}">
				<c:set var = "forecastAdvisory" value = "Seek shelter and avoid hiking on exposed ridges" />
				</c:when>
				<c:when test = "${day.forecast  == 'sunny'}">
					<c:set var = "forecastAdvisory" value = "Pack sunblock" />
				</c:when>
				</c:choose>
				
				<div><img src = "img/weather/${day.forecast}.png"></div>
				<div>High<span>${day.highTemp}</span>Low<span>${day.lowTemp}</span></div>
				<div>${forecastAdvisory}</div>
				<div>${tempAdvisoryHighLow}</div>
				<c:if test = "${tempAdvisoryRange.length()>0}">
					<div>${tempAdvisoryRange}</div>
				</c:if>
				
				
				
				<br>
		
			
			</div>
		
		
		</c:forEach>
	
	
	
	</div>
	
	
	</section>
	</body>
	
	
	
	
	</html>