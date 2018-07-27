<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/site.css" />
<title>detailPage</title>
</head>
<body>
	<header>
		<img class="logo" alt="npgeek logo" src="img/logo.png">
	</header>
	<nav>
		<form method="GET" action="detailpageCelcius">
			<ul>
				<li><a href="/m3-java-capstone/homepage">Home</a></li>
				<li><a href="/m3-java-capstone/surveypage">Survey</a></li>
				<li><label for="tempUnit">Temp Unit: F</label> <input
					type="radio" name="tempUnit" value="F"> <label
					for="tempUnit">C</label> <input type="radio" name="tempUnit"
					value="C">
				<li>
				<li><input type="submit" value="Apply changes">
				<li>
			</ul>
		</form>
	</nav>
	<section id="main-content">
		<div class="imgContainerDP">
			<img class="parkImgDP"
				src="img/parks/${park.parkCode.toLowerCase()}.jpg">
			<div class="detailsContainer" class="parkDescription">
				<div>
					<h1>${park.parkName}</h1>
				</div>
				<div class="parkQuote">
					<span>"${park.inspirationalQuote}"</span><span>
						~${park.quoteSource}</span>
				</div>
				<div class="parkStatistics">
					<div>
						<span>State: </span><span>${park.state}</span>
					</div>
					<div>
						<span>Acres: </span><span>${park.acreage}</span>
					</div>
					<div>
						<span>Elevation: </span><span>${park.elevation} ft.</span>
					</div>
					<div>
						<span>Miles of trail: </span><span>${park.milesOfTrail}</span>
					</div>
					<div>
						<span>Number of campsites: </span><span>${park.numberOfCampsites}</span>
					</div>
					<div>
						<span>Climate: </span><span>${park.climate}</span>
					</div>
					<div>
						<span>Founded in: </span><span>${park.yearFounded}</span>
					</div>
					<div>
						<span>Annual Visitors: </span><span>${park.annualVisitors}</span>
					</div>
					<div>
						Number of Animal Species: <span>${park.numberOfAnimalSpecies}</span>
					</div>
					<div>
						<span>Entry fee: </span><span>$ ${park.entryFee}</span>
					</div>
				</div>
				<div>${park.description}</div>


			</div>
		</div>

		<c:set var="day" value="${todaysForecast}" />
		<c:set var="tempAdvisoryHighLow" value=" " />
		<c:choose>
			<c:when test="${day.highTemp > 75}">
				<c:set var="tempAdvisoryHighLow"
					value="Bring an extra gallon of water" />
			</c:when>
			<c:when test="${day.lowTemp < 20}">
				<c:set var="tempAdvisoryHighLow"
					value="Frigid temperatures expected, be sure to minimize exposed skin and time outdoors" />
			</c:when>
		</c:choose>
		<c:set var="tempAdvisoryRange" value="" />
		<c:choose>
			<c:when test="${day.highTemp - day.lowTemp > 20}">
				<c:set var="tempAdvisoryRange" value="Wear breathable layers" />
			</c:when>
		</c:choose>

		<c:set var="forecastAdvisory" value="" />
		<c:choose>
			<c:when test="${day.forecast  == 'snow'}">
				<c:set var="forecastAdvisory" value="Pack snowshoes" />
			</c:when>
			<c:when test="${day.forecast  == 'rain'}">
				<c:set var="forecastAdvisory"
					value="Pack rain gear and wear waterproof shoes" />
			</c:when>
			<c:when test="${day.forecast  == 'thunderstorms'}">
				<c:set var="forecastAdvisory"
					value="Seek shelter and avoid hiking on exposed ridges" />
			</c:when>
			<c:when test="${day.forecast  == 'sunny'}">
				<c:set var="forecastAdvisory" value="Pack sunblock" />
			</c:when>
		</c:choose>


		<c:set var="hiTemp" value="${day.highTemp}" />
		<c:set var="lowTemp" value="${day.lowTemp}" />
		<c:set var="tempSuffix" value="F" />

		<c:choose>
			<c:when test="${tempUnit == 'C'}">
				<c:set var="hiTemp" value="${(day.highTemp - 32) * (5/9)}" />
				<c:set var="lowTemp" value="${(day.lowTemp - 32) * (5/9)}" />
				<c:set var="tempSuffix" value="C" />

				<fmt:parseNumber var="hiTemp" integerOnly="true" type="number"
					value="${hiTemp}" />
				<fmt:parseNumber var="lowTemp" integerOnly="true" type="number"
					value="${lowTemp}" />
			</c:when>
		</c:choose>

		<div class="allWeather">
			<div class ="todaysWeather">
			<div><h4>Today's Forecast</h4></div>
				<div><img src="img/weather/${day.forecast}.png"></div>
				<div>
					<span><strong>High</strong> ${hiTemp}&deg;${tempSuffix}</span> <span><strong>Low</strong> ${lowTemp}&deg;${tempSuffix}</span>
				</div>
				<div>${forecastAdvisory}</div>
				<div>${tempAdvisoryHighLow}</div>
				<c:if test="${tempAdvisoryRange.length() > 0}">
					<div>${tempAdvisoryRange}</div>
				</c:if> 
			</div>
			<div class="fourDayForecast">
				<c:forEach var="day" items="${fourDayForecast}">
					<div class="dayInForecast">
						<div>
							<img src="img/weather/${day.forecast}.png">
						</div>
						<div><strong>High</strong> ${hiTemp}&deg;${tempSuffix} <strong>Low</strong> ${lowTemp}&deg;${tempSuffix}</div>
					</div>
				</c:forEach>
			</div>
		</div>


	</section>
</body>
</html>