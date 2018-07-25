<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>detailPage</title>
	</head>
	<body>
	<h1>You are the detail page</h1>
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
		<div>$ ${park.entryFee}</div>
		<div>${park.numberOfAnimalSpecies}</div>
	</div>
	<div>
		<c:forEach var = "day" items = "${fiveDayForecast}">
			<div class = "dailyWeather">
				<div><img src = "img/weather/${day.forecast}.png"></div>
				<p>${day.forecast}</p>
				<div>High<span>${day.highTemp}</span>Low<span>${day.lowTemp}</span></div>
				
				<c:choose>
				<c:when test = "${day.forecast  == 'snow'}">
					<div>Pack snowshoes</div>
				</c:when>
				<c:when test = "${day.forecast  == 'rain'}">
					<div>Pack rain gear and wear waterproof shoes</div>
				</c:when>
				<c:when test = "${day.forecast  == 'thunderstorms'}">
					<div>Seek shelter and avoid hiking on exposed ridges</div>
				</c:when>
				<c:when test = "${day.forecast  == 'sunny'}">
					<div>Pack sunblock</div>
				</c:when>
				</c:choose>
				<br>
				
				
		
			
			</div>
		
		
		</c:forEach>
	
	
	
	</div>
	
	
	
	</body>
	
	
	
	
	</html>