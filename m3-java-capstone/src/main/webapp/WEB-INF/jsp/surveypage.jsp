<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<link rel = "stylesheet" href = "css/site.css"/>
<title>Survey</title>

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
	<form:form method = "POST" action = "surveypage" modelAttribute ="survey">
		<div>
			<form:label for = "favoritePark" path = "parkCode">Favorite National Park</form:label>
			<form:select name = "parkcode" path = "parkCode">
			
			<form:option value="" selected="selected">Select a National Park</form:option>
				<c:forEach var = "park" items = "${parkList}">
					<form:option value = "${park.parkCode}">${park.parkName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path = "parkCode" cssClass="error"/>
		</div>
	
	<div><form:label for = "email" path ="email" > Your email</form:label>
	<form:input name = "email" type = "text" placeholder = "email" path = "email"/>
	<form:errors path = "email" cssClass="error"/>
	</div>
	
	<div><form:label for = "state" path = "state" > State of residence</form:label>
	
	<form:select name="state" id="state"  path = "state">
	  <form:option value="" selected="selected" >Select a State</form:option>
	  <form:option value="AL">Alabama</form:option>
	  <form:option value="AK">Alaska</form:option>
	  <form:option value="AZ">Arizona</form:option>
	  <form:option value="AR">Arkansas</form:option>
	  <form:option value="CA">California</form:option>
	  <form:option value="CO">Colorado</form:option>
	  <form:option value="CT">Connecticut</form:option>
	  <form:option value="DE">Delaware</form:option>
	  <form:option value="FL">Florida</form:option>
	  <form:option value="GA">Georgia</form:option>
	  <form:option value="HI">Hawaii</form:option>
	  <form:option value="ID">Idaho</form:option>
	  <form:option value="IL">Illinois</form:option>
	  <form:option value="IN">Indiana</form:option>
	  <form:option value="IA">Iowa</form:option>
	  <form:option value="KS">Kansas</form:option>
	  <form:option value="KY">Kentucky</form:option>
	  <form:option value="LA">Louisiana</form:option>
	  <form:option value="ME">Maine</form:option>
	  <form:option value="MD">Maryland</form:option>
	  <form:option value="MA">Massachusetts</form:option>
	  <form:option value="MI">Michigan</form:option>
	  <form:option value="MN">Minnesota</form:option>
	  <form:option value="MS">Mississippi</form:option>
	  <form:option value="MO">Missouri</form:option>
	  <form:option value="MT">Montana</form:option>
	  <form:option value="NE">Nebraska</form:option>
	  <form:option value="NV">Nevada</form:option>
	  <form:option value="NH">New Hampshire</form:option>
	  <form:option value="NJ">New Jersey</form:option>
	  <form:option value="NM">New Mexico</form:option>
	  <form:option value="NY">New York</form:option>
	  <form:option value="NC">North Carolina</form:option>
	  <form:option value="ND">North Dakota</form:option>
	  <form:option value="OH">Ohio</form:option>
	  <form:option value="OK">Oklahoma</form:option>
	  <form:option value="OR">Oregon</form:option>
	  <form:option value="PA">Pennsylvania</form:option>
	  <form:option value="RI">Rhode Island</form:option>
	  <form:option value="SC">South Carolina</form:option>
	  <form:option value="SD">South Dakota</form:option>
	  <form:option value="TN">Tennessee</form:option>
	  <form:option value="TX">Texas</form:option>
	  <form:option value="UT">Utah</form:option>
	  <form:option value="VT">Vermont</form:option>
	  <form:option value="VA">Virginia</form:option>
	  <form:option value="WA">Washington</form:option>
	  <form:option value="WV">West Virginia</form:option>
	  <form:option value="WI">Wisconsin</form:option>
	  <form:option value="WY">Wyoming</form:option>
	</form:select>
	<form:errors path = "state" cssClass="error"/>
	</div>
	
	
	
	<div>
		<form:label for = "activitylevel" path = "activityLevel" > Activity Level</form:label>
		
		<form:select name = "activitylevel"  path = "activityLevel">
			<form:option value="" selected="selected" >Select an activity level</form:option>
			<form:option value = "inactive">Inactive</form:option>
			<form:option value = "sedentary">Sedentary</form:option>
			<form:option value = "active">Active</form:option>
			<form:option value = "extremelyactive">Extremely Active</form:option>
		</form:select>
		<form:errors path = "activityLevel" cssClass="error"/>
	</div>
	<div>
	<input type="submit" value="Submit Your Survey">
	</div>
	</form:form>




</section>
</body>




</html>