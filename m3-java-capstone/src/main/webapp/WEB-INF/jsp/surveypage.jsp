<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<form method = "POST" action = "surveypage">
		<div>
			<label for = "favoritePark">Favorite National Park</label>
			<select name = "parkcode" required>
			<option value="" selected="selected">Select a National Park</option>
				<c:forEach var = "park" items = "${parkList}">
					<option value = "${park.parkCode}">${park.parkName}</option>
				</c:forEach>
			</select>
		</div>
	
	<div><label for = "email" > Your email</label>
	<input name = "email" type = "text" placeholder = "email" required></div>
	
	<div><label for = "state" > State of residence</label>
	<select name="state" id="state" required>
	  <option value="" selected="selected" >Select a State</option>
	  <option value="AL">Alabama</option>
	  <option value="AK">Alaska</option>
	  <option value="AZ">Arizona</option>
	  <option value="AR">Arkansas</option>
	  <option value="CA">California</option>
	  <option value="CO">Colorado</option>
	  <option value="CT">Connecticut</option>
	  <option value="DE">Delaware</option>
	  <option value="FL">Florida</option>
	  <option value="GA">Georgia</option>
	  <option value="HI">Hawaii</option>
	  <option value="ID">Idaho</option>
	  <option value="IL">Illinois</option>
	  <option value="IN">Indiana</option>
	  <option value="IA">Iowa</option>
	  <option value="KS">Kansas</option>
	  <option value="KY">Kentucky</option>
	  <option value="LA">Louisiana</option>
	  <option value="ME">Maine</option>
	  <option value="MD">Maryland</option>
	  <option value="MA">Massachusetts</option>
	  <option value="MI">Michigan</option>
	  <option value="MN">Minnesota</option>
	  <option value="MS">Mississippi</option>
	  <option value="MO">Missouri</option>
	  <option value="MT">Montana</option>
	  <option value="NE">Nebraska</option>
	  <option value="NV">Nevada</option>
	  <option value="NH">New Hampshire</option>
	  <option value="NJ">New Jersey</option>
	  <option value="NM">New Mexico</option>
	  <option value="NY">New York</option>
	  <option value="NC">North Carolina</option>
	  <option value="ND">North Dakota</option>
	  <option value="OH">Ohio</option>
	  <option value="OK">Oklahoma</option>
	  <option value="OR">Oregon</option>
	  <option value="PA">Pennsylvania</option>
	  <option value="RI">Rhode Island</option>
	  <option value="SC">South Carolina</option>
	  <option value="SD">South Dakota</option>
	  <option value="TN">Tennessee</option>
	  <option value="TX">Texas</option>
	  <option value="UT">Utah</option>
	  <option value="VT">Vermont</option>
	  <option value="VA">Virginia</option>
	  <option value="WA">Washington</option>
	  <option value="WV">West Virginia</option>
	  <option value="WI">Wisconsin</option>
	  <option value="WY">Wyoming</option>
	</select></div>
	
	
	<div>
		<label for = "activitylevel" > Activity Level</label>
		<select name = "activitylevel" required>
			<option value="" selected="selected" >Select an activity level</option>
			<option value = "inactive">Inactive</option>
			<option value = "sedentary">Sedentary</option>
			<option value = "active">Active</option>
			<option value = "extremelyactive">Extremely Active</option>
		</select>
	</div>
	<div>
	<input type="submit" value="Submit Your Survey">
	</div>
	</form>




</section>
</body>




</html>